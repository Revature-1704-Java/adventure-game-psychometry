import java.util.ArrayList;

public class Room{
    private ArrayList<RoomScenario> scenarios;
    private String description;
    public Room(){
        scenarios = new ArrayList<RoomScenario>();
        description = "It's an empty room with 1 door";
    }
    public Room(String description){
        scenarios = new ArrayList<RoomScenario>();
        this.description = description;
    }
    public void addScenario(RoomScenario scene){
        scenarios.add(scene);
    }
    public ArrayList<RoomScenario> getScenarios(){
        return scenarios;
    }
    public String getDescription(){
        return description;
    }
}