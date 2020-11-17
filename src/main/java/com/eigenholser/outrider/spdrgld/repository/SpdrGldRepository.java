package com.eigenholser.outrider.spdrgld.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.eigenholser.outrider.spdrgld.model.SpdrGld;

public interface SpdrGldRepository extends CrudRepository<SpdrGld, Long> {
	Page<SpdrGld> findByDateBetween(LocalDate dateStart, LocalDate dateEnd, Pageable pageable);

	SpdrGld findByDate(LocalDate date);
	
	SpdrGld findFirstByOrderByDateDesc();
}
