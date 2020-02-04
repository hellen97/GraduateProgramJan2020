package com.mastek.training.hrapp.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.ObjIntConsumer;

import com.mastek.training.dao.DataAcessObject;
import com.mastek.training.hrapp.Employee;

public class EmployeeBinaryFileDAO implements DataAcessObject<Employee> {
	
	Map<Integer, Employee>empMap;
	
	private String fileName;

	public EmployeeBinaryFileDAO(String fileName) {
		empMap=new HashMap<Integer,Employee>();
		this.fileName = fileName;
		//read all the data from file and load in collection map
		readMapFromFile();
		
	}
	//read the data from file and add it to the map shared
	private void readMapFromFile() {
		//ObjectInputStream: read objects from binary file input stream
		//FileInputStream: read binary data from file objects 
		//file: open or refer to the file using file Name/File path
		try (ObjectInputStream objn = new ObjectInputStream(
											new FileInputStream(
													new File(fileName)))){
			//we use try block with resources to manage autoclosing of streams
			empMap= (Map<Integer, Employee>) objn.readObject();
		} catch (Exception e) {
			System.out.println("Exception Thrown");
			e.printStackTrace();
		}
	}
	
	//update forle with the map content
	private void writeMapToFile() {
		//ObjectOutputStream: write binary object in serialized format in FileOutpUtStream
		//FileOutputStream: write binary objects to files
		//File: file oject will refer to the file to be updated/created if not present
		try(ObjectOutputStream objOut = new ObjectOutputStream(
											new FileOutputStream(
													new File(fileName)))) {
			objOut.writeObject(empMap);//wite all the data in serialized format in the file
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Employee add(Employee newEmployee) {
		readMapFromFile();
		if(!empMap.containsKey(newEmployee.getEmpno())) {
		empMap.put(newEmployee.getEmpno(), newEmployee);
		//update the file with new content
		writeMapToFile();
		
		}
		
		return newEmployee;
	}

	@Override
	public Collection<Employee> listAll() {
		readMapFromFile();
		return empMap.values();//returns all the values from the map
	}

	@Override
	public Employee find(int key) {
		readMapFromFile();
		return empMap.get(key);
	}

	@Override
	public Employee remove(int key) {
		readMapFromFile();
		
		Employee removedEmp = null;
		if(empMap.containsKey(key)) {
			removedEmp = empMap.remove(key);
			writeMapToFile();
		}
		
		return removedEmp;
	}

}
