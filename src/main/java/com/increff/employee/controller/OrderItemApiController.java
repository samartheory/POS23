//package com.increff.employee.controller;
//
//import com.increff.employee.dto.OrderItemDto;
//import com.increff.employee.model.OrderItemData;
//import com.increff.employee.model.OrderItemForm;
//import com.increff.employee.service.ApiException;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Api
//@RestController
//public class OrderItemApiController {
//
//    @Autowired
//    private OrderItemDto dto;
//
//    @ApiOperation(value = "Adds an Order")
//    @RequestMapping(path = "/api/Order", method = RequestMethod.POST)
//    public void add(@RequestBody OrderItemForm orderItemForm) throws ApiException {
//        dto.add(orderItemForm);
//    }
//
//
//    @ApiOperation(value = "Deletes Order")
//    @RequestMapping(path = "/api/Order/{id}", method = RequestMethod.DELETE)
//    // /api/1
//    public void delete(@PathVariable int id) {
//        dto.delete(id);
//    }
//
//    @ApiOperation(value = "Gets an Order by ID")
//    @RequestMapping(path = "/api/Order/{id}", method = RequestMethod.GET)
//    public OrderItemData get(@PathVariable int id) throws ApiException {
//        return dto.get(id);
//    }
//
//    @ApiOperation(value = "Gets list of all Orders")
//    @RequestMapping(path = "/api/Order", method = RequestMethod.GET)
//    public List<OrderItemData> getAll() {
//        return dto.getAll();
//    }
//
////    @ApiOperation(value = "Updates an Order")
////    @RequestMapping(path = "/api/Order/{id}", method = RequestMethod.PUT)
////    public void update(@PathVariable int id, @RequestBody OrderForm f) throws ApiException {
////        dto.update(id, f);
////    }
//
//
//}
