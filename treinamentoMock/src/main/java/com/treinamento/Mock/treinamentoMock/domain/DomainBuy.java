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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DomainBuy domainBuy = (DomainBuy) o;

        if (id != null ? !id.equals(domainBuy.id) : domainBuy.id != null) return false;
        if (insert != null ? !insert.equals(domainBuy.insert) : domainBuy.insert != null) return false;
        if (num != null ? !num.equals(domainBuy.num) : domainBuy.num != null) return false;
        return login != null ? login.equals(domainBuy.login) : domainBuy.login == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (insert != null ? insert.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        return result;
    }
}
