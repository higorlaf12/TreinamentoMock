package com.treinamento.Mock.treinamentoMock.controller;

import com.treinamento.Mock.treinamentoMock.service.DomainBuyServer;
import com.treinamento.Mock.treinamentoMock.service.DomainLoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
