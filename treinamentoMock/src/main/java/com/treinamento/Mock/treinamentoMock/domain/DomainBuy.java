package com.treinamento.Mock.treinamentoMock.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "PageBuy")
public class DomainBuy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pagebuyID")
    private Integer id;

    @Column(name = "INSERIRDADOS", length = 200)
    private String insert;

    @Column(name = "NUMERODAINSERCAO", length = 8)
    private Integer num;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "NUMLOGIN")
    private DomainLogin login;


    public Integer getId() {
        return id;
    }

    public DomainBuy id(Integer id) {
        this.id = id;
        return this;
    }

    public String getInsert() {
        return insert;
    }

    public DomainBuy insert(String insert) {
        this.insert = insert;
        return this;
    }

    public Integer getNum() {
        return num;
    }

    public DomainBuy num(Integer num) {
        this.num = num;
        return this;
    }

    public DomainLogin getLogin() {
        return login;
    }

    public DomainBuy login(DomainLogin login) {
        this.login = login;
        return this;
    }
}
