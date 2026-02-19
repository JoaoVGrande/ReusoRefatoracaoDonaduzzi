package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import br.com.nogueiranogueira.aularefatoracao.solidproject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegraUsuarioVIP implements RegraUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public boolean suporta(String tipo) {
        return "VIP".equals(tipo);
    }

    @Override
    public Usuario processar(UsuarioDTO dto) {
        if (dto.email() == null || !dto.email().contains("@")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        if (dto.idade() < 18) {
            throw new IllegalArgumentException("Usuário deve ser maior de idade");
        }

        Usuario usuario = new Usuario(dto.nome(), dto.email(), dto.tipo());
        usuario.setPontos(100);
        return usuarioRepository.save(usuario);
    }
}