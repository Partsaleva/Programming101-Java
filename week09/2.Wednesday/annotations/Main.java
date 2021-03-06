package annotations;

import java.lang.annotation.Annotation;

public class Main {

	public static void main(String[] args) {
		MyClass obj=new MyClass();
		
		@SuppressWarnings("unchecked")
		Class<MyClass> cla=(Class<MyClass>) obj.getClass();
		Annotation[] annotations=cla.getDeclaredAnnotations();
		
		for(Annotation annotation: annotations){
			ClassInfo info= (ClassInfo) annotation;
			System.out.println(info.author());
		}
	}

}
