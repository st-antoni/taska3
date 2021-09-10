public class HelpTable {

    public static String findLongest(String[] args){
        int index = 0;
        int elementLength = args[0].length();
        for(int i = 1; i < args.length; i++) {
            if(args[i].length() > elementLength) {
                index = i; elementLength = args[i].length();
            }
        }
        return args[index];
    }

    public static void helpTable(String[] args){

        System.out.print(" ");
        for (int i = 0; i < findLongest(args).length(); i++){
            System.out.print("_");
        }
        for (String arg : args) {
            for (int j = 0; j < arg.length(); j++) {
                System.out.print("_");
            }
            System.out.print("_");
        }

        System.out.print("\n|");
        for (int i = 0; i < findLongest(args).length(); i++){
            System.out.print(" ");
        }
        for (String arg : args) {
            System.out.print("|" + arg);
        }
        System.out.print("|\n|");

        strip(args);

        for (int k = 0; k < args.length; k++){

            System.out.print("\n|" + args[k]);
            for (int i = 0; i < findLongest(args).length() - args[k].length(); i++){
                System.out.print(" ");
            }
            System.out.print("|");
            for (int j = 0; j < args.length; j++) {

                if (j > args.length / 2) {
                    if ((k > j - args.length / 2 - 1 && (k <  j))) {
                        System.out.print("-");
                        for (int i = 0; i < args[j].length() - 1; i++) System.out.print(" ");
                        System.out.print("|");
                    } else if (k == j) {
                        System.out.print("=");
                        for (int i = 0; i < args[j].length() - 1; i++) System.out.print(" ");
                        System.out.print("|");
                    } else {
                        System.out.print("+");
                        for (int i = 0; i < args[j].length() - 1; i++) System.out.print(" ");
                        System.out.print("|");

                    };
                } else {
                    if ((k <= j + args.length / 2 && (k >= j + 1))) {
                        System.out.print("+");
                        for (int i = 0; i < args[j].length() - 1; i++) System.out.print(" ");
                        System.out.print("|");
                    } else if (k == j) {
                        System.out.print("=");
                        for (int i = 0; i < args[j].length() - 1; i++) System.out.print(" ");
                        System.out.print("|");
                    } else {
                        System.out.print("-");
                        for (int i = 0; i < args[j].length() - 1; i++) System.out.print(" ");
                        System.out.print("|");
                    }
                }
            }

            System.out.print("\n|");

            strip(args);

        }
     }

    private static void strip(String[] args) {
        for (int i = 0; i < findLongest(args).length() + 1; i++){
            System.out.print("-");
        }
        for (String arg : args) {
            for (int j = 0; j < arg.length(); j++) {
                System.out.print("-");
            }
            System.out.print("-");
        }
    }
}
