package vehicle;

import interfaces.Flyable;
import tower.*;
import vehicle.Coordinates;;

public class JetPlane extends Aircraft implements Flyable{

    public JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        
    }

    public void registerTower(final WeatherTower WeatherTower){

    }
      
}