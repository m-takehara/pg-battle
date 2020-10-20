package org.example.marshmallow;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.example.marshmallow.Level3.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Level3Test {

    @Test
    public void 問題集に載っている入力例をパスすること_1本倒し() {
        final List<Pair> pairs = Arrays.asList(
                new Pair("2", "3"),
                new Pair("1", "2"),
                new Pair("1", "1"),
                new Pair("2", "1")
        );
        final Input input = new Input(4, 10, pairs);
        final int result = execute(input);

        assertEquals(1, result);
    }

    @Test
    public void 問題集に載っている入力例をパスすること_0本倒し() {
        final List<Pair> pairs = Arrays.asList(
                new Pair("100", "100"),
                new Pair("100", "100"),
                new Pair("100", "100"),
                new Pair("100", "100"),
                new Pair("100", "100")
        );
        final Input input = new Input(5, 5, pairs);
        final int result = execute(input);

        assertEquals(0, result);
    }
}
