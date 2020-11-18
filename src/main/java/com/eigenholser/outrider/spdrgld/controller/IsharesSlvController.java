package com.eigenholser.outrider.spdrgld.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eigenholser.outrider.spdrgld.model.IsharesSlv;
import com.eigenholser.outrider.spdrgld.service.IsharesSlvService;

@RestController
public class IsharesSlvController {
	@Autowired
	IsharesSlvService isharesSlvSvc;

	@GetMapping("/ishares/{date}")
	public IsharesSlv getIsharesRowByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		return isharesSlvSvc.getIsharesSlvByDate(date);
	}
}
