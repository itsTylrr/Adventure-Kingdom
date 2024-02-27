import java.util.*;
public class Main {
  private static ArrayList<Player> characters;
  
  public static void main(String[] args) {
    reDo();
  }

  //reDo function
  public static void reDo(){
    characters = null;
    cS();
    loadingScreen(100);
    title();
    selection();
  }
  
  //Loading screen by https://stackoverflow.com/questions/852665/command-line-progress-bar-in-java
  public static void loadingScreen(int s){
    cS();
    String anim= "|/-\\";
    for (int x =0 ; x < 100 ; x++) {
      String data = "\r" + anim.charAt(x % anim.length()) + " " + x;
      try {
        System.out.write(data.getBytes());
        Thread.sleep(s);
      } catch (Exception e){}
    }
    cS();
  }
  
  //Prompts selction choice to user
  public static void selection(){
    Scanner s = new Scanner(System.in);
    characters = new ArrayList<Player>();
    int playerCount;
    String[] gender = {"Male", "Female"};
    String[] cls = {"Mage", "Longsword"};

    //Number of characters
    System.out.println("===================================================================================================================================================");
    
    System.out.print("How much characters do you want? (1, 2, 3): ");
    playerCount = s.nextInt();
    if(!(playerCount < 4 && playerCount > 0)){
      System.out.println("Please select a valid number!");
      reDo();
    }

    //Menu for customization
System.out.println("===================================================================================================================================================");
    System.out.println("1: Male   1: Mage");
    System.out.println("2: Female 2: Longsword");
System.out.println("===================================================================================================================================================");
    
    //Loops for the number of characters selected
    for(int i = 1; i <= playerCount; i++){
      System.out.print("Player " + i + " Gender: ");
      int g = s.nextInt();
      System.out.print("Player " + i + " Class: ");
      int c = s.nextInt();
      System.out.print("Player " + i + " Name: ");
      s.nextLine();
      String n = s.nextLine();
      int d = (int) (Math.random()*25)+1;
      characters.add(new Player(n,d,1,gender[g-1],cls[c-1]));
System.out.println("===================================================================================================================================================");
    }

    //Continue?
    con();
  }
  
  //Continue prompt
  public static void con(){
    Scanner s = new Scanner(System.in);
    System.out.print("Want to start your adventure? (Y/N): ");
    String contin = s.nextLine().toLowerCase();

    //If user says yes, then continue
    if(contin.substring(0,1).equals("y")){
      cS();
      loadingScreen(50);
      Actions.round(characters);
    } else if(contin.substring(0,1).equals("n")){ //If user says no, print out ending sequence.
      cS();
      String ending1 = "After careful deliberation, you decide to not go on your adventure. With a long sigh, the buddies you have befriended walk releucnatly out the gate. The friends you just made wave goodbye to you, and your farewell is as sudden and final as your meeting.";
      String ending2 = "After the deperature of the others, your life continues as normal. Meanwhile, one of your bestfriends start to rekindle the usual activities. However, it doesn't take long before your bestfriend to lose interest in the repetitive activities, and you go on to find yourself a job.";
      String ending3 = "You spend a peaceful life all alone. The other adventurers visits a few times before disappearing for good. From the occasional visitor, you hear stories about how the final end of adventures and their ambitions shakes the world to its very core. Sometimes you wonder whether their destiny would have changed, had you continued to adventure with them";

      //Prints every character of ending1 with a delay
      for(int x = 0; x < ending1.length(); x++){
        System.out.print(ending1.charAt(x));
        try {
          Thread.sleep(25);
        } catch (Exception e){}        
      }
      
      System.out.print("\n\n Press enter to continue...");
      s.nextLine();
      System.out.print("\n\n");

      //Prints every character of ending2 with a delay
      for(int x = 0; x < ending2.length(); x++){
        System.out.print(ending2.charAt(x));
        try {
          Thread.sleep(25);
        } catch (Exception e){}
      }
      
      System.out.print("\n\n Press enter to continue...");
      s.nextLine();
      System.out.print("\n\n");

      //Prints every character of ending3 with a delay
      for(int x = 0; x < ending3.length(); x++){
        System.out.print(ending3.charAt(x));
        try {
          Thread.sleep(25);
        } catch (Exception e){}
      }
    } else { //If user types in something other than yes or no.
        cS();
        System.out.println("Please enter a valid answer!\n");
        con();
      }
    }
  
  //Clears console
  public static void cS() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  } 
  
  //2D Array for tittle and printing title
  public static void title(){
    String[][] title = {{" :::====  :::====  :::  === :::===== :::= === :::==== :::  === :::====  :::=====      :::  === ::: :::= === :::=====  :::====  :::====  :::======= "},
                        {" :::  === :::  === :::  === :::      :::===== :::==== :::  === :::  === :::           ::: ===  ::: :::===== :::       :::  === :::  === ::: === ==="},
                        {" ======== ===  === ===  === ======   ========   ===   ===  === =======  ======        ======   === ======== === ===== ===  === ===  === === === ==="},
                        {" ===  === ===  ===  ======  ===      === ====   ===   ===  === === ===  ===           === ===  === === ==== ===   === ===  === ===  === ===     ==="},
                        {" ===  === =======     ==    ======== ===  ===   ===    ======  ===  === ========      ===  === === ===  ===  =======  =======   ======  ===     ==="}};

    //Prints out title to show the title
    for(int r = 0; r < title.length; r++){
      System.out.println(title[r][0]);  
    }
  }
  
  //Method of getting list of playable Players
  public static ArrayList<Player> getPlayers(){
    return characters;
  }
}