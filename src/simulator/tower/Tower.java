package tower;

import java.util.ArrayList;
import vehicle.*;

public abstract class Tower {
    ArrayList<Flyable> observers = new ArrayList<>();
    public void register(Flyable flyable){
        if (!this.observers.contains(flyable)){
            this.observers.add(flyable);
        }
    }
    public  void unregister(Flyable flyable){
        this.observers.remove(flyable);
    }
    protected void conditionChange() {
        for (int i = 0; i < this.observers.size(); i++){
            int size = this.observers.size();
            this.observers.get(i).updateConditions();
            if (this.observers.size() < size)
                i--;
        }
    }
}