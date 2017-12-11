package com.raveture;
public class LimitedRoomScenario extends RoomScenario{
    private int limit;
    private String limitConsequence;
    public LimitedRoomScenario(){
        this.type="Limited";
    }
    public LimitedRoomScenario(String description, String consequence, String limitConsequence, int HpChange, int newLoc, int limit){
        super(description, consequence, HpChange, newLoc);
        this.limit=limit;
        this.limitConsequence=limitConsequence;
    }
    public int deltaHp(int HP){
        if(limit>0){
            return super.deltaHP(HP);
        }else{
            return 0;
        }
    }
    public void displayCons(){
        if(limit>0){
            super.displayCons();
        }else{
            System.out.println(limitConsequence);
        }
    }
    public void decrementLimit(){
        limit--;
    }
	public int getLimit() {
		return limit;
    }
}