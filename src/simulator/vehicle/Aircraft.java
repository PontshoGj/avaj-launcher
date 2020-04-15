package vehicle;

import vehicle.Coordinates;;

public class Aircraft {
    
    protected long id;
    protected String name;
    protected Coordinates coordinates
    private long idCounter = 0;
    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = idCounter
    }

    private long nextId(){
        return (++Aircraft.idCounter);
    }
}