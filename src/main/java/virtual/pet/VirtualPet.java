package virtual.pet;

public class VirtualPet {

	private String name;
	private int hungerLevel;
	private int thirstLevel;
	private int boredomLevel;
	private int tirednessLevel;
	private int wasteLevel;

	public VirtualPet() {
		this("Widget", 20, 20, 50, 10, 0);
	}

	public VirtualPet(String name, int hunger, int thirst, int boredom, int tiredness, int waste) {
		this.name = name;
		hungerLevel = hunger;
		thirstLevel = thirst;
		boredomLevel = boredom;
		tirednessLevel = tiredness;
		wasteLevel = waste;
	}

	public String getName() {
		return name;
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

	public void eat() {
		hungerLevel -= 20;
		thirstLevel += 10;
		boredomLevel -= 5;
		tirednessLevel += 10;
		wasteLevel += 20;
	}

	public void drink() {
		thirstLevel -= 40;

	}

	public void play() {
		hungerLevel += 10;
		thirstLevel += 10;
		boredomLevel -= 40;
		tirednessLevel += 30;
	}

	public void sleep() {
		hungerLevel += 20;
		thirstLevel += 20;
		tirednessLevel -= 50;
	}

	public void useBathroom() {
		wasteLevel -= 40;
	}

}
