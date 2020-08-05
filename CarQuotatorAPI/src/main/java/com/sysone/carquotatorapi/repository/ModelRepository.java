package com.sysone.carquotatorapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysone.carquotatorapi.model.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> 
{
	Optional<Model> findByName(String name);
}