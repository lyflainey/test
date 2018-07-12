package com.news.rec.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

/**
 * Hello world!
 *
 */
public class TestHttps 
{
    public static void testhttps()
    {
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("uuids", "hd4582951821A1F11A"));
			params.add(new BasicNameValuePair("uuids", "hdFFEA9F23FB5CC344"));
			params.add(new BasicNameValuePair("uuids", "hd4F96F04A412B6C8A"));
			params.add(new BasicNameValuePair("uuids", "hd767B4512407A8777"));
			params.add(new BasicNameValuePair("uuids", "hd99064FDEEF64AA6F"));
			params.add(new BasicNameValuePair("uuids", "hd9A0913F8C1E9C119"));
			params.add(new BasicNameValuePair("uuids", "hdE6566861ABAC6861"));
			HttpPost httpPost = new HttpPost("https://testwenda.netease.com/wenda/admin/recommend/answerDynamics.do");
			httpPost.setEntity(new UrlEncodedFormEntity(params));
			ThreadSafeClientConnManager connectionManager = new ThreadSafeClientConnManager();
			connectionManager.setDefaultMaxPerRoute(5); // 每个host最多5个连接
			connectionManager.setMaxTotal(50); // 一共50个连接
//			DefaultHttpClient defaultHttpClient = new DefaultHttpClient(connectionManager);
//			HttpConnectionParams.setConnectionTimeout(defaultHttpClient.getParams(), 1000); // 1秒超时
//			HttpClient httpClient = defaultHttpClient;
			try {
				HttpClient httpClient = new SSLClient(connectionManager);
				HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), 1000); // 1秒超时
				HttpResponse response = httpClient.execute(httpPost);
				HttpEntity entity = response.getEntity();
				System.out.println(EntityUtils.toString(entity, "UTF-8"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void main( String[] args )
    {
		System.out.println("------------testhttps------------");
		testhttps();
    }
}
class SSLClient extends DefaultHttpClient{
    public SSLClient(ThreadSafeClientConnManager connectionManager) throws Exception{  
        super(connectionManager);
        SSLContext ctx = SSLContext.getInstance("TLS");  
        X509TrustManager tm = new X509TrustManager() {  
                public void checkClientTrusted(X509Certificate[] chain,  
                        String authType) throws CertificateException {  
                }
                public void checkServerTrusted(X509Certificate[] chain,  
                        String authType) throws CertificateException {  
                }
                public X509Certificate[] getAcceptedIssuers() {  
                    return null;  
                }  
        };  
        ctx.init(null, new TrustManager[]{tm}, null);  
        SSLSocketFactory ssf = new SSLSocketFactory(ctx,SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);  
        ClientConnectionManager ccm = this.getConnectionManager();
        SchemeRegistry sr = ccm.getSchemeRegistry();  
        sr.register(new Scheme("https", 443, ssf));  
    }
}
