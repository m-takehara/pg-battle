package org.example.marshmallow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Level3 {
    public static void main(String[] args) {
        final Input input = getArgsFromStdIn();
        System.out.println(execute(input));
    }

    static int execute(Input input) {
        final int max = Math.max(input.pinCount, input.playerCount);

        final List<List<Integer>> pins = IntStream.range(0, input.pinCount).parallel().mapToObj(i ->
                IntStream.range(0, max).mapToObj(j -> i + j + 1).collect(Collectors.toList()))
                .collect(Collectors.toList());
        final List<List<Integer>> players = IntStream.range(0, input.playerCount).mapToObj(i ->
                IntStream.range(0, max).mapToObj(j -> {
                    final Pair pair = input.players.get(i);
                    return pair.a + pair.b <= j && j % pair.a == 0 ? i + 1 : 0;
                }).collect(Collectors.toList())).collect(Collectors.toList());
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < pins.size(); i++) {
            for (int j = 0; j < players.size(); j++) {
                for (int k = 0; k < max; k++) {
                    if (pins.get(i).get(k).equals(players.get(j).get(k))) {
                        result.add(i);
                    }
                }
            }
        }
        return (int) result.stream().distinct().count();
    }

    private static Input getArgsFromStdIn() {
        final Scanner scanner = new Scanner(System.in);
        final String first = scanner.nextLine();
        final String[] splitted = first.split("\\s");
        final int n = Integer.parseInt(splitted[0]);
        final int m = Integer.parseInt(splitted[1]);

        final List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            final String line = scanner.nextLine();
            final String[] split = line.split("\\s");
            pairs.add(new Pair(split[0], split[1]));
        }
        scanner.close();

        return new Input(n, m, pairs);
    }

    static class Input {
        private final int playerCount;
        private final int pinCount;
        private final List<Pair> players;

        Input(int playerCount, int pinCount, List<Pair> players) {
            this.playerCount = playerCount;
            this.pinCount = pinCount;
            this.players = players;
        }
    }

    static class Pair {
        private final int a;
        private final int b;

        Pair(String a, String b) {
            this.a = Integer.parseInt(a);
            this.b = Integer.parseInt(b);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) {
                return false;
            }
            return this.a == ((Pair) obj).a && this.b == ((Pair) obj).b;
        }
    }
}
