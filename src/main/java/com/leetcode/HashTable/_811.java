package com.leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _811 {

	/**  考察Hashmap的使用
	 * public String[] split(String regex)
	 * \\s表示   空格,回车,换行等空白符,    
 	 * +号表示一个或多个的意思,所以...
 	 * \\. 按.分割
	 *JDK8 hashmap新方法https://blog.csdn.net/qq_15071263/article/details/77543043
	 *思路：
	 *把每个域名的所有子域名放进HASHMAP即可
	 */
	public static List<String> subdomainVisits(String[] cpdomains) {
		HashMap<String, Integer> counts = new HashMap<>();
		for (String string : cpdomains) {
			String[] stringBySpace = string.split("\\s+");
			String[] stringByDot = stringBySpace[1].split("\\."); //点是特殊符号
			int count = Integer.parseInt(stringBySpace[0]); //900
			//遍历stringByDot
			String subDomain = "";
			/*for (int i = 0; i < stringByDot.length; i++) {
				for(int j = i;)
			}
			这种复杂度高了，一个循环就可以了
			*/
			for(int i = stringByDot.length-1;i >= 0; i--){
				if(i == stringByDot.length-1){
					subDomain =stringByDot[i] ;
				}else{
					subDomain =stringByDot[i] + "." +subDomain;
				}
				//注意放进去，如果已经有了，会擦除，但我们要的是累加的结果。要注意没有key，返回null的情况
				//counts.put(subDomain, count+counts.get("subDomain"));
				counts.put(subDomain, counts.containsKey(subDomain) ? count+counts.get(subDomain) : count);
			}
			
		}

		List<String> res= new ArrayList();
		for(String dom : counts.keySet()){
			res.add(counts.get(dom) + " " +dom);
		}
		return res;
		
    }
	public static void main(String[] args) {
		String[] s = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		List<String> res= new ArrayList();
		res = subdomainVisits(s);
		for (String string : res) {
			System.out.println(string);
		}
	}

}
