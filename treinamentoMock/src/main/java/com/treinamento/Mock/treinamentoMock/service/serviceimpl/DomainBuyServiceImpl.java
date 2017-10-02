package com.treinamento.Mock.treinamentoMock.service.serviceimpl;

import com.treinamento.Mock.treinamentoMock.domain.DomainBuy;
import com.treinamento.Mock.treinamentoMock.repository.DomainBuyRepository;
import com.treinamento.Mock.treinamentoMock.service.DomainBuyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainBuyServiceImpl implements DomainBuyServer{

    private DomainBuyRepository domainBuyRepository;

    @Autowired
    public DomainBuyServiceImpl(DomainBuyRepository domainBuyRepository){
        this.domainBuyRepository = domainBuyRepository;
    }

    @Override
    public List<DomainBuy> findAllDomainBuy() {
        return domainBuyRepository.findAll();
    }

    @Override
    public DomainBuy findOneDomainBuy(Integer id) {
        return domainBuyRepository.findOne(id);
    }

    @Override
    public void saveDomainBuy(DomainBuy domainBuy) {
        domainBuyRepository.save(domainBuy);
    }

    @Override
    public void deleteDomainBuy(int id) {
        DomainBuy domainBuy = findOneDomainBuy(id);
        domainBuyRepository.delete(domainBuy);
    }
}
