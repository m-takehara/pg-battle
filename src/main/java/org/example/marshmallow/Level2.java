package org.example.marshmallow;

public class Level2 {
    public static void main(String[] args) {
        final String message = execute(args);
        System.out.println(message);
    }

    static String execute(String[] args) {
        String arg = args[0];
        if (arg.matches("AtCoder")) {
            return Answer.YES.getMessage();
        }
        if (arg.matches("(?i)atcoder")) {
            return Answer.MAYBE.getMessage();
        }
        return Answer.NO.getMessage();
    }

    enum Answer {
        YES("Yes"),

        MAYBE("Maybe"),

        NO("No");

        private final String message;

        Answer(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
