import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VirtualPetShelter {

	private Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>(0);

	// This method returns a Collection of Virtual Pet objects
	// It mimics the Pet Shelter's database of Virtual Pets.
	// A collection is necessary to be able to iterate through each entry.
	public Collection<VirtualPet> getAllPets() {
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

	// If a name is supplied that does not exist, the Virtual Pet object "returned"
	// will be null. Just to be safe, check it for not null before using it,
	// otherwise we could potentially crash with a null pointer exception.
	public void walkAPet(String name) {

		VirtualPet aPet = pets.get(name);
		if (aPet != null) {
			aPet.goForWalk();
		}

	}

	// If a name is supplied that does not exist, the Virtual Pet object "returned"
	// will be null. Just to be safe, check it for not null before using it,
	// otherwise we could potentially crash with a null pointer exception.
	public void playWithAPet(String name) {

		VirtualPet aPet = pets.get(name);
		if (aPet != null) {
			aPet.play();
		}

	}

	// If a name is supplied that does not exist, the Virtual Pet object "returned"
	// will be null. Just to be safe, check it for not null before using it,
	// otherwise we could potentially crash with a null pointer exception.
	public void takeAPetOutside(String name) {

		VirtualPet aPet = pets.get(name);
		if (aPet != null) {
			aPet.goOut();
		}

	}

	// If a name is supplied that does not exist, the Virtual Pet object "returned"
	// will be null. Just to be safe, check it for not null before using it,
	// otherwise we could potentially crash with a null pointer exception.
	public void cleanCage(String name) {

		VirtualPet aPet = pets.get(name);
		if (aPet != null) {
			aPet.haveMessCleanedUp();
		}

	}

	public int getNumberOfPets() {
		return pets.size();
	}

}
