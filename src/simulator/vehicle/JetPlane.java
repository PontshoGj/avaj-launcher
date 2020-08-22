package vehicle;

import java.util.HashMap;
import tower.*;
import logs.*;

public class JetPlane extends Aircraft implements Flyable{
    private WeatherTower weather;

    public JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String condition = this.weather.getWeather(this.coordinates);
        HashMap<String, String> comment = new HashMap<String, String>();
        

        switch(condition){
            case "SUN":{
                this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2
                );
                comment.put("SUN", "The sun is blinding me!");
                break;
            }
            case "RAIN":{
                this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 5,
                    coordinates.getHeight()
                );
                comment.put("RAIN", "F***k its raining");
                break;
            }
            case "FOG":{
                this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 1,
                    coordinates.getHeight()
                );
                comment.put("FOG", "Its The FOG!");
                break;
            }
            case "SNOW":{
                this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 5
                );
                comment.put("SNOW", "Oh snow");
                break;
            }
        }
        Logs log = new Logs().getLogs();
        if (this.coordinates.getHeight() <= 0){
            log.wirteLog("JetPlane#" + this.name + "(" + this.id +") lannded at " + this.coordinates.getLongitude() + " Long, " + this.coordinates.getLatitude() + " Lat, " + this.coordinates.getHeight() + " high.");
            log.wirteLog("Tower says: JetPlane#" + this.name + "(" + this.id +") unregistered from weather tower.");
            this.weather.unregister(this);
        }else{
            if (this.coordinates.getHeight() > 100){
                this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    100
                );
            }
            log.wirteLog("JetPlane#"+ this.name + "(" + this.id + "): " + comment.get(condition) + ".");
        }   
    }

    public void registerTower(WeatherTower WeatherTower){
        this.weather = WeatherTower;
        //registaring to tower
        this.weather.register(this);
        //log message
        Logs log = new Logs().getLogs();
        log.wirteLog("Tower says: JetPlane#" + this.name + "(" + this.id +") registered to weather tower");
    }
      
}