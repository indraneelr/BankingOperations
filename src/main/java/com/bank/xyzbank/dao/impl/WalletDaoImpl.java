package com.bank.xyzbank.dao.impl;

import com.bank.xyzbank.dao.WalletDao;
import com.bank.xyzbank.model.BankWallet;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.Clock;
import java.util.logging.Logger;

@Repository
public class WalletDaoImpl implements WalletDao {

    private static final Logger LOGGER = Logger.getLogger(WalletDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void updateWallet(BankWallet wallet) {

        Session session = this.sessionFactory.getCurrentSession();

        try {
            session.saveOrUpdate(wallet);
            LOGGER.info("Updated Wallet with ID = {} " + wallet.getWalletId());

        } catch (Exception e) {
            // transaction.rollback();
            //LOGGER.error("Exception occurred while updating bug." + e.getMessage());
        } finally {
            // session.flush();
            // session.close();
        }
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public BankWallet getWalletById(int walletId) {

        Session session = this.sessionFactory.getCurrentSession();
        BankWallet bankWallet = new BankWallet();
        try {
            session.load(bankWallet, walletId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // session.flush();
            // session.close();
        }
        return bankWallet;
    }
}
