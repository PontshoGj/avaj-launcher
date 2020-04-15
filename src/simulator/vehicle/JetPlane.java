package vehicle;

import java.util.HashMap;
import interfaces.Flyable;
import tower.*;
import vehicle.Coordinates;
import logs.Logs;

public class JetPlane extends Aircraft implements Flyable{
    private weather  WeatherTower

    public JetPlane(String name, Coordinates coordinates){
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
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 5,
                    coordinates.getHeight()
                );
                comment.put("RAIN", "");
                break;
            }
            case weather.equals("FOG"):{
                this.coordinates = New Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 1,
                    coordinates.getHeight()
                );
                comment.put("FOG", "");
                break;
            }
            case weather.equals("SNOW"):{
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

    public void registerTower(final WeatherTower WeatherTower){

    }
      
}