package com.treinamento.Mock.treinamentoMock.repository;

import com.treinamento.Mock.treinamentoMock.domain.DomainLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainLoginRepository extends JpaRepository<DomainLogin, Integer>{

}
