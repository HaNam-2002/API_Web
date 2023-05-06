package com.ensat.controllers;

import com.ensat.entities.Infomation;
import com.ensat.services.InfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/Infomation") //http://localhost:8083/Infomation
@CrossOrigin("*")
public class InfomationController {
    @Autowired
    private InfomationService infomationService ;
    @GetMapping("/all")
    public ResponseEntity<List<Infomation>> list() {
        return new ResponseEntity<>(infomationService.listAll(), HttpStatus.OK);
    }
    @GetMapping("/{iID}")
    public ResponseEntity<Infomation> get(@PathVariable Integer iID) {
        Infomation infomation = infomationService.get(iID);
        if(infomation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(infomation, HttpStatus.OK);
    }
    @PutMapping("/update/{iID}")
    public ResponseEntity<Infomation> updateInfomation(@PathVariable Integer iID,
                                                       @RequestBody Infomation infomationUpdate) {
        Infomation infomation = infomationService.get(iID);
        if (infomation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        infomationUpdate.setIID(iID);
        infomationService.save(infomationUpdate);
        return new ResponseEntity<>(infomationUpdate, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{iID}")
    public ResponseEntity<Void> delete(@PathVariable Integer iID) {
        Infomation infomation = infomationService.get(iID);
        if(infomation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        infomationService.delete(iID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
