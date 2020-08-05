package com.sysone.carquotatorapi.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sysone.carquotatorapi.model.Car;
import com.sysone.carquotatorapi.model.Optional;
import com.sysone.carquotatorapi.repository.ModelRepository;
import com.sysone.carquotatorapi.service.CarService;
import com.sysone.carquotatorapi.service.OptionalService;

@RestController
public class CarController 
{
	@Autowired
	private CarService service;
	
	@Autowired
	private ModelRepository modelRepository;
	
	@Autowired
	private OptionalService optionalService;
	
	@GetMapping("/cars")
	public List<Car> getCars()
	{
		return setTotals(service.findAll());
	}
	
	@GetMapping("/cars/{id}")
	public Car getCarById(@PathVariable int id)
	{
		Car car = service.findById(id);
		car.setTotal(calculateTotal(car.getOptionals()) + car.getModel().getPrice().doubleValue());
		return car;
	}
	
	@GetMapping("/cars/model/{modelId}")
	public List<Car> getCarsByModel(@PathVariable int modelId)
	{
		return service.findByModel(modelId);
	}
	
	@PostMapping("/cars")
	public Car postCar(@RequestBody Car newCar)
	{
		return service.save(newCar);
	}
	
	@DeleteMapping("/cars/{id}")
	public void deleteCar(@PathVariable int id)
	{
		service.delete(id);
	}
	
	private List<Car> setTotals(List<Car> cars)
	{
		List<Car> newList = new ArrayList<Car>();
		for (Car car : cars) 
		{
			car.setTotal(calculateTotal(car.getOptionals()) + car.getModel().getPrice().doubleValue());
			newList.add(car);
		}
		return newList;
	}
	
	private double calculateTotal(List<Optional> optionals)
	{
		double optionalsTotal = 0;
		for (Optional optional : optionals) 
		{
			optionalsTotal += optional.getType().getPrice().doubleValue();
		}
		return optionalsTotal;
	}
}