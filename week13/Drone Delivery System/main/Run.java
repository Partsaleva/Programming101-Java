package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import processing.RequestProcessor;


public class Run {

	public static void main(String[] args) {
		String file="input1.txt";
		readInputFile(file);

	}

	public static void readInputFile(String inputFile){
		try(BufferedReader reader=new BufferedReader(new FileReader(inputFile))){
			
		} catch (FileNotFoundException fnfe) {
			System.err.println(fnfe);
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
	
	public static void readRequest(String request){
		String[] reqParts=request.split(" ");
		String type=reqParts[0];
		RequestProcessor rp=new RequestProcessor();
		rp.processRequest(type, request);
		
	}
	
	public static void readRequest(File request){}
}
