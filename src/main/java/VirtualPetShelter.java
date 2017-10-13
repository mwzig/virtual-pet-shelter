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
	
	public void walkAPet(String name) {
		VirtualPet aPet = pets.get(name);
		aPet.goForWalk();
		
	}

	public void PlayWithAPet(String name) {
		VirtualPet aPet = pets.get(name);
		aPet.play();
		
	}

	public int getNumberOfPets() {
		return pets.size();
	}

}
