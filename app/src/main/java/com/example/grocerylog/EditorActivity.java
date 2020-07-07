package com.example.grocerylog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.grocerylog.data.groceryContract.groceryEntry;
import com.example.grocerylog.data.grocerydbhelper;

public class EditorActivity extends AppCompatActivity {
    //
    grocerydbhelper mDbHelper;
    //
    SQLiteDatabase db;
    //
    private EditText mitemnameEditText;
    private Spinner mCategorySpinner;
    private int mItem =groceryEntry.NonVeg ;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        mitemnameEditText = (EditText) findViewById(R.id.edit_item_name);
        mCategorySpinner = (Spinner) findViewById(R.id.spinner_category);
        setupSpinner();
        mDbHelper = new grocerydbhelper(this);
        /**
         * oncreate ends here
         */
    }
    public void setupSpinner(){
        ArrayAdapter<CharSequence> CategorySpinnerAdapter = ArrayAdapter.createFromResource(this,R.array.category,android.R.layout.simple_spinner_item);
        CategorySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCategorySpinner.setAdapter(CategorySpinnerAdapter);
        mCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String selection = (String) parent.getItemAtPosition(pos);
                if (!TextUtils.isEmpty(selection)){
                    if (selection.equals("NonVeg")) {
                        mItem = groceryEntry.NonVeg;
                    } else if (selection.equals("Vegetable")) {
                        mItem = groceryEntry.Vegetable;
                    } else if (selection.equals("Fruits")) {
                        mItem = groceryEntry.Fruits;
                    } else if (selection.equals("Masalla")) {
                        mItem = groceryEntry.Masalla;
                    } else if (selection.equals("Snacks")) {
                        mItem = groceryEntry.Snacks;
                    } else if (selection.equals("HomeCare")) {
                        mItem = groceryEntry.Homecare;
                    } else {
                        mItem = groceryEntry.Personalcare;
                    }
                }
                /**
                 * onItemSelected ends here
                 */
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mItem = 0; // Unknown
            }
            /**
             * setOnItemSelectedListener ends here
             */
        });
        /**
         * setupSpinner ends here
         */
    }
    private void insertgroceries(){
        String edit_text_item_name = mitemnameEditText.getText().toString();
        db = mDbHelper.getWritableDatabase();
        //
        ContentValues values = new ContentValues();
        values.put(groceryEntry.column_itemName, edit_text_item_name);
        values.put(groceryEntry.column_category, mItem);
        // Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = db.insert(groceryEntry.table_name, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving pet", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Pet saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                insertgroceries();
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}