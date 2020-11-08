package com.eigenholser.outrider.spdrgld;

import java.time.LocalDate;
import java.util.List;

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

@RestController
public class SpdrGldController {
	private static final Logger logger = LogManager.getLogger(SpdrGldController.class);

	@Autowired
	SpdrGldService spdrGldSvc;

	@GetMapping("/spdrgld/{date}")
	public SpdrGld getRowByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		return spdrGldSvc.getSpdrGldByDate(date);
	}

	@GetMapping("/spdrgld/{startDate}/{endDate}")
	public Page<SpdrGld> getRowByDateBetween(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
			@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum) {
		return spdrGldSvc.getSpdrGldDateRange(startDate, endDate, pageSize, pageNum);
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
