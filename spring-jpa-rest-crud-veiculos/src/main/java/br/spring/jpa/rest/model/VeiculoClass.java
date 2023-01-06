package br.spring.jpa.rest.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tab_veiculo")
public class VeiculoClass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column()
	private String veiculo;
	
	@Column()
	private String marca;

	@Column(name = "ano", nullable = false, length = 20)
	private Integer ano;
	
	@Column()
	private String descricao;
	
	@Column()
	private boolean vendido;
	
	@Column()
	private LocalDate created;
	

	@Column()
	private LocalDate update;
	
	
	@JsonIgnore
	@OneToOne()
	@JoinColumn(name = "imagem_id")
	private Imagem imagem;
	
	
	public VeiculoClass() {

	}

	public VeiculoClass(
			Integer id, 
			String veiculo, 
			String marca, 
			Integer ano, 
			String descricao, 
			boolean vendido,
			LocalDate created,
			LocalDate update
			
			) {
		super();
		this.id = id;
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
		this.created = created;
		this.update = update;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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


	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
	
	@Override
	public String toString() {
		return "VeiculoClass [id=" + id + ", veiculo=" + veiculo + ", marca=" + marca + ", ano=" + ano + ", descricao="
				+ descricao + ", vendido=" + vendido + ", created=" + created + ", update=" + update + ", imagem="
				+ imagem + "]";
	}
}
