package com.increff.employee.dao;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;
import com.increff.employee.pojo.BrandPojo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BrandDao extends AbstractDao {

//	TODO: change to final and capital case
	private static final String DELETE_ID = "delete from BrandPojo p where id=:id";
	private static String select_id = "select p from BrandPojo p where id=:id";
	private static String select_all = "select p from BrandPojo p";

	private static String select_bybrandcat = "select p from BrandPojo p where brand = : brand and category = : category";

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void insert(BrandPojo p) {
			em.persist(p);
			System.out.println("insdiedao");
//			TODO: configure log4j
	}
	public BrandPojo selectByBrandCategory(String brand, String category) {
		TypedQuery<BrandPojo> query = em().createQuery(select_bybrandcat, BrandPojo.class);
		query.setParameter("brand", brand);
		query.setParameter("category", category);
		return getSingle(query);
	}
	public int delete(int id) {
		Query query = em.createQuery(DELETE_ID);
		query.setParameter("id", id);
		return query.executeUpdate();
	}

	public BrandPojo select(int id) {
		TypedQuery<BrandPojo> query = getQuery(select_id, BrandPojo.class);
		query.setParameter("id", id);
		return getSingle(query);
	}

	public List<BrandPojo> selectAll() {
		TypedQuery<BrandPojo> query = getQuery(select_all, BrandPojo.class);
		return query.getResultList();
	}

	public void update(BrandPojo p) {
	}


}
