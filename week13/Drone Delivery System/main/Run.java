package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import managers.WarehouseManager;
import models.Warehouse;
import processing.RequestProcessor;


public class Run {

	public static void main(String[] args) {
		WarehouseManager w=new WarehouseManager();
		String supplyFile="testInputSupply.txt";
		String deliveryFile="testInputDelivery.txt";
		//TODO create other warehouses
		Warehouse warehouse=w.getWarehouseById("w1");
		
		//readInputFile(warehouse,supplyFile);
		
		readInputFile(warehouse,deliveryFile);
		
		
		//w.updateWarehouseData(warehouse);
		//System.out.println(warehouse.getProducts());
		//System.out.println(warehouse.getProducts().size());
		
	}

	public static void readInputFile(Warehouse warehouse,String inputFile){
		try(BufferedReader reader=new BufferedReader(
				new FileReader(inputFile))){
			String line=null;
			while((line=reader.readLine())!= null){
				readRequest(warehouse,line);
			}
					
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe);
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
	
	public static void readRequest(Warehouse warehouse,String request){
		String[] reqParts=request.split(" ");
		//get word supply or delivery
		String type=reqParts[0];
		//process request
		RequestProcessor rp=new RequestProcessor();
		rp.processRequest(warehouse,type, request);
	}
	
}
