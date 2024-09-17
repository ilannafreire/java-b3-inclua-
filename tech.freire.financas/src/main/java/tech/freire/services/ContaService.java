package tech.freire.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.freire.model.Conta;
import tech.freire.repository.ContaRepository;

import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public Optional<Conta> buscarContaPorId(Long id) {
        return contaRepository.findById(id);
    }

    public void deletarConta(Long id) {
        contaRepository.deleteById(id);
    }
}