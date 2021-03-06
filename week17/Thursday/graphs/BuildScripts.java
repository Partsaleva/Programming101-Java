package graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BuildScripts {

	static LinkedList<Integer> adj[];
	 
	  
	 
	public static void main(String[] args) {
		List<String> listOfDependencies=new ArrayList<>();
		int numberOfPrograms= 5;
		String namesOfPrograms = "Extensions Interface Core Common Networking";
		String programToBuild = "Interface";
		String depend1 = "3 Common Core Networking";
		String depend2 = "4 Core Common Extensions Networking";
		String depend3 = "0";
		String depend4 = "1 Core";
		String depend5 = "2 Core Common";
		listOfDependencies.add(depend1);
		listOfDependencies.add(depend2);
		listOfDependencies.add(depend3);
		listOfDependencies.add(depend4);
		listOfDependencies.add(depend5);
		adj=new LinkedList[numberOfPrograms];
		buildGraph(namesOfPrograms, listOfDependencies);
		//printGraph();
		System.out.println(orderOfInstalation(namesOfPrograms));		
	}

	public static List<String> orderOfInstalation(String namesOfPrograms){
		List<String> result=new ArrayList<String>();
		List<String> programs=makeProgramList(namesOfPrograms);
		Stack<Integer> notVisited= new Stack<>();
		for (int i = 0; i < adj.length; i++) {
			if (adj[i].size() == 0) {
				result.add(programs.get(i));
				
				for (int j = 0; j < adj.length; j++) {
					for (Iterator<Integer> iterator = adj[j].listIterator(); 
							iterator.hasNext();) {
						Integer n = iterator.next();
						if (i==n) {
							iterator.remove();
						}						
					}
					System.out.println(adj[j]);					
				}
				System.out.println();
			}
			else {
				notVisited.push(i);
			}			
		}
		int size=0;
		if (!notVisited.isEmpty()) {
			size=notVisited.pop();
		}
		
		for (int i = 0; i <= size; i++) {
			if (adj[i].size() == 0) {
				result.add(programs.get(i));
				
				
				for (int j = 0; j <=size; j++) {
					for (Iterator<Integer> iterator = adj[j].listIterator(); 
							iterator.hasNext();) {
						Integer n = iterator.next();
						if (i==n) {
							iterator.remove();
						}						
					}
					System.out.println(adj[j]);					
				}
				System.out.println();
			}
			
			
		}
		
		return result;
	}
	
	public static void printGraph() {
		for (int i = 0; i < adj.length; i++) {
			System.out.print(i);
			Iterator<Integer> it = adj[i].listIterator();
			System.out.print(" [");
	        while (it.hasNext())
	        {
	        	System.out.print(it.next());
	        }
	        System.out.print("]");
	        System.out.println();
		}
		
	}

	public static void buildGraph(String namesOfPrograms, List<String> listOfDependencies){
		List<List<String>> dependencies=makeDependencyList(listOfDependencies);
		List<String> programs=makeProgramList(namesOfPrograms);
		for (int i=0; i<programs.size(); ++i){
            adj[i] = new LinkedList();
		}
		for (int i = 0; i < dependencies.size(); i++) {
			List<String> depList=dependencies.get(i);
			//for every list of dependencies
			for (String str : depList) {
				// there is way from row[index] to column[index]
				adj[i].add(programs.indexOf(str));
			}
			
		}
	}
	
	//create list of dependencies -add every string as list
	public static List<List<String>> makeDependencyList(List<String> listOfDependencies) {
		List<List<String>> dependencies=new ArrayList<List<String>>();
		
		for (int i = 0; i < listOfDependencies.size(); i++) {
			
			String[] dep=listOfDependencies.get(i).split(" ");
			List<String> depList=new ArrayList<String>();
			
			for (int j = 1; j < dep.length; j++) {
				depList.add(dep[j]);
			}
			dependencies.add(depList);
		}				
		return dependencies;		
	}
	
	//parse from string to ArrayList
	public static List<String> makeProgramList(String namesOfPrograms) {
		
		String[] arrayOfprogramsNames=namesOfPrograms.split(" ");
		List<String> programs=new ArrayList<>();
		
		for (String string : arrayOfprogramsNames) {
			programs.add(string);
		}
		return programs;	
	}
}
