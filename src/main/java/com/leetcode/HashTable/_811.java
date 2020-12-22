package com.leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _811 {

	/**  ����Hashmap��ʹ��
	 * public String[] split(String regex)
	 * \\s��ʾ   �ո�,�س�,���еȿհ׷�,    
 	 * +�ű�ʾһ����������˼,����...
 	 * \\. ��.�ָ�
	 *JDK8 hashmap�·���https://blog.csdn.net/qq_15071263/article/details/77543043
	 *˼·��
	 *��ÿ�������������������Ž�HASHMAP����
	 */
	public static List<String> subdomainVisits(String[] cpdomains) {
		HashMap<String, Integer> counts = new HashMap<>();
		for (String string : cpdomains) {
			String[] stringBySpace = string.split("\\s+");
			String[] stringByDot = stringBySpace[1].split("\\."); //�����������
			int count = Integer.parseInt(stringBySpace[0]); //900
			//����stringByDot
			String subDomain = "";
			/*for (int i = 0; i < stringByDot.length; i++) {
				for(int j = i;)
			}
			���ָ��Ӷȸ��ˣ�һ��ѭ���Ϳ�����
			*/
			for(int i = stringByDot.length-1;i >= 0; i--){
				if(i == stringByDot.length-1){
					subDomain =stringByDot[i] ;
				}else{
					subDomain =stringByDot[i] + "." +subDomain;
				}
				//ע��Ž�ȥ������Ѿ����ˣ��������������Ҫ�����ۼӵĽ����Ҫע��û��key������null�����
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
