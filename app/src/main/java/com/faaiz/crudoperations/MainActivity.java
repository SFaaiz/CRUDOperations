package com.faaiz.crudoperations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.faaiz.crudoperations.databinding.ActivityMainBinding;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SetListData setListData = (SetListData) this.getApplication();
    List<DataModel> list;
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        getActionBar();

        list = setListData.getList();

        DataBase db = new DataBase(getApplicationContext());
        if(db.getAllFromDB().size()==0) for(DataModel dm: list) db.addItemToDB(dm);


        list = db.getAllFromDB();
        Collections.reverse(list);

        adapter = new RecyclerViewAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(llm);

        binding.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InsertData.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.az){
            Collections.sort(list, DataModel.SortByNameAsc);
        }else{
            Collections.sort(list,new DataModel.SortByNameDesc());
        }
        adapter.notifyDataSetChanged();
        return true;
    }



}