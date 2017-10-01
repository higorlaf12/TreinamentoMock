package com.treinamento.Mock.treinamentoMock.repository;

import com.treinamento.Mock.treinamentoMock.domain.DomainBuy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainBuyRepository extends JpaRepository<DomainBuy , Integer>{

}
