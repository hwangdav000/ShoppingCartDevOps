package com.ecom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.ecom.model.OrderRequest;
import com.ecom.model.ProductOrder;

import java.util.List;

@FeignClient(name = "SHOPPING-MICROSERVICE5", url = "http://${microservice5:localhost}:8095")
public interface OrderClient {

    @PostMapping("/save")
    void saveOrder(@RequestParam Integer userId, @RequestBody OrderRequest orderRequest) throws Exception;

    @GetMapping("/user/{userId}")
    List<ProductOrder> getOrdersByUser(@PathVariable Integer userId);

    @PutMapping("/update/{id}")
    ProductOrder updateOrderStatus(@PathVariable Integer id, @RequestParam String status);

    @GetMapping("/all")
    List<ProductOrder> getAllOrders();

    @GetMapping("/{orderId}")
    ProductOrder getOrdersByOrderId(@PathVariable String orderId);

    @GetMapping("/all/pagination")
    Page<ProductOrder> getAllOrdersPagination(@RequestParam Integer pageNo, @RequestParam Integer pageSize);
}
