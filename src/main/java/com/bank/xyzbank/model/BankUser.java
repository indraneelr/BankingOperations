package com.bank.xyzbank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class BankUser implements Serializable {

    private static final long serialVersionUID = 1L;

    public BankUser() {
    }

    public BankUser(String name, String email) {
        this.userName = name;
        this.email = email;
    }

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String userName;
    private String email;
    private String contactNumber;

    @Column(updatable = false)
    private Timestamp createdDate;

    private Timestamp updatedDate;

    @JsonIgnore
    public Set<BankWallet> getLinkedWallets() {
        return linkedWallets;
    }

    @JsonDeserialize(as = LinkedHashSet.class)
    @JsonProperty
    public void setLinkedWallets(Set<BankWallet> linkedWallets) {
        this.linkedWallets = linkedWallets;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade({ CascadeType.ALL })
    private Set<BankWallet> linkedWallets;


    public int getUserId() {
        return userId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void addWallet(BankWallet walletToAdd) {
        this.linkedWallets.add(walletToAdd);
        walletToAdd.setLinkedUser(this);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(int userid) {
        this.userId = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "userid=" + this.userId + ", name=" + this.userName + ", email=" + this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;

        if (getEmail() == null && getUserName() == null)
            return false;

        BankUser ref = (BankUser) o;
        if (!(getEmail().equals(ref.getEmail())))
            return false;

        if (!(getUserName().equals(ref.getUserName())))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;

        hash = 47 * hash + ((getEmail() != null) ? getEmail().hashCode() : 0);
        hash = 47 * hash + ((getUserName() != null) ? getUserName().hashCode() : 0);

        return hash;
    }

}
