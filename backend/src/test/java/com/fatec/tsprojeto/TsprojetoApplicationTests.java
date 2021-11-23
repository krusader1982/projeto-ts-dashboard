package com.fatec.tsprojeto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.tsprojeto.dto.SellerDTO;
import com.fatec.tsprojeto.entities.Seller;
import com.fatec.tsprojeto.repositories.SellerRepository;
import com.fatec.tsprojeto.service.SellerService;

@SpringBootTest
@Transactional
@Rollback
class TsprojetoApplicationTests {
	
	@Autowired
	public SellerService seller;
	
	@Autowired
	private SellerRepository selRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test //Teste para encontrar todos Vendedores cadastrados
	void testFindAll() {
		List<SellerDTO> sellers = seller.findAll();
		assertEquals(sellers.size(), 5);
	}
	
	@Test //Teste para verificar se esta salvando o vendedor
	void sellerSaveTestOK(){
		Seller sel = new Seller();
		sel.setName("Samuel");
		selRepo.save(sel);
		assertNotNull(sel.getId());
	}
	
	@Test //Teste para verificar o service 
	void sellerServiceCadastrarSellerTest() {
		seller.cadastrarSeller("Samuel");
		assertNotNull(selRepo.findByName("Samuel"));
	}
	
	@Test //Teste para verificar se encontra um vendedor pelo nome 
	void findByNameTest() {
		List<SellerDTO> sellers = seller.findAll();
		assertNotNull(selRepo.findByName("Barry Allen"));
	}
	
}