package virtual.pet;

public class VirtualPet {

	private int hungerLevel;
	private int thirstLevel;
	private int boredomLevel;
	private int tirednessLevel;

	public VirtualPet() {
		this(20, 20, 50, 10);
	}

	public VirtualPet(int hunger, int thirst, int boredom, int tiredness) {
		hungerLevel = hunger;
		thirstLevel = thirst;
		boredomLevel = boredom;
		tirednessLevel = tiredness;
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

}
