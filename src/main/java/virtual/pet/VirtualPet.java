package virtual.pet;

public class VirtualPet {

	private int hungerLevel;
	private int thirstLevel;
	private int boredomLevel;
	private int tirednessLevel;
	private int wasteLevel;

	public VirtualPet() {
		this(20, 20, 50, 10, 0);
	}

	public VirtualPet(int hunger, int thirst, int boredom, int tiredness, int waste) {
		hungerLevel = hunger;
		thirstLevel = thirst;
		boredomLevel = boredom;
		tirednessLevel = tiredness;
		wasteLevel = waste;
	}

	public int getHungerLevel() {
		return hungerLevel;
	}

	public int getThirstLevel() {
		return thirstLevel;
	}

	public int getBoredomLevel() {
		return boredomLevel;
	}

	public int getTirednessLevel() {
		return tirednessLevel;
	}

	public int getWasteLevel() {
		return wasteLevel;
	}

}
