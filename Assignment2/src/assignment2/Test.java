package assignment2;

public class Test {
	
	public void print(int n) {
		for(int i=0; i< n; i++)
			for(int j=0; j< n; j++)
				System.out.println("This is O(n^2)");
	}
	public static long getCountOperate(int n) {
		long counter =0;
		for(int i=0; i< n; i++)
			for(int j=0; j< n; j++)
				counter ++;	
		return counter;
	}
	public static int sum(int a, int b) {
		int start = (a%2==0)? a : (a+1);
		int end = (b%2==0)? b : (b-1);
	    if (start == end) {
	        return start;
	    } else if (end > start) {
	        return sum(start, end - 2) + end;
	    } else {
	        return 0;
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( getCountOperate(6));
		System.out.println(sum(1, 5));
	}

}
