package vehicle;

import tower.*;
import vehicle.*;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
}