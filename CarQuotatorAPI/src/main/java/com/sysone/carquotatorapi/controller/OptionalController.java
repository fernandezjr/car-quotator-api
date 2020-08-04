package com.sysone.carquotatorapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sysone.carquotatorapi.model.Optional;
import com.sysone.carquotatorapi.service.OptionalService;
import com.sysone.carquotatorapi.service.OptionalTypeService;

@RestController
public class OptionalController 
{
	@Autowired
	private OptionalService service;
	
	@Autowired
	private OptionalTypeService optionalTypeService;
	
	@GetMapping("/optionals")
	public List<Optional> getOptionals()
	{
		return service.findOptionals();
	}
	
	@GetMapping("/optionals/{id}")
	public Optional getOptionalById(@PathVariable int id)
	{
		return service.findById(id);
	}
	
	@PostMapping("/optionals")
	public Optional postOptional(@RequestBody Optional newOptional)
	{
		newOptional.setType(optionalTypeService.findOptionalTypeById(newOptional.getType().getId()));
		return service.saveOptional(newOptional);
	}
	
	@DeleteMapping("/optionals/{id}")
	public void deleteOptioanl(@PathVariable int id)
	{
		service.delete(id);
	}
}