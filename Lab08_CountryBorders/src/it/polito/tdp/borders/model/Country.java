package it.polito.tdp.borders.model;

public class Country {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country =" + ccode + ", " + stateAbb + ", " + stateName + "\n";
	}
	private int ccode;
	private String stateAbb;
	private String stateName;
	
	
	public Country(int ccode, String stateAbb, String stateName) {
		super();
		this.ccode = ccode;
		this.stateAbb = stateAbb;
		this.stateName = stateName;
	}
	
	public Country (int code){
		this.ccode=code;
	}
	
	/**
	 * @return the ccode
	 */
	public int getCcode() {
		return ccode;
	}
	/**
	 * @param ccode the ccode to set
	 */
	public void setCcode(int ccode) {
		this.ccode = ccode;
	}
	/**
	 * @return the stateAbb
	 */
	public String getStateAbb() {
		return stateAbb;
	}
	/**
	 * @param stateAbb the stateAbb to set
	 */
	public void setStateAbb(String stateAbb) {
		this.stateAbb = stateAbb;
	}
	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}
	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ccode;
		result = prime * result + ((stateAbb == null) ? 0 : stateAbb.hashCode());
		result = prime * result + ((stateName == null) ? 0 : stateName.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (ccode != other.ccode)
			return false;
		if (stateAbb == null) {
			if (other.stateAbb != null)
				return false;
		} else if (!stateAbb.equals(other.stateAbb))
			return false;
		if (stateName == null) {
			if (other.stateName != null)
				return false;
		} else if (!stateName.equals(other.stateName))
			return false;
		return true;
	}

	

}
