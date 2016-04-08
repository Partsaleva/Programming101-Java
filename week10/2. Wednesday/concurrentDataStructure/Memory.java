package concurrentDataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Memory implements IMemory
{
	private final List<Object> data=new ArrayList<>();
	private final int capacity;
	
	public Memory(int capacity){
		this.capacity=capacity;
	}

	@Override
	public void put(Object o) throws InterruptedException {
		synchronized (data) {
			while(data.size()==capacity){
				data.wait();
			}
			data.add(o);
			data.notifyAll();
		}
		
	}

	@Override
	public Object get() throws InterruptedException {
		Object element=null;
		synchronized (data) {
			while(data.size()==0){
				data.wait();
			}
			element=data.remove(data.size()-1);
			data.notifyAll();
		}
		return element;
	}

	
	public static class Factory {
	    public static IMemory createMemory(int capacity) {
	      return new Memory(capacity);
	    }
	    public static IMemory createJavaMemory(int capacity) {
	      return new JavaMemory();
	    }
	  }
	  
	  static class JavaMemory implements IMemory {
	    
	    CopyOnWriteArrayList<Object> memory = new CopyOnWriteArrayList<>();
	    
	    @Override
	    public void put(Object o) throws InterruptedException {
	      memory.add(o);
	    }

	    @Override
	    public Object get() throws InterruptedException {
	      return memory.get(memory.size() - 1);
	    }
	    
	  }
}
