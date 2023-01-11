package com.increff.employee.dto;

import com.increff.employee.model.ProductData;
import com.increff.employee.model.ProductForm;
import com.increff.employee.pojo.ProductPojo;
import com.increff.employee.service.ApiException;
import com.increff.employee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class ProductDtoHelper {
    public static List<ProductData> getAllConverter(List<ProductPojo> list) {
        List<ProductData> list2 = new ArrayList<ProductData>();
        for (ProductPojo p : list) {
            list2.add(convert(p));
        }
        return list2;
    }
    public static ProductData convert(ProductPojo p) {
        ProductData d = new ProductData();
        d.setBarcode(p.getBarcode());
        d.setBrand(p.getBrand());
        d.setCategory(p.getCategory());
        d.setName(p.getName());
        d.setMrp(p.getMrp());
        d.setId(p.getId());
        return d;
    }
    public static ProductPojo convert(ProductForm f) {
        ProductPojo p = new ProductPojo();
        p.setBarcode(f.getBarcode());
        p.setBrand(f.getBrand());
        p.setCategory(f.getCategory());
        p.setName(f.getName());
        p.setMrp(f.getMrp());
        return p;
    }
}
