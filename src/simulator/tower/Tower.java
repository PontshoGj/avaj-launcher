package tower;

import java.util.ArrayList;
import vehicle.*;

public class Tower {
    ArrayList<Flyable> observers = new ArrayList<Flyable>();
    public void register(Flyable flyable){
        if (!this.observers.contains(flyable)){
            this.observers.add(flyable);
        }
    }
    public  void unregister(Flyable flyable){
        this.observers.remove(flyable);
    }
    protected void conditionChange() {
        for (Flyable vehicle : this.observers){
            vehicle.updateConditions();
        }
    }
}