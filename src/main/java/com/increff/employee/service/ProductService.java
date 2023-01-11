package com.increff.employee.service;

import com.increff.employee.dao.BrandDao;
import com.increff.employee.dao.ProductDao;
import com.increff.employee.pojo.BrandPojo;
import com.increff.employee.pojo.ProductPojo;
import com.increff.employee.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	@Autowired
	private BrandDao brandDao;
	@Transactional
	public void add(ProductPojo p) throws ApiException {
		if(StringUtil.isEmpty(p.getBrand()) || StringUtil.isEmpty(p.getName()) || StringUtil.isEmpty(p.getCategory())) {
			throw new ApiException("Brand/Name/Category cannot be empty");
		}
		normalize(p);
//		System.out.println(p.getId() + p.getBrand() + p.getCategory());
		BrandPojo brandPojo = brandDao.selectByBrandCategory(p.getBrand(), p.getCategory());
		if(Objects.isNull(brandPojo)){
			throw new ApiException("Brand or Category doesn't exists");
		}
		checkByBarcode(p.getBarcode());
		dao.insert(p);
	}

	@Transactional(rollbackFor = ApiException.class)
	public void delete(int id) {
		dao.delete(id);
	}
//TODO: read only
	@Transactional(readOnly = true)
	public ProductPojo get(int id) throws ApiException {
		return getCheck(id);
	}
	@Transactional(readOnly = true)
	public void checkByBarcode(String barcode) throws ApiException {
		ProductPojo productPojo = dao.selectByBarcode(barcode);
		if(Objects.nonNull(productPojo)){
			throw new ApiException("Given Barcode already exists");
		}
	}
	@Transactional(readOnly = true)
	public List<ProductPojo> getAll() {
		return dao.selectAll();
	}

	@Transactional(rollbackFor = ApiException.class)
	public void update(int id, ProductPojo p) throws ApiException {
		normalize(p);
		ProductPojo ex = getCheck(id);
		ex.setName(p.getName());
		ex.setBarcode(p.getBarcode());
		ex.setBrand(p.getBrand());
		ex.setCategory(p.getCategory());
		dao.update(ex);
	}

	@Transactional(readOnly = true)
	public ProductPojo getCheck(int id) throws ApiException {
		ProductPojo p = dao.select(id);
		if (Objects.isNull(p)) {
			throw new ApiException("Product with given ID does not exit, id: " + id);
		}
		return p;
	}

	protected static void normalize(ProductPojo p) {
		p.setBrand(StringUtil.toLowerCase(p.getBrand()));
		p.setCategory(StringUtil.toLowerCase(p.getCategory()));
		p.setBarcode(StringUtil.toLowerCase(p.getBarcode()));
		p.setName(StringUtil.toLowerCase(p.getName()));
	}
}
