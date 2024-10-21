package com.ecom.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.model.Product;

import java.util.List;

@FeignClient(name = "SHOPPING-MICROSERVICE3", url = "http://${microservice3:localhost}:8093")
public interface ProductClient {

    @PostMapping("/api/products/save")
    Product saveProduct(@RequestBody Product product);

    @GetMapping("/api/products/all")
    List<Product> getAllProducts();

    @DeleteMapping("/api/products/delete/{id}")
    Boolean deleteProduct(@PathVariable Integer id);

    @GetMapping("/api/products/{id}")
    Product getProductById(@PathVariable Integer id);

    @PutMapping("/api/products/update")
    Product updateProduct(@RequestPart("product") Product product, @RequestPart("file") MultipartFile file);

    @GetMapping("/api/products/active")
    List<Product> getAllActiveProducts(@RequestParam String category);

    @GetMapping("/api/products/search")
    List<Product> searchProduct(@RequestParam String ch);

    @GetMapping("/api/products/active/pagination")
    Page<Product> getAllActiveProductsPagination(@RequestParam Integer pageNo, @RequestParam Integer pageSize, @RequestParam String category);

    @GetMapping("/api/products/search/pagination")
    Page<Product> searchProductPagination(@RequestParam Integer pageNo, @RequestParam Integer pageSize, @RequestParam String ch);

    @GetMapping("/api/products/pagination")
    Page<Product> getAllProductsPagination(@RequestParam Integer pageNo, @RequestParam Integer pageSize);

    @GetMapping("/api/products/search/active/pagination")
    Page<Product> searchActiveProductPagination(@RequestParam Integer pageNo, @RequestParam Integer pageSize, @RequestParam String category, @RequestParam String ch);
}
