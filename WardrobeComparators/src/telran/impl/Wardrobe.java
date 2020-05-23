package telran.impl;

public class Wardrobe implements Comparable<Wardrobe> {
	private double width;
	private double length;
	private double heigth;
	
	public Wardrobe(double width, double length, double heigth) {
		super();
		this.width = width;
		this.length = length;
		this.heigth = heigth;
	}

	public double getWidth() {
		return width;
	}

	public void setWidht(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeigth() {
		return heigth;
	}

	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(heigth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Wardrobe other = (Wardrobe) obj;
		if (Double.doubleToLongBits(heigth) != Double.doubleToLongBits(other.heigth))
			return false;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	

	@Override
	public int compareTo(Wardrobe arg0) {
		
		return Double.compare(area(), arg0.area());
	}

	//++++++++++++++++++++++++++++++++++
	
	public double area() {
		return width*length;
	}
	
	public double volume() {
		return area()*heigth;
	}

	@Override
	public String toString() {
		return "Wardrobe [width=" + width + ", length=" + length + ", heigth=" + heigth + ", area()=" + area()
				+ ", volume()=" + volume() + "]";
	}
	
	

}
