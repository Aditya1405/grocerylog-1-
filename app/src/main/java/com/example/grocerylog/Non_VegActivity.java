package com.example.grocerylog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.grocerylog.data.groceryContract.groceryEntry;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.example.grocerylog.data.grocerydbhelper;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Non_VegActivity extends AppCompatActivity {
    private grocerydbhelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non__veg);
        setTitle("Non-Veg");
        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * write intent to go form nonveg to additemactivity page
                 */
                Intent intent = new Intent(Non_VegActivity.this,EditorActivity.class);
                startActivity(intent);
            }
        });
        mDbHelper = new grocerydbhelper(this);
        /**
         * oncreate ends here
         */
    }

    @Override
    protected void onStart() {
        super.onStart();
        //initialize db
        displayDatabaseInfo();
        /**
         * onstart ends here
         */
    }

    public void displayDatabaseInfo(){
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                groceryEntry.ID,
                groceryEntry.column_itemName,
                groceryEntry.column_category,
                groceryEntry.column_count};

        /**
         * add selection args
         * only nonveg item count should be visible
         */
        Cursor cursor = db.query(groceryEntry.table_name,projection,
                null,
                null,
                null,
                null,
                null);
        TextView displayView = (TextView) findViewById(R.id.text_view_non_veg);
        //display number of items stored in db
        try {

            displayView.setText("The grocery table contains " + cursor.getCount() + " items.\n\n");

            displayView.append(groceryEntry._ID + " - " +
                    groceryEntry.column_itemName + " - " +
                    groceryEntry.column_category + " - " +
                    groceryEntry.column_count + " - " +
                    "\n");
            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(groceryEntry._ID);
            int itemnameColumnIndex = cursor.getColumnIndex(groceryEntry.column_itemName);
            int categoryColumnIndex = cursor.getColumnIndex(groceryEntry.column_category);
            int countColumnIndex = cursor.getColumnIndex(groceryEntry.column_count);

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(itemnameColumnIndex);
                int currentCategory = cursor.getInt(categoryColumnIndex);
                int currentCount = cursor.getInt(countColumnIndex);
                // Display the values from each column of the current row in the cursor in the TextView
                displayView.append(("\n" + currentID + " - " +
                        currentName + " - " +
                        currentCategory + " - " +
                        currentCount));
            }
        }finally {
            cursor.close();
        }
        /**
         * displayDatabaseInfo ends here
         */
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /**
         * write code for delete options
         */
        return super.onOptionsItemSelected(item);
    }
}