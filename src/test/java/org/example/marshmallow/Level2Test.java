package org.example.marshmallow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.marshmallow.Level2.Answer.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Level2Test {
    @ParameterizedTest
    @MethodSource("params")
    void 問題集に載っている入力例をパスすること(String[] args, String expectedAnswer) {
        final String actualAnswer = Level2.execute(args);
        assertEquals(expectedAnswer, actualAnswer);
    }

    static Stream<Arguments> params() {
        return Stream.of(
                arguments(new String[]{"AtCoder"}, YES.getMessage()),
                arguments(new String[]{"Atcoder"}, MAYBE.getMessage()),
                arguments(new String[]{"ACCoder"}, NO.getMessage())
        );
    }
}
