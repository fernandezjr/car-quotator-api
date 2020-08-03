package com.sysone.carquotatorapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysone.carquotatorapi.model.OptionalType;
import com.sysone.carquotatorapi.repository.OptionalTypeRepository;

@Service
public class OptionalTypeService 
{
	@Autowired
	private OptionalTypeRepository repository;
	
	public List<OptionalType> findOptionalTypes()
	{
		return repository.findAll();
	}
	
	public OptionalType findOptionalTypeById(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	public OptionalType findOptionalTypeByName(String name)
	{
		return repository.findByName(name).orElse(null);
	}
	
	public OptionalType saveOptionalType(OptionalType newOptionalType)
	{
		return repository.save(newOptionalType);
	}
	
	public OptionalType updateOptionalType(OptionalType updated)
	{
		OptionalType optionalTypeToUpdate = repository.findById(updated.getId()).orElse(null);
		optionalTypeToUpdate.setName(updated.getName());
		optionalTypeToUpdate.setPrice(updated.getPrice());
		
		return repository.save(updated);
	}
	
	public void deleteOptionalType(int id)
	{
		repository.deleteById(id);
	}
}