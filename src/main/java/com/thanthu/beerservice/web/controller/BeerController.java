package com.thanthu.beerservice.web.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thanthu.beerservice.web.model.BeerDto;

@RequestMapping(BeerController.API_BASE_URL)
@RestController
public class BeerController {
	
	public static final String API_BASE_URL = "/api/v1/beer";
	
	@GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId){
		
		//TODO impl
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveNewBeer(@RequestBody BeerDto beerDto){
    	
    	//TODO impl
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Void> updateBeerById(@PathVariable UUID beerId, @RequestBody BeerDto beerDto){
    	
    	//TODO impl
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
