package com.thanthu.beerservice.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.thanthu.beerservice.bootstrap.BeerLoader;
import com.thanthu.beerservice.services.BeerService;
import com.thanthu.beerservice.web.model.BeerDto;
import com.thanthu.beerservice.web.model.BeerStyleEnum;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
	
	private static final UUID beerId = UUID.randomUUID();
	private BeerDto beerDto;
	private BeerDto copyOfBeerDtoWithoutId;
	private String beerName = "My Beer";
	private BeerStyleEnum beerStyle = BeerStyleEnum.ALE;
	private String upc = BeerLoader.BEER_1_UPC;
	private BigDecimal price = BigDecimal.TEN;
	private Integer quantityOnHand = 1;
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
    BeerService beerService;
	
	@BeforeEach
	void setup() {
		beerDto = BeerDto.builder()
				.id(beerId)
				.beerName(beerName)
				.beerStyle(beerStyle)
				.upc(upc)
				.price(price)
				.quantityOnHand(quantityOnHand)
				.build();
		
		copyOfBeerDtoWithoutId = BeerDto.builder()
				.beerName(beerName)
				.beerStyle(beerStyle)
				.upc(upc)
				.price(price)
				.quantityOnHand(quantityOnHand)
				.build();
		
	}

	@Test
	void testGetBeerById() throws Exception {

		given(beerService.getById(any())).willReturn(beerDto);

		mockMvc.perform(get(BeerController.API_BASE_URL + "/" + beerId)).andExpect(status().isOk());
	}

	@Test
	void testSaveNewBeer() throws Exception {
		
        given(beerService.saveNewBeer(any())).willReturn(beerDto);

		mockMvc.perform(post(BeerController.API_BASE_URL)
				.contentType(MediaType.APPLICATION_JSON)
				.content(AbstractRestControllerTest.asJsonString(copyOfBeerDtoWithoutId)))
		.andExpect(status().isCreated());
	}

	@Test
	void testUpdateBeerById() throws Exception {
		
		given(beerService.updateBeer(any(), any())).willReturn(beerDto);
		
		mockMvc.perform(put(BeerController.API_BASE_URL + "/" + beerId)
				.contentType(MediaType.APPLICATION_JSON)
				.content(AbstractRestControllerTest.asJsonString(copyOfBeerDtoWithoutId)))
		.andExpect(status().isNoContent());
	}

}
