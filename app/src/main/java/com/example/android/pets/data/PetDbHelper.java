package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;

/**
 * Created by jonathanbarrera on 2/26/18.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = "PetDbHelper.class.getSimpleName()";

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;

    // Name of the database
    public static final String DATABASE_NAME = "shelter.db";

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        // Create a string that contains the SQL statement
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetEntry.TABLE_NAME + " (" +
                        PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PetEntry.COLUMN_PET_NAME + " TEXT NON NULL, " +
                        PetEntry.COLUMN_PET_BREED + " TEXT, " +
                        PetEntry.COLUMN_PET_GENDER + " INTEGER NON NULL, " +
                        PetEntry.COLUMN_PET_WEIGHT + " INTEGER NON NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Still on Version 1, so for the moment leave empty.
    }
}
