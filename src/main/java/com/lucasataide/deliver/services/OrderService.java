package com.lucasataide.deliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasataide.deliver.dto.OrderDTO;
import com.lucasataide.deliver.entities.Order;
import com.lucasataide.deliver.repositories.OrderRepository;

@Service // torna a nossa classe um COMPONENTE registrado que pode ser INJETADO em outros
			// componentes
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Transactional(readOnly = true) // Como é uma operacao só de leitura, evita o locking de escrita no banco
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts(); // busca os produtos do repository
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList()); // transforma a lista de product
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
