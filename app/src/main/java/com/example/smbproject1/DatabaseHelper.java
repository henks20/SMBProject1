package com.example.smbproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "shoppinglist";
    public static  final String DATABASE_NAME = "project1.db";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PRICE";
    public static final String COL_4 = "QUANTITY";
    public static final String COL_5 = "BOUGHT";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (NAME TEXT, PRICE INT, QUANTITY INT, BOUGHT INT)");
    }

     @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

     }

     public void insertData(String name, Integer price, Integer quantity, Integer bought ) {
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues contentValues = new ContentValues();
         contentValues.put(COL_2, name);
         contentValues.put(COL_3, price);
         contentValues.put(COL_4, quantity);
         contentValues.put(COL_5, bought);
         System.out.println("insertData "+db.insert(TABLE_NAME, null, contentValues));
     }

    public ArrayList<ItemActivity> getAllItems() {
        ArrayList<ItemActivity> itemsList = new ArrayList<ItemActivity>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                System.out.println("gwtAllItems" + cursor.getString(0));
                ItemActivity item = new ItemActivity();
                item.setName(cursor.getString(0));
                item.setPrice(cursor.getInt(1));
                item.setQuantity(cursor.getInt(2));
                itemsList.add(item);
            } while (cursor.moveToNext());
        }
        db.close();
        return itemsList;
    }

     public boolean updateData(String id, String name, Integer price, Integer quantity, Integer bought) {
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues contentValues = new ContentValues();
         contentValues.put(COL_2, name);
         contentValues.put(COL_3, price);
         contentValues.put(COL_4, quantity);
         contentValues.put(COL_5, bought);
         db.update(TABLE_NAME,contentValues, "NAME = ?", new String[] {id} );
         return true;
     }

     public Integer deleteData(String name) {
         SQLiteDatabase db = this.getWritableDatabase();
         return db.delete(TABLE_NAME, "NAME = ?", new String[] {name});
     }



}
