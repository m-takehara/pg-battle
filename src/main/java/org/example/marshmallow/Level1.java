package org.example.marshmallow;

// https://products.sint.co.jp/hubfs/resource/topsic/pgb/1-1.pdf
public class Level1 {
    public static void main(String[] args) {
        String answer = execute(args);
        System.out.println(answer);
    }

    static String execute(String[] args) {
        if (args.length != 3) {
            System.err.println("Invalid Input.");
        }

        final int width = Integer.parseInt(args[0]);
        final int k = Integer.parseInt(args[1]);
        final int distance = Integer.parseInt(args[2]);

        boolean canJump = k <= distance && width - k <= distance;
        return canJump ? "Yes" : "No";
    }
}
