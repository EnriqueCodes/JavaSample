import java.text.ParseException;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AttackMonitor {

    //Create Scanner object in order to take input from user
    Scanner sc = new Scanner(System.in);

    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");





    MonsterAttack[] attackArray;

    public void reportAttacks() throws ParseException {

        //Create an array to hold all the monster attacks and also individual monster attacks that will go inside the array
        attackArray = new MonsterAttack[5];

        MonsterAttack attack1 = new MonsterAttack();
        MonsterAttack attack2 = new MonsterAttack();
        MonsterAttack attack3 = new MonsterAttack();
        MonsterAttack attack4 = new MonsterAttack();
        MonsterAttack attack5 = new MonsterAttack();


        attackArray[0] = attack1;
        attackArray[1] = attack2;
        attackArray[2] = attack3;
        attackArray[3] = attack4;
        attackArray[4] = attack5;


        //Create variables to hold monster information
        String monsterName;
        String location;
        int damages=0;
        String stringDate;
        Date date = null;
        //Create a regex pattern for Date




        System.out.println("--------------------- Monster Attack Reporting Center--------------------- ");
        System.out.println(" ");

        //Run a loop to get the information of 5 monster attacks
        for(int i =0;i< attackArray.length;i++) {
            {
               System.out.println("Enter name of monster: ");
                monsterName =sc.nextLine();
                attackArray[i].setMonsterName(monsterName);

                System.out.println("Enter attack location: ");
                location = sc.nextLine();
                attackArray[i].setAttackLocation(location);

                System.out.println("Enter damages in million: ");
                while(!sc.hasNextDouble()){
                    System.out.println("Invalid Input. Please enter a number: ");
                    sc.next();
                }
                damages = sc.nextInt();
                attackArray[i].setDamages(damages);

                System.out.println("Enter date of incident in this format Month-Day-Year - MM-dd-yyyy:");
                stringDate = sc.next();
                date=sdf.parse(stringDate);
                attackArray[i].setDate(date);




                sc.nextLine();



                //Set values from input*/



                attackArray[i].setDate(date);



            }


        }


    }
    public void showAttacks() {
        for(int i = 0; i<attackArray.length;i++) {

            if(attackArray[i].getMonsterName() !=null || attackArray[i].getAttackLocation() != null) {
                System.out.println(attackArray[i].toString());
            }




        }
    }

    public void showMenu() {
        System.out.println("Monster Attack Monitor");
        System.out.println(" ");

        System.out.println("1. Report Attacks");
        System.out.println("2. Show Attacks");
        System.out.println("3. Show Damages");
        System.out.println("4. Show Monsters");
        System.out.println("5. Show Earliest Attack");
        System.out.println("6. Quit Program");



    }

    public void showDamages() {


        double damages = 0;


        //Run a loop to get all damages from each attack and add them up, also mean damages
        for(int i=0;i<attackArray.length;i++) {
            double temp = attackArray[i].getDamagesInMillionUSD();
            damages += temp;
        }

        double average = damages/attackArray.length;

        System.out.println("Total damages: $ " + damages + " million.");
        System.out.println("Average location damage: $ " + average + " million.");



    }


    public void showMonsters() {

        LinkedHashMap<String,Integer> monsters = new LinkedHashMap<>();

        for (int i = 0; i < attackArray.length; i++) {
            monsters.put(attackArray[i].getMonsterName(),1);
        }
        ArrayList<String> compare = new ArrayList<>();
        //int array to keep score of attacks
        compare.add(String.valueOf(monsters.keySet()));


        System.out.println(compare);
        }

        public void showEarliestAttack(){
            String earliestAttack;

            for (int i = 0; i < attackArray.length; i++) {
                earliestAttack= attackArray[i].toString();
               if(attackArray[i+1].getDate().compareTo(attackArray[i].getDate())<0){
                   earliestAttack = attackArray[i+1].toString();
               }
                System.out.println(earliestAttack);
            }




        }







        }





























