package com.algaworks.algatransito.domain.service;

import com.algaworks.algatransito.domain.exception.DomainException;
import com.algaworks.algatransito.domain.model.Proprietario;
import com.algaworks.algatransito.domain.model.StatusVeiculo;
import com.algaworks.algatransito.domain.model.Veiculo;
import com.algaworks.algatransito.domain.repository.ProprietarioRepository;
import com.algaworks.algatransito.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ProprietarioService proprietarioService;

    @Transactional
    public Veiculo cadastrar(Veiculo novoVeiculo) {

        if (novoVeiculo.getId() != null) {
            throw new DomainException("Veículo a ser cadastrado não deve possuir código");
        }
        boolean placaEmUso = veiculoRepository.findByPlaca(novoVeiculo.getPlaca())
                        .filter(veiculo -> !veiculo.equals(novoVeiculo))
                        .isPresent();
        if (placaEmUso) {
            throw new DomainException("Já existe um veículo cadastrado com esta placa");
        }

        Proprietario proprietario = proprietarioService.buscar(novoVeiculo.getProprietario().getId());

        novoVeiculo.setProprietario(proprietario);
        novoVeiculo.setStatus(StatusVeiculo.REGULAR);
        novoVeiculo.setDataCadastro(LocalDateTime.now());

        return veiculoRepository.save(novoVeiculo);
    }


}
