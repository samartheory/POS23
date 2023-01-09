package com.increff.employee.dao;

import com.increff.employee.pojo.InventPojo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class InventDao extends AbstractDao {

	private static String delete_id = "delete from InventPojo p where id=:id";
	private static String select_id = "select p from InventPojo p where id=:id";
	private static String select_all = "select p from InventPojo p";
	private static String select_bybrandcat = "select p from InventPojo p where brand = : brand and category = : category";

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void insert(InventPojo p) {
			em.persist(p);
	}
	public InventPojo selectByBrandCategory(String brand, String category) {
		TypedQuery<InventPojo> query = em().createQuery(select_bybrandcat, InventPojo.class);
		query.setParameter("brand", brand);
		query.setParameter("category", category);
		return getSingle(query);
	}
	public int delete(int id) {
		Query query = em.createQuery(delete_id);
		query.setParameter("id", id);
		return query.executeUpdate();
	}

	public InventPojo select(int id) {
		TypedQuery<InventPojo> query = getQuery(select_id, InventPojo.class);
		query.setParameter("id", id);
		return getSingle(query);
	}

	public List<InventPojo> selectAll() {
		TypedQuery<InventPojo> query = getQuery(select_all, InventPojo.class);
		return query.getResultList();
	}

	public void update(InventPojo p) {
	}


}
