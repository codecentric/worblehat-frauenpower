package de.codecentric.psd.worblehat.web.command;

/**
 * This class represent the form data of the return book form.
 * 
 * @author psd
 * 
 */
public class ReturnAllBooksFormData {

	/**
	 * Empty constructor, required by Spring Framework.
	 */
	public ReturnAllBooksFormData() {
		super();
	}

	/**
	 * @param emailAddress
	 *            the user email address
	 */
	public ReturnAllBooksFormData(String emailAddress) {
		if (emailAddress != null) {
			this.emailAddress = emailAddress.replaceAll(" ", "");
		} else {
			this.emailAddress = emailAddress;
		}
	}

	private String emailAddress;

	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * 
	 * @param emailAddress
	 *            email address from form
	 */
	public void setEmailAddress(String emailAddress) {

		boolean exists = emailAddress != null;
		if (exists) {
			this.emailAddress = emailAddress.replaceAll(" ", "");
		} else {
			this.emailAddress = emailAddress;
		}
	}

}
