package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}