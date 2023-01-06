package br.spring.jpa.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.spring.jpa.rest.model.VeiculoClass;

public interface VeiculoRepository extends JpaRepository<VeiculoClass, Integer> {

}
