package tower;
import vehicle.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates){
        WeatherPorvider provider = WeatherPorvider.getProvide();
        return (provider.getCurrentWeather(coordinates));
    }
    private void changeWeather() {
        this.conditionChange()
    }    

}