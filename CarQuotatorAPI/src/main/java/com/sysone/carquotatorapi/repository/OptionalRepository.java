package com.sysone.carquotatorapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysone.carquotatorapi.model.Optional;

@Repository
public interface OptionalRepository extends JpaRepository<Optional, Integer> 
{
	List<Optional> findByTypeId(int typeId);
}