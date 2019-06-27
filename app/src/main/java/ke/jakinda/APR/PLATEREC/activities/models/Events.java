package ke.jakinda.APR.PLATEREC.activities.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by jakin on 08/03/2018.
 */
@Table(name="Events")
public class Events extends Model {


        @Column(name="Number_Plate")
        public String Number_Plate;
        @Column(name="Date")
        public int Date;
        @Column(name="Arrival_Time")
        public String Arrival_Time;
        @Column(name="Departure_Time")
        public String Departure_Time;
        @Column(name="Parking_Number")
        public int Parking_Number;
        @Column(name="RegistrationDetails")
        RegistrationDetails eventsRegistrationDetails;
        @Column(name="Parking_Time")
        Parking_Time EventsParking_Time;


        public int getParking_Number() {
            return Parking_Number;
        }

        public void setParking_Number(int parking_Number) {
            Parking_Number = parking_Number;
        }




        public String getNumber_Plate() {
            return Number_Plate;
        }

        public void setNumber_Plate(String number_Plate) {
            Number_Plate = number_Plate;
        }

        public int getDate() {
            return Date;
        }

        public void setDate(int date) {
            Date = date;
        }

        public String getArrival_Time() {
            return Arrival_Time;
        }

        public void setArrival_Time(String arrival_Time) {
            Arrival_Time = arrival_Time;
        }

        public String getDeparture_Timw() {
            return Departure_Time;
        }

        public void setDeparture_Timw(String departure_Time) {
            Departure_Time = departure_Time;
        }


        public RegistrationDetails getEventsRegistrationDetails() {
            return eventsRegistrationDetails;
        }

        public void setEventsRegistrationDetails(RegistrationDetails eventsRegistrationDetails) {
            this.eventsRegistrationDetails = eventsRegistrationDetails;
        }

        public Parking_Time getEventsParking_Time() {
            return EventsParking_Time;
        }

        public void setEventsParking_Time(Parking_Time eventsParking_Time) {
            EventsParking_Time = eventsParking_Time;
        }
    }

