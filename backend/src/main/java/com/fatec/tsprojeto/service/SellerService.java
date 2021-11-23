package com.fatec.tsprojeto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.tsprojeto.dto.SellerDTO;
import com.fatec.tsprojeto.entities.Seller;
import com.fatec.tsprojeto.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public  Seller cadastrarSeller(String name) {
		Seller sel = new Seller();
		sel.setName(name);
		repository.save(sel);
		return sel;
		
	}
	
	public List<SellerDTO> findByName(){
		List<Seller> result = repository.findByName(null);
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
	
}
