package com.lucasataide.deliver.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //os produtos correspondem a uma entidade que será gerenciada pelo jpa (ferramenta orm)
@Table(name = "tb_product") //definição do nome da tabela no banco
public class Product implements Serializable{ //serializable é um padrão para permitir que o objeto seja transformado em uma sequencia de bytes

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //instrui ao jpa a interpretar o id como uma chave primaria auto incrementavel pelo banco de dados relacional
	private Long id;
	private String name;
	private Double price;
	private String imageUri;
	private String description;

	public Product() {
		
	}

	public Product(Long id, String name, Double price, String image_uri, String description) {
		super();
		id = id;
		this.name = name;
		this.price = price;
		this.imageUri = image_uri;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
