package concurrentDataStructure;

public interface IMemory {
	 public void put (Object o) throws InterruptedException;
	 Object get() throws InterruptedException ;
}
