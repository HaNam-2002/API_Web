package com.ensat.controllers;

import com.ensat.entities.Category;
import com.ensat.entities.Product;
import com.ensat.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("/categories")  // http://localhost:8083/categories
@RestController
@CrossOrigin("*")
public class CategoryController {
    @Autowired
 private CategoryService service ;
    @GetMapping("/all")
    public ResponseEntity<List<Category>> list() {
        return new ResponseEntity<>(service.listAll(), HttpStatus.OK);
    }
    @GetMapping("/get/{cID}")
    public ResponseEntity<Category> get(@PathVariable Integer cID) {
        try {
             Category category = service.get(cID);
            return  new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (NoSuchFieldError e) {
            return  new  ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/add")
    public  void add(@RequestBody Category category ) {
        service.save(category) ;
    }
    @PutMapping("/{cID}")
    public ResponseEntity<?> update(@RequestBody Category category,
                                    @PathVariable Integer cID) {
        try {
            Category exitCategory = service.get(cID);
            service.save(category);
            return new ResponseEntity<Product>(HttpStatus.OK);
        }
        catch (NoSuchFieldError e) {
            return  new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{cID}")
    public  void delete(@PathVariable Integer cID) {
        service.delete(cID);
    }

    public ResponseEntity<List<Product>>getProductbyCategory(@PathVariable Integer cID) {
        return null;
    }
}

