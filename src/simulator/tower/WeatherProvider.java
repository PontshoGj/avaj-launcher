package tower;

import vehicle.Coordinates;
import java.util.Random;

public class WeatherProvider {
    
    private String[] weather = { "SUN", "RAIN", "FOG", "SNOW"};
    private static int holdprevvalue;

    private static WeatherProvider weatherProvider = new WeatherProvider();
    public WeatherProvider(){}

    public WeatherProvider getProvider(){
        return (weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates){
        Random rand = new Random(); 
        rand.setSeed(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude());
        int a = rand.nextInt(4);
        holdprevvalue = a;
        // System.out.println(a);
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