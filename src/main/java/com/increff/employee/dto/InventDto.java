package com.increff.employee.dto;

import com.increff.employee.model.InventData;
import com.increff.employee.model.InventForm;
import com.increff.employee.pojo.InventPojo;
import com.increff.employee.service.ApiException;
import com.increff.employee.service.InventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventDto {
    @Autowired
    private InventService service;

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
        List<InventData> list2 = new ArrayList<InventData>();
        for (InventPojo p : list) {
            list2.add(convert(p));
        }
        return list2;
    }

    public void update( int id, InventForm f) throws ApiException {
        InventPojo p = convert(f);
        service.update(id, p);
    }
    private static InventData convert(InventPojo p) {
        InventData d = new InventData();
        d.setQuantity(p.getQuantity());
        d.setId(p.getId());
        return d;
    }
//TODO change inventory such that it can take barcode and quantity and search if the product is present
    private static InventPojo convert(InventForm f) {
        InventPojo p = new InventPojo();
        p.setQuantity(f.getQuantity());
        p.setBarcode(f.getBarcode());
//        p.setId(f.getId());
        return p;
    }
}
