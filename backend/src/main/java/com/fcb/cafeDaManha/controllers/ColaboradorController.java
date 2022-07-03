package com.fcb.cafeDaManha.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fcb.cafeDaManha.entitiesDTO.ColaboradorDTO;
import com.fcb.cafeDaManha.service.ColaboradorService;

@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping
	public ResponseEntity<List<ColaboradorDTO>>  findAll() {
		List<ColaboradorDTO> list = colaboradorService.findItensService();
		return ResponseEntity.ok().body(list);
	}
}
