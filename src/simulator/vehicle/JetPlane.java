package vehicle;

import java.util.HashMap;
import tower.*;
import vehicle.Coordinates;
import logs.Logs;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weather;

    public JetPlane(String name, Coordinates coordinates){
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
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 5,
                    coordinates.getHeight()
                );
                comment.put("RAIN", "");
                break;
            }
            case condition.equals("FOG"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 1,
                    coordinates.getHeight()
                );
                comment.put("FOG", "");
                break;
            }
            case condition.equals("SNOW"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 5
                );
                comment.put("SNOW", "");
                break;
            }
        }
    }

    public void registerTower(WeatherTower WeatherTower){
        this.weather = WeatherTower;
        //registaring to tower
        this.weather.register(this.JetPlane);
        //log message
    }
      
}