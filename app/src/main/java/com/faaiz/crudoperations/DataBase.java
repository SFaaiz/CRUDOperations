package com.faaiz.crudoperations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    public static final String TABLE = "LIST_TABLE";
    public static final String NAME = "LIST_NAME";
    public static final String URL = "LIST_URL";


    public DataBase(@Nullable Context context) {
        super(context, "ListDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTableQuery = "create table " + TABLE + " (" + NAME + " TEXT, " + URL + " TEXT)";

        sqLiteDatabase.execSQL(createTableQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addItemToDB(DataModel dataModel){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, dataModel.getName());
        cv.put(URL, dataModel.getImgUrl());

        database.insert(TABLE, null, cv);
        database.close();
    }

    public void updateItemInDB(DataModel dataModel, String name){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(NAME, dataModel.getName());
        cv.put(URL, dataModel.getImgUrl());
        database.update(TABLE, cv,NAME + " =?" , new String[]{name});
        database.close();
    }

    public void removeItemFromDB(DataModel dataModel){
        SQLiteDatabase database = getWritableDatabase();
        database.delete(TABLE, NAME + "=?", new String[]{dataModel.getName()});
        database.close();
//        String deleteQuery = "delete from " + TABLE + " where " + NAME + " = " + dataModel.getName();
//        database.rawQuery(deleteQuery, null);
    }

    public List<DataModel> getAllFromDB(){
        List<DataModel> list = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        String selectAllQuery = " select * from " + TABLE;
        Cursor cursor = database.rawQuery(selectAllQuery, null);
        if(cursor.moveToFirst()){
            do{
                String url = cursor.getString(1);
                String name = cursor.getString(0);
                list.add(new DataModel(url, name));
            }while (cursor.moveToNext());
        }
        database.close();
        cursor.close();
        return list;
    }







}
