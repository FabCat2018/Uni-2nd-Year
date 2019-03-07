import java.util.ArrayList;

public class UserRegistry {
    private static UserRegistry instance = null;
    private ArrayList<RegisteredUser> usersList = new ArrayList<RegisteredUser>();

    /**
     * 
     * @param instance
     * @param usersList
    */
    private UserRegistry () {
        Administrator admin = Administrator.getInstance("admin", "admin", true);
    }

    public static UserRegistry getInstance () {
        if (instance == null)
            instance = new UserRegistry();
        return instance;
    }

    public boolean checkUserExists (String userName) {
        for (int i = 0; i < usersList.size(); i++) {
            if (userName.equals(usersList.get(i).getUserName()))
                return true;
        }
        return false;
    }

    public RegisteredUser addRegisteredUser (String userName, String password, boolean isAdmin) {
        RegisteredUser newUser = new RegisteredUser(userName, password, isAdmin);
        this.usersList.add(newUser);
        return newUser;
    }
}