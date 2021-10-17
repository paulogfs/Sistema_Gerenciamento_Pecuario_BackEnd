package com.projetointegrado.gerenciamentobolvino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrado.gerenciamentobolvino.domain.StatusRacaoAndLote;

@Repository
public interface StatusRacaoAndLoteRepository extends JpaRepository<StatusRacaoAndLote, Integer>{

}
