
public class Attack {

	public String name;
	public Integer countAct;
	public Integer countAccomplishedAct;

	
	public Attack(String name, Integer countAct) {
		super();
		this.name = name;
		this.countAct = countAct;
	}


	public Integer getCountAct() {
		return countAct;
	}


	public void setCountAct(Integer countAct) {
		this.countAct = countAct;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countAccomplishedAct == null) ? 0 : countAccomplishedAct.hashCode());
		result = prime * result + ((countAct == null) ? 0 : countAct.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attack other = (Attack) obj;
		if (countAccomplishedAct == null) {
			if (other.countAccomplishedAct != null)
				return false;
		} else if (!countAccomplishedAct.equals(other.countAccomplishedAct))
			return false;
		if (countAct == null) {
			if (other.countAct != null)
				return false;
		} else if (!countAct.equals(other.countAct))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Attack [name=" + name + ", countAct=" + countAct + ", countAccomplishedAct=" + countAccomplishedAct
				+ "]";
	}
	
	
	
	
	
}
