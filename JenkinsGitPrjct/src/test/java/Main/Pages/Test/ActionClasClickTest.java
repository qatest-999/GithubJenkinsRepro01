package Main.Pages.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Main.Pages.ActionClassClick;

public class ActionClasClickTest {
	
	ActionClassClick actionclpg;
	SoftAssert sa = new SoftAssert();
	
	@BeforeMethod
	public void SetUp() {
		actionclpg= new ActionClassClick();
		actionclpg.BrowserSetUp();
	}
	@Test (priority = 1)
	public void doubleClickTest() {
		boolean result= actionclpg.doubleClick();
		sa.assertEquals(result, true);
		sa.assertAll();
	}
	@Test (priority = 2)
	public void rightClickTest() {
		boolean result= actionclpg.rightClick();
		sa.assertEquals(result, true);
		sa.assertAll();
	}

	@AfterMethod
	public void teardown() {
		actionclpg.teardown();
	}

}
