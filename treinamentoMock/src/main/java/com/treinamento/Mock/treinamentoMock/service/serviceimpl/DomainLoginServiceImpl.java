package com.treinamento.Mock.treinamentoMock.service.serviceimpl;

import com.treinamento.Mock.treinamentoMock.domain.DomainBuy;
import com.treinamento.Mock.treinamentoMock.domain.DomainLogin;
import com.treinamento.Mock.treinamentoMock.repository.DomainLoginRepository;
import com.treinamento.Mock.treinamentoMock.service.DomainLoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainLoginServiceImpl implements DomainLoginServer {

    private DomainLoginRepository domainLoginRepository;

    @Autowired
    public DomainLoginServiceImpl(DomainLoginRepository domainLoginRepository){
        this.domainLoginRepository = domainLoginRepository;
    }


    @Override
    public List<DomainLogin> findAllDomainLogin() {
        return domainLoginRepository.findAll();
    }

    @Override
    public DomainLogin findOneDomainLogin(Integer id) {
        return domainLoginRepository.findOne(id);
    }

    @Override
    public void saveDomainLogin(DomainLogin domainLogin) {
        domainLoginRepository.save(domainLogin);
    }



}
