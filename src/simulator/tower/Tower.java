package tower;

import java.util.ArrayList;

public class Tower {
    ArrayList<Flyable> observers = new ArrayList<String>();
    public void register(Flyable flyable){
        if (!observers.contains(flyable)){
            observers.add(flyable);
        }
    }
    public  void unregister(Flyable flyable){
        observers.remove(flyable);
    }
    protected void conditionChange() {
        for (Flyable vehicle in this.observers){
            vehicle.updateCondition();
        }
    }
}