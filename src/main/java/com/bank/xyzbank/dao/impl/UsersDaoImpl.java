package com.bank.xyzbank.dao.impl;

import com.bank.xyzbank.dao.UsersDao;
import com.bank.xyzbank.model.BankUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.logging.Logger;

@Repository
public class UsersDaoImpl implements UsersDao {

    private static final Logger LOGGER = Logger.getLogger(UsersDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public int createUser(BankUser iUser) {

        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.save(iUser);
            LOGGER.info("Inserted User record with ID = {} at time = {} ");

        } catch (Exception e) {
            LOGGER.severe("Exception occurred while saving user into Users table." + e.getMessage());
        } finally {
            // session.flush();
            // session.close();
        }
        return iUser.getUserId();
    }


}
