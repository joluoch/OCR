package ke.jakinda.APR.PLATEREC.activities.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import ke.jakinda.APR.PLATEREC.activities.models.Parking_Number;

/**
 * Created by jakin on 07/03/2018.
 */
@Table(name="Parking_Time")
public class Parking_Time extends Model {
    @Column(name="Parking_Number")
    public int Parking_Number;
    @Column(name="Date")
    public int Date;
    @Column(name="Time")
    public String Time;

    public int getParking_Number() {
        return Parking_Number;
    }

   

    public void setParking_Number(int parking_Number) {
        Parking_Number = parking_Number;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
