package com.treinamento.Mock.treinamentoMock.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

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

    public DomainLogin id(Integer id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public DomainLogin login(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DomainLogin password(String password) {
        this.password = password;
        return this;
    }

    public DomainBuy getDomainBuy() {
        return domainBuy;
    }

    public void setDomainBuy(DomainBuy domainBuy) {
        this.domainBuy = domainBuy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DomainLogin that = (DomainLogin) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        return domainBuy != null ? domainBuy.equals(that.domainBuy) : that.domainBuy == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (domainBuy != null ? domainBuy.hashCode() : 0);
        return result;
    }
}

