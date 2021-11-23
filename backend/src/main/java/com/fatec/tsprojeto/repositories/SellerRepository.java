package com.fatec.tsprojeto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.tsprojeto.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {
	
	//public Seller findByNome(String name);

	public List<Seller> findByName(String name);

	

}
