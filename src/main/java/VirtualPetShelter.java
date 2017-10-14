import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VirtualPetShelter {

	private Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>(0);

	// This method returns a Collection of Virtual Pet objects
	// It mimics the Pet Shelter's bank's database of Virtual Pets
	// A collection is easier to iterate through than a Map
	public Collection<VirtualPet> getPets() {
		return pets.values();
	}

	public VirtualPet getPet(String name) {
		return pets.get(name);
	}

	public void addPet(VirtualPet newPet) {
		pets.put(newPet.getName(), newPet);
	}

	public VirtualPet releasePet(String name) {
		return pets.remove(name);
	}

	public void feedPets() {

		for (Entry<String, VirtualPet> eachPet : pets.entrySet()) {
			eachPet.getValue().eat();
		}
	}

	public void waterPets() {

		for (Entry<String, VirtualPet> eachPet : pets.entrySet()) {
			eachPet.getValue().drink();
		}
	}

	public void tick() {

		for (Entry<String, VirtualPet> eachPet : pets.entrySet()) {
			eachPet.getValue().tick();
		}
	}

	//If the user supplies a pet name that does not exist, the Virtual Pet object returned
	//by the get method will be null.  Since we are not doing front end editing, check it here
	//to make sure it is not null before calling goForWalk() so that we don't crash with a 
	//null pointer exception.
	public void walkAPet(String name) {
		
		VirtualPet aPet = pets.get(name);
		if (aPet != null) {
			aPet.goForWalk();
		}

	}

	//If the user supplies a pet name that does not exist, the Virtual Pet object returned
	//by the get method will be null.  Since we are not doing front end editing, check it here
	//to make sure it is not null before calling play() so that we don't crash with a 
	//null pointer exception.
	public void playWithAPet(String name) {
		
		VirtualPet aPet = pets.get(name);
		if (aPet != null) {
			aPet.play();
		}

	}

	//If the user supplies a pet name that does not exist, the Virtual Pet object returned
	//by the get method will be null.  Since we are not doing front end editing, check it here
	//to make sure it is not null before calling play() so that we don't crash with a 
	//null pointer exception.
	public void takeAPetOutside(String name) {
		
		VirtualPet aPet = pets.get(name);
		if (aPet != null) {
			aPet.goOut();
		}

	}

	public int getNumberOfPets() {
		return pets.size();
	}

}
