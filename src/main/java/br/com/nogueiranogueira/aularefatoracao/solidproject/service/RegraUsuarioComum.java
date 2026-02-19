package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegraUsuarioComum implements RegraUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public boolean suporta(String tipo) {
        return "COMUM".equals(tipo);
    }

    @Override
    public Usuario processar(UsuarioDTO dto) {
        if (dto.email() == null || !dto.email().contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        Usuario usuario = new Usuario(dto.nome(), dto.email(), dto.tipo());
        usuario.setPontos(0);
        return usuarioRepository.save(usuario);
    }
}