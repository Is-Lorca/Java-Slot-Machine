import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
public class main {
    static Scanner scanner = new Scanner(System.in, "UTF-8");
    static Random random = new Random();
    public static void main(String[] args) throws InterruptedException, IOException{
        //variables
        String anykey;
        String[] row;
        int balance, bet, payout;
        boolean playing = true;
        
        //welcome message
        welcome();

        //enter balance
        balance = balance();
        do{
            //enter bet amount
            System.out.printf("\nBalance: $%,d\n", balance);
            bet = bet(balance);
            
            scanner.nextLine(); //clear the buffer
            //subtract bet from balance
            balance -= bet;
            clearScreen();

            System.out.printf("Balance: %,d", balance);
            System.out.printf("\nBet: %,d\n", bet);
            System.out.println("Press any key and Enter to pull the lever!");
            anykey = scanner.nextLine().trim();

            //spin row
            row = spinRow();
            System.out.println();
            //print row
            for(String symbol: row){
                System.out.print("|  " + symbol + "  |");
                Thread.sleep(1000);
            }


            //get payout (add at balance)
            payout = getPayout(row, bet);
            if (payout>0){
                System.out.println("\n\nYou won!");
                balance += payout;
                System.out.printf("New balance: %,d\n", balance);
            }
            else{
                System.out.println("\n\nNo prize, boo hoo!");
            }

            //ask play again
            System.out.println("\n\nDo you want to play again? (Y/N)");
            playing = scanner.nextLine().trim().toUpperCase().contains("Y");

            clearScreen();
            //check the balance, if 0 asks to put more credit
            if(balance == 0){
                System.out.println("Your balance is zero, would you like to add more credit? (Y/N)");
                boolean answer = scanner.nextLine().trim().toUpperCase().contains("Y");
                System.out.println();
                //check if the user want to put more credit, if not, the program ends
                if(answer){
                    balance = balance();
                }
                else{
                    System.out.println("Sorry, you need to put more credit to continue playing.");
                    System.out.println("Try again later.\n");
                    System.out.println("Press any key then Enter to exit.");
                    anykey = scanner.nextLine();
                    playing = false;
                }
            }

        }while(playing);
        clearScreen();
        //goodbye message
        System.out.println("Thank you for playing, until next time!");
        System.out.printf("Final balance: %,d\n", balance);
    }

    static void clearScreen() throws InterruptedException, IOException{
        //variables
        //get the OS
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")){
            //for Windows:
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        else{
            //for Linux or macOS
            new ProcessBuilder("sh", "-c","clear").inheritIO().start().waitFor();
        }
    }
    static void welcome(){
        String name = "Slot Machine", payout = "Payouts:";
        System.out.println("=".repeat(40));
        System.out.printf("%25s\n", name);
        System.out.println("=".repeat(40));
        System.out.printf("%23s\n\n", payout);
        System.out.println("🌩️ : Double -> 2 Triple -> 3\n🌧️ : Double -> 3 Triple -> 4");
        System.out.println("🌦️ : Double -> 4 Triple -> 5\n⛅: Double -> 5 Triple -> 10");
        System.out.println("☀️ : Double -> 10 Triple -> 20");
        System.out.println("-".repeat(40));
        System.out.println();
    }
    static int balance(){
        int balance;
        do{
            System.out.print("Enter your balance to start playing: ");
            balance = scanner.nextInt();
            if(balance <= 0){
                System.out.println("\nInvalid number, put an amount above 0.");
            }
        //repeat if balance <= 0
        }while(balance <= 0);
        return balance;
    }
    static int bet(int balance){
        int bet;
        do{
            System.out.print("Enter your bet: ");
            bet = scanner.nextInt();
            //if bet > balance --> don't play
            if(bet> balance){
                System.out.println("\nThis bet is over your balance.");
                System.out.println("Please, put a valid value.");
                System.out.printf("Your current balance: $%,d\n\n", balance);
            }
            //if bet < 0 --> don't play
            if(bet<= 0){
                System.out.println("\nYou cannot enter a value equal to or less than zero.");
                System.out.println("Please, put a valid value.\n");
            }
        }while(bet > balance || bet <= 0);
        return bet;
    }
    static String[] spinRow(){
        //variables
        String[] symbols={"🌩️","🌧️","🌦️","⛅","☀️"};
        String[] row = new String[3];

        for(int i = 0; i < row.length; i++){
            row[i] = symbols[random.nextInt(0, symbols.length)];
        }
        
        return row;
    }
    static int getPayout(String[] row, int bet){
        if(row[0].equals(row[1])&&row[1].equals(row[2])){
            return switch(row[0]){
                case "🌩️" -> bet * 3;
                case "🌧️" -> bet * 4;
                case "🌦️" -> bet * 5;
                case "⛅" -> bet * 10;
                case "☀️" -> bet * 20;
                default -> bet * 0;
            };
        }
        else if(row[0].equals(row[1])){
            return switch(row[0]){
                case "🌩️" -> bet * 2;
                case "🌧️" -> bet * 3;
                case "🌦️" -> bet * 4;
                case "⛅" -> bet * 5;
                case "☀️" -> bet * 10;
                default -> bet * 0;
            };
        }
        else if(row[1].equals(row[2])){
             return switch(row[1]){
                case "🌩️" -> bet * 2;
                case "🌧️" -> bet * 3;
                case "🌦️" -> bet * 4;
                case "⛅" -> bet * 5;
                case "☀️" -> bet * 10;
                default -> bet * 0;
            };
        }
        else if(row[0].equals(row[2])){
            return switch(row[0]){
                case "🌩️" -> bet * 2;
                case "🌧️" -> bet * 3;
                case "🌦️" -> bet * 4;
                case "⛅" -> bet * 5;
                case "☀️" -> bet * 10;
                default -> bet * 0;
            };
        }

        return 0;
    }
}