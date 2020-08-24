package vehicle;


public class AircraftFactory{
    public Flyable newAircraft(String type,String name, int longitude, int latitude, int height){
        Coordinates coordinates = new Coordinates(
            longitude,
            latitude,
            height
        );
        type = type.toLowerCase();
        Flyable flyable = null;
        switch(type){
            case "helicopter":{
                flyable = new Helicopter(name, coordinates);
                break;
            }
            case "baloon":{
                flyable = new Baloon(name, coordinates);
                break;
            }
            case "jetplane":{
                flyable = new JetPlane(name, coordinates);
                break;
            }
        }
        return flyable;
    }
}