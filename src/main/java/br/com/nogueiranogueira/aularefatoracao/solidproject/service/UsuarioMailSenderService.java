package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMailSenderService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmailService emailService;

    public void enviarEmailBoasVindas(String email) {
        // Lógica para enviar email de boas-vindas
        String assunto = "Bem-vindo ao nosso sistema!";
        String mensagem = "Olá! Obrigado por se cadastrar em nosso sistema.";
        emailService.sendEmail(email, assunto, mensagem);
    }


}
