package org.otojunior.sample;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.io.StringReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class App {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void main(String[] args) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String url = "http://10.32.49.186:8080/jenkins/api/json?tree=jobs[name]&pretty=true";
		HttpGet request = new HttpGet(url);
				
		CloseableHttpResponse response = httpclient.execute(request);
		//System.out.println(response.getStatusLine());
		
		HttpEntity entity = response.getEntity();
		
		System.out.println(entity.getContentLength());
		System.out.println(entity.getContentEncoding());
		System.out.println(entity.getContentType());
		System.out.println();
		
		InputStream content = entity.getContent();
		BufferedReader bin = new BufferedReader(new InputStreamReader(content));
		
		String line = bin.readLine();
		while (line != null) {
			System.out.println(line);
			line = bin.readLine();
		}
		
		bin.close();
	}
}
