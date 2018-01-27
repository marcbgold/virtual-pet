package virtual.pet;

public class VirtualPet {

	private String name;
	private int hungerLevel;
	private int thirstLevel;
	private int boredomLevel;
	private int tirednessLevel;
	private int wasteLevel;
	// private boolean isAsleep;

	private int foodBowlLevel;
	private int foodType;
	private int waterBowlLevel;
	private int litterBoxLevel;

	boolean hasUsedFloorBefore;

	public VirtualPet() {
		this("Widget", 20, 20, 50, 10, 0);
	}

	public VirtualPet(String name) {
		this(name, 20, 20, 50, 10, 0);
	}

	public VirtualPet(String name, int hunger, int thirst, int boredom, int tiredness, int waste) {
		this.name = name;
		hungerLevel = hunger;
		thirstLevel = thirst;
		boredomLevel = boredom;
		tirednessLevel = tiredness;
		wasteLevel = waste;
		// isAsleep = false;

		foodBowlLevel = 0;
		waterBowlLevel = 0;
		litterBoxLevel = 0;

		hasUsedFloorBefore = false;
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

	// public boolean getSleepStatus() {
	// return isAsleep;
	// }

	public int getFoodBowlLevel() {
		return foodBowlLevel;
	}

	public int getFoodType() {
		return foodType;
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
		boredomLevel -= 5;
		tirednessLevel += 10;
		wasteLevel += 20;
		foodBowlLevel--;

		checkForValuesOver100();
	}

	public void drink() {
		thirstLevel -= 40;
		wasteLevel += 20;
		waterBowlLevel--;

		checkForValuesOver100();
	}

	public void play() {
		hungerLevel += 10;
		thirstLevel += 10;
		boredomLevel -= 40;
		tirednessLevel += 30;

		checkForValuesOver100();
	}

	public void sleep() {
		hungerLevel += 20;
		thirstLevel += 20;
		tirednessLevel -= tirednessLevel;
		// isAsleep = true;

		checkForValuesOver100();
	}

	public void useLitterBox() {
		wasteLevel -= wasteLevel;
		litterBoxLevel++;
	}

	public void useFloor() {
		wasteLevel -= wasteLevel;
		hasUsedFloorBefore = true;
	}

	public void putOutFood(int foodType) {
		foodBowlLevel = 2;
		this.foodType = foodType;
	}

	public void putOutWater() {
		waterBowlLevel = 2;
	}

	public void scoopLitterBox() {
		litterBoxLevel = 0;
	}

	public void tick() {
		hungerLevel += 10;
		thirstLevel += 10;
		boredomLevel += 10;
		tirednessLevel += 10;
		wasteLevel += 10;

		checkForValuesOver100();
	}

	public void takeCareOfSelf() {
		if (hungerLevel >= 50 && foodBowlLevel > 0) {
			eat();
		}

		if (thirstLevel >= 50 && waterBowlLevel > 0) {
			drink();
		}

		if (wasteLevel >= 70 && litterBoxLevel < 3) {
			useLitterBox();
		}
	}

	public void checkForValuesOver100() {
		if (hungerLevel > 100)
			hungerLevel = 100;

		if (thirstLevel > 100)
			thirstLevel = 100;

		if (boredomLevel > 100)
			boredomLevel = 100;

		if (tirednessLevel > 100)
			tirednessLevel = 100;

		if (wasteLevel > 100)
			wasteLevel = 100;
	}

	public boolean getHasUsedFloorBefore() {
		return hasUsedFloorBefore;
	}

}
