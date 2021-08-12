package com.example.chapter2.predicate;

import com.example.chapter2.Apple;
import com.example.chapter2.ApplePredicate;

public class AppleHeavyWeightPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }

}
