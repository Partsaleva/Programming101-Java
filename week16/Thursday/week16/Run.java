package week16;

public class Run {

	public static void main(String[] args) {
		System.out.println(new Zero().toString());
		System.out.println(new Succ(new Succ(new Zero())).toInt());
		System.out.println(new Succ(new Zero()).toString());
		System.out.println(new Succ(new Succ(new Zero())).toString());
	}

}
