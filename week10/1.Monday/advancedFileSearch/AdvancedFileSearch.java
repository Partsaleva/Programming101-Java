package advancedFileSearch;


public class AdvancedFileSearch {

	public static void main(String[] args) {
		Memory memory=new Memory(50);
		Searcher searcher=new Searcher(memory);	
		Get get=new Get(memory);
		Thread tr1=new Thread(searcher);
		Thread tr2=new Thread(get);
		tr1.start();
		tr2.start();
		try {
			tr1.join();
			tr2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
