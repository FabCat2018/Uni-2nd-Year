public class Comment {

	private String body;
	private RegisteredUser owner;

	/**
	 * 
	 * @param body
	 */
	public Comment(String body, RegisteredUser owner) {
		this.body = body;
		this.owner = owner;
	}

	public void editBody(String newBody) {
		this.body = newBody;
	}

	public String getBody () {
		return this.body;
	}

	public RegisteredUser getOwner () {
		return this.owner;
	}
}