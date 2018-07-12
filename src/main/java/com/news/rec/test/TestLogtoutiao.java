package com.news.rec.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.news.rec.service.CryptService;

public class TestLogtoutiao{
	private static String curpath="/";
	private static String logspath="logs/";
	
	static{
		try{
			curpath=TestLogtoutiao.class.getResource("/").getPath();
			logspath=curpath+"logs/";
		}catch(Exception e){
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
    public static final class PARAM_FIELD{
    	public final static String requestId = "requestId";
    	public final static String curtime = "curtime";
    	public final static String devId = "devId";
    	public final static String passport = "passport";
    	public final static String cursor = "cursor";
    	public final static String limit = "limit";
    	public final static String ts = "ts";
    	public final static String mac = "mac";
    	public final static String lat = "lat";
    	public final static String lon = "lon";
    	public final static String net = "net";
    	public final static String ipv4 = "ipv4";
    	public final static String sign = "sign";
    	public final static String sessionid = "sessionid";
    	public final static String ua = "ua";
    	public final static String canal = "canal";
    	public final static String version = "version";
    	public final static String spever = "spever";
    	public final static String open = "open";
    	public final static String openpath = "openpath";
    	public final static String user_source = "user_source";
    	public final static String query_text = "query_text";
    	public final static String abtestId = "abtestId";
    	public final static String abtestProfile = "abtestProfile";
    }
	
	private static Map<String,String> convertSubObject(String data){
		Map<String,String> result=new HashMap<String,String>();
		if(data==null || data.isEmpty()){
			System.out.println(data);
			return result;
		}
		try{
			String[] arr=data.split(",");
			if(arr==null || arr.length<=0){
				System.out.println(data);
				return result;
			}
			for(String str:arr){
				if(str==null || str.isEmpty()){
					System.out.println(str);
					continue;
				}
				try{
					String[] tmp=str.split(":");
					if(tmp==null || tmp.length<=0){
						System.out.println(tmp);
						continue;
					}
					if(tmp.length==2){
						result.put(tmp[0], tmp[1]);
					}
				}catch(Exception e){
					System.out.println(data);
					System.err.println(e.getMessage());
					e.printStackTrace();
					return result;
				}
			}
			
			return result;
		}catch(Exception e){
			System.out.println(data);
			System.err.println(e.getMessage());
			e.printStackTrace();
			return result;
		}
	}
	
	private static Map<String,String> convertObject(String data){
		Map<String,String> result=new HashMap<String,String>();
		if(data==null || data.isEmpty()){
			System.out.println(data);
			return result;
		}
		try{
			String spitstr=",query_text:";
			int ind=data.indexOf(spitstr);
			if(ind<0){
				System.out.println(data);
				return result;
			}
			Map<String,String> subres=convertSubObject(data.substring(0, ind));
			if(subres!=null){
				result.putAll(subres);
			}
			return result;
		}catch(Exception e){
			System.out.println(data);
			System.err.println(e.getMessage());
			e.printStackTrace();
			return result;
		}
	}
	
	private static String removePackage(String data){
		if(data==null || data.isEmpty()){
			System.out.println(data);
			return data;
		}
		try{
			String spitstr=" - ";
			int ind=data.indexOf(spitstr);
			if(ind<0){
				System.out.println(data);
				return data;
			}
			return data.substring(ind+spitstr.length());
		}catch(Exception e){
			System.out.println(data);
			System.err.println(e.getMessage());
			e.printStackTrace();
			return data;
		}
	}
	
    private static int StatSearchAndroidDevIds(String infilename,String outfilename,List<String> devIds){
        BufferedReader reader=null;
        FileWriter writer=null;
        int count=0;
        try {
            File file=new File(infilename);
            if(!file.exists()){
            	System.out.println("file exists false");
            }else{
                reader = new BufferedReader(
                		new InputStreamReader(new FileInputStream(infilename), "utf-8"));
                
                writer=new FileWriter(outfilename,true);
                
                String devId=null;
                String data=null;
                Map<String,String> obj=null;
                String line = reader.readLine();
                while(line != null) {
                	if(line.isEmpty() || !line.contains(PARAM_FIELD.devId)){
                		count++;
                		line = reader.readLine();
                		continue;
                	}
                	data=removePackage(line);
                	obj=convertObject(data);
                	if(obj==null || !obj.containsKey(PARAM_FIELD.devId)){
                		count++;
                		line = reader.readLine();
                		continue;
                	}
                	devId=obj.get(PARAM_FIELD.devId);
                	if(devIds.contains(devId)){
                		count++;
                		line = reader.readLine();
                		continue;
                	}
                	devIds.add(devId);
                	writer.write(devId);
                	writer.write("\r\n");
                	writer.write("\r\n");
                    writer.flush();
                	count++;
                	line = reader.readLine();
                	if(count%1000==0){
                		System.out.println(count);
                	}
                }
                reader.close();
                writer.flush();
                writer.close();
                System.out.println("infilename:"+infilename);
                System.out.println("count:"+count);
                System.out.println("outfilename:"+outfilename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null)
                	reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (writer != null)
                	writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return count;
    }
	
    public static int StatSearchAndroidDevIds(){
        int count=0;
        try {
        	String outfilename=logspath+"android.2017-06-08.log";
            File file=new File(outfilename);
            if(file.exists()){
            	file.delete();
            }
        	file.createNewFile();
        	
        	List<String> devIds=new ArrayList<String>();
        	count+=StatSearchAndroidDevIds(logspath+"android.8.2017-06-08.log",outfilename,devIds);
        	count+=StatSearchAndroidDevIds(logspath+"android.9.2017-06-08.log",outfilename,devIds);
        	count+=StatSearchAndroidDevIds(logspath+"android.10.2017-06-08.log",outfilename,devIds);
            System.out.println("devIds.size:"+devIds.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("count:"+count);
        return count;
    }
    
    
    public static void CryptDevIdsAndPassport(){
        BufferedReader reader=null;
        FileWriter writer=null;
        int count=0;
        try {
        	String filename=TestLogtoutiao.class.getResource("/").getPath()+"devids/unlike_user_infos";
            File file=new File(filename);
            if(!file.exists()){
            	System.out.println("file exists false");
            }else{
                reader = new BufferedReader(
                		new InputStreamReader(new FileInputStream(filename), "utf-8"));
                
            	String filename_encryed=TestLogtoutiao.class.getResource("/").getPath()+"devids/unlike_user_infos.encryed";
                file=new File(filename_encryed);
                if(file.exists()){
                	file.delete();
                }
            	file.createNewFile();
                writer=new FileWriter(filename_encryed);
                
                String devId_encryed=null;
                String sign=null;
        		long ts=1471070364000L;
                String line = reader.readLine();
                String[] arr=null;
                while(line != null) {
                	if(line.isEmpty()){
                		count++;
                		line = reader.readLine();
                		continue;
                	}
                	arr=line.split("\t");
                	if(arr==null || arr.length<1){
                		count++;
                		line = reader.readLine();
                		continue;
                	}
                	devId_encryed=CryptService.encrypt(arr[0]);
                	sign=CryptService.sign(arr[0]+ts);
                	writer.write("devId="+arr[0]);
                	writer.write("\r\n");
                	writer.write("devId_encryed="+devId_encryed);
                	writer.write("\r\n");
                	writer.write("sign="+sign);
                	writer.write("\r\n");
                	if(arr.length>1 && arr[1]!=null && !arr[1].isEmpty()){
                    	writer.write("passport="+arr[1]);
                    	writer.write("\r\n");
                    	writer.write("passport_encryed="+CryptService.encrypt(arr[1]));
                    	writer.write("\r\n");
                	}
                	writer.write("\r\n");
                    writer.flush();
                	count++;
                	line = reader.readLine();
                	if(count%1000==0){
                		System.out.println(count);
                	}
                }
                reader.close();
                writer.flush();
                writer.close();
                System.out.println("filename:"+filename);
                System.out.println("count:"+count);
                System.out.println("filename_encryed:"+filename_encryed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null)
                	reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (writer != null)
                	writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main( String[] args ){
		System.out.println("------------StatSearchAndroidDevIds------------");
		StatSearchAndroidDevIds();
    }
}
