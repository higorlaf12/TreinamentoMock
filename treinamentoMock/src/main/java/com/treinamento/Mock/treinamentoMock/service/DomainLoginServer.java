package com.treinamento.Mock.treinamentoMock.service;

import com.treinamento.Mock.treinamentoMock.domain.DomainLogin;

import java.util.List;

public interface DomainLoginServer {

    List<DomainLogin> findAllDomainLogin();

    DomainLogin findOneDomainLogin(Integer id);

    void saveDomainLogin (DomainLogin domainLogin);


}
