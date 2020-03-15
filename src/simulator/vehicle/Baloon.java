package vehicle;

import interfaces.Flyable;
import tower.*;
import vehicle.Coordinates;

public class Baloon extends Aircraft implements Flyable {


    public Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        
    }
    public void registerTower(WeatherTower WeatherTower){

    }
    
}