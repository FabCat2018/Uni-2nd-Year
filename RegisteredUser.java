import com.sun.media.jfxmedia.events.NewFrameEvent;

public class RegisteredUser extends User {

	private String userName;
	private String password;

	/**
	 * 
	 * @param userName
	 * @param password
	 */
	public RegisteredUser(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	/**
	 * 
	 * @param name
	 * @param password
	 */
	public boolean login(String name, String password) {
		if ((name.equals(this.name)) && (password.equals(this.password)))
			return true;
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
	 * @param body
	 */
	public boolean writeReview(Movie movie, String body) {
		Review newReview = new Review(body, this);
		movie.addReview(review);
	}

	/**
	 * 
	 * @param review
	 */
	public boolean editReview(Movie movie, Review review, String newBody) {
		return movie.editReview(review, newBody);
	}

	/**
	 * 
	 * @param review
	 */
	public boolean deleteReview(Movie movie, Review review) {
		return movie.removeReview(review);
	}
}