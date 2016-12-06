/**
 * Created by hcanaway on 12/6/2016.
 */
public class J_35 {
    public static void main(String[] args) {
        Deadlock ichi = new Deadlock("Ichi");
        Deadlock ni = new Deadlock("Ni");

        ichi.setDeadlock(ni);
        ni.setDeadlock(ichi);

        ichi.start();
        ni.start();
    }
}
