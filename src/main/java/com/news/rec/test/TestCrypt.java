package com.news.rec.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import com.news.rec.service.CryptService;

public class TestCrypt{
    public static void CryptDevIds(){
        BufferedReader reader=null;
        FileWriter writer=null;
        int count=0;
        try {
        	String filename=TestCrypt.class.getResource("/").getPath()+"devids/user1";
            File file=new File(filename);
            if(!file.exists()){
            	System.out.println("file exists false");
            }else{
                reader = new BufferedReader(
                		new InputStreamReader(new FileInputStream(filename), "utf-8"));
                
            	String filename_encryed=TestCrypt.class.getResource("/").getPath()+"devids/user1.encryed";
                file=new File(filename_encryed);
                if(file.exists()){
                	file.delete();
                }
            	file.createNewFile();
                writer=new FileWriter(filename_encryed);
                
                String devId=null;
                String devId_encryed=null;
                String sign=null;
        		long ts=1471070364000L;
                String line = reader.readLine();
                while(line != null) {
                	if(line.isEmpty()){
//                	if(line.isEmpty() || !line.startsWith("devid=")){
                		count++;
                		line = reader.readLine();
                		continue;
                	}
                	devId=line;
//                	devId=line.replace("devid=", "");
                	devId_encryed=CryptService.encrypt(devId);
                	sign=CryptService.sign(devId+ts);
                	writer.write(line);
                	writer.write("\r\n");
//                	writer.write("devId_encryed="+devId_encryed);
                	writer.write(devId_encryed);
                	writer.write("\r\n");
                	writer.write("sign="+sign);
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
    public static void CryptDevIdsAndPassport(){
        BufferedReader reader=null;
        FileWriter writer=null;
        int count=0;
        try {
        	String filename=TestCrypt.class.getResource("/").getPath()+"devids/unlike_user_infos0";
            File file=new File(filename);
            if(!file.exists()){
            	System.out.println("file exists false");
            }else{
                reader = new BufferedReader(
                		new InputStreamReader(new FileInputStream(filename), "utf-8"));
                
            	String filename_encryed=TestCrypt.class.getResource("/").getPath()+"devids/unlike_user_infos0.encryed";
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
//		System.out.println("------------CryptDevIds------------");
//		CryptDevIds();
		System.out.println("------------CryptDevIdsAndPassport------------");
		CryptDevIdsAndPassport();
    }
}
