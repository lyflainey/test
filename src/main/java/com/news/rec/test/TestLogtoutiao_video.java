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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestLogtoutiao_video{
	private static final class username_value{
		private static final String kurashiru="kurashiru";
		private static final String youtube="youtube";
	}
	
	private static String curpath="/";
	private static String logspath_video="logs/video/";
	
	static{
		try{
			curpath=TestLogtoutiao_video.class.getResource("/").getPath();
			logspath_video=curpath+"logs/video/";
		}catch(Exception e){
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
    public static final class PARAM_FIELD_VIDEO{
    	public final static String requestId = "requestId";
    	public final static String curtime = "curtime";
    	public final static String article = "article";
    	public final static String operator = "operator";
        public static final class sub_article{
        	public final static String topicid = "topicid";
        	public final static String weight = "weight";
        	public final static String interests = "interests";
        	public final static String mapping = "mapping";
        	public final static String username = "username";
        	public final static String title = "title";
        	public final static String isshow = "isshow";
        	public final static String rvideoid = "rvideoid";
        	public final static String description = "description";
        	public final static String sectionsid = "sectionsid";
        	public final static String ltime = "ltime";
        	public final static String mp4SdUrl = "mp4SdUrl";
        	public final static String vid = "vid";
        	public final static String tags = "tags";
        	public final static String commentid = "commentid";
        	public final static String sid = "sid";
        	public final static String sdUrl = "sdUrl";
        	public final static String vrvideo = "vrvideo";
        	public final static String pgcvideo = "pgcvideo";
        	public final static String bigimgpath = "bigimgpath";
        	public final static String hdUrl = "hdUrl";
        	public final static String commentboard = "commentboard";
        	public final static String copyrighted = "copyrighted";
        	public final static String continousplay = "continousplay";
        	public final static String hits = "hits";
        	public final static String category = "category";
        	public final static String transcodeStatus = "transcodeStatus";
        	public final static String imgpath = "imgpath";
        	public final static String playlength = "playlength";
        	public final static String sectiontitle = "sectiontitle";
        	public final static String irlocation = "irlocation";
        	public final static String source = "source";
        	public final static String subtitle = "subtitle";
        	public final static String stree = "stree";
        	public final static String playersize = "playersize";
        	public final static String sizeSD = "sizeSD";
        	public final static String sizeHD = "sizeHD";
        	public final static String m3u8SdUrl = "m3u8SdUrl";
        	public final static String sectiondescription = "sectiondescription";
        	public final static String ptime = "ptime";
        	public final static String sectionimg = "sectionimg";
        }
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
			String spitstr=",operator:cms-video";
			int ind=data.indexOf(spitstr);
			if(ind<0){
				System.out.println(data);
				return result;
			}
			result.put(PARAM_FIELD_VIDEO.operator,"cms-video");
			String tmp=data.substring(0, ind);
			
			spitstr=",article:";
			ind=tmp.indexOf(spitstr);
			if(ind<0){
				System.out.println(data);
				return result;
			}
			result.put(PARAM_FIELD_VIDEO.article,tmp.substring(ind+spitstr.length()));
			
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
	
    private static int StatUsernameDatas(String infilename,List<String> vids){
        BufferedReader reader=null;
        int count=0;
        try {
            File file=new File(infilename);
            if(!file.exists()){
            	System.out.println("file exists false");
            }else{
                reader = new BufferedReader(
                		new InputStreamReader(new FileInputStream(infilename), "utf-8"));

                String data=null,article=null,username=null,mapping=null,vid=null;
                Map<String,String> obj=null;
                JSONObject articleobj=null;
                String line = reader.readLine();
                while(line != null) {
                	if(line.isEmpty() || !line.contains(PARAM_FIELD_VIDEO.article)){
                		count++;
                		line = reader.readLine();
                		continue;
                	}
                	data=removePackage(line);
                	obj=convertObject(data);
                	if(obj==null || !obj.containsKey(PARAM_FIELD_VIDEO.article)){
                		count++;
                		line = reader.readLine();
                		continue;
                	}
                	
                	article=obj.get(PARAM_FIELD_VIDEO.article);
                	try{
                    	articleobj=JSON.parseObject(article);
                	}catch(Exception e){
                		System.err.println(e.getMessage());
                		e.printStackTrace();
                	}
                	if(articleobj==null || !articleobj.containsKey(PARAM_FIELD_VIDEO.sub_article.username)){
                		count++;
                		line = reader.readLine();
                		continue;
                	}
                	
                	username=articleobj.getString(PARAM_FIELD_VIDEO.sub_article.username);
                	if(username==null || username.isEmpty() || !username.equalsIgnoreCase(username_value.youtube)){
                		count++;
                		line = reader.readLine();
                		continue;
                	}
                	
                	vid=articleobj.getString(PARAM_FIELD_VIDEO.sub_article.vid);
                	mapping=articleobj.getString(PARAM_FIELD_VIDEO.sub_article.mapping);
                    if(mapping!=null && !mapping.isEmpty() && !mapping.equals("0")){
                    	System.out.println("Is mapping article , replace docid  from ["+vid+"] to ["+mapping+"] !");
                    	vid=mapping;
                    }
                    if(vid!=null && !vid.isEmpty() && !vids.contains(vid)){
                    	vids.add(vid);
                    }
                	count++;
                	line = reader.readLine();
                	if(count%10000==0){
                		System.out.println(count);
                	}
                }
                reader.close();
                System.out.println("infilename:"+infilename);
                System.out.println("count:"+count);
                System.out.println("vids:"+vids.size());
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
        }
        return count;
    }
	
    private static int StatUsernameExposure(String infilename,String outfilename,List<String> vids){
        BufferedReader reader=null;
        FileWriter writer=null;
        int count=0,exposurenum=0;
        try {
            File file=new File(infilename);
            if(!file.exists()){
            	System.out.println("file exists false");
            }else{
                reader = new BufferedReader(
                		new InputStreamReader(new FileInputStream(infilename), "utf-8"));
                
                writer=new FileWriter(outfilename,true);

                String line = reader.readLine();
                while(line != null) {
                	if(line.isEmpty()){
                		count++;
                		line = reader.readLine();
                		continue;
                	}
                	
                	for(String vid:vids){
                		if(line.contains(vid)){
                        	writer.write(line);
                        	writer.write("\r\n");
                        	writer.write("\r\n");
                            writer.flush();
                            
                			exposurenum++;
                		}
                	}
                	count++;
                	line = reader.readLine();
                	if(count%10000==0){
                		System.out.println(count);
                	}
                }
                reader.close();
                writer.flush();
                writer.close();
                System.out.println("infilename:"+infilename);
                System.out.println("count:"+count);
                System.out.println("vids:"+vids.size());
                System.out.println("exposurenum:"+exposurenum);
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
	
    public static int StatUsernameExposures(){
        int count=0;
        try {
        	String outfilename=logspath_video+"exposure.youtube.2017-06-21.log";
            File file=new File(outfilename);
            if(file.exists()){
            	file.delete();
            }
        	file.createNewFile();
        	
        	List<String> vids=new ArrayList<String>();
        	count+=StatUsernameDatas(logspath_video+"29log20170621",vids);
        	count+=StatUsernameDatas(logspath_video+"30log20170621",vids);
            System.out.println("videocount:"+count);
        	
        	count=0;
        	count+=StatUsernameExposure(logspath_video+"27exposure.log.2017-06-21",outfilename,vids);
        	count+=StatUsernameExposure(logspath_video+"26exposure.log.2017-06-21",outfilename,vids);
        	count+=StatUsernameExposure(logspath_video+"25exposure.log.2017-06-21",outfilename,vids);
        	count+=StatUsernameExposure(logspath_video+"24exposure.log.2017-06-21",outfilename,vids);
        	count+=StatUsernameExposure(logspath_video+"23exposure.log.2017-06-21",outfilename,vids);
            System.out.println("exposurecount:"+count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("count:"+count);
        return count;
    }
    
    public static void main( String[] args ){
		System.out.println("------------StatUsernameExposures------------");
		StatUsernameExposures();
    }
}
