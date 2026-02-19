package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.dto.UsuarioDTO;
import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenciadorUsuarioService {

    @Autowired
    private List<RegraUsuario> regras;

    public Usuario criarUsuario(UsuarioDTO dto) {
        return regras.stream()
                .filter(regra -> regra.suporta(dto.tipo()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo inválido"))
                .processar(dto);
    }
}
