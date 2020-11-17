package com.eigenholser.outrider.spdrgld;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SpdrGldController {
	private static final Logger logger = LogManager.getLogger(SpdrGldController.class);

	@Autowired
	SpdrGldService spdrGldSvc;
	
	@GetMapping("/spdrgld/{date}")
	public SpdrGld getRowByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		return spdrGldSvc.getSpdrGldByDate(date);
	}
	
	@GetMapping("/spdrgld/latest")
	public SpdrGld findByDateMax() {
		return spdrGldSvc.getSpdrGldByDateMax();
	}

	@GetMapping("/spdrgld/{startDate}/{endDate}")
	public ResponseEntity<Page<SpdrGld>> getRowByDateBetween(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
			@RequestParam(name = "pageSize") Optional<Integer> pageSize,
			@RequestParam(name = "pageNum") Optional<Integer> pageNum,
			@RequestParam(name = "sortOrder") Optional<String> sortOrder) {
		try {
			return new ResponseEntity<Page<SpdrGld>>(
					spdrGldSvc.getSpdrGldDateRange(startDate, endDate, pageSize, pageNum, sortOrder), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			logger.warn("exception: " + e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Something bad happened");
		}
	}

	@PostMapping("/spdrgld")
	public ResponseEntity<SpdrGld> addRow(@RequestBody SpdrGld request) {
		logger.debug("Request: " + request);
		try {
			return new ResponseEntity<SpdrGld>(spdrGldSvc.save(request), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<SpdrGld>(request, HttpStatus.BAD_REQUEST);
		}

	}
}
