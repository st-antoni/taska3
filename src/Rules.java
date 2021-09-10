import java.util.Arrays;
import java.util.Scanner;

public class Rules {
    

    public static boolean detectDuplicate(String[] args) {
          
        for(int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if(args[i].equals(args[j])) {
                    System.out.println("Element " + (i + 1) + " and element " + (j + 1) + " are equal");
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkArgumentRules(String[] args){
        if (args.length < 3){
            System.out.println("You should enter 3 or more parameters");
            return false;
        }
        else if (args.length % 2 != 1){
            System.out.println("Parameters quantity should not be equal");
            return false;
        }
        else if (!detectDuplicate(args)){
            System.out.println("Parameters should be different");
            return false;
        }
        return true;
    }
    
    public boolean checkInputRules(int choice, String[] args, int compChoice) {
        if (choice > args.length + 1 || choice < 0) {
            System.out.println("Wrong input :(\nYou shouldEntered elements should be different\nYou should enter number from 0 to  "  + (args.length + 1));
            HelpTable.helpTable(args);
            return false;
        } else if (choice == args.length + 1) {
            HelpTable.helpTable(args);
            return false;
        } else if (choice > args.length / 2) {
            if ((compChoice > choice - args.length / 2 - 1 && (compChoice < choice))) {
                System.out.println("You lost :(");
            } else if (compChoice == choice) {
                System.out.println("It's a tie!");
            } else System.out.println("You won :)");
        } else {
            if ((compChoice <= choice + args.length / 2 && (compChoice >= choice + 1))) {
                System.out.println("You won!");
            } else if (compChoice == choice) {
                System.out.println("It's a tie!");
            } else System.out.println("You lost :(");
        }
        return true;
    }
}
