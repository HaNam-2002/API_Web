package com.ensat.services;

import com.ensat.entities.Product;
import com.ensat.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repo;
    public List<Product> listAll() {
        return  repo.findAll();
    }
    public void  save (Product product) {
        repo.save(product);
    }
    public  Product get(Integer pID) {
        return  repo.findById(pID).orElse(null);
    }
    public void  delete ( Integer pID) {
        repo.deleteById(pID);
    }
}
