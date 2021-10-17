package com.projetointegrado.gerenciamentobolvino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrado.gerenciamentobolvino.domain.Racao;

@Repository
public interface RacaoRepository extends JpaRepository<Racao, Integer>{

}
