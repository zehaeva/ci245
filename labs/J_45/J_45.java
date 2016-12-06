/**
 * Created by hcanaway on 12/6/2016.
 */
public class J_45 {
    public static void main(String[] args) {
        UserFactory.setUserDB("C:\\Users\\hcanaway.CFS\\IdeaProjects\\ci245\\labs\\J_45\\users.db");
        UserFactory.registerUser("hcanaway", "qwerty");
        User user = UserFactory.logIn("hcanaway", "qwerty");
        System.out.println(user.getUserName());
    }
}
