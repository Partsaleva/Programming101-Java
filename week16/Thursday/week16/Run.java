package week16;

public class Run {

	public static void main(String[] args) {
		System.out.println(Zero.getInstance().toString());
		System.out.println(new Succ(new Succ(Zero.getInstance())).toInt());
		System.out.println(new Succ(Zero.getInstance()).toString());
		System.out.println(new Succ(new Succ(Zero.getInstance())).toString());
	}

}
