package com.mastek.training.dao;

import java.util.Collection;

public interface DataAcessObject<D> {
	
	public D add (D newD);
	public Collection<D> listAll();
	public D find(int key);
	public D remove(int key);
}