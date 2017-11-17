package com.example.d0279582.myapplication;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import android.app.PendingIntent;
import android.nfc.NdefMessage;

public class MainActivity extends AppCompatActivity {
    private NdefMessage mNdefPushMessage;
    private Map<String, User> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = new HashMap<>();
        int points = 0;

        Intent startIntent = getIntent();
        if (startIntent != null && startIntent.hasExtra("EXTRA_POINTS")) {
            Bundle extras = startIntent.getExtras();
            String str =  extras.getString("EXTRA_POINTS");
            points = Integer.parseInt(str);
        }

        mTextView = (TextView) findViewById(R.id.textView_explanation);
        mTextView.setText("" + points);
        mAdapter = NfcAdapter.getDefaultAdapter(this);
        if (mAdapter == null) {
            //nfc not support your device.
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
                String tagId = bytesToString(id).toString();

                if (users.containsKey(tagId)) {
                    //login
                } else {
                    //Intent registerIntent = new Intent(this, RegisterActivity.class);
                    Intent registerIntent = new Intent(this, WhatHaveYouDone.class);
                    startActivity(registerIntent);
                }

                mTextView.setText("Read content: " + "     "+  tagId);
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
