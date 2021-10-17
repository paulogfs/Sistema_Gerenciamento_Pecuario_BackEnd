package com.projetointegrado.gerenciamentobolvino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrado.gerenciamentobolvino.domain.StatusPastoAndLote;

@Repository
public interface StatusPastoAndLoteRepository extends JpaRepository<StatusPastoAndLote, Integer>{

}
