package com.example.copycontacts.base;


import android.content.ContentValues;
import android.database.Cursor;

import com.example.copycontacts.domain.entities.Calls;

import java.util.Date;

/**
 * Created by Михайлик on 06.12.2015.
 */
public class TABLE {
    public static class CALLS {
        public final static String TABLE_NAME = "CALLS";
        public final static String ID = "CALLS_ID";
        public final static String NAME = "PHONE";

        public static String createTable() {
            return " create table " + TABLE_NAME + " ( " +
                    ID + " integer primary key autoincrement, " +
                    NAME + " text " +
                    " ) ";
        }
        public static String drop()
        {
            return "drop table " + TABLE_NAME;
        }



        public static ContentValues getContentValues(Calls calls, boolean addId) {
            ContentValues values = new ContentValues();
            if (addId) {
                values.put(ID, calls.getId());
            }
            values.put(NAME, calls.getName());
            return values;
        }

        public static Calls getCalls(Cursor cursor) {
            int indexId = cursor.getColumnIndexOrThrow(ID);
            int indexPhone = cursor.getColumnIndexOrThrow(NAME);

            return new Calls(
                    cursor.getLong(indexId),
                    cursor.getString(indexPhone));
        }
    }
}