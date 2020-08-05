package com.sysone.carquotatorapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysone.carquotatorapi.model.Counter;
import com.sysone.carquotatorapi.model.Model;
import com.sysone.carquotatorapi.model.OptionalType;
import com.sysone.carquotatorapi.model.Stats;
import com.sysone.carquotatorapi.repository.CarRepository;
import com.sysone.carquotatorapi.repository.ModelRepository;
import com.sysone.carquotatorapi.repository.OptionalRepository;
import com.sysone.carquotatorapi.repository.OptionalTypeRepository;

@Service
public class StatsService 
{
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private ModelRepository modelRepository;
	
	@Autowired
	private OptionalTypeRepository optionalTypeRepository;
	
	@Autowired
	private OptionalRepository optionalRepository;
	
	public Stats findAll()
	{
		Stats stats = new Stats();
		int carsCount = carRepository.findAll().size();
		stats.setCount(carsCount);
		stats.setCars(getModelsCounter(carsCount));
		stats.setOptionals(getOptionalsCounter(carsCount));
		return stats;
	}
	
	private List<Counter> getModelsCounter(int carsCount)
	{
		List<Counter> counters = new ArrayList<Counter>();
		for (Model model : modelRepository.findAll()) 
		{
			Counter modelCounter = new Counter();
			modelCounter.setModel(model.getName());
			int modelsCount = carRepository.findByModelId(model.getId()).size();
			modelCounter.setCount(modelsCount);
			modelCounter.setPercent(calculatePercentage(carsCount, modelsCount));
			counters.add(modelCounter);
		}
		return counters;
	}
	
	private List<Counter> getOptionalsCounter(int carsCount)
	{
		List<Counter> counters = new ArrayList<Counter>();
		for (OptionalType optionalType : optionalTypeRepository.findAll()) 
		{
			Counter optionalCounter = new Counter();
			optionalCounter.setModel(optionalType.getName());
			int optionalsCount = optionalRepository.findByTypeId(optionalType.getId()).size();
			optionalCounter.setCount(optionalsCount);
			optionalCounter.setPercent(calculatePercentage(carsCount, optionalsCount));			
			counters.add(optionalCounter);
		}
		return counters;
	}
	
	private double calculatePercentage(int carsCount, int modelCount)
	{
		return (double) (modelCount * 100) / carsCount;
	}
}