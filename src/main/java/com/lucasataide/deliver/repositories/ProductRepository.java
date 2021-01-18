package com.lucasataide.deliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasataide.deliver.entities.Product;

//Objeto que faz o acesso ao banco de dados

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findAllByOrderByNameAsc();

}
