/**
 * 
 */
package org.otojunior.sample.processor;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import org.apache.commons.io.IOUtils;
import org.otojunior.sample.datastructure.Address;
import org.otojunior.sample.datastructure.Customer;
import org.otojunior.sample.datastructure.PhoneNumber;

/**
 * @author 01456231650
 *
 */
public class JsonRiProcessor {
	private static final String URL = "https://raw.githubusercontent.com/otojunior/sample-quickstart/json/src/main/resources/customer.json";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		InputStream in = new URL(URL).openStream();
		try {
			JsonReader reader = Json.createReader(in);
			JsonObject jsonObj = reader.readObject();
			Customer customer = toCustomer(jsonObj);
			System.out.println(customer);
		} finally {
			IOUtils.closeQuietly(in);
		}
	}
	
	/**
	 * 
	 * @param jsonObject
	 * @return
	 */
	public static Customer toCustomer(JsonObject jsonObject) {
		JsonObject jsonObjectAddr = jsonObject.getJsonObject("address");
		Address address = new Address();
		address.setCity(jsonObjectAddr.getString("city"));
		address.setPostalCode(Integer.valueOf(jsonObjectAddr.getString("postalCode")));
		address.setState(jsonObjectAddr.getString("state"));
		address.setStreetAddress(jsonObjectAddr.getString("streetAddress"));
		
		List<PhoneNumber> phoneNumberList = new ArrayList<PhoneNumber>();
		JsonArray array = jsonObject.getJsonArray("phoneNumber");
		for (JsonValue jsonValue : array) {
			JsonObject obj = (JsonObject) jsonValue;
			PhoneNumber phoneNumber = new PhoneNumber();
			phoneNumber.setType(obj.getString("type"));
			phoneNumber.setNumber(obj.getString("number"));
			phoneNumberList.add(phoneNumber);
		}
						
		Customer customer = new Customer();
		customer.setFirstName(jsonObject.getString("firstName"));
		customer.setLastName(jsonObject.getString("lastName"));
		customer.setAge(Integer.valueOf(jsonObject.getInt("age")));
		customer.setAddress(address);
		customer.setPhoneNumber(phoneNumberList);
		
		return customer;
	}
}
