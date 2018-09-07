package com.bank.xyzbank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "User_Wallets")
public class BankWallet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "walletId")
    private int walletId;

    private double balance;

    @Column(updatable = false)
    private Timestamp createdDate;

    private Timestamp updatedDate;

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public BankUser getLinkedUser() {
        return linkedUser;
    }

    public void setLinkedUser(BankUser linkedUser) {
        this.linkedUser = linkedUser;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }


    @ManyToOne
    @JoinColumn(name = "userId", insertable = true, updatable = true, nullable = false)
    private BankUser linkedUser;

    public BankWallet() {
        this.balance = 0.0;
    }

    public BankWallet(int id, double amount) {
        this.walletId = id;
        this.balance = amount;
    }

    @Override
    public String toString() {
        return "walletId=" + this.walletId ;
    }
}
