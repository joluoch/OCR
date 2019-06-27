package ke.jakinda.APR.PLATEREC.activities.models;



import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by jakin on 07/03/2018.
 */
@Table(name="RegistrationDetails")
public class RegistrationDetails extends Model{
    @Column(name = "Name")
    public String Name;
    @Column(name = "National_Id")
    public String National_Id;
    @Column(name = "Telephone_No")
    public String Telephone_No;
    @Column(name = "Number_Plate")
    public String Number_Plate;
    @Column(name="Model")
    public String Model;
    @Column(name = "Parking_Type")
    public String Parking_Type;
    @Column(name = "date")
    public String date;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNational_Id() {
        return National_Id;
    }

    public void setNational_Id(String national_Id) {
        National_Id = national_Id;
    }

    public String getTelephone_No() {
        return Telephone_No;
    }

    public void setTelephone_No(String telephone_No) {
        Telephone_No = telephone_No;
    }

    public String getNumber_Plate() {
        return Number_Plate;
    }

    public void setNumber_Plate(String number_Plate) {
        Number_Plate = number_Plate;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getParking_Type() {
        return Parking_Type;
    }

    public void setParking_Type(String parking_Type) {
        Parking_Type = parking_Type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}



