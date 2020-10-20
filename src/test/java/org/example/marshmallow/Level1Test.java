package org.example.marshmallow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Level1Test {
    @ParameterizedTest
    @MethodSource("params")
    void 問題集に載っている入力例をパスすること(String[] args, String expectedAnswer) {
        final String actualAnswer = Level1.execute(args);
        assertEquals(expectedAnswer, actualAnswer);
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new String[]{"8", "3", "6"}, "Yes"),
                arguments(new String[]{"8", "3", "5"}, "Yes"),
                arguments(new String[]{"8", "3", "4"}, "No"),
                arguments(new String[]{"100", "50", "10"}, "No")
        );
    }
}