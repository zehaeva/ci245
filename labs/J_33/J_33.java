/**
 * Created by zehaeva on 11/3/16.
 */
public class J_33 {
    public static void main(String[] args) {
        Bridge londonBridge = new Bridge(3);
        Troll troll = new Troll(londonBridge);
        londonBridge.setTroll(troll);

        Woolie ichi = new Woolie("Kenichi", 3, "Tokyo", londonBridge);
        Woolie ni = new Woolie("Nisan", 5, "Tokyo", londonBridge);
        Woolie san = new Woolie("San-chan", 8, "Tokyo", londonBridge);
        Woolie yon = new Woolie("Momo", 6, "Tokyo", londonBridge);
        Woolie go = new Woolie("Junko-san", 7, "Tokyo", londonBridge);
        Woolie roku = new Woolie("John", 4, "Tokyo", londonBridge);


        ichi.start();
        ni.start();
        san.start();
        yon.start();
        go.start();
        roku.start();

    }
}
