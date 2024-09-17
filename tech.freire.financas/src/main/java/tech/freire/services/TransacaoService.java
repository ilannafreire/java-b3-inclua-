package tech.freire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.freire.model.Transacao;
import tech.freire.repository.TransacaoRepository;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao salvarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> listarTodasTransacoes() {
        return transacaoRepository.findAll();
    }
}
