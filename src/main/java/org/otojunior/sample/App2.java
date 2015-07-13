/**
 * 
 */
package org.otojunior.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author 01456231650
 *
 */
public class App2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String url = "http://10.32.49.186:8080/jenkins/api/json?tree=jobs[name]&pretty=true";
		InputStream in = new URL(url).openStream();
		try {
			BufferedReader buf = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
			}
		} finally {
			in.close();
		}

	}

}
