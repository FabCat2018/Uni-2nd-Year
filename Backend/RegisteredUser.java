public class RegisteredUser extends User {

	private String userName;
	private String password;
	protected boolean isAdmin;

	//Any methods involving add or remove no longer return boolean, now void

	/**
	 * 
	 * @param userName
	 * @param password
	 * @param isAdmin
	 */
	public RegisteredUser(String userName, String password, boolean getIsAdmin) {
		this.userName = userName;
		this.password = password;
		this.isAdmin = false;
	}

	/**
	 * 
	 * @param name
	 * @param password
	 */
	public boolean login(String name, String password) {
		if ((name.equals(this.userName)) && (password.equals(this.password))) {
			System.out.println("You are now logged in");
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param review
	 * @param body
	 */
	public boolean writeComment(Review review, String body) {
		Comment newComment = new Comment(body, this);
		return review.getCommentsList().add(newComment);
	}

	/**
	 * 
	 * @param movie
	 * @param body
	 */
	public Review writeReview(Movie movie, String body) {
		Review newReview = new Review(body, this);
		movie.addReview(newReview);
		return newReview;
	}

	/**
	 * 
	 * @param movie
	 * @param review
	 * @param newBody
	 */
	public void editReview(Movie movie, Review review, String newBody) {
		movie.editReview(review, newBody);
	}

	/**
	 * 
	 * @param movie
	 * @param review
	 */
	public void deleteReview(Movie movie, Review review) {
		movie.removeReview(review);
	}

	public String getUserName () {
		return this.userName;
	}

	public boolean getIsAdmin () {
		return this.isAdmin;
	}
}