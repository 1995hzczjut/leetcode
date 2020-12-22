package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class _535 {

	/**
	 * 1.��ҵ�ϵ�˼·������ʹ��������������һ�����������Ρ������ظ��Ľ�����Ҳû��Ҫ�ù�ϣ���Ƿ��ظ���
	 * ���ƣ�
	 * 
	 * 2.ʹ��6����ĸ��������������Ĵ�����MAP�棬Ҫ�����ظ��ġ�
	 */
	public class Codec1 {
		Map<String,String> index = new HashMap<>();//�̣�6λ������
		Map<String,String> revIndex = new HashMap<>();//������
		static final String BASE_HOST = "http://tinyurl.com/";
		String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
	    // Encodes a URL to a shortened URL.
	    public String encode(String longUrl) {
	        //��Ҫ�����Ƿ��Ѿ�����
	    	if(revIndex.containsKey(longUrl)) return BASE_HOST+revIndex.get(longUrl);
	    	//�㴮��Ҫ�����ظ�
	    	StringBuilder res = new StringBuilder();
	    	do{
	    		for(int i = 0; i <= 5; ++i){	    			
	    			res.append(charSet.charAt((int)(Math.random()*charSet.length())));
	    		}
	    	}while(index.containsKey(res.toString()));
	    	index.put(res.toString(), longUrl);
	    	revIndex.put(longUrl, res.toString());
	    	return BASE_HOST+res.toString();
	    	
	    }

	    // Decodes a shortened URL to its original URL.
	    public String decode(String shortUrl) {
	        String s = shortUrl.replace(BASE_HOST, "");
	        return index.get(s);
	    }
	}

}
