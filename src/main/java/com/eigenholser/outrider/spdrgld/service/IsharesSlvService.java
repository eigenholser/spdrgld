package com.eigenholser.outrider.spdrgld.service;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.eigenholser.outrider.spdrgld.model.IsharesSlv;

@Service
public class IsharesSlvService {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("spdrgld");
	private static final EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	
	public IsharesSlv getIsharesSlvByDate(LocalDate date) {
		String query = "SELECT i FROM IsharesSlv i WHERE i.date = :date";

		TypedQuery<IsharesSlv> tq = em.createQuery(query, IsharesSlv.class);
		tq.setParameter("date", date);
		IsharesSlv slv = null;
		try {
			slv = tq.getSingleResult();
			System.out.println(slv);
			return slv;
		} catch (NoResultException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}
}
