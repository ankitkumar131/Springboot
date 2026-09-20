package com.course.day04;

public class LoggingEmailSender implements EmailSender {
    private final EmailSender delegate;

    public LoggingEmailSender(EmailSender delegate) {
        this.delegate = delegate;
    }

    @Override
    public void send(String to, String body) {
        System.out.println("[log] sending to " + to);
        delegate.send(to, body);
    }
}
