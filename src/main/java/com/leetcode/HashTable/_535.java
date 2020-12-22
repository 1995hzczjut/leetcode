package com.leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class _535 {

	/**
	 * 1.工业上的思路。就是使用自增主键，来一个，自增依次。就算重复的进来，也没必要用哈希算是否重复。
	 * 劣势：
	 * 
	 * 2.使用6个字母。数字生成随机的串，用MAP存，要考虑重复的。
	 */
	public class Codec1 {
		Map<String,String> index = new HashMap<>();//短（6位），长
		Map<String,String> revIndex = new HashMap<>();//长，短
		static final String BASE_HOST = "http://tinyurl.com/";
		String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
	    // Encodes a URL to a shortened URL.
	    public String encode(String longUrl) {
	        //先要检验是否已经有了
	    	if(revIndex.containsKey(longUrl)) return BASE_HOST+revIndex.get(longUrl);
	    	//算串。要避免重复
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
