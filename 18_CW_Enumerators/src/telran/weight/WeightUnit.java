package telran.weight;

public enum WeightUnit {
	GR(1.0f), KG(1000.0f), TN(1000000.0f), LBS(453.592f);
	
	private float gramAmount;
	
	private WeightUnit(float gramAmount) {
		this.gramAmount=gramAmount;
	}

	public float getGramAmount() {
		return gramAmount;
	}
	
	public float convert(WeightUnit other)
	{
		return gramAmount/other.gramAmount;
	}
	
	
}
