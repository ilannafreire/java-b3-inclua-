package tech.freire.controller;


import org.springframework.web.bind.annotation.*;
import tech.freire.model.Conta;
import tech.freire.model.TipoTransacao;
import tech.freire.model.Transacao;
import tech.freire.services.ContaService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class ContaController {

    @RequestMapping("/conta")
    @ResponseBody
    public Conta criarConta() {
        Conta conta = new Conta();
        conta.setSaldo(new BigDecimal("500.00")); // Define o saldo inicial

        // Criando duas transações
        Transacao transacao1 = new Transacao();
        transacao1.setDescricao("Depósito inicial");
        transacao1.setValor(new BigDecimal("200.00"));
        transacao1.setHorario(LocalDateTime.now());
        transacao1.setTipo(TipoTransacao.OUTROS);

        Transacao transacao2 = new Transacao();
        transacao2.setDescricao("Pagamento de contas");
        transacao2.setValor(new BigDecimal("100.00"));
        transacao2.setHorario(LocalDateTime.now());
        transacao2.setTipo(TipoTransacao.OUTROS);

        // Adiciona as transações à conta
        conta.setTransacoes(new ArrayList<>());
        conta.getTransacoes().add(transacao1);
        conta.getTransacoes().add(transacao2);

        return conta; // Retorna a conta com o saldo e as transações
    }

    private ContaService contaService;

    @PostMapping("/salvar")
    public Conta salvarConta(@RequestBody Conta conta) {
        return contaService.salvarConta(conta);
    }

    @GetMapping("/{id}")
    public Optional<Conta> buscarConta(@PathVariable Long id) {
        return contaService.buscarContaPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarConta(@PathVariable Long id) {
        contaService.deletarConta(id);
    }
}

