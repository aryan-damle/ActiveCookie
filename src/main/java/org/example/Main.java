package org.example;

public class Main {
    private Main() {

    }
    public static void main(final String[] theArgs) {
        final parseCookies pc = new parseCookies();
        pc.readCookies();
        System.out.println("hi");
        System.out.println(pc.readCookies());
    }
}