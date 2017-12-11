package com.raveture;
import java.util.ArrayList;

public class Room{
    private ArrayList<RoomScenario> scenarios;
    private String description;
    private boolean unhide=false;
    public Room(){
        scenarios = new ArrayList<RoomScenario>();
        description = "It's an empty room";
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
    public void revealScenarios(){
        int monsterCount=0;
        for (RoomScenario s : scenarios) {
            if(s.getType().equals("monster")){
                monsterCount++;
            }
        }
        if(monsterCount==0){
            unhide=true;
        }
    }
    public void clearMonster(){
        ArrayList<RoomScenario> clone=new ArrayList<RoomScenario>(scenarios);
        for (RoomScenario s : clone) {
            if(s.getType().equals("monster")){
                MonsterScenario temp= (MonsterScenario) s;
                if(temp.getMonsterHp()<=0){
                    scenarios.remove(scenarios.indexOf(s));
                }
            }
        }
    }
    public String getDescription(){
        return description;
    }
    public boolean revealed(){
        return unhide;
    }
}