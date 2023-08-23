package com.example.soumyakant_menu_activity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "UserManager.db";
    private static final String TABLE_USER="useer";
    private static final String COLUMN_USER_ID="user_id";
    private static final String COLUMN_USER_NAME="user_name";
    private static final String COLUMN_USER_EMAIL="user_email";
    private static final String COLUMN_USER_PASSWORD="user_password";


    private  String CREATE_TABLE_USER =
            "CREATE TABLE " + TABLE_USER + " (" +
                    COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USER_NAME + " TEXT, " +
                    COLUMN_USER_EMAIL + " TEXT, " +
                    COLUMN_USER_PASSWORD + " TEXT" +
                    ");";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;



    public DatabaseHelper(Context context) {
        super (context, DATABASE_NAME, null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL (CREATE_TABLE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean checkUserByUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {
                COLUMN_USER_ID
        };
        String selection = COLUMN_USER_NAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        return cursorCount > 0;
    }



    public void addUser(User User) {
        SQLiteDatabase db =this.getWritableDatabase ();
        ContentValues values = new ContentValues ();
        values.put (COLUMN_USER_NAME, User.getName());
        values.put (COLUMN_USER_EMAIL, User.getEmail());
        values.put (COLUMN_USER_PASSWORD, User.getPassword());
        db.insert (TABLE_USER,null,values);
        db.close ();

    }



    @SuppressLint("Range")
    public User getUserDetails(int userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        User user = new User();

        Cursor cursor = db.query(
                TABLE_USER,
                new String[]{COLUMN_USER_NAME, COLUMN_USER_EMAIL},
                COLUMN_USER_ID + "=?",
                new String[]{String.valueOf(userId)},
                null, null, null
        );

        if (cursor != null && cursor.moveToFirst()) {
            user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
            user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
            cursor.close();
        }

        db.close();

        return user;
    }

}
