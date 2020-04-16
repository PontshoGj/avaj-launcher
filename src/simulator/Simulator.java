// package simulator;

import exception.*;
import vehicle.*;
import tower.*;

public class Simulator{
    public static void main(String[] args){
        try{
            ExceptionHandling check = new ExceptionHandling();
            check.checkInput(args[0]);
            //check the file and returning the vehicles
            String[][] vehicles = check.checkFile(args[0]);
            //instanciating a new AircraftFactory class to register the vehicles to the tower
            AircraftFactory aircraft = new AircraftFactory();
            WeatherTower weatherTower = new WeatherTower();
            //creating new vehicle and registaring them to the tower
            // for (int i = 0; i < vehicles.length; i++){
            //     System.out.println(vehicles[i][0]);
            // }
            for (int i = 0; i < vehicles.length; i++){
                    aircraft.newAircraft(vehicles[i][0], vehicles[i][1], Integer.parseInt(vehicles[i][2]), Integer.parseInt(vehicles[i][3]), Integer.parseInt(vehicles[i][4])).registerTower(weatherTower);
                // System.out.println(WeatherTower);
            }
        }catch(Exception e){
            if (e.getMessage().equals("Index 0 out of bounds for length 0")){
                System.out.println("please provide simulation text file as args");
                System.exit(0);
            }else{
                System.out.println(e.getMessage());
                System.exit(0);
            }
        } 
    }
}