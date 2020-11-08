package com.eigenholser.outrider.spdrgld;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SpdrGldService {

	@Autowired
	SpdrGldRepository repo;

	public SpdrGld getSpdrGldByDate(LocalDate date) {
		return repo.findByDate(date);
	}

	public Page<SpdrGld> getSpdrGldDateRange(LocalDate startDate, LocalDate endDate, int pageSize, int pageNum) {
		return repo.findByDateBetween(startDate, endDate, //
				PageRequest.of(pageNum - 1, pageSize, Sort.by(Sort.Direction.ASC, "date")));
	}

	public SpdrGld save(SpdrGld spdrGld) {
		return repo.save(spdrGld);
	}
}
