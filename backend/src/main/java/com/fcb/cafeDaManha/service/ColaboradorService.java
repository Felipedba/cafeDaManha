package com.fcb.cafeDaManha.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fcb.cafeDaManha.entities.Colaborador;
import com.fcb.cafeDaManha.entitiesDTO.ColaboradorDTO;
import com.fcb.cafeDaManha.repository.ColaboradorRepositorys;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepositorys colaboradorRepository;

	@Transactional(readOnly=true)
	public List<ColaboradorDTO> findItensService() {
		List<Colaborador> list = colaboradorRepository.findAll();
		return list.stream().map(x -> new ColaboradorDTO(x)).collect(Collectors.toList());
	}
}
