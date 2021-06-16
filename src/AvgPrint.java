import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AvgPrint {
	int sum=0;
	int avg=0;
	int value=0;
	int k=1;
	public void avg(){
			
for(int j=0;j<50;j++) {
	System.out.println("Enter a value");
	Scanner s=new Scanner(System.in);
	sum=s.nextInt()+sum;
	avg=sum/k;
	k++;
	System.out.println("Average is: "+avg);	
}
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AvgPrint av=new AvgPrint();
		av.avg();
	}

}
