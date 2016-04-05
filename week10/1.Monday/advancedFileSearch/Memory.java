package advancedFileSearch;

import java.util.HashMap;
import java.util.Map;

public class Memory {

	Map<Object,Object> data = new HashMap<>();
    int capacity;
    
    public Memory(int capacity) {
      this.capacity = capacity;
    }
    
    void put (Object k,Object v) throws InterruptedException {
      synchronized (data) {
        while (data.size() == capacity) {
          data.wait();
        }
        data.put(k,v);
        data.notifyAll();
      }
    }

    Object get() throws InterruptedException {
      Object element = null;
      synchronized (data) {
        while (data.size() == 0) {
          data.wait();
        }
        element = data.values();
        data.notifyAll();
      }
      return element;
    }
  }

