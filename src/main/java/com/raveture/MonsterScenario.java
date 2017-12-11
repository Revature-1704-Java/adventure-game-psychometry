package com.raveture;
public class MonsterScenario extends RoomScenario{
    public Chara monster;
    private String deathConsequence;
    public MonsterScenario(){
    }
    public MonsterScenario(String description, String consequence, String deathConsequence, int newLoc, Chara monster){
        super(description, consequence, -monster.getAtk(), newLoc);
        this.type = "monster";
        this.deathConsequence=deathConsequence;
        this.monster = monster;
    }
    public MonsterScenario(String description, String consequence, String deathConsequence, int newLoc, boolean hidden, Chara monster){
        this(description, consequence, deathConsequence, newLoc, monster);
        this.hidden=hidden;
    }
    public void displayDesc(){
        System.out.println(description);
    }
    public void displayCons(){
        if(monster.getHp()>0){
            super.displayCons();
            System.out.print("The monster has "+monster.getHp()+" remain. ");
            System.out.println("You recieve "+monster.getAtk()+" damage");
        }else{
            System.out.println(deathConsequence);
        }
    }
    public void MonsterHpDecrement(int atk){
        monster.setHp(monster.getHp()-atk);
    }
    public int getMonsterHp(){
        return monster.getHp();
    }
}