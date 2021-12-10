package DBAccess;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Countries;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCountries {

    public static ObservableList<String> getAllCountries(){

        ObservableList<String> countryList = FXCollections.observableArrayList();

        try {

            String sqlC = "SELECT Country\n" +
                            "FROM countries\n" +
                                "WHERE Country_ID < 4;";

            PreparedStatement psC = JDBC.getConnection().prepareStatement(sqlC);

            ResultSet rsC = psC.executeQuery();

            while(rsC.next()){

                String countryName = rsC.getString("Country");


                countryList.add(countryName);
            }
        }

        catch(SQLException e){
            e.printStackTrace();
        }

        return countryList;
    }

}
