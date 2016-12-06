import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by hcanaway on 12/6/2016.
 */
public class UserFactory {
    private static Path _user_db;
    private static ArrayList<String[]> _users;

    public static void setUserDB(String userDB) {
        try {
            initializeUsers();

            // read in file
            ArrayList<String> data = ReadTextFile(userDB);

            for (String user_data :
                    data) {
                _users.add(user_data.split(":"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initializeUsers() {
        if (_users == null) {
            _users = new ArrayList<>();
        }
    }

    /**
     * Code stolen from the instructor Coveny J_11
     * @param fileName the name of the file to read
     * @return arraylist of the file
     */
    private static ArrayList<String> ReadTextFile(String fileName) throws IOException {
        // Now we will read all of the lines back that we just wrote
        _user_db = Paths.get(fileName);

        ArrayList<String> linesToRead = new ArrayList<String>();

        try {
            // Need to cast the return result to an ArrayList
            linesToRead = (ArrayList<String>) Files.readAllLines(_user_db);

        } catch (IOException e) {
            System.out.println(_user_db.toString());
            throw e;
        }

        return linesToRead;
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            return new String(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User logIn(String userName, String password) {
        initializeUsers();
        // find user name
        for (String[] user :
                _users) {
            if (userName.equals(user[0])) {
                // verify password
                String encryptedString = hashPassword(password);
                // return user if valid password
                if (encryptedString.equals(user[1])) {
                    return new User(userName);
                }
            }
        }
        // return null if not available
        return null;
    }

    public static void registerUser(String userName, String password) {
        initializeUsers();

        boolean duplicate = false;

        for (String[] user:
              _users) {
            if (userName.equals(user[0])) {
                duplicate = true;
                break;
            }
        }

        if (! duplicate) {
            String[] new_user = new String[2];
            // get hashed password
            new_user[1] = hashPassword(password);
            new_user[0] = userName;
            _users.add(new_user);
            writeDB();
        }
    }


    /**
     * Code stolen from the instructor Coveny
     */
    public static void writeDB() {
        initializeUsers();
        ArrayList<String> input = new ArrayList<>();
        for (String[] user_data :
                _users) {
            input.add(String.join(":", user_data));
        }
        // Try and catch prevents "typical" errors from breaking the program.
        // For some error types a try/catch block is REQUIRED to compile.  This
        // is one of those instances.
        try {
            Files.write(_user_db, input, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("There was a problem getting to the file!");
        }
    }
}
