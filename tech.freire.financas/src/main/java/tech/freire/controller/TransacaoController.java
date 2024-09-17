package tech.freire.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tech.freire.model.TipoTransacao;
import tech.freire.model.Transacao;
import tech.freire.services.TransacaoService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@RestController
public class TransacaoController {

    @RequestMapping("/transacao")
    @ResponseBody
    public Transacao obtemTransacao() {
        Transacao transacao = new Transacao();
        transacao.setDescricao("Minha primeira transacao");
        transacao.setValor(new BigDecimal("100.00"));
        transacao.setHorario(LocalDateTime.now());
        transacao.setTipo(TipoTransacao.OUTROS);
        return transacao;
    }
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("transacao/salvar")
    public Transacao salvarTransacao(@RequestBody Transacao transacao) {
        return transacaoService.salvarTransacao(transacao);
    }

    @GetMapping("/todas")
    public List<Transacao> listarTransacoes() {
        return transacaoService.listarTodasTransacoes();
    }
}
