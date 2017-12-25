package learn;

import java.util.Arrays;
import java.util.Scanner;

public class LightsOut {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		for(int t=0;t<T;t++){
			int lights = Integer.parseInt(in.nextLine());
			String cont = in.nextLine();
			String[] condsS = cont.split(" ");
			int exVal = 0;
			int[] conds = new int[lights];
			
			for(int i =0;i<condsS.length;i++){
				
				conds[i] = Integer.parseInt(condsS[i]);
			}
			int solution = 1;
	 		for(int i =0;i<conds.length;i++){
				int el = conds[i];
				conds[i] = toggle(el);
				if(i>0){
					conds[i-1] = toggle(conds[i-1]);
				}
				if(i<conds.length -1){
					conds[i+1] = toggle(conds[i+1]);
				}
				
				solution = 1;
				System.out.println(Arrays.toString(conds));
				for(int k =0;k<conds.length;k++){
		 			if(conds[k] != exVal){
		 				solution = -1;
		 				break;
		 			}
		 		}
				if(solution == 1){
		 			System.out.println("YES");
		 			break;
		 		}
			}
	 		if(solution == -1){
	 			System.out.println("NO");
	 		}
	 		
		}
	}
	public static int toggle(int v){
		if(v ==1)
			return 0;
		return 1;
	}
}
