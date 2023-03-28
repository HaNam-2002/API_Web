package com.ensat.services;

import com.ensat.entities.Category;
import com.ensat.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository repo;
    public List<Category> listAll() {
        return  repo.findAll();
    }
    public void  save (Category category) {
        repo.save(category);
    }
    public  Category get(Long cID) {
        return  repo.findById(cID) .get();
    }
    public void  delete ( Long cID) {
        repo.deleteById(cID);
    }
}
