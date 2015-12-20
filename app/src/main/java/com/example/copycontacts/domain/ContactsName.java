package com.example.copycontacts.domain;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;
import com.example.copycontacts.base.Repository;
import com.example.copycontacts.domain.entities.Calls;
import java.util.ArrayList;

/**
 * Created by Михайлик on 12.12.2015.
 */
public class ContactsName {
    String name;
    Repository repository;
    Context context;

    public ContactsName(Context context) {
        this.context = context;
    }

    public void getContactsName(ContentResolver contentResolver) {
        repository = new Repository(context);
        Cursor cursor = contentResolver.query(ContactsContract
                .CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        ArrayList<String> nameNumberArray = new ArrayList<String>();
        ArrayList list = new ArrayList();

        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    name = cursor.getString(cursor.getColumnIndex(ContactsContract
                            .Contacts.DISPLAY_NAME));
                    nameNumberArray.add(name);
                } while (cursor.moveToNext());

            }
            for (String item : nameNumberArray) {
                char[] chars = item.toCharArray();
                for (char contactArray : chars) {
                    if ( contactArray == 'а') {
                        repository.insertCalls(new Calls(0,item));
                    }
                }
            }
        }
    }
}
