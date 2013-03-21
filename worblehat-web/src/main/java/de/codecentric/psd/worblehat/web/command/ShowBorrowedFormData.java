package de.codecentric.psd.worblehat.web.command;

public class ShowBorrowedFormData {

	private String emailAddress;

	public ShowBorrowedFormData() {
		super();
	}

	/**
	 * @param emailAddress
	 *            the user email address
	 */
	public ShowBorrowedFormData(String emailAddress) {
		if (emailAddress != null) {
			this.emailAddress = emailAddress.replaceAll(" ", "");
		} else {
			this.emailAddress = emailAddress;
		}
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {

		boolean exists = emailAddress != null;
		if (exists) {
			this.emailAddress = emailAddress.replaceAll(" ", "");
		} else {
			this.emailAddress = emailAddress;
		}
	}

}
