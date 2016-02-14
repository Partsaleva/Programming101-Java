package wednesday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class StatisticData implements Statistics{

	public static void main(String[] args) {
		StatisticData data=new StatisticData();
		data.insertSorted(2);data.insertSorted(2);data.insertSorted(1);data.insertSorted(2);
		data.insertSorted(6);data.insertSorted(3);data.insertSorted(7);data.insertSorted(8);
		data.print(); 
		System.out.println("Mean: "+data.getMean());
		System.out.println("Range: "+data.getRange());
		System.out.println("Mode: "+data.getMode());
		System.out.println("Median: "+data.getMedian());
	}


	public StatisticData(){
		this.arr=new ArrayList<>();
		this.size=0;
		this.sum=0;
		this.mode=new HashMap<>();
	}

	public void insertSorted(int value) {
		arr.add(value);
		int occurences = 1;
		if(mode.containsKey(value)){
			occurences = (mode.get(value));
		    mode.put(value,occurences+1);
		}
		else{
			mode.put(value,occurences);
		}
		
		for(int i=arr.size()-1; i>0; i--){
			while(arr.get(i)<arr.get(i-1)){
				Collections.swap(arr, i, i-1);
			}
		}
		size++;
		sum+=value;
	}

	public void print(){
		for(int n: arr){
			System.out.print(n+" ");
		}
		System.out.println();
		 // Get a set of the entries
	      Set<?> set = mode.entrySet();
	      // Get an iterator
	      Iterator<?> i = set.iterator();
	      // Display elements
	      while(i.hasNext()) {
	         Map.Entry m = (Map.Entry)i.next();
	         System.out.print(m.getKey() + ": ");
	         System.out.println(m.getValue());
	      }
	}

	@Override
	public double getMean() {
		return sum/size;
	}



	@Override
	public double getMedian() {
		if(size%2==0){
			return (arr.get(size/2-1)+arr.get(size/2)) / 2.0;
		}
		else{
			return arr.get(size/2);
		}		
	}



	@Override
	public int getMode() {
		int key=0;
		int maxValue= Collections.max(mode.values());
		if(maxValue==1)return 0;
		for (Entry<Integer, Integer> entry : mode.entrySet()) {  
            if (entry.getValue()==maxValue) {
                key= entry.getKey();     
            }
        }
		return key;
	}



	@Override
	public int getRange() {
		return arr.get(size-1)-arr.get(0);
	}

	private ArrayList<Integer> arr;
	private int size;
	private double sum;
	private HashMap<Integer, Integer> mode;

}
