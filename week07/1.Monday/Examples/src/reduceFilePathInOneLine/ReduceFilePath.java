package reduceFilePathInOneLine;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ReduceFilePath {

	public static void main(String[] args) {
		String[] test={"/", "/srv/../", "/srv/www/htdocs/wtf/", "/srv/www/htdocs/wtf",
		"/srv/./././././", "/etc//wtf/", "/etc/../etc/../etc/../", "//////////////", "/../"};
		
		for(int i=0; i<test.length;i++){
			Path path=Paths.get(test[i]).normalize();
			System.out.println(path);
		}

	}

}
