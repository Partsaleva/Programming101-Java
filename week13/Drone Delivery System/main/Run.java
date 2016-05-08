package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import processing.RequestProcessor;


public class Run {

	public static void main(String[] args) {
		String file="testInputSupply.txt";
		readInputFile(file);

	}

	public static void readInputFile(String inputFile){
		try(BufferedReader reader=new BufferedReader(
				new FileReader(inputFile))){
			String line=null;
			while((line=reader.readLine())!= null){
				readRequest(line);
			}
					
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe);
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
	
	public static void readRequest(String request){
		String[] reqParts=request.split(" ");
		//get word supply or delivery
		String type=reqParts[0];
		//process request
		RequestProcessor rp=new RequestProcessor();
		rp.processRequest(type, request);
		
	}
	
}