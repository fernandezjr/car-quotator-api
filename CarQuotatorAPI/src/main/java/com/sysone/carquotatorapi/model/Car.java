/*package com.sysone.carquotatorapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "car")
public class Car 
{
	@Id
	@Column
	private String id;
	
	@OneToMany
	private ModelType model;
	
	@ManyToMany
	@JoinTable(name = "car_optional",
			joinColumns = {@JoinColumn(referencedColumnName = "car_id")},
			inverseJoinColumns = {@JoinColumn(referencedColumnName = "optional_id")})
	private List<Optional> optionals;
}*/