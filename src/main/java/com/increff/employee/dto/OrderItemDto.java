package com.increff.employee.dto;
import com.increff.employee.model.OrderData;
import com.increff.employee.model.OrderItemForm;
import com.increff.employee.pojo.OrderPojo;
import com.increff.employee.service.ApiException;
import com.increff.employee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.increff.employee.dto.OrderDtoHelper.convert;
import static com.increff.employee.dto.OrderDtoHelper.getAllConverter;

@Service
public class OrderItemDto {
    @Autowired
    private OrderService service;

    public void add(OrderItemForm orderItemForm) throws ApiException {
        OrderPojo p = new OrderPojo();
        service.add(p);
    }

    public void delete(int id) {
        service.delete(id);
    }

    public OrderData get(int id) throws ApiException {
        OrderPojo p = service.get(id);
        return convert(p);
    }

    public List<OrderData> getAll() {
        return getAllConverter(service);
    }
}
