package com.example.grocerylog.data;
import com.example.grocerylog.data.groceryContract.groceryEntry;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class grocerydbhelper extends SQLiteOpenHelper {
    //dbname
    private static final String Database_Name = "grocerylog.db";
    //dbversion
    private static final int Database_Version = 1;
    //constructor
    public grocerydbhelper(@Nullable Context context) {
        super(context, Database_Name, null, Database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //sql query
        String SQL_CREATE_GROCERY_TABLE = "CREATE TABLE " + groceryEntry.table_name +
                "(" + groceryEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + groceryEntry.column_itemName + " TEXT NOT NULL, "
                + groceryEntry.column_category + " INTEGER NOT NULL, "
                +  groceryEntry.column_count + " INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_GROCERY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
