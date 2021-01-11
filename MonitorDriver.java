import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class MonitorDriver {



    public static void main(String[] args) throws ParseException {


        AttackMonitor testMonitor = new AttackMonitor();

        int input=0;

        do {

            //create a scanner to receive user input
            Scanner sc = new Scanner(System.in);
            testMonitor.showMenu();
            input = sc.nextInt();
            while(input <1 || input >6) {
                System.out.println("Enter a menu option from 1 to 6: ");
                input = sc.nextInt();
            }
            switch(input) {
                case 1:
                    testMonitor.reportAttacks();

                    break;
                case 2:
                    if(testMonitor.attackArray ==null){
                        System.out.println("There are no attacks in the system. Choose Option 1 to report an attack:");
                       break;
                    }
                    else{
                        testMonitor.showAttacks();
                        System.out.println(" ");
                        break;
                    }

                case 3:
                    if(testMonitor.attackArray ==null) {
                        System.out.println("There are no attacks in the system. Choose Option 1 to report an attack:");
                        break;
                    }
                    testMonitor.showDamages();
                    System.out.println(" ");
                    break;

                case 4:
                    if(testMonitor.attackArray ==null) {
                        System.out.println("There are no attacks in the system. Choose Option 1 to report an attack:");
                        break;
                    }
                    testMonitor.showMonsters();
                    break;
                case 5:
                    if(testMonitor.attackArray ==null) {
                        System.out.println("There are no attacks in the system. Choose Option 1 to report an attack:");
                        break;
                    }
                    testMonitor.showEarliestAttack();
                    break;



            }//End of Switch statement








    }while(input !=6);


}}
