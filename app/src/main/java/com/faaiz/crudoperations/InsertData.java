package com.faaiz.crudoperations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.Glide;
import com.faaiz.crudoperations.databinding.ActivityInsertDataBinding;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class InsertData extends AppCompatActivity {

    ActivityInsertDataBinding binding;
    List<DataModel> list;
    SetListData setListData = (SetListData) this.getApplication();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = setListData.getList();

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String url = i.getStringExtra("url");

        binding.etName.setText(name);
        binding.etUrl.setText(url);
        Glide.with(this).load(url).into(binding.imageView);


        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData(i.getBooleanExtra("isNewData", true), name);
            }
        });
    }

    public void insertData(boolean isNewData, String et_name){
        String name = binding.etName.getText().toString();
        String url = binding.etUrl.getText().toString();
        if(name.isEmpty() || url.isEmpty()){
            Snackbar sb = Snackbar.make(binding.getRoot(), "Data Field is empty!", BaseTransientBottomBar.LENGTH_LONG);
            sb.show();
        }else{
            Intent i = new Intent(InsertData.this,MainActivity.class);
            DataBase db = new DataBase(this);
            if(isNewData){
                DataModel dataModel = new DataModel(url, name);
                db.addItemToDB(dataModel);
                list.add(dataModel);
            }else{
                for(DataModel dm: list){
                    if(dm.getName().equals(et_name)){
                        dm.setName(name);
                        dm.setImgUrl(url);
                        db.updateItemInDB(dm,et_name);
                    }
                }
            }
            startActivity(i);
            finish();

        }
    }

}