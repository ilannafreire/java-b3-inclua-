package tech.freire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.freire.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
