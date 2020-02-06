package com.mastek.hrapp.entities;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

@Component// class is initialised by Spring Application Context 
public class EmployeeListener {
	
	//@<Lifecycle-Event>
	// public void<method-name>(Entity e)
	
	@PrePersist// calls this method before inserting each emp object in employee table 
	public void beforeEmpInsert(Employee e){
		System.out.println("Before Employee Instert");
		System.out.println("Raise Email request for "+e.getName());
	}
	@PostPersist //calls this method After inserting each emp object in employee table 
	public void afterEmpInsert(Employee e) {
		System.out.println("After Employee Insert");
		System.out.println("Screen Name Generated:"+e.getName()+e.getEmpno());
	}
	@PreUpdate//calls this method before updating  each emp object in employee table 
	public void beforeUpdate(Employee e) {
		System.out.println("Before Update: "+e);
	}
	@PostUpdate//calls this method After updating each emp object in employee table 
	public void afterUpdate(Employee e ) {
		System.out.println("After Update: "+e);
	}
	@PostLoad//calls this method after loading each emp object in employee table
	public void afterLoading(Employee e) {
		System.out.println("Employee Fetched:"+e);
	}
	@PreRemove//calls this metod before removing each emp object in employee table 
	public void beforeDelete(Employee e) {
		System.out.println("Before Removing"+e);
		System.out.println("Disable Profile for"+e.getName());
	}
}
