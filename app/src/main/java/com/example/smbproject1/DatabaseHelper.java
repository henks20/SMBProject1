package com.example.smbproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "ShoppingList_db";
    public static  final String DATABASE_NAME = "project1.db";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PRICE";
    public static final String COL_4 = "QUANTITY";
    public static final String COL_5 = "BOUGHT";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PRICE INTEGER, QUANTITY INTEGER, BOUGHT INTEGER)");
    }

     @Override
     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

     }

     public boolean insertData(String name, Integer price, Integer quantity, Integer bought ) {
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues contentValues = new ContentValues();
         contentValues.put(COL_2, name);
         contentValues.put(COL_3, price);
         contentValues.put(COL_4, quantity);
         contentValues.put(COL_5, bought);
//         db.insert(TABLE_NAME, null, contentValues);
//         db.close();
         long result = db.insert(TABLE_NAME, null, contentValues);
         if(result == -1 )
             return false;
         else
             return  true;
//         db.close()
     }

     public Cursor getAllData() {
         SQLiteDatabase db = this.getWritableDatabase();
         Cursor result = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
//         db.close();
         return result;
     }

     public boolean updateData(String id, String name, Integer price, Integer quantity, Integer bought) {
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues contentValues = new ContentValues();
         contentValues.put(COL_1, id);
         contentValues.put(COL_2, name);
         contentValues.put(COL_3, price);
         contentValues.put(COL_4, quantity);
         contentValues.put(COL_5, bought);
         db.update(TABLE_NAME,contentValues, "ID = ?", new String[] {id} );
//         db.close();
         return true;
     }

     public Integer deleteData(String id) {
         SQLiteDatabase db = this.getWritableDatabase();
         return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
     }



}
