package com.example.chapter2;

import com.example.chapter2.predicate.AppleGreenColorPredicate;
import com.example.chapter2.predicate.AppleHeavyWeightPredicate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppleTest {

    private List<Apple> inventory;

    @BeforeAll
    void setup() {
        inventory = new ArrayList<>();
        Apple[] apples = {
                new Apple(Color.GREEN, 100),
                new Apple(Color.GREEN, 180),
                new Apple(Color.RED, 170)
        };
        inventory.addAll(
                Arrays.asList(apples)
        );
    }

    @Test
    @DisplayName("사과 색상: 녹색")
    void extract_apple_list_color_green() {
        ApplePredicate predicate = new AppleGreenColorPredicate();
        List<Apple> greenApples = Apple.filterApples(inventory, predicate);

        assertAll(
                () -> assertEquals(Color.GREEN, greenApples.get(0).getColor()),
                () -> assertNotEquals(Color.RED, greenApples.get(greenApples.size()-1).getColor())
        );
    }

    @Test
    @DisplayName("사과 무게: 150 초과")
    void extract_apple_list_weight_over_150() {
        ApplePredicate predicate = new AppleHeavyWeightPredicate();
        List<Apple> weightOver150Apples = Apple.filterApples(inventory, predicate);

        assertTrue(weightOver150Apples.get(0).getWeight() > 150);
    }

}