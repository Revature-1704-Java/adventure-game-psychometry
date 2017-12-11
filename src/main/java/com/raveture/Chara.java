package com.raveture;
public class Chara{
    private int hp;
    private int loc;
    private int atk;
    public Chara(){
    }
    public Chara(int hp, int loc, int atk){
        this.hp=hp;
        this.loc=loc;
    }
    public void setHp(int newHp){
        hp=newHp;
    }
    public int getHp(){
        return hp;
    }
    public void setLoc(int newLoc){
        loc=newLoc;
    }
    public int getLoc(){
        return loc;
    }
}