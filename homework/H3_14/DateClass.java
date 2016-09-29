/**
 * Created by hcanaway on 9/29/2016.
 */
public class DateClass {
    private int _day;
    private int _month;
    private int _year;

    /**
     * Generates a new Date with the day, month and year set
     * @param day
     * @param month
     * @param year
     */
    public DateClass(int day, int month, int year) {
        this._day = day;
        this._month = month;
        this._year = year;
    }

    /**
     * Gets the Day
     * @return
     */
    public int getDay() {
        return _day;
    }

    /**
     * sets the day
     * @param day
     */
    public void setDay(int day) {
        this._day = day;
    }

    /**
     * gets the month
     * @return
     */
    public int getMonth() {
        return _month;
    }

    /**
     * sets the month
     * @param month
     */
    public void setMonth(int month) {
        this._month = month;
    }

    /**
     * gets the year
     * @return
     */
    public int getYear() {
        return _year;
    }

    /**
     * sets the year
     * @param year
     */
    public void setYear(int year) {
        this._year = year;
    }

    /**
     * returns a formatted date in the mm/dd/yyyy format
     * @return Date
     */
    public String displayDate() {
        return String.format("%d/%d/%d", this._month, this._day, this._year);
    }
}
