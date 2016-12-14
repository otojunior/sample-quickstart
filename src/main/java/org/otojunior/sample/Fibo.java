package org.otojunior.sample;

public class Fibo {
	public byte[] fibon() {
		final int[] p = {8, 101, 1, 1, 2, 0}; // varie p[1] para variar a senha
		final byte[] b = new byte[7];
		for (; p[4] < p[0]; ++p[4]) {
			b[p[4]-2] = (byte)(p[2] + p[1]);
			int temp = p[2];
			p[2] += p[3];
			p[3] = temp;
		}
		b[p[4]-2] = (byte)(p[2] + p[1]);
		p[5] = b[0];
		b[0] = b[2];
		b[2] = (byte)p[5];
		p[5] = b[1];
		b[1] = b[6];
		b[6] = (byte)p[5];
		return b;
	}
	
	public static void main(String[] args) {
		Fibo f = new Fibo();
		System.out.println(new String(f.fibon())); // cuaehmb
	}
}
