package com.blanco.ExamenADAT.controller;


import com.blanco.ExamenADAT.model.Product;
import com.blanco.ExamenADAT.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/products" )
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product newProduct = productService.save(product);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> productList = productService.getAllProducts();
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/{stock}")
    public ResponseEntity<List<Product>> getByStock(@PathVariable Integer stock) {
        List<Product> products = productService.findByStock(stock);
        if (!products.isEmpty())
            return ResponseEntity.ok(products);
        return ResponseEntity.notFound().build();
    }




    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String name) {
        List<Product> product = productService.searchByName(name);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<?> updateProduct(@PathVariable Long idProduct, @RequestBody Product product) {
        boolean updated = productService.updateProduct(idProduct, product);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Optional<Product>> deleteProduct(@PathVariable Long idProduct) {
        productService.deleteProduct(idProduct);
        return ResponseEntity.ok().build();
    }

}
