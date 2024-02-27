public class Enemy extends Character{
  private String types;

  //Enemy Constructor
  public Enemy(String n, int d, int l, String t){
    super(n,d,l);
    types = t;
  }

  //Getter/Setter Method
  public String getTypes(){return types;}
  public void setTypes(String t){types=t;}

  //ToString
  public String toString(){
    return super.toString() + "\nType: " + types;
  }
}