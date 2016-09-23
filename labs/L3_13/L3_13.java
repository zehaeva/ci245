public class L3_13 {
    public static void main(String[] args) {
        Employee howard = new Employee("Howard", "Canaway", 100000);
        Employee john = new Employee("John", "Roberts", 90000);

        System.out.println(howard);
        System.out.println(john);

        System.out.printf("%s's Yearly Salaray is: %f\n", howard.getFirstName(), howard.getYearlySalary());
        System.out.printf("%s's Yearly Salaray is: %f\n", john.getFirstName(), john.getYearlySalary());

        howard.giveRaise(10);
        john.giveRaise(10);

        System.out.println(howard);
        System.out.println(john);
    }
}