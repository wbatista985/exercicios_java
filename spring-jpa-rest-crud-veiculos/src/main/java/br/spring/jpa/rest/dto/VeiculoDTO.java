package br.spring.jpa.rest.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import br.spring.jpa.rest.model.VeiculoClass;

public class VeiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String veiculo;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Marca inválida")
	private String marca;

	private Integer ano;

	private String descricao;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private boolean vendido;
	
	private LocalDate created;
	
	private LocalDate update;
	
	public VeiculoDTO() {
		super();
	}

	public VeiculoDTO(VeiculoClass veiculos) {
		id = veiculos.getId();
		veiculo = veiculos.getVeiculo();
		marca = veiculos.getMarca();
		ano = veiculos.getAno();
		descricao = veiculos.getDescricao();
		vendido = veiculos.isVendido();
		created = veiculos.getCreated();
		update = veiculos.getUpdate();
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public LocalDate getUpdate() {
		return update;
	}

	public void setUpdate(LocalDate update) {
		this.update = update;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;		
	}

	
}
