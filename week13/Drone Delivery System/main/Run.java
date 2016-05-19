package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import managers.WarehouseManager;
import models.Warehouse;
import processing.RequestProcessor;


public class Run {

	public static void main(String[] args) {
		WarehouseManager w=new WarehouseManager();
		//String supplyFile="testInputSupply.txt";
		//String deliveryFile="testInputDelivery.txt";
		String inputFile="input.txt";
		//TODO create other warehouses
		Warehouse warehouse=w.getWarehouseById("w1");
		
		
		
			//readInputFile(warehouse,supplyFile);
			//readInputFile(warehouse,deliveryFile);
			
		List<Thread> listOfThreads=readInputFile(warehouse,inputFile);
		for (Thread thread : listOfThreads) {
			thread.start();
		}
			
		for (Thread thread : listOfThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		//w.updateWarehouseData(warehouse);
		//System.out.println(warehouse.getProducts());
		//System.out.println(warehouse.getProducts().size());
		
	}

	public static List<Thread> readInputFile(Warehouse warehouse,String inputFile){
		List<Thread> listOfThreads=new ArrayList<Thread>();
		try(BufferedReader reader=new BufferedReader(
				new FileReader(inputFile))){
			String line=null;
			while((line=reader.readLine())!= null){				
				listOfThreads.add(readRequest(warehouse,line));
			}
					
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe);
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
		return listOfThreads;
	}
	
	public static Thread readRequest(Warehouse warehouse,String request) {
		String[] reqParts=request.split(" ");
		//get word supply or delivery
		String type=reqParts[0];
		//process request
		return (new Thread(new RequestProcessor(warehouse,type, request)));		
	}
	
}
