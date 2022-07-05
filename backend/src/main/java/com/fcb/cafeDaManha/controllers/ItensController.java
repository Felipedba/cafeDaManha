package com.fcb.cafeDaManha.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fcb.cafeDaManha.entities.Itens;
import com.fcb.cafeDaManha.entitiesDTO.ItensDTO;
import com.fcb.cafeDaManha.service.ItensService;

public class ItensController {

	@RestController
	@RequestMapping(value = "/itens")
	public class ProductController {

		@Autowired
		private ItensService itensService;

		@GetMapping
		public ResponseEntity<List<ItensDTO>> findAll() {
			List<ItensDTO> list = itensService.findAll();
			return ResponseEntity.ok().body(list);
		}

		@GetMapping("/pageItens")
		public ResponseEntity<Page<ItensDTO>> buscarItens(
				@RequestParam(value = "page", defaultValue = "0") Integer page,
				@RequestParam(value = "linesPage", defaultValue = "24") Integer linesPage,
				@RequestParam(value = "direction", defaultValue = "ASC") String direction,
				@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {

			Page<ItensDTO> list = itensService.buscarItens(page, linesPage, direction, orderBy);
			return ResponseEntity.ok().body(list);
		}

		@PostMapping
		public ResponseEntity<String> insert(@RequestBody ItensDTO objDTO) {
			Itens obj = itensService.fromDTO(objDTO);
			itensService.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
					.toUri();
			return ResponseEntity.created(uri).body("Cliente adicionado com sucesso, URI = " + uri);
		}
		
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<Void>delete(@PathVariable Long id) {
			itensService.delete(id);
		    return ResponseEntity.noContent().build();
		}
		
		@PutMapping(value = "/{id}")
		public ResponseEntity<Void> update(@RequestBody ItensDTO objDto,@PathVariable Long id) {
			Itens obj = itensService.fromDTO(objDto);
			obj.setId(id);
			obj = itensService.update(obj);
			return ResponseEntity.noContent().build();
		}
	}
}
