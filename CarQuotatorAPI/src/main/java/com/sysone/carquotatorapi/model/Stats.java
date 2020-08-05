package com.sysone.carquotatorapi.model;

import java.util.List;

public class Stats 
{
	private int count;
	private List<Counter> cars;
	private List<Counter> optionals;
	
	public int getCount() 
	{
		return count;
	}
	
	public void setCount(int count) 
	{
		this.count = count;
	}
	
	public List<Counter> getCars() 
	{
		return cars;
	}
	
	public void setCars(List<Counter> cars) 
	{
		this.cars = cars;
	}

	public List<Counter> getOptionals() 
	{
		return optionals;
	}

	public void setOptionals(List<Counter> optionals) 
	{
		this.optionals = optionals;
	}	
}