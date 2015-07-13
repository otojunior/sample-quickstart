/**
 * 
 */
package org.otojunior.sample.processor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.otojunior.sample.datastructure.Customer;

import com.google.gson.Gson;

/**
 * @author 01456231650
 *
 */
public class GsonProcessor {
	private static final String URL = "https://raw.githubusercontent.com/otojunior/sample-quickstart/json/src/main/resources/customer.json";

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();

		InputStream in = new URL(URL).openStream();
		try {
			InputStreamReader reader = new InputStreamReader(in);
			Customer customer = gson.fromJson(reader, Customer.class);
			System.out.println(customer);
		} finally {
			IOUtils.closeQuietly(in);
		}

	}
}
