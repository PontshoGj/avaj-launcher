package tower;

import java.util.ArrayList;
import vehicle.*;
import logs.Logs;
public class Tower {
    ArrayList<Flyable> observers = new ArrayList<Flyable>();
    public void register(Flyable flyable){
        if (!this.observers.contains(flyable)){
            this.observers.add(flyable);
            System.out.println(this.observers);
            // Logs.getLogs().wirteLog(info);
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