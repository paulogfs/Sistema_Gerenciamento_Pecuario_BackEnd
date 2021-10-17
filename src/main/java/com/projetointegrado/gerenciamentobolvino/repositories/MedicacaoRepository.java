package com.projetointegrado.gerenciamentobolvino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrado.gerenciamentobolvino.domain.Medicacao;

@Repository
public interface MedicacaoRepository extends JpaRepository<Medicacao, Integer>{

}
