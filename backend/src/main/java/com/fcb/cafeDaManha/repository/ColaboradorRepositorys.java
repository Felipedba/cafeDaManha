package com.fcb.cafeDaManha.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fcb.cafeDaManha.entities.Colaborador;

public interface ColaboradorRepositorys extends JpaRepository<Colaborador, Long> {
	
	@Query(value = "SELECT * FROM colaborador ORDER BY ?1",
		    countQuery = "SELECT count(*) FROM colaborador",
		    nativeQuery = true)
	Page<Colaborador>BuscarColaborador(Pageable pageable);
	
	@Modifying
	@Query(value = "insert into colaborador(cpf,nome,senha)"
			+ "values (?1,?2,?3)",nativeQuery = true)
	void inserir(String cpf, String nome, String senha);
	
	@Query(value = "SELECT * FROM colaborador WHERE ?1 LIKE ?2",
		    nativeQuery = true)
	List<Colaborador>buscarPorParametro(String parametro, String valor);
}
