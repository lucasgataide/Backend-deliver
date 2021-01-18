package com.lucasataide.deliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasataide.deliver.dto.ProductDTO;
import com.lucasataide.deliver.services.ProductService;

@RestController
@RequestMapping(value = "/products") // define o caminho do recurso
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping //endpoint para o método get do http
	public ResponseEntity<List<ProductDTO>> findAll(){ //tipo especial do springboot que encapusula uma resposta de uma requisição http
		List<ProductDTO> list = service.findAll();
		return ResponseEntity.ok().body(list); //cria uma resposa dizendo que deu certo com uma list
	}
}
