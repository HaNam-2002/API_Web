package com.ensat.controllers;

import com.ensat.entities.Category;
import com.ensat.entities.Product;
import com.ensat.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
 private CategoryService service ;
    @GetMapping("")
    public List<Category> list() {
         return  service.listAll();
    }
    @GetMapping("/{cID}")
    public ResponseEntity<Category> get(@PathVariable Long cID) {
        try {
             Category category = service.get(cID);
            return  new ResponseEntity<Category>(category, HttpStatus.OK);
        } catch (NoSuchFieldError e) {
            return  new  ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("")
    public  void add(@RequestBody Category category ) {
        service.save(category) ;
    }
    @PutMapping("/{cID}")
    public ResponseEntity<?> update(@RequestBody Category category,
                                    @PathVariable Long cID) {
        try {
            Category exitCategory = service.get(cID);
            service.save(category);
            return new ResponseEntity<Product>(HttpStatus.OK);
        }
        catch (NoSuchFieldError e) {
            return  new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{cID}")
    public  void delete(@PathVariable Long cID) {
        service.delete(cID);
    }
}

