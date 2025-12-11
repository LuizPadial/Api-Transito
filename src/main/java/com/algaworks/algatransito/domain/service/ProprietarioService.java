package com.algaworks.algatransito.domain.service;
import com.algaworks.algatransito.domain.exception.DomainException;
import com.algaworks.algatransito.domain.model.Proprietario;
import com.algaworks.algatransito.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    public Proprietario buscar(Long proprietarioId) {
        return proprietarioRepository.findById(proprietarioId)
                .orElseThrow(() -> new DomainException("Propietário não encontrado"));
    }

    @Transactional
    public Proprietario salvar(Proprietario proprietario){
        boolean emailEmUso = proprietarioRepository.findByEmail(proprietario.getEmail())
                .filter(p -> !p.equals(proprietario))
                .isPresent();

        if (emailEmUso) {
            throw new DomainException("Já existe um proprietário com esse email");
        }

        return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void excluir(Long proprietarioId) {
        proprietarioRepository.deleteById(proprietarioId);
    }

}
