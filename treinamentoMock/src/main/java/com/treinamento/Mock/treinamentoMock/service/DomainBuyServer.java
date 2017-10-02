package com.treinamento.Mock.treinamentoMock.service;

import com.treinamento.Mock.treinamentoMock.domain.DomainBuy;

import java.util.List;

public interface DomainBuyServer {

    List<DomainBuy> findAllDomainBuy();

    DomainBuy findOneDomainBuy(Integer id);

    void saveDomainBuy(DomainBuy domainBuy);

    void deleteDomainBuy(int id);

}
