package de.codecentric.psd.atdd.step.page;

import java.sql.ResultSet;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.inject.Inject;

import de.codecentric.psd.atdd.library.Config;
import de.codecentric.psd.atdd.library.DatabaseAdapter;
import de.codecentric.psd.atdd.library.SeleniumAdapter;

/**
 * Needed for ATDD.
 * 
 * @author asf17
 * 
 */
public class BorrowedSortedBooks {
	private final WebDriver driver;
	private final SeleniumAdapter selenium;
	public DatabaseAdapter database;

	@Inject
	public BorrowedSortedBooks(SeleniumAdapter selenium,
			DatabaseAdapter database) {
		this.selenium = selenium;
		driver = selenium.getDriver();
		this.database = database;
	}

	// *******************
	// *** G I V E N *****
	// *******************

	// *****************
	// *** W H E N *****
	// *****************

	@When("a user <user> wants to see his borrowed books <isbns>")
	public void whenUseruserReturnsAllHisBooks(@Named("user") String user)
			throws InterruptedException {
		openShowBorrowedBooksPage();
		typeIntoField("emailAddress", user);
		submitForm();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		// vorher
		// openReturnAllBooksPage();
		// typeIntoField("emailAddress", user);
		// submitForm();
		// selenium.waitUntilPageContainsId("welcome_heading");
	}

	// *****************
	// *** T H E N *****
	// *****************
	@Then("the books <isbns> are sorted by return date")
	// TODO check whether books are sorted by return date
	public void shouldShowSortedBorrowedBooks(@Named("isbns") String isbns,
			@Named("user") String user, @Named("borrowDate") String borrowDate)
			throws Exception {

		// hole Daten sortiert aus der DB
		ResultSet currentBorrower_ID = database
				.getResultSet("SELECT id FROM Borrowing WHERE borrowerEmailAddress='"
						+ user + "' ORDER BY borrowDate");

		StringBuilder gelieheneISBN = new StringBuilder();

		while (currentBorrower_ID.next()) {
			long aktuelleISBN = currentBorrower_ID.getLong("id");

			gelieheneISBN
					.append(database
							.getResult("SELECT isbn FROM book b WHERE currentBorrowing_id = '"
									+ aktuelleISBN + "' ")
							+ " ");
		}

		// hole Daten von der Website -> TODO: geht das so?
		WebElement element = driver.findElement(By.tagName("tbody"));
		String textAufWebsite = element.getText();

		// prüfe, ob gleiche Reihenfolge wie sortiert aus DB -> gucke ob titel
		// in richtiger reihenfolge

		String listen = gelieheneISBN.toString();

		String[] liste = listen.split(" ");

		// grobe planung:

		int index1 = textAufWebsite.indexOf(liste[0]);
		int index2 = textAufWebsite.indexOf(liste[1]);

		if (index1 > index2)
			throw new Exception("FEHLER");

	}

	// *****************
	// *** U T I L *****
	// *****************

	private void openShowBorrowedBooksPage() {
		driver.get(Config.getApplicationURL() + "/"
				+ Config.getApplicationContext() + "/showBorrowed");
	}

	private void submitForm() {
		driver.findElement(By.id("showBorrowed")).click();
	}

	private void typeIntoField(String id, String value) {
		WebElement element = driver.findElement(By.id(id));
		element.clear();
		element.sendKeys(value);
	}
}
