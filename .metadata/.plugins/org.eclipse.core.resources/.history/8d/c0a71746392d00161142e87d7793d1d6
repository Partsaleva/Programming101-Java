package graphs;

import java.util.ArrayList;
import java.util.List;

public class BuildScripts {

	static int[][] graph;
	 
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
		graph=new int[numberOfPrograms][numberOfPrograms];
		buildGraph(namesOfPrograms, listOfDependencies);
		printGraph();
				
	}

	private static void printGraph() {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	public static void buildGraph(String namesOfPrograms, List<String> listOfDependencies){
		List<List<String>> dependencies=makeDependencyList(listOfDependencies);
		List<String> programs=makeProgramList(namesOfPrograms);
		
		for (int i = 0; i < dependencies.size(); i++) {
			List<String> depList=dependencies.get(i);
			//for every list of dependencies
			for (String str : depList) {
				//find where in our program list is this dependency
				int index=programs.indexOf(str);
				// there is way from row[index] to column[index]
				graph[index][i]=1;
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
