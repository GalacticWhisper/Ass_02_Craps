import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        int die1 = 1;
        int die2 = 2;
        int dieTotal = die1 + die2;
        int diePoint = 0;
        int rollNum = 0;
        String YN;
        boolean pointActiveDone = false;
        boolean done = false;

        System.out.println("~~~~~~~~~~Craps Game~~~~~~~~~~");
        System.out.println(" ");
        System.out.println("Roll:            Die1 Die2 Sum");
        System.out.println("______________________________");

        do // Everything within this Do While loop is part of the Craps Game. Once [done] becomes true, the program will end.
        {
            pointActiveDone = false;
            rollNum = 0;
            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            dieTotal = die1 + die2;
            rollNum++;

            System.out.printf("Roll: %-5d %8d %4d %4d\n", rollNum, die1, die2, dieTotal);

            if(dieTotal == 2 || dieTotal == 3 || dieTotal == 12)
            {
                System.out.println("Craps... You lose.");
                System.out.println("Play again? [Y/N]: ");
                YN = in.nextLine();
                switch (YN)
                {
                    case "Y":
                    case "y":
                        rollNum = 0;
                        break;
                    case "N":
                    case "n":
                        done = true;
                        break;
                    default:
                        done = true;
                }

            }
            else if(dieTotal == 7 || dieTotal == 11)
            {
                System.out.println("Natural! You win!");
                System.out.println("Play again? [Y/N]: ");
                YN = in.nextLine();
                switch (YN)
                {
                    case "Y":
                    case "y":
                        rollNum = 0;
                        break;
                    case "N":
                    case "n":
                        done = true;
                        break;
                    default:
                        done = true;
                }
            }
            else
            {
                diePoint = dieTotal;
                do
                {
                    System.out.println("Your point is now " + diePoint + ".");
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    dieTotal = die1 + die2;
                    rollNum++;

                    System.out.printf("Roll: %-5d %8d %4d %4d\n", rollNum, die1, die2, dieTotal);

                    if(dieTotal == 7)
                    {
                        System.out.println("7... You lose.");
                        System.out.println("Play again? [Y/N]: ");
                        YN = in.nextLine();
                        switch (YN)
                        {
                            case "Y":
                            case "y":
                                pointActiveDone = true;
                                break;
                            case "N":
                            case "n":
                                pointActiveDone = true;
                                done = true;
                                break;
                            default:
                                pointActiveDone = true;
                                done = true;
                        }
                    }
                    else if (dieTotal == diePoint)
                    {
                        System.out.println("Rolled point! You win!");
                        System.out.println("Play again? [Y/N]: ");
                        YN = in.nextLine();
                        switch (YN)
                        {
                            case "Y":
                            case "y":
                                pointActiveDone = true;
                                break;
                            case "N":
                            case "n":
                                pointActiveDone = true;
                                done = true;
                                break;
                            default:
                                pointActiveDone = true;
                                done = true;
                        }
                    }
                    else
                    {
                        diePoint = dieTotal;
                    }
                } while(!pointActiveDone);
            }
        } while(!done);
    }
}