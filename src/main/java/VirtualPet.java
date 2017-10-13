
public class VirtualPet {

	// attributes
	private String name;
	private String nameDescriptor;
	private int hungerLevel;
	private int thirstLevel;
	private int activityLevel;
	private boolean needsToPee = false;
	private boolean needsToPoop = false;

	// constructor
	public VirtualPet(String name, String nameDescriptor, int hungerLevel, int thirstLevel, int activityLevel) {
		this.name = name;
		this.nameDescriptor = nameDescriptor;
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
		this.activityLevel = activityLevel;
	}

	// getters
	public String getName() {
		return name;
	}

	public String getFullName() {
		String fullName = name + " " + nameDescriptor;
		return fullName;
	}

	public int getHungerLevel() {
		return hungerLevel;
	}

	public int getThirstLevel() {
		return thirstLevel;
	}

	public int getActivityLevel() {
		return activityLevel;
	}

	String getStatus() {
		String status = "";
		boolean needsSomething = false;
		if (hungerLevel >= 50) {
			needsSomething = true;
			status += name + " is hungry! ";
		}
		if (thirstLevel >= 50) {
			needsSomething = true;
			status += name + " is thirsty! ";
		}
		if ((activityLevel < 33) || needsToPee || needsToPoop) {
			needsSomething = true;
			status += name + " needs a walk, please. ";
			status += "\n(";
			if (activityLevel < 33) {
				status += "Needs exercise! ";
			}
			if (needsToPee) {
				status += "Needs to pee! ";
			}
			if (needsToPoop) {
				status += "Needs to poop!";
			}
			status += ")";
		}
		// If the pet gets hungry, thirsty, needs exercise, and needs to pee and poop,
		// it will take care of its own needs by peeing and pooping on the floor, eating
		// your shoe, and then throwing up on your bed.
		//
		if (hungerLevel >= 50 && thirstLevel >= 50 && activityLevel < 33 && needsToPee && needsToPoop) {
			status += "\nUh-Oh!!!  You have not been taking good care of your pet! ";
			status += "\nShe ate your shoe, peed and pooped on the floor, and threw up on your bed!";
		} else {
			if (!needsSomething) {
				status += "Great Job! You are taking wonderful care of your pet!";
			}
		}
		return status;
	}

	void tick() {
		hungerLevel += 5;
		thirstLevel += 5;
		activityLevel -= 5;
	}

	void eat() {
		hungerLevel = 0;
		needsToPoop = true;
	}

	void drink() {
		thirstLevel = 0;
		needsToPee = true;
	}

	void goForWalk() {
		if (activityLevel < 75) {
			activityLevel = 75;
		} else {
			activityLevel += 5;
		}
		needsToPee = false;
		needsToPoop = false;
	}

	void play() {
		if (activityLevel < 75) {
			activityLevel = 75;
		} else {
			activityLevel += 5;
		}
	}

}
