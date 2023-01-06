package br.spring.jpa.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.spring.jpa.rest.model.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {}
