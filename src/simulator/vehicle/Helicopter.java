package vehicle;

import java.util.HashMap;
import tower.*;
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
            case "SUN":{
                this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2
                );
                comment.put("SUN", "This is hot.");
                break;
            }
            case "RAIN":{
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 5,
                    coordinates.getLatitude(),
                    coordinates.getHeight()
                );
                comment.put("RAIN", "Hhhh rain");
                break;
            }
            case "FOG":{
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 1,
                    coordinates.getLatitude(),
                    coordinates.getHeight()
                );
                comment.put("FOG", "Its getting foggy");
                break;
            }
            case "SNOW":{
                this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    coordinates.getHeight() - 12
                );
                comment.put("SNOW", "Winter is coming!");
                break;
            }
        }
        Logs log = new Logs().getLogs();
        if (this.coordinates.getHeight() <= 0){
            log.wirteLog("Helicopter#" + this.name + "(" + this.id +") landed at " + this.coordinates.getLongitude() + " Long, " + this.coordinates.getLatitude() + " Lat, " + this.coordinates.getHeight() + " high.");
            log.wirteLog("Tower says: Helicopter#" + this.name + "(" + this.id +") unregistered from weather tower.");
            this.weather.unregister(this);
        }else{
            if (this.coordinates.getHeight() > 100){
                this.coordinates = new Coordinates(
                    coordinates.getLongitude(),
                    coordinates.getLatitude(),
                    100
                );
            }
            log.wirteLog("Helicopter#"+ this.name + "(" + this.id + "): " + comment.get(condition) + ".");
        }    
    }

    public void registerTower(WeatherTower WeatherTower){
        this.weather = WeatherTower;
        //registaring to tower
        this.weather.register(this);
        //log message
        Logs log = new Logs().getLogs();
        log.wirteLog("Tower says: Helicopter#" + this.name + "(" + this.id +") registered to weather tower");
    }
    
}