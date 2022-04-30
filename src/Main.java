
import java.util.Random;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
    Scanner in = new Scanner(System.in);
	Random rnd = new Random();
    int crapsRoll;
    int point;
    int pointRoll;
    boolean reroll = true;
    boolean replay= false;
    String playAgain;
    do
    {
        int die1 = rnd.nextInt(6)+ 1;
        int die2 = rnd.nextInt(6)+ 1;
        crapsRoll = die1 + die2;
        System.out.println("You rolled a " + crapsRoll +" ("+die1+","+die2+")");
        if (crapsRoll ==2 || crapsRoll == 3 || crapsRoll == 12)
        {
            System.out.println("You have crapped out with a rolls of: " + crapsRoll);
            System.out.println("Do you want to play again [Y/N]: ");
            playAgain = in.nextLine();
            if (playAgain.equalsIgnoreCase("n"))
            {
                replay = true;
            }

        }
        else if (crapsRoll == 7 || crapsRoll == 11)
        {
            System.out.println("You have won with a natural of: " +crapsRoll );
            System.out.println("Do you want to play again [Y/N]:");
            playAgain = in.nextLine();
            if (playAgain.equalsIgnoreCase("n"))
            {
                replay = true;
            }
        }
        else {
            point = crapsRoll;
            System.out.println("Your point sum is: "+ point);
            while (reroll) {
                die1 = rnd.nextInt(6) + 1;
                die2 = rnd.nextInt(6) + 1;
                pointRoll = die1 + die2;
                System.out.println("You rolled: " + pointRoll +" (" + die1 + "," +die2 + ")");
                if (pointRoll == point) {
                    System.out.println("You have won by making point.");
                    reroll = false;

                } else if (pointRoll == 7) {
                    System.out.println("You got a Seven and lost.");
                    reroll = false;

                }
            }

            System.out.println("Do you want to play again [Y/N]: ");
            playAgain = in.nextLine();
            if (playAgain.equalsIgnoreCase("n")) {
                replay = true;
            }
            else
            {
                reroll = true;
            }
        }
    } while (!replay);
    }
}
