package com.eigenholser.outrider.spdrgld;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpdrGldController {
	private static final Logger logger = LogManager.getLogger(SpdrGldController.class);

	@Autowired
	SpdrGldRepository repo;

	@GetMapping("/spdrgld/{date}")
	public SpdrGld getRowByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		return repo.findByDate(date);
	}

	@GetMapping("/spdrgld/{startDate}/{endDate}")
	public List<SpdrGld> getRowByDateBetween(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
		return repo.findByDateBetween(startDate, endDate);
	}

	@PostMapping("/spdrgld")
	public ResponseEntity<SpdrGld> addRow(@RequestBody SpdrGld request) {
		logger.debug("Request: " + request);
		try {
			return new ResponseEntity<SpdrGld>(repo.save(request), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<SpdrGld>(request, HttpStatus.BAD_REQUEST);
		}

	}
}
