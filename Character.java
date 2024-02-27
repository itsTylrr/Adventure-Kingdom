public class Character{
  private String name;
  private int dmg;
  private int lvl;
  private int health;
  private final int critDmgMult = 3;

  //Character constructor
  public Character(String n, int d, int l){
    name = n;
    dmg = d;
    l = lvl;
    health = (int)(Math.random()*100)+25;
  }

  //Getter/Setter methods
  public String getName(){return name;}
  public int getDmg(){return dmg;}
  public int getLvl(){return lvl;}
  public int getHealth(){return health;}
  public void setHealth(int h){health = h;}
  
  //ToStrng
  public String toString(){
    return ("Name: " + name + "\nAttack: " + dmg + "\nLevel: "+ lvl + "\nHealth: " + health);
  }

  //Health Up!
  public void healthUp(){
    health += (int)(Math.random()*lvl)+1;
  }
  
  //Attack method
  public boolean attack(Character e){
    int crit = (int) (Math.random()*1);
    int critDmg = (int) (Math.random()*lvl)*critDmgMult;

    //If crit is envoked
    if(crit == 1){
      int x = this.dmg-critDmg;
      e.setHealth(e.getHealth()-x);
      if(e.getHealth()<=0){
        e.setHealth(0);
        return false;
      }
      return true;
    } else { //If crit is not envoked
      int x = this.dmg;
      e.setHealth(e.getHealth()-x);
      if(e.getHealth()<=0){
        e.setHealth(0);
        return false;
      }
      return true;
    }
  }

}