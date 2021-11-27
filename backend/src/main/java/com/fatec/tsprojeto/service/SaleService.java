package com.fatec.tsprojeto.service;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.tsprojeto.dto.SaleDTO;
import com.fatec.tsprojeto.dto.SaleSuccessDTO;
import com.fatec.tsprojeto.dto.SaleSumDTO;
import com.fatec.tsprojeto.entities.Sale;
import com.fatec.tsprojeto.entities.Seller;
import com.fatec.tsprojeto.repositories.SaleRepository;
import com.fatec.tsprojeto.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}
	
	@Transactional
	public Sale cadastrarSale(Long id, Integer visited, Integer deals, Double amount, LocalDate date, Seller seller){
		Sale sal = new Sale();
		sal.setId(id);
		sal.setVisited(visited);
		sal.setDeals(deals);
		sal.setAmount(amount);
		sal.setDate(date);
		sal.setSeller(seller);
		repository.save(sal);
		return sal;
	}
}
