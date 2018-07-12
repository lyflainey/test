package com.news.rec.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class TestLocationcode{
    public static void getLocationcode1(){
        BufferedReader reader=null;
        FileWriter writer=null;
        int count=0;
        try {
        	String filename=TestLocationcode.class.getResource("/").getPath()+"locationcode/locationcode1.txt";
            File file=new File(filename);
            if(!file.exists()){
            	System.out.println("file exists false");
            }else{
                reader = new BufferedReader(
                		new InputStreamReader(new FileInputStream(filename), "utf-8"));
                
            	String filename_out=TestLocationcode.class.getResource("/").getPath()+"locationcode/locationcode1.output";
                file=new File(filename_out);
                if(file.exists()){
                	file.delete();
                }
            	file.createNewFile();
                writer=new FileWriter(filename_out);
                
                String data=null;
                String line = reader.readLine();
                while(line != null) {
                	if(line.isEmpty() || !line.startsWith("INSERT INTO `sh_area` VALUES (")){
                		count++;
                		line = reader.readLine();
                		continue;
                	}
                	data=line.replace("INSERT INTO `sh_area` VALUES (","");
                	data=data.replace(");","");
                    String[] datainfo=data.split(", ");
                    if(datainfo==null || datainfo.length!=12){
                        System.out.println("data:"+data);
                		count++;
                		line = reader.readLine();
                		continue;
                    }
                	writer.write(data);
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
                System.out.println("filename_out:"+filename_out);
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
    
    public static void getLocationcode2(){
        BufferedReader reader=null;
        FileWriter writer=null;
        int count=0;
        try {
        	String filename=TestLocationcode.class.getResource("/").getPath()+"locationcode/locationcode2.txt";
            File file=new File(filename);
            if(!file.exists()){
            	System.out.println("file exists false");
            }else{
                reader = new BufferedReader(
                		new InputStreamReader(new FileInputStream(filename), "utf-8"));
                
            	String filename_out=TestLocationcode.class.getResource("/").getPath()+"locationcode/locationcode2.output";
                file=new File(filename_out);
                if(file.exists()){
                	file.delete();
                }
            	file.createNewFile();
                writer=new FileWriter(filename_out);
                
                String data=null;
                String line = reader.readLine();
                while(line != null) {
                	if(line.isEmpty() || !line.startsWith("{")){
                		count++;
                		line = reader.readLine();
                		continue;
                	}
                	data=line.replace("{","");
                	data=data.replace("},","");
                    String[] datainfo=data.split(",");
                    if(datainfo==null || datainfo.length!=6){
                        System.out.println("data:"+data);
                		count++;
                		line = reader.readLine();
                		continue;
                    }
                	writer.write(data);
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
                System.out.println("filename_out:"+filename_out);
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
//		System.out.println("------------getLocationcode1------------");
//		getLocationcode1();
		System.out.println("------------getLocationcode2------------");
		getLocationcode2();
    }
}
