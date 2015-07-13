/**
 * 
 */
package org.otojunior.sample;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.gson.Gson;

/**
 * @author 01456231650
 *
 */
public class App4 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws Exception {
		String url = "http://10.32.49.186:8080/jenkins/api/json?tree=jobs[name,color]";
		Gson gson = new Gson();

		InputStream in = new URL(url).openStream();
		try {
			InputStreamReader reader = new InputStreamReader(in);
			Dados dados = gson.fromJson(reader, Dados.class);
			System.out.println(dados);
		} finally {
			IOUtils.closeQuietly(in);
		}

	}
	
	@SuppressWarnings("unused")
	private static class Dados {
		private static class Job {
			public String name;
			public String color;
			
			@Override
			public String toString() {
				return ToStringBuilder.reflectionToString(
					this, ToStringStyle.SHORT_PREFIX_STYLE);
			}
		}
		
		public List<Job> jobs;
		
		@Override
		public String toString() {
			StringBuilder b = new StringBuilder();
			for (Job job : jobs) {
				String jobstr = ToStringBuilder.reflectionToString(
					job, 
					ToStringStyle.SHORT_PREFIX_STYLE);
				b.append(jobstr).append("\n");
			}
			return b.toString();
		}
	}
}
