package com.projetointegrado.gerenciamentobolvino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrado.gerenciamentobolvino.domain.HistoricoMedicacao;

@Repository
public interface HistoricoMedicacaoRepository extends JpaRepository<HistoricoMedicacao, Integer>{

}
