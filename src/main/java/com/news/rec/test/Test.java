package com.news.rec.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class Test 
{
    public static void testLinkedHashSet()
    {
		Set<String> result=new LinkedHashSet<String>();
		List<String> curkeylist=new ArrayList<String>();
		curkeylist.add("1");
		curkeylist.add("13");
		curkeylist.add("31");
		curkeylist.add("41");
		curkeylist.add("81");
		curkeylist.add("10");
		curkeylist.add("41");
		curkeylist.add("81");
		result.addAll(curkeylist);
		System.out.println("curkeylist:"+curkeylist);
		System.out.println("result:"+result);
		
		curkeylist.clear();
		curkeylist.add("1");
		curkeylist.add("13");
		curkeylist.add("31");
		curkeylist.add("41");
		curkeylist.add("81");
		curkeylist.add("10");
		curkeylist.add("41");
		curkeylist.add("81");
		curkeylist.add("10");
		curkeylist.add("10");
		curkeylist.add("50");
		result.addAll(curkeylist);
		System.out.println("curkeylist:"+curkeylist);
		System.out.println("result:"+result);
    }
    
    public static void testHashSet()
    {
		Set<String> result=new HashSet<String>();
		List<String> curkeylist=new ArrayList<String>();
		curkeylist.add("1");
		curkeylist.add("13");
		curkeylist.add("31");
		curkeylist.add("41");
		curkeylist.add("81");
		curkeylist.add("10");
		curkeylist.add("41");
		curkeylist.add("81");
		result.addAll(curkeylist);
		System.out.println("curkeylist:"+curkeylist);
		System.out.println("result:"+result);
		
		curkeylist.clear();
		curkeylist.add("1");
		curkeylist.add("13");
		curkeylist.add("31");
		curkeylist.add("41");
		curkeylist.add("81");
		curkeylist.add("10");
		curkeylist.add("41");
		curkeylist.add("81");
		curkeylist.add("10");
		curkeylist.add("10");
		curkeylist.add("50");
		result.addAll(curkeylist);
		System.out.println("curkeylist:"+curkeylist);
		System.out.println("result:"+result);
    }
    public static void testLinkedHashSetInt()
    {
		Set<Integer> result=new LinkedHashSet<Integer>();
		List<Integer> curkeylist=new ArrayList<Integer>();
		curkeylist.add(1);
		curkeylist.add(13);
		curkeylist.add(31);
		curkeylist.add(41);
		curkeylist.add(81);
		curkeylist.add(10);
		curkeylist.add(41);
		curkeylist.add(81);
		result.addAll(curkeylist);
		System.out.println("curkeylist:"+curkeylist);
		System.out.println("result:"+result);
		
		curkeylist.clear();
		curkeylist.add(1);
		curkeylist.add(13);
		curkeylist.add(31);
		curkeylist.add(41);
		curkeylist.add(81);
		curkeylist.add(10);
		curkeylist.add(41);
		curkeylist.add(81);
		curkeylist.add(10);
		curkeylist.add(10);
		curkeylist.add(50);
		result.addAll(curkeylist);
		System.out.println("curkeylist:"+curkeylist);
		System.out.println("result:"+result);
    }
    
    public static void testHashSetInt()
    {
		Set<Integer> result=new HashSet<Integer>();
		List<Integer> curkeylist=new ArrayList<Integer>();
		curkeylist.add(1);
		curkeylist.add(13);
		curkeylist.add(31);
		curkeylist.add(41);
		curkeylist.add(81);
		curkeylist.add(10);
		curkeylist.add(41);
		curkeylist.add(81);
		result.addAll(curkeylist);
		System.out.println("curkeylist:"+curkeylist);
		System.out.println("result:"+result);
		
		curkeylist.clear();
		curkeylist.add(1);
		curkeylist.add(13);
		curkeylist.add(31);
		curkeylist.add(41);
		curkeylist.add(81);
		curkeylist.add(10);
		curkeylist.add(41);
		curkeylist.add(81);
		curkeylist.add(10);
		curkeylist.add(10);
		curkeylist.add(50);
		result.addAll(curkeylist);
		System.out.println("curkeylist:"+curkeylist);
		System.out.println("result:"+result);
    }
    
    public static void testPay()
    {
		List<Double> curkeylist=new ArrayList<Double>();
		curkeylist.add(11.04);
		curkeylist.add(13.75);
		curkeylist.add(25.39);
		curkeylist.add(19.90);
		curkeylist.add(8.67);
		curkeylist.add(22.72);
		curkeylist.add(13.28);
		curkeylist.add(16.75);
		curkeylist.add(20.55);
		curkeylist.add(10.97);
		curkeylist.add(5.47);
		curkeylist.add(19.90);
		curkeylist.add(24.90);
		curkeylist.add(3.50);
		curkeylist.add(11.50);
		List<Integer> val=new ArrayList<Integer>();
		List<Integer> maxval=new ArrayList<Integer>();
		double max=0,curpay=0;
		int iter=10000,pos=0;
//		while(pos<iter){
//			curpay=0;
//			for(int ind=0;ind<curkeylist.size();ind++){
//				
//			}
//			pos++;
//		}
		System.out.println("curkeylist:"+curkeylist);
		System.out.println("val:"+val);
		System.out.println("maxval:"+maxval);
		System.out.println("max:"+max);
    }
    
    public static void main( String[] args )
    {
//		System.out.println("------------testHashSet------------");
//    	testHashSet();
//		System.out.println("------------testLinkedHashSet------------");
//    	testLinkedHashSet();
//		System.out.println("------------testHashSetInt------------");
//    	testHashSetInt();
//		System.out.println("------------testLinkedHashSetInt------------");
//    	testLinkedHashSetInt();
		System.out.println("------------testPay------------");
//		testPay();
    }
}
