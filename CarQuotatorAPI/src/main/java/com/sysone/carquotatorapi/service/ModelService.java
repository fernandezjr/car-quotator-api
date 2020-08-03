package com.sysone.carquotatorapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysone.carquotatorapi.model.Model;
import com.sysone.carquotatorapi.repository.ModelRepository;

@Service
public class ModelService 
{
	@Autowired
	private ModelRepository repository;
	
	public List<Model> findModels()
	{
		return repository.findAll();
	}
	
	public Model findModelById(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	public Model findModelByName(String name)
	{
		return repository.findByName(name).orElse(null);
	}
	
	public Model saveModel(Model newModel)
	{
		return repository.save(newModel);
	}
	
	public Model updateModel(Model updated)
	{
		Model modelToUpdate = repository.findById(updated.getId()).orElse(null);
		modelToUpdate.setName(updated.getName());
		modelToUpdate.setPrice(updated.getPrice());
		
		return repository.save(modelToUpdate);
	}
	
	public void deleteModel(int id)
	{
		repository.deleteById(id);
	}
}