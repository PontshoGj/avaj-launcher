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
        Random rand = new Random(); 
        
        // return (this.weather[rand.nextInt(5)]);
        return (this.weather[3]);
    }
}