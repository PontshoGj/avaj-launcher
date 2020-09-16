package tower;

import vehicle.*;

public class WeatherTower extends Tower {

    public static String getWeather(Coordinates coordinates){
        
        WeatherProvider provider = WeatherProvider.getProvider();
        return (provider.getCurrentWeather(coordinates));
    }
    public  void changeWeather() {
        this.conditionChange();
    }    

}