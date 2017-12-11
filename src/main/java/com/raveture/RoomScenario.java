package com.raveture;
public class RoomScenario implements Scenario{
    protected String description, consequence, type;
    private int HpChange, newLoc;
    protected boolean hidden;
    public RoomScenario(){
        super();
    }
    public RoomScenario(String description, String consequence, int HpChange, int newLoc){
        this.type="none";
        this.description = description;
        this.consequence = consequence;
        this.HpChange = HpChange;
        this.newLoc = newLoc;
        this.hidden = false;
    }
    public RoomScenario(String description, String consequence, int HpChange, int newLoc, boolean hidden){
        this(description, consequence, HpChange, newLoc);
        this.hidden = hidden;
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
    public String getType(){
        return type;
    }
    public boolean hide(){
        return hidden;
    }
    public String toString(){
        return HpChange+","+newLoc;
    }
}