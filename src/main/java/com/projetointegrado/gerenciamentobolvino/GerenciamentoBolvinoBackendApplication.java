package com.projetointegrado.gerenciamentobolvino;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projetointegrado.gerenciamentobolvino.domain.Animal;
import com.projetointegrado.gerenciamentobolvino.domain.HistoricoMedicacao;
import com.projetointegrado.gerenciamentobolvino.domain.Lote;
import com.projetointegrado.gerenciamentobolvino.domain.Medicacao;
import com.projetointegrado.gerenciamentobolvino.domain.Pasto;
import com.projetointegrado.gerenciamentobolvino.domain.Peso;
import com.projetointegrado.gerenciamentobolvino.domain.Racao;
import com.projetointegrado.gerenciamentobolvino.domain.StatusBovinoAndLote;
import com.projetointegrado.gerenciamentobolvino.domain.StatusPastoAndLote;
import com.projetointegrado.gerenciamentobolvino.domain.StatusRacaoAndLote;
import com.projetointegrado.gerenciamentobolvino.domain.Usuario;
import com.projetointegrado.gerenciamentobolvino.domain.Venda;
import com.projetointegrado.gerenciamentobolvino.repositories.AnimalRepository;
import com.projetointegrado.gerenciamentobolvino.repositories.HistoricoMedicacaoRepository;
import com.projetointegrado.gerenciamentobolvino.repositories.LoteRepository;
import com.projetointegrado.gerenciamentobolvino.repositories.MedicacaoRepository;
import com.projetointegrado.gerenciamentobolvino.repositories.PastoRepository;
import com.projetointegrado.gerenciamentobolvino.repositories.PesoRepository;
import com.projetointegrado.gerenciamentobolvino.repositories.RacaoRepository;
import com.projetointegrado.gerenciamentobolvino.repositories.StatusBovinoAndLoteRepository;
import com.projetointegrado.gerenciamentobolvino.repositories.StatusPastoAndLoteRepository;
import com.projetointegrado.gerenciamentobolvino.repositories.StatusRacaoAndLoteRepository;
import com.projetointegrado.gerenciamentobolvino.repositories.UsuarioRepository;
import com.projetointegrado.gerenciamentobolvino.repositories.VendaRepository;


@SpringBootApplication
public class GerenciamentoBolvinoBackendApplication implements CommandLineRunner{

	@Autowired
	private AnimalRepository animalrepository;
	@Autowired
	private PesoRepository pesorepository;
	@Autowired
	private HistoricoMedicacaoRepository historicomedicacaorepository;
	@Autowired
	private MedicacaoRepository medicacaorepository;
	@Autowired
	private LoteRepository loterepository;
	@Autowired
	private PastoRepository pastorepository;
	@Autowired
	private RacaoRepository racaorepository;
	@Autowired
	private StatusBovinoAndLoteRepository statusbovinoandloterepository;
	@Autowired
	private StatusPastoAndLoteRepository statuspastoandloterepository;
	@Autowired
	private StatusRacaoAndLoteRepository statusracaoandloterepository;
	@Autowired
	private UsuarioRepository usuariorepository;
	@Autowired
	private VendaRepository vendarepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoBolvinoBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

        Animal ani1 = new Animal(null,"02PG","Nelore");
        Medicacao medic1 = new Medicacao(null, "12 meses", "Vitamina", "L01");
        Lote lot1 = new Lote(null, "15/10/2021", "Lote Brasileiro");
        Pasto past1 = new Pasto(null, "15/10/2021", "Pasto Brasileiro");
        Racao rac1 = new Racao(null, "Carne", "15/10/2021");
        Usuario user1 = new Usuario(null, "Paulo", "paulo", "paulo123", "15/10/2021");

        Peso pes1 = new Peso(null, "15/10/2021", 110, ani1);
        ani1.getPesos().addAll(Arrays.asList(pes1));
		Peso pes2 = new Peso(null, "16/10/2021", 220, ani1);
		ani1.getPesos().addAll(Arrays.asList(pes2));
		Peso pes3 = new Peso(null, "17/10/2021", 330, ani1);
		ani1.getPesos().addAll(Arrays.asList(pes3));

        HistoricoMedicacao histmedic1 = new HistoricoMedicacao(null, "15/10/2021", 350, ani1, medic1);
        ani1.getHistoricoMedicacaos().addAll(Arrays.asList(histmedic1));
        medic1.getHistoricoMedicacaos().addAll(Arrays.asList(histmedic1));

        StatusBovinoAndLote statusBovinoAndLote = new StatusBovinoAndLote(null, "15/10/2021", "19/10/2021", ani1, lot1);
        ani1.getStatusBovinoAndLotes().addAll(Arrays.asList(statusBovinoAndLote));
        lot1.getStatusBovinoAndLotes().addAll(Arrays.asList(statusBovinoAndLote));

        StatusPastoAndLote statusPastoAndLote = new StatusPastoAndLote(null, "15/10/2021", "30/10/2021", past1, lot1);
        past1.getStatusPastoAndLotes().addAll(Arrays.asList(statusPastoAndLote));
        lot1.getStatusPastoAndLotes().addAll(Arrays.asList(statusPastoAndLote));

        StatusRacaoAndLote statusRacaoAndLote = new StatusRacaoAndLote(null, "15/10/2021", "25/10/2021", rac1, lot1);
        rac1.getStatusRacaoAndLotes().addAll(Arrays.asList(statusRacaoAndLote));
        lot1.getStatusRacaoAndLotes().addAll(Arrays.asList(statusRacaoAndLote));

        Venda vend1 = new Venda(null, 140, "01/11/2021", "Ariane", 10000, user1);
        user1.getVendas().addAll(Arrays.asList(vend1));

        this.animalrepository.saveAll(Arrays.asList(ani1));
        this.pesorepository.saveAll(Arrays.asList(pes1, pes2, pes3));
        this.medicacaorepository.saveAll(Arrays.asList(medic1));
        this.historicomedicacaorepository.saveAll(Arrays.asList(histmedic1));
        this.loterepository.saveAll(Arrays.asList(lot1));
        this.pastorepository.saveAll(Arrays.asList(past1));
        this.racaorepository.saveAll(Arrays.asList(rac1));
        this.statusbovinoandloterepository.saveAll(Arrays.asList(statusBovinoAndLote));
        this.statuspastoandloterepository.saveAll(Arrays.asList(statusPastoAndLote));
        this.statusracaoandloterepository.saveAll(Arrays.asList(statusRacaoAndLote));
        this.usuariorepository.saveAll(Arrays.asList(user1));
        this.vendarepository.saveAll(Arrays.asList(vend1));
	}

}
