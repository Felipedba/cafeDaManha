package com.fcb.cafeDaManha.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.PropertyValueConverter.ObjectToObjectPropertyValueConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fcb.cafeDaManha.entities.Itens;
import com.fcb.cafeDaManha.entitiesDTO.ItensDTO;
import com.fcb.cafeDaManha.repository.ItensRepository;

@Service
public class ItensService {

	@Autowired
	private ItensRepository itensRepository;
	
	@Transactional(readOnly=true)
	public List<ItensDTO> findAll() {
		List<Itens> list = itensRepository.findAll();
		return list.stream().map(x -> new ItensDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public Page<ItensDTO> buscarItens(Integer page, Integer linesPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPage, Direction.valueOf(direction), orderBy);
		Page<Itens> pages = itensRepository.buscarItens(pageRequest);
		return pages.map(x -> new ItensDTO(x));
	}
	
	@Transactional
	public void insert(Itens obj) {
		itensRepository.inserirItens(obj.getNome(), obj.getStatus(), obj.getColaborador());
	}
	
	@Transactional
	public void delete(Long id) {
		itensRepository.deletaItens(id);
	}

	@Transactional
	public Itens update(Itens obj) {
		Itens newObj = find(obj.getId());
		updateData(newObj, obj);
		return itensRepository.save(newObj);
	}

	private void updateData(Itens newItens, Itens obj) {
		newItens.setNome(obj.getNome());
		newItens.setStatus(obj.getStatus());
		newItens.setColaborador(obj.getColaborador());
	}
	
	public Itens fromDTO(ItensDTO objDTO) {
		return new Itens(objDTO.getId(), objDTO.getNome(), objDTO.getStatus(), objDTO.getColaborador());
	}
}
