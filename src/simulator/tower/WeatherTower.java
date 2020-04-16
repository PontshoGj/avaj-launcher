package tower;

import vehicle.*;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates){
        
        WeatherProvider provider = new WeatherProvider().getProvider();
        return (provider.getCurrentWeather(coordinates));
    }
    void changeWeather() {
        this.conditionChange();
    }    

}