package com.sysone.carquotatorapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysone.carquotatorapi.model.Optional;
import com.sysone.carquotatorapi.repository.OptionalRepository;

@Service
public class OptionalService 
{
	@Autowired
	private OptionalRepository repository;
	
	public List<Optional> findOptionals()
	{
		return repository.findAll();
	}
	
	public Optional findById(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	public Optional saveOptional(Optional newOptional)
	{
		return repository.save(newOptional);
	}
	
	public void delete(int id)
	{
		repository.deleteById(id);
	}
}