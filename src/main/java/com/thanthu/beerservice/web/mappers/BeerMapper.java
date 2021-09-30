package com.thanthu.beerservice.web.mappers;

import org.mapstruct.Mapper;

import com.thanthu.beerservice.domain.Beer;
import com.thanthu.beerservice.web.model.BeerDto;

@Mapper(uses = { DateMapper.class })
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
