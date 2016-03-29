package annotations;

public @interface ClassInfo {
	String author();
	int revision();
	boolean checked();
	String[] relatedClasses();
}
