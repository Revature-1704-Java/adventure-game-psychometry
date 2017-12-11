package com.raveture;
public class LimitedRoomScenario extends RoomScenario{
    private int limit;
    private String limitConsequence;
    public LimitedRoomScenario(){
    }
    public LimitedRoomScenario(String description, String consequence, String limitConsequence, int HpChange, int newLoc, int limit){
        super(description, consequence, HpChange, newLoc);
        this.type="limited";
        this.limit=limit;
        this.limitConsequence=limitConsequence;
    }
    public LimitedRoomScenario(String description, String consequence, String limitConsequence, int HpChange, int newLoc, int limit, boolean hidden){
        this(description, consequence, limitConsequence, HpChange, newLoc, limit);
        this.hidden=hidden;
    }
    public void displayCons(){
        if(limit>0){
            super.displayCons();
        }else{
            System.out.println(limitConsequence);
        }
    }    
    public int deltaHP(int HP){
        if (limit>0){
            return super.deltaHP(HP);
        }else{
            return HP;
        }
        
    }
    public void decrementLimit(){
        limit=limit-1;
    }
	public int getLimit() {
		return limit;
    }
}