package com.example.copycontacts.ui.service;

import android.app.IntentService;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.copycontacts.R;
import com.example.copycontacts.base.Repository;
import com.example.copycontacts.domain.ContactsName;
import com.example.copycontacts.domain.entities.Calls;
import com.example.copycontacts.ui.Presenter;

import java.util.ArrayList;

/**
 * Created by Михайлик on 13.12.2015.
 */
public class ContactService extends IntentService {
    public static final String con = ".ui.service.ContactService";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

    Repository repository;
    ContactsName contactsName;
    private ArrayList list;
    public ContactService(String name) {
        super(name);
    }

    public ContactService(){
        super("ContactService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        repository = new Repository(this);
        list = (ArrayList) repository.getCalls();

        contactsName = new ContactsName(this);
        contactsName.getContactsName(getContentResolver());

        Intent someIntent = new Intent(con);
        someIntent.putExtra("size", list.size());
        someIntent.putExtra("value",true);
        sendBroadcast(someIntent);

    }
}

