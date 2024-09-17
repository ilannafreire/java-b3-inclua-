package tech.freire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.freire.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}