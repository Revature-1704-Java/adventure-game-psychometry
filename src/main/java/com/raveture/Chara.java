public class Chara{
    private int hp;
    private int loc;
    public Chara(){
    }
    public Chara(int hp, int loc){
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