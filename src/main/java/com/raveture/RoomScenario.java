public class RoomScenario implements Scenario{
    private String description, consequence;
    private int HpChange, newLoc;
    public RoomScenario(){
    }
    public RoomScenario(String description, String consequence, int HpChange, int newLoc){
        this.description = description;
        this.consequence = consequence;
        this.HpChange = HpChange;
        this.newLoc = newLoc;  
    }
    public int deltaHP(int HP){
        return HP+HpChange;
    }
    public int deltaLoc(){
        return newLoc;
    }
    public void displayDesc(){
        System.out.println(description);
    }
    public void displayCons(){
        System.out.println(consequence);
    }
}