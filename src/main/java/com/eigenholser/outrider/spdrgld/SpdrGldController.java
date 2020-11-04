package com.eigenholser.outrider.spdrgld;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpdrGldController {
	@Autowired
	SpdrGldRepository repo;
	
	@GetMapping("/spdrgld/{date}")
	public SpdrGld getRowByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		return repo.findByDate(date);
	}
	
	@PostMapping("/spdrgld")
	@ResponseStatus(HttpStatus.CREATED)
	public SpdrGld addRow(@RequestBody SpdrGld request) {
		return repo.save(request);
	}
}
