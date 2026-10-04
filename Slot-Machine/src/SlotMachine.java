
import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//1.Assign Int
//2.Welcome message
//3.Initial Balance
//4. Slot symbols
//5. Slot mechanics
//6.payout
//RUles
// Playagain

        int input = 0;
        int credit = 100;
        int bet =0;
        System.out.println("Welcome to the Slot Machine");
        while (input < 1 || input > 3) {
            System.out.println("You currently have " + credit + "₹");
            System.out.println("****************************");
            System.out.println("Please Select the Difficulty");
            System.out.println("Enter 1 -> Easy");
            System.out.println("Enter 2 -> Medium");
            System.out.println("Enter 3 -> Hard");

            if (sc.hasNextInt()) {
                input = sc.nextInt();


            } else {
                System.out.println("Please enter a valid Number");
                sc.next();
                continue;
            }
            if (input < 1 || input > 3) {
                System.out.println("Please enter from(1,2,3)");
                continue;
            }
            System.out.println("Please enter Your bet");
            if (sc.hasNextInt()) {
                bet = sc.nextInt();
            } else {
                System.out.println("Please enter a valid Number");
                sc.next();
            }
            while (bet < 10) {
                if (bet <= 0) {
                    System.out.println("please enter a Positive Number");
                    bet = sc.nextInt();}
                else if(bet>0 && bet <10){
                    System.out.println("Minimum 10₹ bet is Required");
                    bet = sc.nextInt();}

                else {
                    break;
                }
            }
            while(bet > credit) {
                System.out.println("Insufficient Credits");
                System.out.println("Please Enter a bet within your balance");
                bet = sc.nextInt();
            }
            credit -= bet;


            String[] Symbol = Difficulty(input);
            String[] slotResult = slot(Symbol);
            System.out.println(String.join(" | ", slotResult));
            int win = Win(slotResult, bet);
            credit += win;
            if (win > 0) {
                System.out.println("You have won " + win + "₹");
                System.out.println("Congrats on your win🎉");
                System.out.println("At this rate you're gonna bankrupt me");
            } else {
                System.out.println("Better luck next time ");
                System.out.println("You Lost " + bet + "₹");
                System.out.println("My pockets are getting heavier");
            }
            System.out.println("Your current Credit Balance is "+ credit);

        }
        }


    public static String[] Difficulty(int input) {
        String[] Symbol = {};
        switch (input) {
            case 1 -> {
                System.out.println("You have selected EASY mode");
                System.out.println("***************************");
                Symbol = new String[]{"🍎", "🍎", "🍋", "🍋", "🍒", "🍒", "🍉", "🍨"};
            }
            case 2 -> {
                System.out.println("You have selected Medium mode");
                System.out.println("******************************");
                Symbol = new String[]{"🍎", "🍎", "🍎",
                                     "🍋", "🍋", "🍋",
                                        "🍒", "🍒", "🍒",
                                        "🍉", "🍉",
                                            "🍨"};
            }
            case 3 -> {
                System.out.println("You have selected Hard mode");
                System.out.println("****************************");
                Symbol = new String[]{"🍎", "🍎", "🍎","🍎","🍎",
                                    "🍋", "🍋", "🍋","🍋"
                                    ,"🍒", "🍒", "🍒",
                                    "🍉", "🍉",
                                    "🍨"};
            }


        }


        return Symbol;
    }

    public static String[] slot(String[] Symbol) {
        int randomm;
        System.out.println("Spinning...");
        Random random = new Random();
        String[] row = new String[3];
        for (int i = 0; i < row.length; i++) {
            randomm = random.nextInt(Symbol.length);
            row[i] = Symbol[randomm];
        }

        return row;
    }

    public static int Win(String[] slotResult, int bet) {
        int win=0;
        if (slotResult[0].equals(slotResult[1])&& slotResult[1].equals(slotResult[2])){
            switch (slotResult[0]){
                case "🍎"-> {win = bet*2;}
                case "🍋"-> {win = bet*3;}
                case "🍒"-> {win = bet*4;}
                case "🍉"-> {win = bet*6;}
                case "🍨"-> {win = bet*10;}
            }
        }else if(slotResult[0].equals(slotResult[1]) || (slotResult[0].equals(slotResult[2])) ){
            switch (slotResult[0]){
                case "🍎"-> {win = bet*2;}
                case "🍋"-> {win = bet*3;}
                case "🍒"-> {win = bet*4;}
                case "🍉"-> {win = bet*6;}
                case "🍨"-> {win = bet*10;}
            }
        }else if(slotResult[1].equals(slotResult[2])){
            switch (slotResult[1]){
                case "🍎"-> {win = bet*2;}
                case "🍋"-> {win = bet*3;}
                case "🍒"-> {win = bet*4;}
                case "🍉"-> {win = bet*6;}
                case "🍨"-> {win = bet*10;}
            }
        }



        return win;
    }


}
