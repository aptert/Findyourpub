package com.example.tomapter.findyourpub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by tomapter on 22/11/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(Context context){
        super(context, "testDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE userTable (colId, colName, colUsername, colPassword)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addUser(User user) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();


        ContentValues contentValues = new ContentValues();
        contentValues.put("colId", user.getId());
        contentValues.put("colName", user.getName());
        contentValues.put("colUserName", user.getUserName());
        contentValues.put("colPassword", user.getPassword());



        long result = sqLiteDatabase.insert("userTable", null, contentValues);

        if (result > 0) {
            Log.d("dbhelper", "inserted successfully");
        } else {
            Log.d("dbhelper", "failed to insert");
        }
        sqLiteDatabase.close();
    }

    // Getting single user
    public User getUser(String userName) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("userTable", new String[] { "ColId", "colUserName","colName",
                "colPassword" }, "colUserName" + "=?",
                new String[] { String.valueOf(userName) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        User user = new User(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3));
        // return contact
        return user;
    }



    public void deleteTable(){
        SQLiteDatabase db = getReadableDatabase();
        db.execSQL("DROPTABLE");
    }
}
