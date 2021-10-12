import java.io.*;

public class StationsAndDepature {

    BufferedReader stations;
    BufferedReader departure;

    {
        try {
            stations = new BufferedReader(new FileReader("Stations.txt"));
            stations.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    {
        try {
            departure = new BufferedReader(new FileReader("Departure.txt"));
            departure.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

