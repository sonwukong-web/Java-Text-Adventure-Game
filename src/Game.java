import javax.jws.soap.SOAPBinding;
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
            System.out.println("Guard: Hello there stranger! So your name is "+playerName+". \nGuard: Sorry but we cannot let you enter the town.");
            enterIp.nextLine();
            townGate();
        }
        else if(choice==2)
        {
            playerHp--;
            System.out.println("Guard: Hey! Don't be stupid.\nThe Guard hit you so hard and you gave up.\n(You recieved 1 damage!)");
            System.out.println("Your HP: "+playerHp);
            enterIp.nextLine();
            townGate();
        }
        else if(choice==3) {
             crossRoad();
        }
        else {
            townGate();
        }



    }

    public void crossRoad()
    {
       System.out.println("\n-----------------------------------------------------------------\n");
       System.out.println("You are at a cross road. If you go South you will return to the town gate.\n");
       System.out.println("1. Go South.");
       System.out.println("2. Go North.");
       System.out.println("3. Go West.");
       System.out.println("4. Go East.");

       choice = enterIp.nextInt();
       if(choice==1)
       {
           south();
       } else if (choice==2)
       {
          north();
       }
       else if(choice==3)
       {
           west();
       }
       else if(choice==4)
       {
           east();
       }
       else {
           crossRoad();
       }


    }

    public void east()
    {

    }

    public void west()
    {

    }

    public void north()
    {
        System.out.println("\n-----------------------------------------------------------------\n");
        System.out.println("There is water at riverside and you can Drink it.");
        System.out.println("Your Hp is recovered.");
        playerHp++;
        System.out.println("Your HP is: "+playerHp);
        System.out.println();
    }

    public void south()
    {
        townGate();
    }

}