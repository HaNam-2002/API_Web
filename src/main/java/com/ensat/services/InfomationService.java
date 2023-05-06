package com.ensat.services;

import com.ensat.entities.Infomation;

import com.ensat.repositories.InfomationRepoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InfomationService {
    @Autowired
    private InfomationRepoitory InfoRepo;

    public List<Infomation> listAll() {
        return InfoRepo.findAll();
    }

    public Infomation save(Infomation infomation) {
        return InfoRepo.save(infomation);
    }

    public Infomation get(Integer iID) {
        return InfoRepo.findById(iID).orElse(null);
    }

    public void delete(Integer iID) {

        InfoRepo.deleteById(iID);
    }
}
