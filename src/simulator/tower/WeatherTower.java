package tower;

import vehicle.*;
import tower.*;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates){
        
        WeatherProvider provider = WeatherProvider.getProvider();
        return (provider.getCurrentWeather(coordinates));
    }
    private void changeWeather() {
        this.conditionChange();
    }    

}