package it.polito.tdp.borders.model;

public class Border {

	private int cod1;
	private int cod2;
	
	public Border(int cod1, int cod2) {
		super();
		this.cod1 = cod1;
		this.cod2 = cod2;
	}

	/**
	 * @return the cod1
	 */
	public int getCod1() {
		return cod1;
	}

	/**
	 * @param cod1 the cod1 to set
	 */
	public void setCod1(int cod1) {
		this.cod1 = cod1;
	}

	/**
	 * @return the cod2
	 */
	public int getCod2() {
		return cod2;
	}

	/**
	 * @param cod2 the cod2 to set
	 */
	public void setCod2(int cod2) {
		this.cod2 = cod2;
	}

	
}