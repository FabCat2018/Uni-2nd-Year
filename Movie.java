public class Movie {

	private String name;
	private String genre;
	private int actingRating;
	private int cinematographyRating;
	private int conceptRating;
	private int soundtrackRating;
	private int plotRating;
	private double totalRating;				//Changed to double to show correct average
	private ArrayList<Review> reviewsList;

	//Moved Review methods to be dealth with here, but
	//called from RegisteredUser

	/**
	 * 
	 * @param name
	 * @param genre
	 * @param actingRating
	 * @param cinematographyRating
	 * @param conceptRating
	 * @param soundtrackRating
	 * @param plotRating
	 */
	public Movie(String name, String genre, int actingRating, int cinematographyRating, int conceptRating, int soundtrackRating, int plotRating) {
		this.name = name;
		this.genre = genre;
		this.actingRating = actingRating;
		this.cinematographyRating = cinematographyRating;
		this.conceptRating = conceptRating;
		this.soundtrackRating = soundtrackRating;
		this.plotRating = plotRating;
	}

	public void editName (String newName) {
		this.name = newName;
	}

	public String getName () {
		return this.name;
	}

	public void editGenre (String newGenre) {
		this.genre = newGenre;
	}

	public String getGenre () {
		return this.genre;
	}

	public void editActingRating (int newRating) {
		this.actingRating = newRating;
	}

	public int getActingRating () {
		return this.actingRating;
	}

	public void editCinematographyRating (int newRating) {
		this.cinematographyRating = newRating;
	}

	public int getCinematographyRating () {
		return this.cinematographyRating;
	}

	public void editConceptRating (int newRating) {
		this.conceptRating = newRating;
	}

	public int getConceptRating () {
		return this.conceptRating;
	}

	public void editSoundtrackRating (int newRating) {
		this.soundtrackRating = newRating;
	}

	public int getSoundtrackRating () {
		return this.soundtrackRating;
	}

	public void editPlotRating (int newRating) {
		this.plotRating = newRating;
	}

	public int getPlotRating () {
		return this.plotRating;
	}

	public void calculateTotalRating () {
		this.totalRating = (this.actingRating + this.conceptRating + this.cinematographyRating + this.soundtrackRating + this.plotRating) / 5;
	}

	public double getTotalRating () {
		return this.totalRating;
	}

	public boolean addReview (Review review) {
		return this.reviewsList.add(review);
	}

	public boolean editReview (Review review, String newBody) {
		review.editBody(newBody);
	}

	public boolean removeReview (Review review) {
		return this.reviewsList.remove(review);
	}

	public ArrayList<Review> getReviewsList () {
		return this.reviewsList;
	}

}