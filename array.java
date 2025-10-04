package java_project_f116;
import java.util.Scanner;
public class array {

	public static void main(String[] args) {
		int [] arr=new int[12];
		Scanner s=new Scanner(System.in);
		for(int i=0;i<12;i++) {
			arr[i]=s.nextInt();
		} 
		for(int j=0;j<12;j++) {
			System.out.println(arr[j]);
		}

	}

}
