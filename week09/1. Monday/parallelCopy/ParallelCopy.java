package parallelCopy;

import java.io.File;

public class ParallelCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void copyFolder(File src, File dest){
		if(src.isDirectory()){
			if(!dest.exists()){
				dest.mkdir();
				System.out.println("Maded destination folder: "+dest.getName());
			}
		}
	}
}
