
public enum LengthUnit {
	MM(1.f), CM(10.f), IN(25.4f), FT(304.8f), M(1000.f);

	private float value;

	private LengthUnit(float value) {                  
		this.value = value;
	}

	public float getValue() {            
		return value;
	}

	public float between(Length l1, Length l2) {
		float distanceMM = getLengthInMillimeters(l2) - getLengthInMillimeters(l1);
		return distanceMM / value;
	}

	private float getLengthInMillimeters(Length l2) {
		return l2.getNumber() * l2.getUnit().getValue();
	}

}
