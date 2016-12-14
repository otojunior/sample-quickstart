/**
 * 
 */
package org.otojunior.sample;

import java.util.StringTokenizer;

/**
 * @author 01456231650
 *
 */
public class CalculadoraGraus {
	/**
	 * Converte decimal em graus.
	 * [0]: latitute
	 * [1]: longitude.
	 * Algoritmo:
	 * A parte inteira da coordenada (graus) permanecerá a mesma. 
	 * Multiplique a parte decimal restante por 60: os minutos.
	 * Multiplique a parte decimal que sobrou por 60: os segundos.
	 * @param decimal
	 * @return
	 */
	public String[] toGraus(String decimal) {
		final String[] r = new String[2];
		StringTokenizer tk = new StringTokenizer(decimal, ",");
		
		// latitude
		if (tk.hasMoreTokens()) {
			String token = tk.nextToken();
			double latitude = Double.parseDouble(token);
			double latitudeAbs = Math.abs(latitude);
			
			String hemisferio = Math.signum(latitude) > 1 ? "N" : "S";
			double graus = Math.floor(latitudeAbs);			
			double minutos = Math.floor((latitudeAbs - graus) * 60);
			double segundos = Math.floor((((latitudeAbs - graus) * 60) - minutos) * 60);
			
			String strlat = (int)graus + "° " + (int)minutos + "\' " +  (int)segundos + "\" " + hemisferio;
			System.out.println(strlat);
			
			
		}
		
		// longitude
		if (tk.hasMoreTokens()) {
			String token = tk.nextToken();
			double longitude = Double.parseDouble(token);
			double longitudeAbs = Math.abs(longitude);
			
			String hemisferio = Math.signum(longitude) > 1 ? "E" : "W";
			double graus = Math.floor(longitudeAbs);			
			double minutos = Math.floor((longitudeAbs - graus) * 60);
			double segundos = Math.floor((((longitudeAbs - graus) * 60) - minutos) * 60);
			
			String strlong = (int)graus + "° " + (int)minutos + "\' " +  (int)segundos + "\" " + hemisferio;
			System.out.println(strlong);
		}
		
		return r;
	}

}
