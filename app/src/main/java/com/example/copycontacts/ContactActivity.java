package com.example.copycontacts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.copycontacts.ui.service.ContactService;

public class ContactActivity extends AppCompatActivity{

    TextView textView;
    Button startBtn;
    ProgressBar progressBar;
    private BroadcastReceiver receiver = new ContactReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        textView = (TextView) findViewById(R.id.activity_contacts_name);

        startBtn = (Button) findViewById(R.id.button);

        IntentFilter intentFilter = new IntentFilter(ContactService.con);
        registerReceiver(receiver, intentFilter);
    }

    public void startService(View view){
        progressBar.setVisibility(ProgressBar.VISIBLE);
        startBtn.setEnabled(false);
        Intent intent = new Intent();
        int base = intent.getIntExtra("size",0);

        startService(new Intent(this,ContactService.class));
    }

    public class ContactReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean finish = intent.getBooleanExtra("value", false);
            int count = intent.getIntExtra("size", 0);
            if (finish)
            {
                textView.setText("All contacts whith 'a' = " + count);
                progressBar.setVisibility(ProgressBar.GONE);
            }
            }
    }

    }