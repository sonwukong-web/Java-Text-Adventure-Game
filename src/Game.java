import java.util.Scanner;

public class Game {
    String playerName;
    String playerWeapon;
    int playerHp;
    int choice;
    Scanner sc= new Scanner(System.in);
    Scanner enterIp = new Scanner(System.in);
    public static void main(String[] args) {
     Game dublin;
     dublin = new Game();

     dublin.playerSetUp();
     dublin.townGate();

    }
    public void playerSetUp()
    {

        playerHp = 10;


        playerWeapon = "Knife";

        System.out.println("Your Hp: " + playerHp);
        System.out.println("Your Weapon : " + playerWeapon);


        System.out.println("Please Enter Your Name:");
        playerName = sc.nextLine();

        System.out.println("\nHello "+playerName+", let's start the game!");
    }

    public void townGate()
    {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("\nYou are at the gate of the town.");
        System.out.println("A guard is standing at the gate.");
        System.out.println("What do you want to do?\n");
        System.out.println("1: Talk to the Guard.");
        System.out.println("2: Attack the guard.");
        System.out.println("3: Leave.");

        choice = sc.nextInt();

        if(choice==1)
        {
            System.out.println("Guard: Hello there stranger! So your name is "+playerName+". Sorry but we cannot let you enter the town.");
            enterIp.nextLine();
            townGate();
        }
        else if(choice==2)
        {
            playerHp--;
            System.out.println("Guard: Hey! Don't be stupid.\nThe Guard hit you so hard and you gave up.\n(You recieved 1 damage!)");
            System.out.println("Your HP: "+playerHp);
            townGate();
        }
        else {

        }



    }

    public void crossRoad()
    {

    }
}