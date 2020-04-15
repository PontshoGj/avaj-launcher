package vehicle;

import vehicle.*;

public class AircraftFactory{
    public Flyable newAircraft(String type,String name, int longitude, int latitude, int height){
        Coordinate coordinates = new Coordinate(
            longitude,
            latitude,
            height
        );
        switch(type){
            case type.toLowerCase().equals('helicopter'){
                return (Helicopter(name, coordinates));
                break;
            }
            case type.toLowerCase().equals('baloon'){
                return (Baloon(name, coordinates));
                break;
            }
            case type.toLowerCase().equals('jetplane'){
                return (Height(name, coordinates));
                break;
            }
        }
    }
}