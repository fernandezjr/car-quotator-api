package com.sysone.carquotatorapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "optionals")
public class Optional
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@ManyToOne(targetEntity = OptionalType.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "optional_type_id", referencedColumnName = "id")
	private OptionalType type;

	public int getId()
	{
		return id;
	}

	public OptionalType getType()
	{
		return type;
	}

	public void setType(OptionalType type)
	{
		this.type = type;
	}
}