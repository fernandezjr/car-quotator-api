package com.sysone.carquotatorapi.model;

import java.math.BigDecimal;

/*import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;*/

//@MappedSuperclass
public abstract class Type
{
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)*/
	private int id;
	
	//@Column(name = "model_name")
	private String name;
	
	//@Column
	private BigDecimal price;
	
	public int getId() 
	{
		return id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	public BigDecimal getPrice() 
	{
		return price;
	}
	public void setPrice(BigDecimal price) 
	{
		this.price = price;
	}
}