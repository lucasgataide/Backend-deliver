package com.lucasataide.deliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasataide.deliver.dto.OrderDTO;
import com.lucasataide.deliver.services.OrderService;

@RestController
@RequestMapping(value = "/orders") // define o caminho do recurso
public class OrderController {

	@Autowired
	private OrderService service;

	@GetMapping //endpoint para o método get do http
	public ResponseEntity<List<OrderDTO>> findAll(){ //tipo especial do springboot que encapusula uma resposta de uma requisição http
		List<OrderDTO> list = service.findAll();
		return ResponseEntity.ok().body(list); //cria uma resposa dizendo que deu certo com uma list
	}
}
