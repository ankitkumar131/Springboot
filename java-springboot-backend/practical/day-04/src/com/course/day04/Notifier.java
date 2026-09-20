package com.course.day04;

public class Notifier {
    private final EmailSender email;

    public Notifier(EmailSender email) {
        this.email = email;
    }

    public void welcome(String to) {
        email.send(to, "Welcome to the course");
    }
}
