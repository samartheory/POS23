package com.increff.employee.dto;

import com.increff.employee.model.ProductData;
import com.increff.employee.model.ProductForm;
import com.increff.employee.pojo.ProductPojo;
import com.increff.employee.service.ApiException;
import com.increff.employee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.increff.employee.dto.ProductDtoHelper.getAllConverter;
import static com.increff.employee.dto.ProductDtoHelper.convert;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDto {
    @Autowired
    private ProductService service;

    public void add(ProductForm form) throws ApiException {
        ProductPojo p = convert(form);
        // Validate if brandpojo exists
        service.add(p);
    }

    public void delete(int id) {
        service.delete(id);
    }

    public ProductData get(int id) throws ApiException {
        return convert(service.get(id));
    }

    public List<ProductData> getAll() {
        List<ProductPojo> list = service.getAll();
        return getAllConverter(list);
    }

    public void update( int id, ProductForm f) throws ApiException {
        service.update(id, convert(f));
    }

}
