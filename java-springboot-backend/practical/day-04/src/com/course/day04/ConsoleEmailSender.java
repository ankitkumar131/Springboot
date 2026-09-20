package com.course.day04;

public class ConsoleEmailSender implements EmailSender {
    @Override
    public void send(String to, String body) {
        System.out.println("[console] to=" + to + " body=" + body);
    }
}
