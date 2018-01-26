package virtual.pet;

public class VirtualPet {

	private String name;
	private int hungerLevel;
	private int thirstLevel;
	private int boredomLevel;
	private int tirednessLevel;
	private int wasteLevel;

	private int foodBowlLevel;
	private int waterBowlLevel;
	private int litterBoxLevel;

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

		foodBowlLevel = 0;
		waterBowlLevel = 0;
		litterBoxLevel = 0;
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

	public int getFoodBowlLevel() {
		return foodBowlLevel;
	}

	public int getWaterBowlLevel() {
		return waterBowlLevel;
	}

	public int getLitterBoxLevel() {
		return litterBoxLevel;
	}

	public void eat() {
		hungerLevel -= 40;

		thirstLevel += 10;
		if (thirstLevel > 100)
			thirstLevel = 100;

		boredomLevel -= 5;

		tirednessLevel += 10;
		if (tirednessLevel > 100)
			tirednessLevel = 100;

		wasteLevel += 20;
		if (wasteLevel > 100)
			wasteLevel = 100;

		foodBowlLevel--;
	}

	public void drink() {
		thirstLevel -= 40;

		wasteLevel += 20;
		if (wasteLevel > 100)
			wasteLevel = 100;
	}

	public void play() {
		hungerLevel += 10;
		if (hungerLevel > 100)
			hungerLevel = 100;

		thirstLevel += 10;
		if (thirstLevel > 100)
			thirstLevel = 100;

		boredomLevel -= 40;

		tirednessLevel += 30;
		if (tirednessLevel > 100)
			tirednessLevel = 100;
	}

	public void sleep() {
		hungerLevel += 20;
		if (hungerLevel > 100)
			hungerLevel = 100;

		thirstLevel += 20;
		if (thirstLevel > 100)
			thirstLevel = 100;

		tirednessLevel -= tirednessLevel;
	}

	public void useBathroom() {
		wasteLevel -= wasteLevel;
	}

	public void putOutFood() {
		foodBowlLevel = 2;
	}

	public void putOutWater() {
		waterBowlLevel = 2;
	}

	public void scoopLitterBox() {
		litterBoxLevel = 0;
	}

	public void tick() {
		hungerLevel += 10;
		if (hungerLevel > 100)
			hungerLevel = 100;

		thirstLevel += 10;
		if (thirstLevel > 100)
			thirstLevel = 100;

		boredomLevel += 10;
		if (boredomLevel > 100)
			boredomLevel = 100;

		tirednessLevel += 10;
		if (tirednessLevel > 100)
			tirednessLevel = 100;

		wasteLevel += 10;
		if (wasteLevel > 100)
			wasteLevel = 100;
	}

}
