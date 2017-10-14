
public class VirtualPet {

	// attributes
	private String name;
	private String description;
	private int hungerLevel;
	private int thirstLevel;
	private int activityLevel;
	private boolean needsToPee;
	private boolean needsToPoop;
	private boolean madeAMess;

	// constructor - takes all attributes as parameters except for madeAMess
	public VirtualPet(String name, String description, int hungerLevel, int thirstLevel, int activityLevel,
			boolean bNeedsToPee, boolean bNeedsToPoop) {
		this.name = name;
		this.description = description;
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
		this.activityLevel = activityLevel;
		this.needsToPee = bNeedsToPee;
		this.needsToPoop = bNeedsToPoop;
		this.madeAMess = false;
	}

	// constructor - takes only name and description as parameters
	// other values set to default
	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		this.hungerLevel = 10;
		this.thirstLevel = 10;
		this.activityLevel = 10;
		this.needsToPee = false;
		this.needsToPoop = false;
		this.madeAMess = false;
	}

	// constructor - takes all attributes as parameters
	// except the need to pee or poop and madeAMess
	public VirtualPet(String name, String description, int hungerLevel, int thirstLevel, int activityLevel) {
		this.name = name;
		this.description = description;
		this.hungerLevel = hungerLevel;
		this.thirstLevel = thirstLevel;
		this.activityLevel = activityLevel;
		this.needsToPee = false;
		this.needsToPoop = false;
		this.madeAMess = false;
	}

	// getters
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
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

	public boolean getNeedsToPee() {
		return needsToPee;
	}

	public boolean getNeedsToPoop() {
		return needsToPoop;
	}

	public boolean getMadeAMess() {
		return madeAMess;
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
				status += "Needs to poop! ";
			}
			if (madeAMess) {
				status += "Made a mess!";
			}

			status += ")";
		}

		if (hungerLevel >= 50 && thirstLevel >= 50 && activityLevel < 33 && needsToPee && needsToPoop) {
			status += "\nUh-Oh!!!  You have not been taking good care of " + this.name + ".";
		} else {
			if (!needsSomething) {
				status += "Great Job! ";
				status += this.name + "does not need anything right now! You are taking wonderful care of " + this.name
						+ "!";
			}
		}
		return status;
	}

	void tick() {
		hungerLevel += 5;
		thirstLevel += 5;
		activityLevel -= 5;
		if (activityLevel < 33 && needsToPee && needsToPoop) {
			madeAMess = true;
		}
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

	// We need to reset needsToPee and needsToPoop here to false because otherwise
	// the cage status will rarely be set to clean since the tick method determines
	// clean or dirty based on needsToPee and needsToPoop and activity level.
	// Assume the pet goes out (call goOut()) while the cage is being cleaned.
	void haveMessCleanedUp() {
		madeAMess = false;
		goOut();

	}

}
