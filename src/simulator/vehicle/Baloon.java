package vehicle;

import java.util.HashMap;
import tower.*;
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
            case "SUN":{
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 2,
                    coordinates.getLatitude(),
                    coordinates.getHeight() + 2
                );
                comment.put("SUN", "Let's enjoy the good weather");
                break;
            }
            case "RAIN":{
                this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() - 5,
                    coordinates.getHeight()
                );
                comment.put("RAIN", "Wow rain");
                break;
            }
            case "FOG":{
                this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() - 3,
                    coordinates.getHeight()
                );
                comment.put("FOG", "What's the big thing");
                break;
            }
            case "SNOW":{
                this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 15
                );
                comment.put("SNOW", "The Snow");
                break;
            }
        }
        Logs log = new Logs().getLogs();
        log.wirteLog("Baloon#"+ this.name + "(" + this.id + "): " + comment.get(condition));
        // if (weather.getHeight <= 0){

        // }else{

        // }
    }
    public void registerTower(WeatherTower WeatherTower){
        this.weather = WeatherTower;
        //registaring to tower
        Logs log = new Logs().getLogs();
        log.wirteLog("Tower says: Baloon#" + this.name + "(" + this.id +") registered to weather tower");
        this.weather.register(this);
        //log message
    }
    
}