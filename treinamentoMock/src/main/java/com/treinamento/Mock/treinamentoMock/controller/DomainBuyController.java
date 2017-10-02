package com.treinamento.Mock.treinamentoMock.controller;

import com.treinamento.Mock.treinamentoMock.domain.DomainBuy;
import com.treinamento.Mock.treinamentoMock.service.DomainBuyServer;
import com.treinamento.Mock.treinamentoMock.service.DomainLoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/buy", produces = "application/json; charset=UTF-8")
public class DomainBuyController {

    private DomainBuyServer domainBuyServer;
    private DomainLoginServer domainLoginServer;

    @Autowired
    public DomainBuyController(DomainBuyServer domainBuyServer, DomainLoginServer domainLoginServer) {
        this.domainBuyServer = domainBuyServer;
        this.domainLoginServer = domainLoginServer;
    }

    @GetMapping
    public List<DomainBuy> findAllDomainBuy() {
        return domainBuyServer.findAllDomainBuy();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findOneDomainBuy(@PathVariable(name = "id") Integer id) {
        try {
            DomainBuy search = domainBuyServer.findOneDomainBuy(id);
            if (search == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(search, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Object> saveDomainBuy(@RequestBody DomainBuy domainBuy) {
        try {
            domainBuyServer.saveDomainBuy(domainBuy);
            return new ResponseEntity<>(domainBuy, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteDomainBuy(@PathVariable(name = "id") Integer id) {
        try {
            DomainBuy domainBuy1 = domainBuyServer.findOneDomainBuy(id);
            if (domainBuy1 == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            domainBuyServer.deleteDomainBuy(id);
            return ResponseEntity.status(HttpStatus.OK).body(id);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }


}