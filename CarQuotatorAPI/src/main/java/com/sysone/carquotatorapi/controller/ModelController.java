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

import com.sysone.carquotatorapi.model.Model;
import com.sysone.carquotatorapi.service.ModelService;

@RestController
public class ModelController 
{
	@Autowired
	private ModelService service;
	
	@GetMapping("/models")
	public List<Model> getModels()
	{
		return service.findModels();
	}
	
	@GetMapping("/models/{id}")
	public Model getModelById(@PathVariable int id)
	{
		return service.findModelById(id);
	}
	
	@GetMapping("/models/name/{name}")
	public Model getModelByName(@PathVariable String name)
	{
		return service.findModelByName(name);
	}
	
	@PostMapping("/models")
	public Model postModel(@RequestBody Model newModel)
	{
		return service.saveModel(newModel);
	}
	
	@PutMapping("/models")
	public Model putModel(@RequestBody Model updated)
	{
		return service.updateModel(updated);
	}
	
	@DeleteMapping("/models/{id}")
	public void deleteModel(@PathVariable int id)
	{
		service.deleteModel(id);
	}
}