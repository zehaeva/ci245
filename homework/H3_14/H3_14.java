public class H3_14 {

    public static void main(String[] args) {
	// write your code here
        DateClass mydate = new DateClass(1, 1, 2016);

        System.out.println(mydate.displayDate());
        
        mydate.setDay(5);
        System.out.println(mydate.displayDate());
        
        mydate.setMonth(5);
        System.out.println(mydate.displayDate());
        
        mydate.setYear(5);
        System.out.println(mydate.displayDate());
    }
}
