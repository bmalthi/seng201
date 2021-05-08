/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Item;
import main.ItemType;
import main.StorageList;

/**
 * @author bmalthi
 *
 */
class StorageListTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void addRemoveItemTest() {
		StorageList test1 = new StorageList("Test1", 10, ItemType.CARGO);
		
		// New StorageList should have capacity of 10
		assertTrue(test1.remainingSpace() == 10);
		
		Item testCargo = new Item("Test1", "", 5, ItemType.CARGO);
		Item testWeapon = new Item("Test1", "", 5, ItemType.WEAPON);
		
		// We should be able to add a Cargo Item of size 5
		assertTrue(test1.addItem(testCargo));
		
		// Remaining space should be 5
		assertTrue(test1.remainingSpace() == 5);		
		
		// The list should have the item we added
		assertTrue(test1.hasItem(testCargo));
		
		// We shouldn't be able to add a WEAPON Item of size 5 since its a CARGO STorageList
		assertFalse(test1.addItem(testWeapon));
		
		// Remaining space should still be 5
		assertTrue(test1.remainingSpace() == 5);
		
		//We shouldn't be able to remove testWeapon from the list since it was never added
		assertFalse(test1.removeItem(testWeapon));
		
		//We should be able to remove the testCargo from the list since it was added
		assertTrue(test1.removeItem(testCargo));
		
		//The storage list should have original space of 10 left
		assertTrue(test1.remainingSpace() == 10);		
				
		

	}

}
