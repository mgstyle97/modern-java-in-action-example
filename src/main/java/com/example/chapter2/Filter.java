package com.example.chapter2;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }

        return result;
    }

}
