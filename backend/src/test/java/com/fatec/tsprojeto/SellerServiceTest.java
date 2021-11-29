package com.fatec.tsprojeto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fatec.tsprojeto.dto.SellerDTO;
import com.fatec.tsprojeto.service.SellerService;

class SellerServiceTest {

	@Test
	void testFindAll() {
		SellerService seller = new SellerService();
		List<SellerDTO> sellers = seller.findAll();
		assertEquals(sellers.size(), 5);
	}

}
