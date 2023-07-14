package it.polito.tdp.exam.model;

public class Adiacenze {
	
	
	Team t1;
	Team t2;
	
	public Adiacenze(Team t1, Team t2) {
		super();
		this.t1 = t1;
		this.t2 = t2;
	}
	
	
	
	

	public Team getT1() {
		return t1;
	}

	public void setT1(Team t1) {
		this.t1 = t1;
	}

	public Team getT2() {
		return t2;
	}

	public void setT2(Team t2) {
		this.t2 = t2;
	}
	
	
	

}
