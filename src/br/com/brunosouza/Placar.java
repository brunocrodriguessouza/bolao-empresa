package br.com.brunosouza;

public class Placar {
	
	private int time1;
	private int time2;
	
	public Placar(int time1, int time2) {
		this.time1 = time1;
		this.time2 = time2;
	}
	
	public int getTime1() {
		return time1;
	}
	
	public int getTime2() {
		return time2;
	}
	
	public int obterVencedor() {
		return Integer.valueOf(getTime1()).compareTo(Integer.valueOf(getTime2())); 
	}
	
	@Override
	public String toString() {
		return "Placar Time 1: " + time1 + ", Placar Time 2: " + time2;
	}
	
	@Override
	public boolean equals(Object obj) {
		Placar outro  = (Placar) obj;
		return this.time1 == outro.time1 && this.time2 == outro.time2;
	}
}
