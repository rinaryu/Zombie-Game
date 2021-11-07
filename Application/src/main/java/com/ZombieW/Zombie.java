abstract class Zombie {
  private int damage;
  private int[] currentLocation;
  public Zombie(){

  }  
  public int[] getLocation() {
    return currentLocation;
  }
  public void setLocation(int[] location) {

  }
  public int getDamage(){
      return damage;
  }
  public void setDamage(int damage){
      this.damage = damage;
  }
  public void attack(){

  }
}