import java.util.Scanner;
public class Game{
    private static Room[] map;
    private static Chara mc = new Chara(20, 0);
    public static void main(String[] args) {
        boolean end;
        int currentRoom = 0;
        Scanner sc = new Scanner(System.in);
        initializeMap();
        do {
            System.out.println(map[currentRoom].getDescription());
            System.out.println("choose your action: ");
            for(int i = 0; i<map[currentRoom].getScenarios().size();i++){
                System.out.print(i+": ");
                map[currentRoom].getScenarios().get(i).displayDesc();
            }
            int choice = sc.nextInt();
            while(choice<0||choice>=map[currentRoom].getScenarios().size()){
                System.out.println();
                System.out.println("Invalid Action, choose your action: ");
                for(int i = 0; i<map[currentRoom].getScenarios().size();i++){
                    System.out.print(i+": ");
                    map[currentRoom].getScenarios().get(i).displayDesc();
                }
                choice = sc.nextInt();
            }
            RoomScenario userChoice=map[currentRoom].getScenarios().get(choice);
            updateMC(userChoice);
            currentRoom=mc.getLoc();
            userChoice.displayCons();
            end = mc.getHp() <= 0 || mc.getLoc() == -1;
            System.out.println("Your health: " + mc.getHp());
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
        map[0].addScenario(new RoomScenario("chose door 1", "You trigger a trap arrow in the room.", -3, 2));
        map[0].addScenario(new RoomScenario("chose door 2", "You were ambushed by a vampire as soon as you entered.", -10, 1));
        map[1] = new Room("This is a room with 2 doors, and you just got got by a vampire.");
        map[1].addScenario(new RoomScenario("try to get back to the last room.", "You turned your back on a vampire, what did you expect?", -10, 2));
        map[1].addScenario(new RoomScenario("dodge the vampire's attacks and head for the door behind him.", "Dodge failed, You took major damage.", -7, -1));
        map[1].addScenario(new RoomScenario("attack the vampire", "Suprised by your bravado, the vampire failed to dodge your attack and perished.", 0, -1));
        map[2] = new Room("This is a room with 1 door, otherwse unremarkable.");
        map[2].addScenario(new RoomScenario("return to previous room", "you moved to the previous room", 0, 0));
    }
    public static void updateMC(Scenario scenario){
        mc.setHp(scenario.deltaHP(mc.getHp()));
        mc.setLoc(scenario.deltaLoc());
    }
} 