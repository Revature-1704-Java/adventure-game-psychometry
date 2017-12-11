package com.raveture;
import java.util.Scanner;
public class Game{
    private static Room[] map;
    private static Chara mc = new Chara(20, 0, 3);
    public static void main(String[] args) {
        boolean end;
        int currentRoom = 0;
        Scanner sc = new Scanner(System.in);
        initializeMap();
        do {
            System.out.println("Your health: " + mc.getHp() + " Your Location " +mc.getLoc());
            System.out.println(map[currentRoom].getDescription());
            System.out.println("choose your action: ");
            map[currentRoom].clearMonster();
            map[currentRoom].revealScenarios();
            for(int i = 0; i<map[currentRoom].getScenarios().size();i++){
                if(map[currentRoom].revealed()){
                    System.out.print(i+": ");
                    map[currentRoom].getScenarios().get(i).displayDesc();
                }else{
                    if(!map[currentRoom].getScenarios().get(i).hide()){
                        System.out.print(i+": ");
                        map[currentRoom].getScenarios().get(i).displayDesc();
                    }
                }
            }
            int choice = sc.nextInt();
            while(choice<0||choice>=map[currentRoom].getScenarios().size()){
                System.out.println();
                System.out.println("Invalid Action, choose your action: ");
                for(int i = 0; i<map[currentRoom].getScenarios().size();i++){
                    if(map[currentRoom].revealed()){
                        System.out.print(i+": ");
                        map[currentRoom].getScenarios().get(i).displayDesc();
                    }else{
                        if(map[currentRoom].getScenarios().get(i).hide()){
                            System.out.print(i+": ");
                            map[currentRoom].getScenarios().get(i).displayDesc();
                        }
                    }
                }
                choice = sc.nextInt();
            }
            RoomScenario userChoice=map[currentRoom].getScenarios().get(choice);
            if(userChoice.type.equals("monster")){
                MonsterScenario mon = (MonsterScenario) userChoice;
                mon.MonsterHpDecrement(mc.getAtk());
                mon.displayCons();
            }else if(userChoice.type.equals("limited")){
                LimitedRoomScenario temp=(LimitedRoomScenario) userChoice;
                System.out.println("Your health: " + mc.getHp());
                temp.displayCons();
                temp.decrementLimit();
            }
            updateMC(userChoice);
            currentRoom=mc.getLoc();
            end = mc.getHp() <= 0 || mc.getLoc() == -1;
            System.out.println();
        } while (!end);
        if(mc.getHp()<=0){
            System.out.println("You died");
        }else{
            System.out.println("Congratulation, you made it out");
        }
        sc.close();
    }
    public static void initializeMap(){
        map = new Room[3];
        map[0] = new Room("This is a room with 2 doors.");
        map[0].addScenario(new LimitedRoomScenario("chose door 1", "You trigger a trap arrow in the room.", "you hear a mechanical click, but nothing happened", -7, 2, 1));
        map[0].addScenario(new RoomScenario("chose door 2", "You were ambushed by a vampire as soon as you entered.", -10, 1));
        map[1] = new Room("This is a room with 2 doors");
        map[1].addScenario(new LimitedRoomScenario("try to get back to the last room.", "You were attacked from the back", "You are forced to engage", -10, 1, 1));
        map[1].addScenario(new MonsterScenario("attack the vampire", "You wounded the monster", "You slain the vampire", 1, new Chara(10,1,4)));
        map[1].addScenario(new RoomScenario("open door behind the vampire","the door opens to the outside", 0, -1,true));
        map[2] = new Room("This is a room with 1 door, otherwse unremarkable, other than the well in the middle");
        map[2].addScenario(new LimitedRoomScenario("You drink from the well", "You feel strengthened", "The well is emptied", +10, 2, 3));
        map[2].addScenario(new RoomScenario("return to previous room", "you moved to the previous room", 0, 0));
    }
    public static void updateMC(Scenario scenario){
        mc.setHp(scenario.deltaHP(mc.getHp()));
        mc.setLoc(scenario.deltaLoc());
    }
} 