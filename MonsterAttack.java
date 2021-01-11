
import java.util.Date;

public class MonsterAttack {

    private String attackLocation;
    private double damagesInMillionUSD;
    private Date date ;
    private String monsterName;

    public MonsterAttack() {
    }


    public MonsterAttack(String attackLocation, double damagesInMillionUSD, Date date, String monsterName) {
        this.attackLocation = attackLocation;
        this.damagesInMillionUSD = damagesInMillionUSD;
        this.date = date;
        this.monsterName = monsterName;
    }

    //Create getter and setter methods
    public String getMonsterName() {

        return monsterName;
    }
    public void setMonsterName(String monsterName) {

        this.monsterName = monsterName.toUpperCase();

    }
    public String getAttackLocation() {

        return attackLocation;
    }
    public void setAttackLocation(String attackLocation) {

        this.attackLocation = attackLocation;
    }
    public double getDamagesInMillionUSD() {

        return damagesInMillionUSD;
    }
    public void setDamages(double damagesInMillionUSD) {


        this.damagesInMillionUSD = damagesInMillionUSD;
    }
    public Date getDate() {

        return date;
    }
    public void setDate(Date date)  {
      this.date = date;

    }
    @Override
    public String toString() {
        return   "Monster Name: " + monsterName+", Attack Location: " + attackLocation + ", Damages: " +  damagesInMillionUSD + " million,  "+ date  ;

    }


}

