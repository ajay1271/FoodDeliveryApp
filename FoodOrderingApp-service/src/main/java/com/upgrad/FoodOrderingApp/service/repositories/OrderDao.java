package com.upgrad.FoodOrderingApp.service.repositories;


import com.upgrad.FoodOrderingApp.service.entities.CouponsEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class OrderDao {

    @PersistenceContext
    private EntityManager entityManager;


    public CouponsEntity getCouponDetails(final String coupon_name) {
        try {
            String query = "select u from CouponsEntity u where u.coupon_name = :coupon_name";
            return entityManager.createQuery(query, CouponsEntity.class)
                    .setParameter("coupon_name", coupon_name).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }


    }
