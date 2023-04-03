package com.ensat.controllers;

import com.ensat.entities.Product;
import com.ensat.repositories.ProductRepository;
import com.ensat.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products") //http://localhost:8083/products
// báo lỗi CORS thì fix như sau
// *: chấp nhận các đường dẫn FE gọi api
// có thể config để bắt 1 đường dẫn từ Fe ví dụ: http://localhost:3000 để chấp nhận app reactjs kết nối
// trong lúc học thì config * cho tiện
@CrossOrigin("*")
public class  ProductController {
    @Autowired
    private ProductService productService ;
    
    @GetMapping("")
    public ResponseEntity<List<Product>> list() {
        return new ResponseEntity<>(productService.listAll(), HttpStatus.OK);
    }
    @GetMapping("/{pID}")
    public ResponseEntity<Product> get(@PathVariable Integer pID) {
      try {
          Product product = productService.get(pID);
          return  new ResponseEntity<>(product, HttpStatus.OK);
      } catch (NoSuchFieldError e) {
          return  new  ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

    }
    @PostMapping("/add")
    public  void add(@RequestBody Product product ) {
        productService.save(product) ;
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product,
                                    @PathVariable Integer pID) {
        try {
            Product exitProduct = productService.get(pID);
            productService.save(product);
            return new ResponseEntity<Product>(HttpStatus.OK);
        }
        catch (NoSuchFieldError e) {
            return  new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete")
    public  void delete(@PathVariable Integer pID) {
        productService.delete(pID);
    }

    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/search") // http://localhost:8083/products/search?name=..
    public ResponseEntity<List<Product>> searchProductsByName(@RequestParam String name) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);
        return ResponseEntity.ok(products);
    }
    @GetMapping("/category/{cID}")
    public List<Product> findByCategoryId(@PathVariable Integer cID) {
        return productService.findByCategoryId(cID);
    }

    }

