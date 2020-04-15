package vehicle;

import java.util.HashMap;
import tower.*;
import vehicle.Coordinates;
import logs.Logs;

public class Helicopter extends Aircraft implements Flyable {
    private  WeatherTower weather;

    public Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);

    }
    public void updateConditions(){
        String condition = this.weather.getWeather(this.coordinates);
        HashMap<String, String> comment = new HashMap<String, String>();

        switch(condition){
            case condition.equals("SUN"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2
                );
                comment.put("SUN", "");
                break;
            }
            case condition.equals("RAIN"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude() + 5,
                    coordinates.getLatitude(),
                    coordinates.getHeight()
                );
                comment.put("RAIN", "");
                break;
            }
            case condition.equals("FOG"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude() + 1,
                    coordinates.getLatitude(),
                    coordinates.getHeight()
                );
                comment.put("FOG", "");
                break;
            }
            case condition.equals("SNOW"):{
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
        this.weather = WeatherTower;
        //registaring to tower
        this.weather.register(this.Helicopter);
        //log message
    }
    
}