package com.fcb.cafeDaManha.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	@Transactional(readOnly = true)
		public Page<ColaboradorDTO> buscarColaborador(Integer page, Integer linesPage, String direction, String orderBy) {

			PageRequest pageRequest = PageRequest.of(page, linesPage, Direction.valueOf(direction), orderBy);
			Page<Colaborador> pages = colaboradorRepository.findAll(pageRequest);
			return pages.map(x -> new ColaboradorDTO(x));
	}

	@Transactional
	public void insert(Colaborador obj) {
		colaboradorRepository.inserir(obj.getCpf(),obj.getCpf(),obj.getSenha());
	}
	
	public Colaborador fromDTO(ColaboradorDTO objDTO) {
		return new Colaborador(objDTO.getId(), objDTO.getNome(), objDTO.getCpf(),objDTO.getSenha());
	}
	
	@Transactional(readOnly = true)
	public List<ColaboradorDTO> buscarPorParametro(String parametro, String valor) {
		List<Colaborador> list = colaboradorRepository.buscarPorParametro(parametro, valor);
		return list.stream().map(x -> new ColaboradorDTO(x)).collect(Collectors.toList());
	}
}
