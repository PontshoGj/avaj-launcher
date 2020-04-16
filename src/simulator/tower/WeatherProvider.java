package tower;

import vehicle.Coordinates;
import java.util.Random;

public class WeatherProvider {
    
    private String[] weather = { "SUN", "RAIN", "FOG", "SNOW"};

    private static WeatherProvider weatherProvider = new WeatherProvider();
    public WeatherProvider(){}

    public WeatherProvider getProvider(){
        return (weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates){
        Random rand = new Random(0, 4); 
        
        return (this.weather[rand]);
    }
}