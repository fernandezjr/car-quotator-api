package com.sysone.carquotatorapi.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "car")
public class Car 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@ManyToOne(targetEntity = Model.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "model_id", referencedColumnName = "id")
	private Model model;
	
	@ManyToMany
	@JoinTable(name = "car_optional",
			joinColumns = {@JoinColumn(referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "optional_id", referencedColumnName = "id")})
	private List<Optional> optionals;
	
	private Double total;

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public Model getModel() 
	{
		return model;
	}

	public void setModel(Model model) 
	{
		this.model = model;
	}

	public List<Optional> getOptionals() 
	{
		return optionals;
	}

	public void setOptionals(List<Optional> optionals) 
	{
		this.optionals = optionals;
	}
	
	public Double getTotal() 
	{
		return total;
	}

	public void setTotal(Double total) 
	{
		this.total = total;
	}
	
	
}