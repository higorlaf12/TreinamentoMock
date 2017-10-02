package com.treinamento.Mock.treinamentoMock.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pageLogin")
public class DomainLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NUMLOGINEXIST")
    private Integer id;

    @NotEmpty
    @Column(name = "Login", length = 35)
    private String login;

    @NotEmpty
    @Column(name = "Password", length = 40)
    private String password;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "NUMIDDOMAINBUY")
    private DomainBuy domainBuy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DomainBuy getDomainBuy() {
        return domainBuy;
    }

    public void setDomainBuy(DomainBuy domainBuy) {
        this.domainBuy = domainBuy;
    }
}














//
//    public Integer getId() {
//        return id;
//    }
//
//    public DomainLogin id(Integer id) {
//        this.id = id;
//        return this;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public DomainLogin login(String login) {
//        this.login = login;
//        return this;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public DomainLogin password(String password) {
//        this.password = password;
//        return this;
//    }
//
//    public List<DomainBuy> getDomainBuyList() {
//        return domainBuyList;
//    }
//
//    public DomainLogin domainBuyList(List<DomainBuy> domainBuyList) {
//        this.domainBuyList = domainBuyList;
//        return this;
//    }