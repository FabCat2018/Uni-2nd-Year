public class UnregisteredUser extends User {

	public UnregisteredUser() {}

	/**
	 * 
	 * @param userName
	 * @param password
	 */

	public RegisteredUser register(String userName, String password) {
		return UserRegistry.getInstance().addRegisteredUser(userName, password, false);
	}

}