package vehicle;

import java.util.HashMap;
import tower.*;
import vehicle.Coordinates;
import logs.Logs;

public class Baloon extends Aircraft implements Flyable {
    private  WeatherTower weather;


    public Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }
    public void updateConditions(){
        String condition = this.weather.getWeather(this.coordinates);
        HashMap<String, String> comment = new HashMap<String, String>();

        switch(condition){
            case condition.equals("SUN"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude() + 2,
                    coordinates.getLatitude(),
                    coordinates.getHeight() + 2
                );
                comment.put("SUN", "");
                break;
            }
            case condition.equals("RAIN"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() - 5,
                    coordinates.getHeight()
                );
                comment.put("RAIN", "");
                break;
            }
            case condition.equals("FOG"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() - 3,
                    coordinates.getHeight()
                );
                comment.put("FOG", "");
                break;
            }
            case condition.equals("SNOW"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 15
                );
                comment.put("SNOW", "");
                break;
            }
        }
        // if (weather.getHeight <= 0){

        // }else{

        // }
    }
    public void registerTower(WeatherTower WeatherTower){
        this.weather = WeatherTower;
        //registaring to tower
        this.weather.register(this.Baloon);
        //log message
    }
    
}