package vehicle;

import vehicle.*;

public class AircraftFactory{
    public Flyable newAircraft(String type,String name, int longitude, int latitude, int height){
        Coordinates coordinates = new Coordinates(
            longitude,
            latitude,
            height
        );
        type = type.toLowerCase();
        switch(type){
            case "helicopter":{
                return (Helicopter(name, coordinates));
                break;
            }
            case "baloon":{
                return (Baloon(name, coordinates));
                break;
            }
            case "jetplane":{
                return (JetPlane(name, coordinates));
                break;
            }
        }
    }
}