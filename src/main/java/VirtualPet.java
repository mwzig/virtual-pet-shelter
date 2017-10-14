
public class VirtualPet {

	// attributes
	private String name;
	private String description;
	private int hungerLevel;
	private int thirstLevel;
	private int activityLevel;
	private boolean needsToPee;
	private boolean needsToPoop;
	private String cageStatus = "Clean";

	// constructor - takes all attributes as parameters except for cageStatus
	public VirtualPet(String name, String description, int hungerLevel, int thirstLevel, int activityLevel, boolean bNeedsToPee, boolean bNeedsToPoop) {
		this.name = name;
		this.description = description;
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
		this.activityLevel = activityLevel;
		this.needsToPee = bNeedsToPee;
		this.needsToPoop = bNeedsToPoop;
	}

	// constructor - takes just name and description as parameters
	// other values set to default
	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		this.hungerLevel = 10;
		this.thirstLevel = 10;
		this.activityLevel = 10;
		this.needsToPee = false;
		this.needsToPoop = false;
	}

	// constructor - takes all attributes as parameters
	// except the need to pee or poop and cageStatus
		public VirtualPet(String name, String description, int hungerLevel, int thirstLevel, int activityLevel) {
			this.name = name;
			this.description = description;
			this.hungerLevel = hungerLevel;
			this.thirstLevel = thirstLevel;
			this.activityLevel = activityLevel;
			this.needsToPee = false;
			this.needsToPoop = false;
		}


	// getters
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	/*
	public String getFullName() {
		String fullName = name + " " + Description;
		return fullName;
	}*/

	public int getHungerLevel() {
		return hungerLevel;
	}

	public int getThirstLevel() {
		return thirstLevel;
	}

	public int getActivityLevel() {
		return activityLevel;
	}

	public boolean getNeedsToPoop() {
		return needsToPoop;
	}

	public boolean getNeedsToPee() {
		return needsToPee;
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
		// it will take care of its own needs by peeing and pooping on the floor
		if (hungerLevel >= 50 && thirstLevel >= 50 && activityLevel < 33 && needsToPee && needsToPoop) {
			status += "\nUh-Oh!!!  You have not been taking good care of " + this.name;
			status += this.name = " peed and pooped on the floor!";
		} else {
			if (!needsSomething) {
				status += "Great Job! You are taking wonderful care of " + this.name;
			}
		}
		return status;
	}

	void tick() {
		hungerLevel += 5;
		thirstLevel += 5;
		activityLevel -= 5;
		if (hungerLevel >= 50 && thirstLevel >= 50 && activityLevel < 33 && needsToPee && needsToPoop) {
			cageStatus = "Dirty";
		}
		
	}

	void cleanCage() {
		cageStatus = "Clean";
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

	void goOut() {
		needsToPee = false;
		needsToPoop = false;
	}


}
