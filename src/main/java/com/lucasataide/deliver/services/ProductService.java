package com.lucasataide.deliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasataide.deliver.dto.ProductDTO;
import com.lucasataide.deliver.entities.Product;
import com.lucasataide.deliver.repositories.ProductRepository;

@Service // torna a nossa classe um COMPONENTE registrado que pode ser INJETADO em outros
			// componentes
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true) // Como é uma operacao só de leitura, evita o locking de escrita no banco
	public List<ProductDTO> findAll() {
		List<Product> list = repository.findAllByOrderByNameAsc(); // busca os produtos do repository
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList()); // transforma a lista de product
																						// em productDTO, utilizando a
																						// função map, aplica o
																						// construtor em cada objeto da
																						// lista, transformando em uma
																						// nova lista, e através da
																						// função toList, converte a
																						// lista que está em formato
																						// stream, para lista novamente
	}

}
