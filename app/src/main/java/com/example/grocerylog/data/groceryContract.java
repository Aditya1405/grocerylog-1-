package com.example.grocerylog.data;

import android.provider.BaseColumns;

public class groceryContract {
    //empty constructor
    private groceryContract(){}
    //
    public static final class groceryEntry implements BaseColumns{
        //table name
        public static final String table_name = "groceries";
        //id
        public static final String ID = BaseColumns._ID;
        //column 1
        public static final String column_itemName = "itemname";
        //category
        public static final String column_category = "category";
        //count
        public static final String column_count = "count";
        //assign diff categories into a unique number
        public static final int NonVeg = 0;
        public static final int Vegetable =1;
        public static final int Fruits = 2;
        public static final int Masalla = 3;
        public static final int Snacks = 4;
        public static final int Homecare = 5;
        public static final int Personalcare = 6;

    }
}
