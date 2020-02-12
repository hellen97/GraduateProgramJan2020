package com.mastek.hrapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.JobPosition;

@Repository // mark class a repotiory 
public interface JobPositionsDAO extends 
				MongoRepository<JobPosition, Integer> {
	//map the document and identifier type with MongoRepository

}
