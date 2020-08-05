package com.sysone.carquotatorapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysone.carquotatorapi.model.Car;
import com.sysone.carquotatorapi.repository.CarRepository;
import com.sysone.carquotatorapi.repository.OptionalRepository;

@Service
public class CarService 
{
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OptionalRepository optionalRepository;
	
	public List<Car> findAll()
	{
		return repository.findAll();
	}
	
	public List<Car> findByModel(int modelId)
	{
		return repository.findByModelId(modelId);
	}
	
	public Car findById(int id)
	{
		return repository.findById(id).orElse(null);
	}
	
	public Car save(Car newCar)
	{
		return repository.save(newCar);
	}
	
	public void delete(int id)
	{
		repository.deleteById(id);
	}
}