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


public class InventDtoHelper {
    public static List<InventData> getAllConverter(List<InventPojo> list) {
        List<InventData> list2 = new ArrayList<InventData>();
        for (InventPojo p : list) {
            list2.add(convert(p));
        }
        return list2;
    }

    public static InventData convert(InventPojo p) {
        InventData d = new InventData();
        d.setQuantity(p.getQuantity());
        d.setId(p.getId());
        return d;
    }

    public static InventPojo convert(InventForm f) {
        InventPojo p = new InventPojo();
        p.setQuantity(f.getQuantity());
        p.setBarcode(f.getBarcode());
//        p.setId(f.getId());
        return p;
    }
}
