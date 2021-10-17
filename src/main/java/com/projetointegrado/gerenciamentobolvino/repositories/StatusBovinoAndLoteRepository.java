package com.projetointegrado.gerenciamentobolvino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrado.gerenciamentobolvino.domain.StatusBovinoAndLote;

@Repository
public interface StatusBovinoAndLoteRepository extends JpaRepository<StatusBovinoAndLote, Integer>{

}
