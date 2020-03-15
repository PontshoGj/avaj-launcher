package tower;
import vehicle.Coordinates;

public class WeatherProvider {
    
    private String weather;
    public WeatherProvider(){

    }
    public String getCurrentWeather(Coordinates coordinates){
        return "SUN";
    }
}