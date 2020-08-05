package com.sysone.carquotatorapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysone.carquotatorapi.model.OptionalType;

@Repository
public interface OptionalTypeRepository extends JpaRepository<OptionalType, Integer> 
{
	Optional<OptionalType> findByName(String name);
}