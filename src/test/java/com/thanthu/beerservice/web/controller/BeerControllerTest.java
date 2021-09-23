package com.thanthu.beerservice.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.thanthu.beerservice.web.model.BeerDto;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
	
	private static final UUID beerId = UUID.randomUUID();
	private BeerDto beerDto;
	
	@Autowired
	MockMvc mockMvc;
	
	@BeforeEach
	void setup() {
		beerDto = BeerDto.builder()
				.id(beerId)
				.build();
		
	}

	@Test
	void testGetBeerById() throws Exception {
		
		mockMvc.perform(get(BeerController.API_BASE_URL + "/" + beerId))
		.andExpect(status().isOk());
	}

	@Test
	void testSaveNewBeer() throws Exception {

		mockMvc.perform(post(BeerController.API_BASE_URL)
				.contentType(MediaType.APPLICATION_JSON)
				.content(AbstractRestControllerTest.asJsonString(beerDto)))
		.andExpect(status().isCreated());
	}

	@Test
	void testUpdateBeerById() throws Exception {
		
		mockMvc.perform(put(BeerController.API_BASE_URL + "/" + beerId)
				.contentType(MediaType.APPLICATION_JSON)
				.content(AbstractRestControllerTest.asJsonString(beerDto)))
		.andExpect(status().isNoContent());
	}

}
