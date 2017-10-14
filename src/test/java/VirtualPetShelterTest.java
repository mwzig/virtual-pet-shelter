
import static org.junit.Assert.*;
import org.junit.Test;

public class VirtualPetShelterTest {

	@Test
	public void shouldBeAbleToCreateVirtualPetWithNameAndDescOnly() {
		VirtualPet underTest = new VirtualPet("Fido", "the great");
		String check = underTest.getFullName();
		assertEquals("Fido the great", check);
		int check2 = underTest.getActivityLevel();
		assertEquals(10, check2);
		check2 = underTest.getHungerLevel();
		assertEquals(10, check2);
		check2 = underTest.getThirstLevel();
		assertEquals(10, check2);
		
	}
	
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
	// Verify that after constructing, the pet does not need
	// to poop.  After feeding, the pet should need to poop.
	@Test
	public void testThatFeedPetsCausesNeedToPoop() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.addPet(new VirtualPet("feefee", "the furious", 10, 5, 5));
		VirtualPet pet1 = underTest.getPet("fido");
		boolean check = pet1.getNeedsToPoop();
		assertFalse(check);
		VirtualPet pet2 = underTest.getPet("feefee");
		check = pet2.getNeedsToPoop();
		assertFalse(check);
		underTest.feedPets();
		pet1 = underTest.getPet("fido");
		check = pet1.getNeedsToPoop();
		assertTrue(check);
		pet2 = underTest.getPet("feefee");
		check = pet2.getNeedsToPoop();
		assertTrue(check);

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
	public void testThatWaterPetsCausesNeedToPee() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.addPet(new VirtualPet("feefee", "the furious", 10, 5, 5));
		VirtualPet pet1 = underTest.getPet("fido");
		boolean check = pet1.getNeedsToPee();
		assertFalse(check);
		VirtualPet pet2 = underTest.getPet("feefee");
		check = pet2.getNeedsToPee();
		assertFalse(check);
		underTest.waterPets();
		pet1 = underTest.getPet("fido");
		check = pet1.getNeedsToPee();
		assertTrue(check);
		pet2 = underTest.getPet("feefee");
		check = pet2.getNeedsToPee();
		assertTrue(check);

	}


	@Test
	public void testThatPlayingWIthChangesActivityLevel() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.PlayWithAPet("fido");
		int check = underTest.getPet("fido").getActivityLevel();
		assertEquals(75, check);

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

	@Test
	public void testThatTickMethodChangesAttributeLevels() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 50));
		underTest.addPet(new VirtualPet("feefee", "the furious", 10, 10, 60));
		underTest.addPet(new VirtualPet("spot", "the spotty", 15, 15, 70));
		underTest.tick();
		underTest.tick();
		int check1 = underTest.getPet("fido").getHungerLevel();
		int check2 = underTest.getPet("fido").getThirstLevel();
		int check3 = underTest.getPet("fido").getActivityLevel();
		assertEquals(15, check1);
		assertEquals(15, check2);
		assertEquals(40, check3);

		int check11 = underTest.getPet("feefee").getHungerLevel();
		int check12 = underTest.getPet("feefee").getThirstLevel();
		int check13 = underTest.getPet("feefee").getActivityLevel();
		assertEquals(20, check11);
		assertEquals(20, check12);
		assertEquals(50, check13);

		int check21 = underTest.getPet("spot").getHungerLevel();
		int check22 = underTest.getPet("spot").getThirstLevel();
		int check23 = underTest.getPet("spot").getActivityLevel();
		assertEquals(25, check21);
		assertEquals(25, check22);
		assertEquals(60, check23);

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
