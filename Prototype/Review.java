import java.util.ArrayList;

public class Review {

	private RegisteredUser owner;
	private String body;
	private ArrayList<Comment> commentsList;

	//Added getters and setters for variables
	//Implemented method to add/edit/remove comments

	/**
	 * 
	 * @param body
	 * @param owner
	 */
	public Review(String body, RegisteredUser owner) {
		this.body = body;
		this.owner = owner;
	}

	public void editBody (String newBody) {
		this.body = newBody;
	}

	public void addComment (String body) {
		Comment newComment = new Comment(body, this.owner);
		this.commentsList.add(newComment);
		return;
	}

	public ArrayList<Comment> getCommentsList () {
		return this.commentsList;
	}

	public String toString () {
		return "Review body: " + this.body + "\tOwner: " + this.owner.getUserName();
	}

}