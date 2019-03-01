public class Administrator extends RegisteredUser {

	private static Administrator instance = null;

	/**
	 * 
	 * @param userName
	 * @param password
	 */
	private Administrator(String userName, String password) {
		super(userName, password);
	}

	public static Administrator getInstance(String userName, String password) {
		if (instance == null) {
			instance = new Administator(userName, password);
		}
		return instance;
	}
}