import java.util.ArrayList;

public class UserRegistry {
    private static UserRegistry instance = null;
    private ArrayList<RegisteredUser> usersList = new ArrayList<RegisteredUser>();

    /**
     * 
     * @param instance
     * @param usersList
    */
    private UserRegistry () {}

    public static UserRegistry getInstance () {
        if (instance == null)
            instance = new UserRegistry();
        return instance;
    }

    public boolean checkUserExists (String userName) {
        for (int i = 0; i < usersList.length(); i++) {
            if (userName.equals(usersList.get(i).getUserName()))
                return true;
        }
        return false;
    }

    public boolean addRegisteredUser (String userName, String password) {
        RegisteredUser newUser = new RegisteredUser(userName, password);
        return this.usersList.add(newUser);
    }
}