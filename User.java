public abstract class User {

	/**
	 * 
	 * @param name
	 */
	public Movie searchMovie(String name) {
		return MovieManager.getInstance().searchMovie(name);
	}

	//Removed viewMovie method as will be implemented by GUI
	//from search method above
}