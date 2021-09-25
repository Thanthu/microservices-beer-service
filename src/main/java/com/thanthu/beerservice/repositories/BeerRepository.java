package com.thanthu.beerservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thanthu.beerservice.domain.Beer;

public interface BeerRepository extends JpaRepository<Beer, UUID> {

}
