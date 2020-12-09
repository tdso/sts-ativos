package com.tdso.ativos.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tdso.ativos.entities.Ativo;
import com.tdso.ativos.entities.Negociacao;
import com.tdso.ativos.entities.Provento;
import com.tdso.ativos.entities.Saldo;
import com.tdso.ativos.entities.enums.TipoAtivo;
import com.tdso.ativos.entities.enums.TipoOperacao;
import com.tdso.ativos.repositories.AtivoRepository;
import com.tdso.ativos.repositories.NegociacaoRepository;
import com.tdso.ativos.repositories.ProventoRepository;
import com.tdso.ativos.repositories.SaldoRepository;

@Configuration
@Profile("test") // tem que ser igual ao nome colocado no profile aplication.properties
// o spring so roda essa classe quando vc estiver no perfil teste
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private NegociacaoRepository negRepo;

	@Autowired
	private AtivoRepository ativoRepository;

	@Autowired
	private SaldoRepository saldoRepository;
	
	@Autowired
	private ProventoRepository proventoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
		Ativo ativo = new Ativo(1L, "ITSA4", TipoAtivo.ACOES);
		Ativo ativo2 = new Ativo(2L, "VIVT4", TipoAtivo.ACOES);
		Ativo ativo3 = new Ativo(null, "HGRU11", TipoAtivo.FII);
		ativoRepository.saveAll(Arrays.asList(ativo, ativo2, ativo3));
		
		Provento p = new Provento(null, ativo, Instant.now(), 750.00);
		Provento p1 = new Provento(null, ativo3, Instant.now(), 1150.00);
		proventoRepository.saveAll(Arrays.asList(p, p1));
				
		Negociacao n1 = new Negociacao(null, Date.from(Instant.now()), ativo, TipoOperacao.COMPRA, 500, 87.56);
		Negociacao n2 = new Negociacao(null, Date.from(Instant.now()), ativo2, TipoOperacao.COMPRA, 1500, 187.00);
		Negociacao n3 = new Negociacao(null, Date.from(Instant.now()), ativo3, TipoOperacao.ALUGUEL, 410, 84.00);
		
		negRepo.saveAll(Arrays.asList(n1, n2, n3));
		
		Saldo s1 = new Saldo(1L,ativo,Instant.now(),500);
		Saldo s2 = new Saldo(2L,ativo2,Instant.now(),1500);
		saldoRepository.saveAll(Arrays.asList(s1,s2));
		
		
	}
	
	
	

}
