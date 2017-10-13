
import static org.junit.Assert.*;
import org.junit.Test;

public class VirtualPetShelterTest {

	@Test
	public void shouldBeAbleToCreateAVirtualPetShelterMap() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.addPet(new VirtualPet("feefee", "the furious", 5, 5, 5));
		int check = underTest.getNumberOfPets();
		assertEquals(2, check);
	}

	// ask how to assertNull(check) on the test below
	@Test
	public void testReleaseNonExistingPetFails() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocius", 5, 5, 5));
		VirtualPet check = underTest.releasePet("feefee");
		// VirtualPet checkPet = new VirtualPet("spot", "the dog", 5,5,5);
		// assertEquals(null, check);
		assertNull(check);
		// assertEquals(checkPet, check);
	}

	// This is a little confusing, but we are removing
	// an existing pet, and comparing the object returned
	// from the function that removes an object from the map
	// (which is the object being removed) to a different object
	// This test actually should fail - hence the notequals
	@Test
	public void testReleaseExistingPetFails() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		VirtualPet testPet = new VirtualPet("fido", "the ferocius", 5, 5, 5);
		VirtualPet testPet2 = new VirtualPet("fidooop", "the ferocius", 5, 5, 5);
		underTest.addPet(testPet);
		VirtualPet check = underTest.releasePet("fido");
		assertNotEquals(testPet2, check);

	}

	@Test
	public void testReleaseExistingPetSucceeds() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		VirtualPet testPet = new VirtualPet("fido", "the ferocius", 5, 5, 5);
		underTest.addPet(testPet);
		VirtualPet check = underTest.releasePet("fido");
		assertEquals(testPet, check);

	}

	@Test
	public void testGetNumberPetsReturnsCorrectNbr() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.addPet(new VirtualPet("feefee", "the furious", 5, 5, 5));
		underTest.addPet(new VirtualPet("spot", "the spotty", 5, 5, 5));
		int check = underTest.getNumberOfPets();
		assertEquals(3, check);
		VirtualPet petToRemove = underTest.releasePet("fido");
		check = underTest.getNumberOfPets();
		assertEquals(2, check);

	}

	@Test
	public void testThatFeedPetsChangesHungerLevel() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.addPet(new VirtualPet("feefee", "the furious", 10, 5, 5));
		underTest.feedPets();
		VirtualPet pet1 = underTest.getPet("fido");
		int check = pet1.getHungerLevel();
		assertEquals(0, check);
		VirtualPet pet2 = underTest.getPet("feefee");
		check = pet2.getHungerLevel();
		assertEquals(0, check);

	}

	@Test
	public void testThatWaterPetsChangesThirstLevel() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.addPet(new VirtualPet("feefee", "the furious", 10, 10, 5));
		underTest.waterPets();
		VirtualPet pet1 = underTest.getPet("fido");
		int check = pet1.getThirstLevel();
		assertEquals(0, check);
		VirtualPet pet2 = underTest.getPet("feefee");
		check = pet2.getThirstLevel();
		assertEquals(0, check);

	}

	@Test
	public void testThatWalkingPetChangesActivityLevel() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.walkAPet("fido");
		int check = underTest.getPet("fido").getActivityLevel();
		assertEquals(75, check);

	}
	@Test
	public void testThatWalkingPetChangesNeedsToPoop() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		boolean check = underTest.getPet("fido").getNeedsToPoop();
		assertEquals(false, check);
		underTest.getPet("fido").eat();
		check = underTest.getPet("fido").getNeedsToPoop();
		assertEquals(true, check);
		underTest.walkAPet("fido");
		check = underTest.getPet("fido").getNeedsToPoop();
		assertEquals(false, check);

	}

	@Test
	public void testThatWalkingPetChangesNeedsToPee() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		boolean check = underTest.getPet("fido").getNeedsToPee();
		assertEquals(false, check);
		underTest.getPet("fido").drink();
		check = underTest.getPet("fido").getNeedsToPee();
		assertEquals(true, check);
		underTest.walkAPet("fido");
		check = underTest.getPet("fido").getNeedsToPee();
		assertEquals(false, check);

	}

}
/*
 * @Test public void shouldBeAbleToCreateABankAccountWithData() { // accountNum,
 * type, balance passed on constructor BankAccount underTest = new
 * BankAccount("1111", "Checking", 5000.05); double check =
 * underTest.getBalance(); assertEquals(5000.05, check, .01); }
 * 
 * @Test public void assertThatAccountIsFound() { // accountNum, type, balance
 * passed on constructor Bank underTest = new Bank();
 * underTest.addBankAccount(new BankAccount("1111", "Checking", 5000.05));
 * String check = underTest.getAccount("1111").getAccountNum(); assertEquals(3,
 * check); }
 * 
 * @Test public void shouldBeAbleToWithDrawFunds() { // accountNum, type,
 * balance passed on constructor BankAccount underTest = new BankAccount("1111",
 * "Checking", 5000.05); underTest.withDraw(500.05); double check =
 * underTest.getBalance(); assertEquals(4500.00, check, .01); }
 * 
 * @Test public void shouldBeAbleToDepositFunds() { // accountNum, type, balance
 * passed on constructor BankAccount underTest = new BankAccount("1111",
 * "Checking", 5000.05); underTest.deposit(500.05); double check =
 * underTest.getBalance(); assertEquals(5500.10, check, .01); }
 * 
 * @Test public void assertThatAddingAccountsChangesTotalNumAccounts() {
 * 
 * Bank underTest = new Bank(); underTest.addBankAccount(new BankAccount("1111",
 * "Checking", 500.00)); underTest.addBankAccount(new BankAccount("2222",
 * "Savings", 2500.00)); int check = underTest.getTotalNumOfAccounts();
 * assertEquals(2, check); }
 * 
 * @Test public void assertThatRemovingAccountChangesTotalNumAccounts() { Bank
 * underTest = new Bank(); underTest.addBankAccount(new BankAccount("1111",
 * "Checking", 500.00)); underTest.addBankAccount(new BankAccount("2222",
 * "Savings", 2500.00)); underTest.closeBankAccount("1111"); int check =
 * underTest.getTotalNumOfAccounts(); assertEquals(1, check); }
 * 
 * @Test public void assertThatGetTotalBankDollarsReturns3000() {
 * 
 * Bank underTest = new Bank(); underTest.addBankAccount(new BankAccount("1111",
 * "Checking", 500.00)); underTest.addBankAccount(new BankAccount("2222",
 * "Savings", 2500.00)); double check = underTest.getTotalBankDollars();
 * assertEquals(3000.00, check, .01); } /*
 * 
 * @Test public void assertThatGetTotalBoxesReturnsSeven() { Order underTest =
 * new Order(); underTest.addItem(new Item("shirt", 14.99, 3));
 * underTest.addItem(new Item("shirt", 14.99, 4)); int check =
 * underTest.getTotalItems(); assertEquals(7, check);
 * 
 * }
 * 
 * @Test public void assertThatRemoveItemRemovesItems() { Order underTest = new
 * Order(); underTest.addItem(new Item("shirt", 14.99, 3));
 * underTest.addItem(new Item("pants", 12.99, 4)); underTest.addItem(new
 * Item("shirt", 15.99, 3)); underTest.removeItem("shirt"); int check =
 * underTest.getTotalItems(); assertEquals(3, check);
 * 
 * }
 */
