package week2;
/*18. Lucas series
Because Fibonacci is way too trivial, implement the following functions that work with Lucas series:
int nthLucas(int n) -> returns the nth Lucas number
Quick hint:
L(0) = 2
L(1) = 1
L(n) = L(n-1) + L(n-2)*/
public class LucasSeries {

	public static void main(String[] args) {
		LucasSeries num=new LucasSeries();
		System.out.println(num.nthLucas(8));
	}

	int nthLucas(int n){
		if(n==0){
			return 2;
		}		
		else if(n==1){
			return 1;
		}
		else{
			return nthLucas(n-1) + nthLucas(n-2);
		}
				
	}
	
}
