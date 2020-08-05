package com.sysone.carquotatorapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysone.carquotatorapi.model.Stats;
import com.sysone.carquotatorapi.service.StatsService;

@RestController
public class StatsController
{
	@Autowired
	private StatsService service;
	
	@GetMapping("/stats")
	public Stats getStats()
	{
		return service.findAll();
	}
}