public class Administrator extends RegisteredUser {

	private static Administrator instance = null;

	/**
	 * 
	 * @param userName
	 * @param password
	 * @param isAdmin
	 */
	private Administrator(String userName, String password, boolean isAdmin) {
		super(userName, password, isAdmin);
		this.isAdmin = true;
	}

	public static Administrator getInstance(String userName, String password, boolean isAdmin) {
		if (instance == null) {
			instance = new Administrator(userName, password, isAdmin);
		}
		return instance;
	}
}