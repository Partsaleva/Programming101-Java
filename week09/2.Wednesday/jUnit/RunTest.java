package jUnit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTest {

	public static void main(String[] args) {
		Class<?> a = ClassTests.class;
		Method[] allMethods = a.getDeclaredMethods();

		ClassTests obj = new ClassTests();

		for (Method method : allMethods) {
			if (method.isAnnotationPresent(Test.class)) {
				try {
					method.invoke(obj);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				System.out.println(method.getName() + " passed successfully!");
			}
		}

	}

}
