package telran.compasssss;

public enum Compass {
	NORTH("Brrrr"), SOUTH("Yuuuhuu"), WEST("Dollars"), EAST("Vodka");
	
	private String associations;
	
	private Compass(String associations)
	{
		this.associations=associations;
	}
	
	public String getAssociations() {
		return associations;
	}
	
	
}
