package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

public interface IProdutoRepository extends JpaRepository<Produto, Long> {
	
	Produto findById(long id);
}
