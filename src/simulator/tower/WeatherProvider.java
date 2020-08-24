package tower;

import vehicle.Coordinates;
import java.util.Random;

public class WeatherProvider {
    
    private String[] weather = { "SUN", "RAIN", "FOG", "SNOW"};
    private static int holdprevvalue;

    private static WeatherProvider weatherProvider = null;
    private WeatherProvider(){}

    public  static WeatherProvider getProvider(){
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return (weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates){
        Random rand = new Random(); 
        rand.setSeed(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude());
        int a = rand.nextInt(4);
        this.holdprevvalue = a;
        while(true){
            if ((a >= 0 && a < 4) && a != holdprevvalue){
                holdprevvalue = a;
                break;
            }
            a = rand.nextInt(4);
            a = rand.nextInt(4);
        }
        return (this.weather[a]);
    }
}