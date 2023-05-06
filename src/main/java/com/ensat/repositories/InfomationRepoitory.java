package com.ensat.repositories;

import com.ensat.entities.Infomation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfomationRepoitory extends JpaRepository<Infomation,Integer> {
}
