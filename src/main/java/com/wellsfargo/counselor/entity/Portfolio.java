package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.List;

public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;
    private String creationDate;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable=false)
    private Client client;

    @OneToMany(mappedBy = "portfolio", cascade= CascadeType.ALL)
    private List<Security> securities;

    public Portfolio(String creationDate, Client client){
        this.creationDate = creationDate;
        this.client = client;
    }

    public Portfolio(){}

    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
