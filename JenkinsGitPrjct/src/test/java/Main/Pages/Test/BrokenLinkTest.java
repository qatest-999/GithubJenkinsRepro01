package Main.Pages.Test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Main.Pages.BrokenLink;

public class BrokenLinkTest {

	BrokenLink brknlinkpg;
	SoftAssert sa= new SoftAssert();
	
	@BeforeClass
	public void SetUp() {
		brknlinkpg= new BrokenLink();
		brknlinkpg.BrowserSetUp();
	}
	
	@Test (priority = 1)
	public void getPageTitleTest() {
		String title= brknlinkpg.getPageTitle();
		System.out.println(title);
		sa.assertEquals(title, "DEMOQA");
		sa.assertAll();
	}
	@Test (priority = 2)
	public void getNumberlinksTest() {
		System.out.println(brknlinkpg.getNumberlinks());
	}
	
	@AfterClass
	public void TearDown() {
		brknlinkpg.teardown();
	}
}
