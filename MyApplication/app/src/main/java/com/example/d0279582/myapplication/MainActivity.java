package com.example.d0279582.myapplication;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.PendingIntent;
import android.nfc.NdefMessage;

import static com.example.d0279582.myapplication.Constants.userID;
import static com.example.d0279582.myapplication.Constants.users;

public class MainActivity extends AppCompatActivity {
    private NdefMessage mNdefPushMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int points = 0;

        Intent startIntent = getIntent();
        if (startIntent.hasExtra("EXTRA_NAME")) {
                Bundle extras = startIntent.getExtras();
                String userName = extras.getString("EXTRA_NAME");
                User user = new User(userName);
                users.put(userID, user);
        }

       // mTextView = (TextView) findViewById(R.id.textView_explanation);
        /*
        List<User> sortedList = new ArrayList<User>(users.values());
        Collections.sort(sortedList);
        String str = "";
        for (User u : sortedList.subList(0, 3)) {
            str += u.toString() + "\n";
        }
            mTextView.setText(str);
            */
        mAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mAdapter == null) {
            //nfc is not supported by your device.
            return;
        }
        mPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this,
                getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

    }

    private TextView mTextView;

    NfcAdapter mAdapter;
    PendingIntent mPendingIntent;

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.enableForegroundDispatch(this, mPendingIntent, null, null);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAdapter != null) {
            mAdapter.disableForegroundDispatch(this);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {

        String action = intent.getAction();
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {

                // Unknown tag type
                byte[] id = intent.getByteArrayExtra(NfcAdapter.EXTRA_ID);
                userID = bytesToString(id).toString();

                if (users.containsKey(userID)) {
                    mTextView.setText("users: " + users);
                    Intent whatHaveYouDoneIntent = new Intent(this, WhatHaveYouDone.class);
                    startActivity(whatHaveYouDoneIntent);
                } else {
                    Intent registerIntent = new Intent(this, RegisterActivity.class);

                    startActivity(registerIntent);
                }

            //mTextView.setText("Read content: " + "     "+  userID);
        }
    }


    private static StringBuilder bytesToString(byte[] bs) {
        StringBuilder s = new StringBuilder();
        for (byte b : bs) {
            s.append(String.format("%02X", b));
        }
        return s;
    }

    @Override
    public Intent getIntent() {
        return super.getIntent();
    }
}
