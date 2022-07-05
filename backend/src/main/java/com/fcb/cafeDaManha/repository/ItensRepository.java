package com.fcb.cafeDaManha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fcb.cafeDaManha.entities.Colaborador;
import com.fcb.cafeDaManha.entities.Itens;
import com.fcb.cafeDaManha.entities.enums.Status;

public interface ItensRepository extends JpaRepository<Itens, Long> {
	
	@Query(value = "SELECT * FROM itens",
			countQuery = "SELECT count(*) FROM itens", nativeQuery = true)
	Page<Itens> buscarItens(Pageable pageable);
	
	@Modifying
	@Query(value = "insert into itens (nome,status,colaborador_id)"
			+ "values (?1,?2,?3)",
			nativeQuery = true)
	void inserirItens(String nome, Status status, Colaborador colaborador);
	
	@Modifying
	@Query(value = "DELETE FROM itens WHERE id=?1)", nativeQuery = true)
	Itens deletaItens(Long id);
	
	@Modifying
	@Query(value = "UPDATE itens set nome= 'felipedba' where id=?1",nativeQuery = true)
	void updateItens(String nome, Status status, Colaborador colaborador);
}
