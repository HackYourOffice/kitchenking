package com.example.d0279582.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import static com.example.d0279582.myapplication.MainActivity.users;

/**
 * A register screen that offers registering with a name.
 */
public class RegisterActivity extends AppCompatActivity {
    // UI references.
    private EditText mNameView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Set up the login form.
        mNameView = (EditText) findViewById(R.id.name);

        Button mRegisterButton = (Button) findViewById(R.id.register_button);
        mRegisterButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        mLoginFormView = findViewById(R.id.register_form);
    }

    private void registerUser(){
        String name = mNameView.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EXTRA_NAME", name);
        startActivity(intent);
    }
}

