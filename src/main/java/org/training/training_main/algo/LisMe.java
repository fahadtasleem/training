package org.training.training_main.algo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LisMe {

    static int longestIncreasingSubsequence(int[] arr) {
        // Complete this function
    		List<Integer>[] L = new List[arr.length];
    		for(int i=0;i<arr.length;i++) {
    			L[i] = new ArrayList<Integer>();
    		}
    		L[0].add(arr[0]);
        for(int i=1;i<arr.length;i++) {
        		for(int j=0;j<i;j++) {
        			if(arr[j] < arr[i] && (L[i].size() < L[j].size()+1)) {
        				L[i] = new ArrayList<>(L[j]);
        				
        			}
        		}
        		L[i].add(arr[i]);
        }
        int l =0;
        for(List<Integer> f: L) {
        		System.out.println(f.toString());
        		if(f.size()>l) {
        			l = f.size();
        		}
        }
        return l;
    }

	public static void main(String[] args) throws IOException, URISyntaxException {
//        List<String> strs = Files.readAllLines(Paths.get("/Users/fahadtasleem/Arr.text"));
//        System.out.println(strs.size());
//        int[] arr = new int[strs.size()];
//        int i=0;
//        for(String s : strs) {
//        		arr[i++] = Integer.parseInt(s);
//        }
        int[] a = {3,2,6,4,5,1};
        int result = longestIncreasingSubsequence(a);
        System.out.println(result);
        int[] b = {1,2,1};
    }

}
