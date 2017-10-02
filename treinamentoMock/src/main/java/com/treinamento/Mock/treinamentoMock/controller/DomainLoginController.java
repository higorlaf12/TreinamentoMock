package com.treinamento.Mock.treinamentoMock.controller;

import com.treinamento.Mock.treinamentoMock.domain.DomainLogin;
import com.treinamento.Mock.treinamentoMock.service.DomainBuyServer;
import com.treinamento.Mock.treinamentoMock.service.DomainLoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/login", produces = "application/json; charset=UTF-8")
public class DomainLoginController {

    private DomainBuyServer domainBuyServer;
    private DomainLoginServer domainLoginServer;

    @Autowired
    public DomainLoginController(DomainBuyServer domainBuyServer, DomainLoginServer domainLoginServer) {
        this.domainBuyServer = domainBuyServer;
        this.domainLoginServer = domainLoginServer;
    }

    @GetMapping
    public List<DomainLogin> findAllDomainLogin() {
        return domainLoginServer.findAllDomainLogin();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DomainLogin> findOneDomainLogin(@PathVariable(name = "id") int id) {

        try {
            DomainLogin search = domainLoginServer.findOneDomainLogin(id);

            return new ResponseEntity<>(search, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveDomainLogin(@RequestBody DomainLogin domainLogin) {
        try {
            domainLoginServer.saveDomainLogin(domainLogin);
            return ResponseEntity.status(HttpStatus.OK).body(domainLogin);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

}
