package com.example.d0279582.myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.d0279582.myapplication.Constants.userID;
import static com.example.d0279582.myapplication.Constants.users;

public class NewScoreActivity extends AppCompatActivity {
    private User user;
    private TextView addedPoints;
    private TextView totalPoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_score);

        addedPoints = findViewById(R.id.added_points);
        totalPoints= findViewById(R.id.total_points);

        int points = 0;
        user = users.get(userID);

        Intent startIntent = getIntent();
        if (startIntent != null) {
            if (startIntent.hasExtra("EXTRA_POINTS")) {
                Bundle extras = startIntent.getExtras();
                String str = extras.getString("EXTRA_POINTS");
                points = Integer.parseInt(str);
                addPoints(points);
            }
        }
        final NewScoreActivity activity = this;
        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                Intent backIntent = new Intent(activity, MainActivity.class);
                startActivity(backIntent);}
        }.start();


    }

    private void addPoints(int points) {
        user.setPoints(user.getPoints() + points);
        addedPoints.setText("Danke, du hast " + points + " Punkte erhalten.");
        totalPoints.setText("Insgesamt hast du nun " + user.getPoints() + " Punkte.");
    }
}
