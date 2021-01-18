package com.lucasataide.deliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasataide.deliver.entities.Order;

//Objeto que faz o acesso ao banco de dados

public interface OrderRepository extends JpaRepository<Order, Long>{

}
