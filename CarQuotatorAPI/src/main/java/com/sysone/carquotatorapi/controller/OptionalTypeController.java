package com.sysone.carquotatorapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sysone.carquotatorapi.model.OptionalType;
import com.sysone.carquotatorapi.service.OptionalTypeService;

@RestController
public class OptionalTypeController 
{
	@Autowired
	private OptionalTypeService service;
	
	@GetMapping("/optional-types")
	public List<OptionalType> getOptionalTypes()
	{
		return service.findOptionalTypes();
	}
	
	@GetMapping("/optional-types/{id}")
	public OptionalType getOptionalTypeById(@PathVariable int id)
	{
		return service.findOptionalTypeById(id);
	}
	
	@GetMapping("/optional-types/name/{name}")
	public OptionalType getOptionalTypeByName(@PathVariable String name)
	{
		return service.findOptionalTypeByName(name);
	}
	
	@PostMapping("/optional-types")
	public OptionalType postOptionalType(@RequestBody OptionalType newOptionalType)
	{
		return service.saveOptionalType(newOptionalType);
	}
	
	@PutMapping("/optional-types")
	public OptionalType putOptionalType(@RequestBody OptionalType updated)
	{
		return service.updateOptionalType(updated);
	}
	
	@DeleteMapping("/optional-types/{id}")
	public void deleteOptionalType(@PathVariable int id)
	{
		service.deleteOptionalType(id);
	}
}