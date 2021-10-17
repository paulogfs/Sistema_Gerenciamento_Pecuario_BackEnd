package com.projetointegrado.gerenciamentobolvino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrado.gerenciamentobolvino.domain.Pasto;

@Repository
public interface PastoRepository extends JpaRepository<Pasto, Integer>{

}
