public class Player extends Character{
  private String gender;
  private String type;
  
  //Player constructor
  public Player(String n, int d, int l, String g, String t){
    super(n,d,l);
    gender = g;
    type = t;
  }

  //Getter methods
  public String getGender(){return gender;}
  public String getType(){return type;}

  //Setter methods
  public void setGender(String g){gender = g;}
  public void setType(String t){type = t;}
  
  //ToString
  public String toString(){
    return super.toString() + "\nType: " + type;
  }
}