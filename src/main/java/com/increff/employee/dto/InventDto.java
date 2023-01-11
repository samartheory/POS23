package com.increff.employee.dto;

import com.increff.employee.model.InventData;
import com.increff.employee.model.InventForm;
import com.increff.employee.pojo.InventPojo;
import com.increff.employee.service.ApiException;
import com.increff.employee.service.InventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.increff.employee.dto.InventDtoHelper.getAllConverter;
import static com.increff.employee.dto.InventDtoHelper.convert;

import java.util.ArrayList;
import java.util.List;
@Service
public class InventDto {
    @Autowired
    private InventService service;
//product service
    public void add(InventForm form) throws ApiException {
        InventPojo p = convert(form);
        service.add(p);
    }

    public void delete(int id) {
        service.delete(id);
    }

    public InventData get(int id) throws ApiException {
        InventPojo p = service.get(id);
        return convert(p);
    }

    public List<InventData> getAll() {
        List<InventPojo> list = service.getAll();
        return getAllConverter(list);
    }

    public void update( int id, InventForm f) throws ApiException {
        InventPojo p = convert(f);
        service.update(id, p);
    }

}
