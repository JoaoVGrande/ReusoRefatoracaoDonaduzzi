package br.com.nogueiranogueira.aularefatoracao.solidproject.repository;

import java.util.List;

public interface UsuarioRelatorioRepository {
    List<Object[]> gerarRelatorioUsuariosPorTipo();
}