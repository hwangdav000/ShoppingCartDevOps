package com.ecom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.ecom.model.Cart;

import java.util.List;

@FeignClient(name = "SHOPPING-MICROSERVICE2", url = "http://${microservice3:localhost}:8092")
public interface CartClient {

    @PostMapping("/api/carts/save")
    Cart saveCart(@RequestParam Integer productId, @RequestParam Integer userId);

    @GetMapping("/api/carts/user/{userId}")
    List<Cart> getCartsByUser(@PathVariable Integer userId);
    
    @GetMapping("/api/carts/count/{userId}")
    Integer getCountCart(@PathVariable Integer userId);

    @PutMapping("/api/carts/updateQuantity")
    void updateQuantity(@RequestParam String sy, @RequestParam Integer cid);
}
