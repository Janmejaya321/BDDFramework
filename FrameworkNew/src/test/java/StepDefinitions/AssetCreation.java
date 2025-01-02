package StepDefinitions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import DriverFactory.Driverfactory;
import Pages.AssetAllocationPage;
import Pages.LoginPage;
import Utils.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssetCreation {
	LoginPage loginpage = new LoginPage(Driverfactory.getDriver());
	AssetAllocationPage assetallocation = new AssetAllocationPage(Driverfactory.getDriver());

/*	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		List<Map<String, String>> credList = dataTable.asMaps();
		String uName = credList.get(0).get("username");
		String pass = credList.get(0).get("password");

		Driverfactory.getDriver().get("https://zephyr-pp.fi.informais.com/");
		loginpage.DoLogin(uName, pass);
		// Selenide.WaitForSpinnerComplete(100000);

	}*/
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application() throws InterruptedException
	{
		loginpage.NavigateTo();
		loginpage.DoLogin();
	}

	@Given("User is on dashboard page")
	public void user_is_on_dashboard_page() {
		loginpage.VerifyLogin();
		assetallocation.ClickLeftMenu("Asset Allocation");
	}

	@When("Click on asset allocation top menu")
	public void click_on_asset_allocation_top_menu() throws InterruptedException {
		assetallocation.ClickTopMenuLinks("Allocation Cases");
	}

	@Then("Verify allocation table header")
	public void verify_allocation_table_header() throws Exception {
		List<String> labels = Arrays.asList("Name", "Assumption Set", "Created", "Modified");
		for (String label : labels)
			assetallocation.VerifyColumnHeaderLabels(label);

	}

	@And("Verify No allocation Available message")
	public void Verify_No_allocation_Available_message() throws Exception {
		assetallocation.VerifyNoAllocationCasesMessage();
	}

	@Given("User is on Asset Allocation page")
	public void user_is_on_asset_allocation_page() throws InterruptedException {
		assetallocation.ClickLeftMenu("Asset Allocation");
		assetallocation.ClickTopMenuLinks("Allocation Cases");
		Selenide.Wait(10);

	}

	@When("Click on Add-Allocation Case Icon In Allocation-Cases Page")
	public void click_on_add_allocation_case_icon_in_allocation_cases_page() throws InterruptedException {
		assetallocation.ClickAddAllocationCase();
		assetallocation.ClickAddAllocationButton();

	}

	@And("Click on All Allocation-Cases burger menu icon to navigate to View all AllocationCaes")
	public void click_on_all_allocation_cases_burger_menu_icon_to_navigate_to_view_all_allocation_caes()
			throws InterruptedException {
		assetallocation.ClickViewAllAllocationCases();
	}

	@Then("Click on down-arrow icon beside too title to Assumption cases")
	public void click_on_down_arrow_icon_beside_too_title_to_assumption_cases() throws Exception {
		
		assetallocation.OpenTitleList();
	}
	
	
	@And("Verify Allocation Case Visible in the list")
	public void verify_allocation_case_visible_in_the_list() throws Exception {
		assetallocation.VerifyAllocationCaseVisible("New Case");
	}

	@And("Logout User from the Application")
	public void logout_user_from_the_application() throws InterruptedException {
		loginpage.Logout();

	}

}
