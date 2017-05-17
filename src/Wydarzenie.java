
import java.util.Date;
import java.io.Serializable;

public class Wydarzenie implements Serializable{
    Date begin;
    Date end;
    String room;
    String name;
    
    Wydarzenie(String name, String room, Date begin, Date end)
    {
        this.name=name;
        this.room=room;
        this.begin=begin;
        this.end=end;
    }
}
