package br.com.nogueiranogueira.aularefatoracao.solidproject.service;

import br.com.nogueiranogueira.aularefatoracao.solidproject.model.Descontavel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescontoService {
    public int calculaDescontoTotal(List<? extends Descontavel> itens) {
        return itens.stream()
                .mapToInt(Descontavel::getDesconto)
                .sum();
    }
}
