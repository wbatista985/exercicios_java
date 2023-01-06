package br.spring.jpa.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.spring.jpa.rest.dto.VeiculoDTO;
import br.spring.jpa.rest.model.VeiculoClass;
import br.spring.jpa.rest.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin
public class VeiculoController {
	@Autowired
	private VeiculoService veiculoService;

	@GetMapping(path = "/listar")
	public ResponseEntity<List<VeiculoClass>> listar() {
		List<VeiculoClass> veiculos = veiculoService.listarVeiculos();
		return ResponseEntity.ok().body(veiculos);
	}

	@PostMapping(path = "/inserir")
	public ResponseEntity<VeiculoClass> inserir(@RequestBody VeiculoDTO veiculoDto) {
		VeiculoClass veiculo = veiculoService.fromDTO(veiculoDto);
		VeiculoClass novoVeiculo = veiculoService.inserirVeiculo(veiculo);
		return ResponseEntity.ok().body(novoVeiculo);
	}

	@PutMapping(path = "/atualizar")
	public ResponseEntity<VeiculoClass> atualizar(
			@RequestBody VeiculoDTO veiculoDto) {
		VeiculoClass veiculo = veiculoService.fromDTO(veiculoDto);
		veiculoService.atualizarVeiculo(veiculo);
		VeiculoClass veiculoAtualizado = veiculoService.buscarVeiculo(veiculo);
		return ResponseEntity.ok().body(veiculoAtualizado);
	}

	@DeleteMapping(path= "/deletar/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		veiculoService.deletarVeiculo(id);
		return ResponseEntity.noContent().build();
	}
}
