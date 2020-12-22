package com.leetcode.hzc;

import java.util.HashSet;

public class _766 {

	/**
	 * 错在raw=3, col = 4 ,变量搞混了。
	 * 最好的做法是判断一个数更他斜对角线那两个数是否一样
	 */
	 public static boolean isToeplitzMatrix(int[][] matrix) {
		if(matrix == null){
			return false;
		}
		int raw = matrix.length;
		int col = matrix[0].length;
		int a = raw-1;
		int b = 0;
		int c = raw-1;
		int d = 0;
		while(b < col && c >= 0){
			System.out.println("[" + a + "," + b + "] , " + "[" + c + "," + d + "]");
			//if(!isHaveSame(matrix,a,b,c,d)){
				//return false;
			//}// 放到前面
			b = a > 0 ? 0 : ++b;
			a = a > 0 ? --a : 0; //注意顺序
			c = d < col-1 ? raw-1 : --c;
			d = d < col-1 ? ++d : col-1;
			
			
		}
		 return true;
	        
	    }
	
	 
	
	
	public static boolean isHaveSame(int[][] matrix, int a, int b, int c, int d) {
		HashSet<Integer> hashset = new HashSet<>();
		while(a <= c && b <= d){
			hashset.add(matrix[a++][b++]);			
		}
		if(hashset.size() == 1){
			//System.out.println(hashset.size());
			return true;
		}else{
			//System.out.println(hashset.size());
			return false;
		}
		
	}




	public static void main(String[] args) {
		//int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		int[][] matrix = {{19},{86}};
		System.out.println(isToeplitzMatrix(matrix));
		
	}

}
