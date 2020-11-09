package com.eigenholser.outrider.spdrgld;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SpdrGldService {
	private static final Logger logger = LogManager.getLogger(SpdrGldService.class);
	private static final Integer MAX_PAGE_SIZE = 50;
	private static final Integer DEFAULT_PAGE_NUM = 0;
	private static final String SORT_ASC = "ASC";
	private static final String SORT_DESC = "DESC";

	@Autowired
	SpdrGldRepository repo;

	public SpdrGld getSpdrGldByDate(LocalDate date) {
		return repo.findByDate(date);
	}

	public Page<SpdrGld> getSpdrGldDateRange(LocalDate startDate, LocalDate endDate, Optional<Integer> optPageSize,
			Optional<Integer> optPageNum, Optional<String> optSortOrder) {

		Integer pageSize = MAX_PAGE_SIZE;
		Integer pageNum = DEFAULT_PAGE_NUM;
		String sortOrder = SORT_ASC; //default sort order

		if (optSortOrder.isPresent()) {
			sortOrder = optSortOrder.get().toUpperCase();
		}

		if (optPageSize.isPresent()) {
			pageSize = optPageSize.get();
		}

		if (optPageNum.isPresent()) {
			pageNum = optPageNum.get() - 1;
		}
		
		if(!sortOrder.equals(SORT_ASC) && !sortOrder.equals(SORT_DESC)) {
			throw new IllegalArgumentException("Invalid sort order!");
		}

		if (pageSize.compareTo(MAX_PAGE_SIZE) == 1 || pageSize.equals(0)) {
			pageSize = MAX_PAGE_SIZE;
		}

		if (pageSize.compareTo(0) == -1) {
			throw new IllegalArgumentException("Invalid page size!");
		}

		if (pageNum.compareTo(DEFAULT_PAGE_NUM) == -1) {
			throw new IllegalArgumentException("Invalid page number!");
		}

		return repo.findByDateBetween(startDate, endDate, //
				PageRequest.of(pageNum, pageSize,
						Sort.by(sortOrder.equals(SORT_ASC) ? Sort.Direction.ASC : Sort.Direction.DESC, "date")));
	}

	public SpdrGld save(SpdrGld spdrGld) {
		return repo.save(spdrGld);
	}
}
