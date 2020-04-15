package vehicle;

import java.util.HashMap;
import interfaces.Flyable;
import tower.*;
import vehicle.Coordinates;
import logs.Logs;

public class Helicopter extends Aircraft implements Flyable {
    private weather  WeatherTower

    public Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);

    }
    public void updateConditions(){
        String weather = WeatherTower.getWeather(this.coordinates);
        HashMap<String, String> comment = new HashMap<String, String>();

        switch(weather){
            case weather.equals("SUN"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2
                );
                comment.put("SUN", "");
                break;
            }
            case weather.equals("RAIN"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude() + 5,
                    coordinates.getLatitude(),
                    coordinates.getHeight()
                );
                comment.put("RAIN", "");
                break;
            }
            case weather.equals("FOG"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude() + 1,
                    coordinates.getLatitude(),
                    coordinates.getHeight()
                );
                comment.put("FOG", "");
                break;
            }
            case weather.equals("SNOW"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 12
                );
                comment.put("SNOW", "");
                break;
            }
        }
    }
    public void registerTower(WeatherTower WeatherTower){

    }
    
}