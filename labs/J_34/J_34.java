/**
 * Created by zehaeva on 11/3/16.
 */
public class J_34 {
    public static void main(String[] args) {
        Bridge34 londonBridge34 = new Bridge34(3);

        Woolie34 ichi = new Woolie34("Kenichi", 3, "Tokyo", londonBridge34);
        Woolie34 ichigo = new Woolie34("Ichigo", 3, "Tokyo", londonBridge34);
        Woolie34 ni = new Woolie34("Nisan", 5, "Tokyo", londonBridge34);
        Woolie34 san = new Woolie34("San-chan", 8, "Tokyo", londonBridge34);
        Woolie34 yon = new Woolie34("Momo", 6, "Tokyo", londonBridge34);
        Woolie34 go = new Woolie34("Junko-san", 7, "Tokyo", londonBridge34);
        Woolie34 roku = new Woolie34("John", 4, "Tokyo", londonBridge34);


        ichi.start();
        ichigo.start();
        ni.start();
        san.start();
        yon.start();
        go.start();
        roku.start();

    }
}
