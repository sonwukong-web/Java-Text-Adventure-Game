import java.util.Scanner;

public class Game {
    String playerName;
    String playerWeapon;
    int playerHp;
    int monsterHp;
    int choice;
    int playerDamage=0;
    //int weaponDamage;
    int monsterDamage=0;
    int silverRing =0 ;
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
        monsterHp = 15;


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
            if(silverRing==1)
            {
                ending();
            }
            else {
                System.out.println("Guard: Hello there stranger! So your name is "+playerName+". \nGuard: Sorry but we cannot let you enter the town.");
                enterIp.nextLine();
                townGate();
            }

        }
        else if(choice==2)
        {
            playerHp--;
            System.out.println("Guard: Hey! Don't be stupid.\nThe Guard hit you so hard and you gave up.\n(You received 1 damage!)");
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
        System.out.println("\n-----------------------------------------------------------------\n");
        System.out.println("You came across a forest.");
        System.out.println("You obtained a Long Sword.");
        playerWeapon = "Long Sword";
        System.out.println("Your Current weapon is "+playerWeapon);
        System.out.println("1: Go back to cross road.");
        System.out.println("\n-----------------------------------------------------------------\n");
        choice = enterIp.nextInt();
        if(choice==1)
        {
            crossRoad();
        }
        else {
            east();
        }
    }

    public void west()
    {
        System.out.println("\n-----------------------------------------------------------------\n");
        System.out.println("You Encounter a Goblin!");
        System.out.println("1: Fight!!!");
        System.out.println("2: Run!");
        System.out.println("\n-----------------------------------------------------------------\n");
         choice = enterIp.nextInt();

         if(choice==1)
         {
             fight();
         }
         else if(choice==2)
         {
             crossRoad();
         }
         else {
             west();
         }
    }

    public void north()
    {
        System.out.println("\n-----------------------------------------------------------------\n");
        System.out.println("There is water at riverside and you can Drink it.");
        System.out.println("Your Hp is recovered.");
        playerHp++;
        System.out.println("Your HP is: "+playerHp);
        System.out.println("1: Go back to cross road. ");
        choice = enterIp.nextInt();
        crossRoad();
    }

    public void south()
    {
        townGate();
    }

    public void fight()
    {
        System.out.println("\n-----------------------------------------------------------------\n");
        System.out.println("Your Hp: "+playerHp);
        System.out.println("Monster HP: "+monsterHp);
        System.out.println("1: Attack");
        System.out.println("2: Run");
        System.out.println("\n-----------------------------------------------------------------\n");
        choice = enterIp.nextInt();
        if(choice==1)
        {
            attack();
        }
        else if(choice==2)
        {
            crossRoad();
        }
        else {
            fight();
        }
    }

    public void attack()
    {
        if(playerWeapon.equalsIgnoreCase("Knife"))
        {
            playerDamage = new java.util.Random().nextInt(5);
        }
        else if(playerWeapon.equalsIgnoreCase("Long Sword"))
        {
            playerDamage = new java.util.Random().nextInt(8);
        }
        System.out.println("You attacked the Monster and gave "+playerDamage+" damage.");
        monsterHp-=playerDamage;

        System.out.println("Monster Hp is "+monsterHp);

        if(monsterHp<1)
        {
            win();
        }
        else {
            monsterDamage = new java.util.Random().nextInt(4);
            System.out.println("The monster attacked you and gave you "+monsterDamage+" damage.");
            playerHp-=monsterDamage;
            if(playerHp<1)
            {
                dead();
            }
            else {
                fight();
            }
        }



    }
    public void dead()
    {
        System.out.println("\n-----------------------------------------------------------------\n");
        System.out.println("You are dead.");
        System.out.println("Gave Over!!!");
        System.out.println("\n-----------------------------------------------------------------\n");

    }

    public void win()
    {
        System.out.println("\n-----------------------------------------------------------------\n");
        System.out.println("You Killed the Monster!!");
        System.out.println("Monster dropped a ring!");
        System.out.println("You obtained a Silver Ring.");
        System.out.println("1. Go East.");
        System.out.println("\n-----------------------------------------------------------------\n");
        silverRing=1;
        choice = enterIp.nextInt();
        if(choice==1)
        {
            crossRoad();
        }
        else {
            win();
        }



    }
   public void  ending()
    {
        System.out.println("\n-----------------------------------------------------------------\n");
        System.out.println("Guard: Oh! You killed the Goblin!");
        System.out.println("Guard: It seems you are trust worthy guy after all. Welcome to our town.");
        System.out.println("\n                          The END                                \n");
        System.out.println("\n-----------------------------------------------------------------\n");

    }

}