package network_security;
import java.util.Scanner;

public class Network_Security {

    public static void main(String[] args) {

        Substitution sb = new Substitution();
        Transposition tb = new Transposition();

        Scanner user = new Scanner(System.in);
        String message;

        System.out.println("Enter the Message for Encryption : ");
        message = user.nextLine();
        System.out.println("Enter the Secreate Key (Int) : ");
        int key = user.nextInt();

        System.out.println("Message : " + message);
       
        System.out.println("-----------Round 1 Encryption-----------\n");
        String subLevel1 = sb.substitutionLevelOne(message);
        System.out.println("Round 1 Substition : " + subLevel1);
        String tbLevel01 = tb.transposeLevelOne(subLevel1);
        System.out.println("Round 1 Transposition : " + tbLevel01);

        System.out.println("\n-----------Round 2 Encryption-----------\n");
        String subLevel2 = sb.substitutionLevelTwo(tbLevel01);
        System.out.println("Round 2 Substition : " + subLevel2);
        String tbLevel02 = tb.unTransposeLevelTwo(key, subLevel2);
        System.out.println("Round 2 Transposition : " + tbLevel02);

        System.out.println("\n-----------Round 1 Decryption-----------\n");
        String utbLevel01 = tb.TransposeLevelTwo(key, tbLevel02);
        System.out.println("Round 1 Untransposition : " + utbLevel01);
        String usbLevel01 = sb.unsubstitutionLevelTwo(utbLevel01);
        System.out.println("Round 1 Unsubstition : " + utbLevel01);
        
         System.out.println("\n-----------Round 2 Decryption-----------\n");
        String utbLevel02 = tb.untransposeLevelOne(usbLevel01);
        System.out.println("Round 2 Untransposition : " + utbLevel02);
        String usbLevel02 = sb.unsubstitutionLevelOne(utbLevel02);
        System.out.println("Round 2 Unsubstition : " + usbLevel02);

        System.out.println("\n-----------Result----------\n");
        System.out.println(usbLevel02);
        
        if(message == null ? usbLevel02 == null : message.equals(usbLevel02)){
            System.out.println("Matching Successfully!");
        }

    }
}
