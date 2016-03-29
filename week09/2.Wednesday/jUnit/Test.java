package jUnit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Test {

	Class<?> expected() default Default.class;

	long timeout() default 0L;

}
