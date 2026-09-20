package com.course.day04;

/** Anti-pattern: dependency is invisible. Tests must poke the field. */
public class BrokenFieldNotifier {
    public EmailSender email;

    public void welcome(String to) {
        email.send(to, "Welcome");
    }
}
