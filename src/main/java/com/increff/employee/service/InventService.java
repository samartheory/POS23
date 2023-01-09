package com.increff.employee.service;

import com.increff.employee.dao.InventDao;
import com.increff.employee.dao.ProductDao;
import com.increff.employee.pojo.InventPojo;
import com.increff.employee.pojo.ProductPojo;
import com.increff.employee.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class InventService {

	@Autowired
	private InventDao dao;
	@Autowired
	private ProductDao proDao;
	@Transactional(rollbackOn = ApiException.class)
	public void add(InventPojo p) throws ApiException {
		if(p.getQuantity() == 0) {
			throw new ApiException("quantity cannot be empty");
		}

		ProductPojo productPojo =  proDao.selectByBarcode(p.getBarcode());
		if(Objects.isNull(productPojo)){
			throw new ApiException("Product with given barcode doesnt exists");
		}
		p.setId(productPojo.getId());
		dao.insert(p);
	}
//TODO we are not able to insert an entry in the inventory table the problem might be in productdao,inventservice
	@Transactional
	public void delete(int id) {
		dao.delete(id);
	}

	@Transactional(rollbackOn = ApiException.class)
	public InventPojo get(int id) throws ApiException {
		return getCheck(id);
	}

	@Transactional
	public List<InventPojo> getAll() {
		return dao.selectAll();
	}

	@Transactional(rollbackOn  = ApiException.class)
	public void update(int id, InventPojo p) throws ApiException {
		InventPojo ex = getCheck(id);
		ex.setQuantity(p.getQuantity());
		dao.update(ex);
	}

	@Transactional
	public InventPojo getCheck(int id) throws ApiException {
		InventPojo p = dao.select(id);
		if (Objects.isNull(p)) {
			throw new ApiException("Invent with given ID does not exit, id: " + id);
		}
		return p;
	}


}
