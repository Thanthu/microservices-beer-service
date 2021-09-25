package com.thanthu.beerservice.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thanthu.beerservice.domain.Beer;
import com.thanthu.beerservice.repositories.BeerRepository;
import com.thanthu.beerservice.web.model.BeerStyleEnum;

@Component
public class BeerLoader implements CommandLineRunner  {
	
	private final BeerRepository beerRepository;
	
	public BeerLoader(BeerRepository beerRepository) {
		this.beerRepository = beerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		if(beerRepository.count() == 0 ) {
            beerRepository.save(Beer.builder()
                .beerName("Mango Bobs")
                .beerStyle(BeerStyleEnum.IPA.name())
                .minOnHand(12)
                .quantityToBrew(200)
                .price(new BigDecimal("12.95"))
                .upc("0631234200036")
                .build());
            
            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyleEnum.PALE_ALE.name())
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("12.95"))
                    .upc("0631234300019")
                    .build());
            
        }
	}
	
	

}
