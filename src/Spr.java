import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;



public class Spr {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {

        int choice;
        Scanner in = new Scanner(System.in);
        Rules rules = new Rules();
        Hmac hmac = new Hmac();

        if (!rules.checkArgumentRules(args)){
            return;
        }
        while (true) {
            Random random = new Random();

            int compChoice = random.nextInt(args.length) + 1;

            System.out.println("\nHmac: " + Hmac.bytesToHex(hmac.encrypt(compChoice)));
            System.out.println("\n0. Exit");

            for (int i = 0; i < args.length; i++){
                System.out.println((i + 1) + ". " + args[i]);
            }

            System.out.println((args.length + 1) + ". help\n");

            System.out.print("Your move: ");
            choice = in.nextInt();

            if (choice == 0) break;
            if (!rules.checkInputRules(choice, args, compChoice)) continue;

            System.out.println("\nComputer choice: " + compChoice + "\n");
            System.out.println("Key: " + Hmac.bytesToHex(hmac.getBytes()) + "\n" +
                    "______________________________________");
        }

        in.close();
    }
}
