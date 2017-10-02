package com.treinamento.Mock.treinamentoMock.controller;

import com.treinamento.Mock.treinamentoMock.domain.DomainBuy;
import com.treinamento.Mock.treinamentoMock.domain.DomainLogin;
import com.treinamento.Mock.treinamentoMock.service.DomainBuyServer;
import com.treinamento.Mock.treinamentoMock.service.DomainLoginServer;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/buy",produces = "application/json; charset=UTF-8")
public class DomainBuyController {

    private DomainBuyServer domainBuyServer;
    private DomainLoginServer domainLoginServer;

    @Autowired
    public DomainBuyController (DomainBuyServer domainBuyServer, DomainLoginServer domainLoginServer){
        this.domainBuyServer= domainBuyServer;
        this.domainLoginServer = domainLoginServer;
    }

    @GetMapping
    public List<DomainBuy> findAllDomainBuy(){
        return domainBuyServer.findAllDomainBuy();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findOneDomainBuy(@PathVariable(name = "id") Integer id){
        try {
            DomainBuy search = domainBuyServer.findOneDomainBuy(id);
            if (search.getId() != null){
                return new ResponseEntity<>(search,HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Object> saveDomainBuy(@RequestBody DomainBuy domainBuy){
        try {
            domainBuyServer.saveDomainBuy(domainBuy);
            return new ResponseEntity<Object>(domainBuy,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteDomainBuy(@PathVariable(name = "id") Integer id,@RequestBody DomainBuy domainBuy){
        try {
            DomainBuy domainBuy1 = domainBuyServer.findOneDomainBuy(domainBuy.getId());
            if (domainBuy1 == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            domainBuyServer.deleteDomainBuy(domainBuy.id(id));
            return ResponseEntity.status(HttpStatus.OK).body(domainBuy.getId());

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }


}