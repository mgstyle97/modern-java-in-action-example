package com.example.chapter2.predicate;

import com.example.chapter2.Apple;
import com.example.chapter2.ApplePredicate;
import com.example.chapter2.Color;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }

}
