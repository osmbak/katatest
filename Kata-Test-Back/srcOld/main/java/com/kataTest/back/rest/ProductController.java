package com.kataTest.back.rest;

import com.kataTest.back.dto.auth.ProductDTO;
import com.kataTest.back.enteties.Product;
import com.kataTest.back.repositoy.IProductRepository;
import com.kataTest.back.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Pageable;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/api/katatest")
@CrossOrigin
@AllArgsConstructor
@RestController
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private final IProductRepository productR;

    @GetMapping("/products")
    ResponseEntity<Page<Product>> productList(Pageable pageable) {
        log.info("get All products");

        Page<Product> products = productService.getProducts(pageable);
        products.stream().map(p -> p.getImage() != null ?
                Base64.getEncoder().encodeToString(p.getImage()) : null)
                .collect(Collectors.toList());
        return   ResponseEntity.ok(products);
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

    @PostMapping(value = "/product" )
    ResponseEntity<ProductDTO> addProduct(@RequestPart("product") ProductDTO productDto,
                                       @RequestPart("photo") MultipartFile image) throws IOException {

        log.info("Produit is succesfuly  added id{} : " + productDto.getName());
        productService.addProduct(productDto,image);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
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