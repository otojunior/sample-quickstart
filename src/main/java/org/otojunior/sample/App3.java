/**
 * 
 */
package org.otojunior.sample;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

/**
 * @author 01456231650
 *
 */
public class App3 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws Exception {
		String url = "http://10.32.49.186:8080/jenkins/api/json?tree=jobs[name]&pretty=true";
		InputStream in = new URL(url).openStream();
		try {
			System.out.println(IOUtils.toString(in));
		} finally {
			IOUtils.closeQuietly(in);
		}

	}

}
