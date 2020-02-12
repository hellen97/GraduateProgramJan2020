package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Payement;

@Repository
public interface PaymentJPADAO extends 
					CrudRepository<Payement, Integer>{

}
