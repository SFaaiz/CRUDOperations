package com.faaiz.crudoperations;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<DataModel> list;
    Context context;

    public RecyclerViewAdapter(List<DataModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(list.get(position).getImgUrl()).into(holder.img);
        holder.text.setText(list.get(position).getName());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, InsertData.class);
                i.putExtra("name", holder.text.getText().toString());
                i.putExtra("url", list.get(position).getImgUrl());
                i.putExtra("isNewData", false);
                context.startActivity(i);
            }
        });

        holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setMessage("Do you want to delete this item?");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DataBase dataBase = new DataBase(context);
                        dataBase.removeItemFromDB(list.get(position));
                        list.remove(position);
                        notifyDataSetChanged();
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alertDialog.setTitle("Delete");
                alertDialog.setIcon(R.drawable.baseline_delete_24);
                alertDialog.show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        DataBase db = new DataBase(context);
        return db.getAllFromDB().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout parent;
        ImageView img;
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.linearLayout);
            img = itemView.findViewById(R.id.item_img);
            text = itemView.findViewById(R.id.item_text);
        }
    }
}
