package com.example.d0279582.myapplication;

import android.support.annotation.NonNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User implements Comparable<User>{
    private final String name;
    private int points;

    @Override
    public int compareTo(@NonNull User user) {
        return user.getPoints() - this.getPoints();
    }

    @Override
    public String toString() {
        return this.name + " : " + this.points;
    }
}
