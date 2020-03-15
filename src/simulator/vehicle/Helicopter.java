package vehicle;

import interfaces.Flyable;
import tower.*;
import vehicle.Coordinates;

public class Helicopter extends Aircraft implements Flyable {

    public Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);

    }
    public void updateConditions(){

    }
    public void registerTower(WeatherTower WeatherTower){

    }
    
}