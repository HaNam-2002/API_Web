package com.ensat.repositories;

import com.ensat.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
