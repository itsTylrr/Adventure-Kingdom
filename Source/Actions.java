import java.util.*;
public class Actions{
  private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();

  //Prints attack menu
  public static void attackMenu(){
    for(int i = 0; i<enemies.size(); i++){
      System.out.print((i+1) + ": " + enemies.get(i).getName() + "\n");
    }
  }
  
  //Starts round, does round calculations, calls rOC
  public static void round(ArrayList<Player> x){
    String[] starters = {"You walked down a mysterious pathway, and you find youself lost...", "You (and your team) heard a loud scream nearby. You ran towards the noise...", "You turn a wrong turn and found youself a deadend. You turn around and suddenly find youself in danger...", "You swam to the nearest shoreline, and wait for your team to arrive. When they arrive, you and your team suddenly find danger...", "You find a rock, and you decide to folow that rock's long pathway..."};
    int rand = (int)(Math.random()*starters.length);
    System.out.println(starters[rand]+"\n");
    Scanner s = new Scanner(System.in);
    enemy(x);
    boolean con = true;
    try {
      Thread.sleep(500);
    } catch (Exception e){}

    
    while(con){

      //Player attack
      for(Player p : x){
        if(p.getHealth()>0){
          System.out.println(p.getName() + "'s turn is up!");          System.out.println("===================================================================================================================================================\n"+p.toString()+"\n");
          attackMenu();

          //Select enemy
          System.out.print("Enter Enemy: ");
          int option = s.nextInt();
          con = p.attack(enemies.get(option-1));
          System.out.println(p.getName() + " attacked!\n\n"+enemies.get(option-1).toString()+"\n\n");

          //Checks if enemy has died and removes them
          if(!con){
            Enemy bruh = enemies.remove(option-1);
            System.out.println("\n"+bruh.getName() + " has died!\n\n");
          }
        }
        try {
          Thread.sleep(500);
        } catch (Exception Z){}
      }

      //Enemy attack
      for(Enemy e : enemies){
        System.out.println(e.getName() + "'s turn is up!");
    System.out.println("===================================================================================================================================================\n"+e.toString()+"\n");
        //Gets random charcter and attacks
        int random = (int)(Math.random()*x.size());
        con = e.attack(x.get(random));
        System.out.println(e.getName() + " attacked!\n\n"+x.get(random).toString()+"\n\n");

        //Checks if character has died and removes them
        if(x.get(random).getHealth()<=0){
          Player bruh = x.remove(random);
          System.out.println("\n"+bruh.getName() + " has died!");
        }
        try {
          Thread.sleep(500);
        } catch (Exception Z){}
      }
    }
    System.out.println("===================================================================================================================================================\n");

    //Return or Continue
    rOC();
  }
  
  //Creates new enemy list
  public static void enemy(ArrayList<Player> x){
    int size = x.size();
    String[] names = {"Bobby", "Xisla", "Ella", "Oupu", "Brosew", "Kindu", "Aio", "Rindie"};

    //Randomizes the enemies for each list
    for(int i = 0; i < size; i++){
      int n = (int) (Math.random()*8);
      
      enemies.add(new Enemy(names[n],(int)(Math.random()*avgPlayerHealth()/2)+1,1,"Goblin"));
    }
  }
  
  //Restart or continue
  public static void rOC(){
    Scanner s = new Scanner(System.in);
    //Checks if there are no players
    if(Main.getPlayers().size()<=0){
      System.out.print("Restart or quit? (R/Q): ");
      String ans = s.nextLine().toLowerCase();
      if(ans.substring(0,1).equals("r")){
        Main.reDo();
      } else {
        Main.cS();
        System.out.print("Quitting...");
        System.exit(0);
      }
    }
    
    System.out.print("Continue or Restart? (C/R): ");
    String ans = s.nextLine().toLowerCase();
    //If continue then, envoke another round
    if(ans.substring(0,1).equals("c")){
      Main.cS();
      round(Main.getPlayers());
    } else if (ans.substring(0,1).equals("r")){
      //If restart, then restart.
      Main.reDo();
    } else {
      //Checks for valid input
      System.out.println("Please input a valid response!");
      rOC();
    }
  }

  public static int avgPlayerHealth(){
    ArrayList<Player> s = Main.getPlayers();
    int health = 0;
    for(Player p : s){
      health += p.getHealth();
    }
    if(s.size()==0){
      return 0;
    }
    return health/s.size();
  }
}