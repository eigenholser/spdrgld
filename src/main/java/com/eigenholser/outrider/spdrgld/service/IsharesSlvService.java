package com.eigenholser.outrider.spdrgld.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eigenholser.outrider.spdrgld.model.IsharesSlv;
import com.eigenholser.outrider.spdrgld.repository.IsharesSlvQueries;

@Service
public class IsharesSlvService {
	
	@Autowired
	IsharesSlvQueries queries;
	
	public IsharesSlv getIsharesSlvByDate(LocalDate date) {
		return queries.getIsharesSlvByDate(date);
	}
}
