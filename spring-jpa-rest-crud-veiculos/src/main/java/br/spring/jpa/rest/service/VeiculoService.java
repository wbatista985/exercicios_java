package br.spring.jpa.rest.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.spring.jpa.rest.dto.VeiculoDTO;
import br.spring.jpa.rest.model.VeiculoClass;
import br.spring.jpa.rest.repository.VeiculoRepository;
import br.spring.jpa.rest.service.exceptions.ObjectNotFoundException;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	
	public List<VeiculoClass> listarVeiculos() {
		return veiculoRepository.findAll();
	}

	public VeiculoClass buscarVeiculoPorId(Integer id) {
		Optional<VeiculoClass> veiculoExistente = veiculoRepository.findById(id);

		return veiculoExistente.orElseThrow(() -> new ObjectNotFoundException(
				"veiculo não encontrado! Id: " + id + ", Tipo: " + VeiculoClass.class.getName()));
	}

	public VeiculoClass buscarVeiculo(VeiculoClass veiculo) {
		Optional<VeiculoClass> veiculoExistente = veiculoRepository.findById(veiculo.getId());
		veiculo.setUpdate(LocalDate.now());

		return veiculoExistente.orElseThrow(() -> new ObjectNotFoundException(
				"veiculo não encontrado! Id: " + veiculo.getId() + ", Tipo: " + VeiculoClass.class.getName()));
	}

	public VeiculoClass inserirVeiculo(VeiculoClass veiculo) {
		veiculo.setId(null);
		veiculo.setCreated(LocalDate.now());
		return veiculoRepository.save(veiculo);
	}

	public void atualizarVeiculo(VeiculoClass veiculo) {
		VeiculoClass veiculoExiste = buscarVeiculo(veiculo);

		if (veiculoExiste != null) {
			veiculoRepository.save(veiculo);
		}
	}

	public void deletarVeiculo(Integer id) {
		VeiculoClass veiculoExiste = buscarVeiculoPorId(id);
		if (veiculoExiste != null) {
			veiculoRepository.delete(veiculoExiste);
		}
	}

	public VeiculoClass fromDTO(VeiculoDTO objDto) {
		VeiculoClass veiculos = new VeiculoClass(objDto.getId(), objDto.getVeiculo(), objDto.getMarca(),
				objDto.getAno(), objDto.getDescricao(), objDto.isVendido(), objDto.getCreated(), objDto.getUpdate());

		
		return veiculos;
	}

}
