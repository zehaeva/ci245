import java.util.ArrayList;

/**
 * Created by zehaeva on 9/29/16.
 */
public class L10_17 {
    public static void main(String[] args) {
        Car bug = new Car(2, "Blue", true);
        Bicycle schwin = new Bicycle(10, "rroad racing", "straight");
        Building empire = new Building(102, "350 5th ave", "New York");

        ArrayList<CarbonFootprint> polluters = new ArrayList<>();

        polluters.add(bug);
        polluters.add(schwin);
        polluters.add(empire);

        for (CarbonFootprint polluter :
                polluters) {
            System.out.println(polluter.getCarbonFootprint());
        }
    }
}
