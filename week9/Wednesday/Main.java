package Wednesday;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;

public class Main {

	public static void main(String[] args) {
		MyClass obj=new MyClass();
		
		@SuppressWarnings("unchecked")
		Class<MyClass> cla=(Class<MyClass>) obj.getClass();
		Annotation[] annotations=cla.getDeclaredAnnotations();
		
		for(Annotation annotation: annotations){
			//Class
		}
	}

}
