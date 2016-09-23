public class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySalary = monthlySalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getYearlySalary() {
        return 12 * this.monthlySalary;
    }

    public void giveRaise(double percentageIncrease) {
        this.monthlySalary = this.monthlySalary * (percentageIncrease / 100 + 1);
    }

    public String toString() {
        return this.firstName + " " + this.lastName + " Monthly Salary: " + this.monthlySalary;
    }

}