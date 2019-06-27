package ke.jakinda.APR.PLATEREC.activities.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by jakin on 07/03/2018.
 */
@Table(name="Parking_Number")
public class Parking_Number extends Model {
    @Column(name="parking_Numberr")
    public int Parking_Numberr;
    @Column(name="Parking_Id")
    public int Parking_id;


    public int getParking_Numberr() {
        return Parking_Numberr;
    }

    public void setParking_Numberr(int parking_Numberr) {
        Parking_Numberr = parking_Numberr;
    }

    public int getParking_id() {
        return Parking_id;
    }

    public void setParking_id(int parking_id) {
        Parking_id = parking_id;
    }


}
