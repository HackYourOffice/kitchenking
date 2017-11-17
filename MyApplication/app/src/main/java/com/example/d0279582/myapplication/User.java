package com.example.d0279582.myapplication;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private final String name;
    private int points;
}
