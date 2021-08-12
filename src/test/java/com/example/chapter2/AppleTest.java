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
    @DisplayName("사과 색상: 빨강 - 익명 클래스 사용")
    void extract_apple_list_color_red_usage_anonymous_class() {
        List<Apple> redApples = Apple.filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });

        assertEquals(Color.RED, redApples.get(0).getColor());
    }

    @Test
    @DisplayName("사과 색상: 빨강 - 람다 표현식 사용")
    void extract_apple_list_color_red_usage_lambda_expression() {
        List<Apple> redApples = Apple.filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));

        assertEquals(Color.RED, redApples.get(0).getColor());
    }

    @Test
    @DisplayName("사과 무게: 150 초과")
    void extract_apple_list_weight_over_150() {
        ApplePredicate predicate = new AppleHeavyWeightPredicate();
        List<Apple> weightOver150Apples = Apple.filterApples(inventory, predicate);

        assertTrue(weightOver150Apples.get(0).getWeight() > 150);
    }

}