package Main.Pages.Test;

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
	
	@Test
	public void getPageTitleTest() {
		System.out.println(brknlinkpg.getPageTitle());
	}
}
