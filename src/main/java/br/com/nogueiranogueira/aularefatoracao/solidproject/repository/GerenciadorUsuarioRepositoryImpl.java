package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class GerenciadorUsuarioRepositoryImpl implements UsuarioCrudRepository {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public java.util.List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public void excluir(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}
