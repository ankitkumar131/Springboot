package com.course.day04;

public class Day04App {
    public static void main(String[] args) {
        EmailSender smtp = new ConsoleEmailSender();
        EmailSender logged = new LoggingEmailSender(smtp);
        Notifier notifier = new Notifier(logged);
        notifier.welcome("ada@example.com");

        BrokenFieldNotifier broken = new BrokenFieldNotifier();
        try {
            broken.welcome("ada@example.com");
        } catch (NullPointerException ex) {
            System.out.println("Field injection forgot the dependency: " + ex);
        }
        broken.email = smtp;
        broken.welcome("ada@example.com");
    }
}
