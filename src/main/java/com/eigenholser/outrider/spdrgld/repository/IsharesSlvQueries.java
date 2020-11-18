package com.eigenholser.outrider.spdrgld.repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.eigenholser.outrider.spdrgld.model.IsharesSlv;

@Service
public class IsharesSlvQueries {
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
	
	public IsharesSlv getIsharesSlvByDate2(LocalDate date) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<IsharesSlv> cq = cb.createQuery(IsharesSlv.class);
		Root<IsharesSlv> root = cq.from(IsharesSlv.class);
		cq.where(cb.equal(root.get("date"), date));
		return em.createQuery(cq.multiselect(root)).getSingleResult();
	}
}
