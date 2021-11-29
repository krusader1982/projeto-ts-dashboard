package com.fatec.tsprojeto;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import java.time.LocalDate;

import javax.security.sasl.Sasl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.tsprojeto.dto.SellerDTO;
import com.fatec.tsprojeto.entities.Sale;
import com.fatec.tsprojeto.entities.Seller;
import com.fatec.tsprojeto.repositories.SaleRepository;
import com.fatec.tsprojeto.repositories.SellerRepository;
import com.fatec.tsprojeto.service.SaleService;
import com.fatec.tsprojeto.service.SellerService;

@SpringBootTest
@Transactional
@Rollback
class TsprojetoApplicationTests {
	
	@Autowired
	public SellerService seller;

	@Autowired
	public SaleService sale;
	
	@Autowired
	private SellerRepository selRepo;

	@Autowired
	private SaleRepository salRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test //Teste para encontrar todos Vendedores cadastrados
	void testFindAll() {
		List<SellerDTO> sellers = seller.findAll();
		assertEquals(sellers.size(), 5);
	}
		
	@Test//Verifica se o retorno da lista de vendedores esta vazia
	void testFindAllTest1(){
		List<SellerDTO> sellers = seller.findAll();
		assertEquals(sellers.isEmpty(), false);
	}

	@Test //Teste para verificar se esta retornando um numero errado de Vendedores cadastrados
	void testFindAllTest() {
		List<SellerDTO> sellers = seller.findAll();
		assertNotEquals(sellers.size(), 6);
	}
	
	@Test //Teste para verificar se esta salvando o vendedor
	void sellerSaveTestOK(){
		Seller sel = new Seller();
		sel.setName("Samuel");
		selRepo.save(sel);
		assertNotNull(sel.getId());
	}

	@Test
	void saleSaveTestOK(){
		Sale sal = new Sale();
		sal.setId((long) 1);
		sal.setVisited(null);
		sal.setDeals(null);
		sal.setAmount(null);
		sal.setDate(null);
		//sal.setSeller(5);
		salRepo.save(sal);
		assertNotNull(sal.getId());
	}

	@Test
	void saleServiceCadastrarSaleTest(){
		sale.cadastrarSale((long)170,45,25,5561.0,null,null);
		
		
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