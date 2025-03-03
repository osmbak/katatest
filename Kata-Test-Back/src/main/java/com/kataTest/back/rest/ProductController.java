package com.kataTest.back.rest;

import com.kataTest.back.dto.auth.ProductDTO;
import com.kataTest.back.enteties.Cart;
import com.kataTest.back.enteties.InventoryStatus;
import com.kataTest.back.enteties.Product;
import com.kataTest.back.repositoy.ProductRepository;
import com.kataTest.back.service.CartService;
import com.kataTest.back.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Pageable;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;

@RequestMapping("/api/katatest")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private final ProductRepository productR;
    private final CartService cartService;


    @GetMapping("/products")
    ResponseEntity<Page<Product>> productList(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page,size);
        log.info("get All products");
        Page<Product> products = productService.getProducts(pageable);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/productsL")
    List<Product> productList() {
        log.info("get All products");
        return productR.findAll();
    }

    @GetMapping("/product/{id}")
    ResponseEntity<Product> getProduct(@PathVariable Long id) {
        log.info("get product id{} :     " + id);
        return productService.getProduct(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/product" ,consumes = {"multipart/form-data"} )
    ResponseEntity<Product> addProduct(@RequestPart("product") ProductDTO p,
                                       @RequestPart("photo") MultipartFile image) throws IOException {

        log.info("Produit is succesfuly  added id{} : " + p.getName());
        Product product = productService.addProduct(p,image);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/product")
    ResponseEntity<ProductDTO> updateProduct(@Validated @RequestPart("product") ProductDTO p
                                        , @RequestPart("image") MultipartFile image,
                                          @RequestParam Long id) throws IOException {
        try {
            log.info("Product is succesfuly update id{} : " + p.getCode());
            productService.putProduct(id, p,image);
            return ResponseEntity.ok(p);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/product/{id}")
    ResponseEntity<Product> productList(@PathVariable Long id) {
        log.info("delete product id {} : " + id);
        productService.removeProduct(id);
        return ResponseEntity.noContent().build();
    }



}