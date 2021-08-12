package com.example.chapter2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    private final List<Integer> integers =
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Test
    @DisplayName("동작 파라미터화 테스트 : 정수형 리스트")
    void extract_even_integer() {
        List<Integer> evenIntegers =
                Filter.filter(integers, (Integer i) -> i % 2 == 0);

        assertEquals(0, evenIntegers.get(0) % 2);
    }

}