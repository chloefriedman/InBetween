//--------------------------------------------------------------------
// HigherLower.java         by Dale/Joyce/Weems              Chapter 6
//
// Plays Higher or Lower? with user through command line interface. 
//--------------------------------------------------------------------
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HigherLower 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to HigherLower! Here are the rules of the game: ");
        System.out.println();
        System.out.println("You start with a certain number of chips called the stake. You must risk one or more chips each round before seeing any cards\nAs long as there are still 3 cards or more in the deck (enough for a hand) the game continues\n Two cards will be dealt face up, and one face down.\nIf the two cards are the same, the player automatically wins. If the two cards are 1 apart, the player automatically loses. ");
        System.out.println();
        boolean worked = false;
        boolean wantToPlay = true;
        while(!worked)
        {
            System.out.println("Ready to play? Respond true or false");
            try
            {
                wantToPlay = sc.nextBoolean();
                worked = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("That is not true or false, try again");
                worked = false;
                sc.next();
            }
        }
        while(wantToPlay)
        {
            System.out.println("How much money do you want in your bank?");
            double bank = sc.nextDouble();
            System.out.println("How much do you want to bet? ");
            double bet = sc.nextDouble();
            while(bank < bet)
            {
                System.out.println("You cannot bet more than you have");
                System.out.println("How much do you want to bet? ");
                bet = sc.nextDouble();
            }
            CardDeck c = new CardDeck();
            c.shuffle();
            System.out.println("Card 1: ");
            if(c.hasNextCard() == false)
            {
                c = new CardDeck();
            }
            Card c1 = c.nextCard();
            System.out.println(c1);
            if(c.hasNextCard() == false)
            {
                c = new CardDeck();
            }
            Card c2 = c.nextCard();
            System.out.println("Card 2: ");
            System.out.println(c2);
            System.out.println();
            if(c2.compareTo(c1) == 0)
            {
                System.out.println("You win!");
                bank = bank + bet;
                System.out.println("Current bank: " + bank);
            }
            else
            {
                if(bet*2 <= bank)
                {
                    boolean a = false;
                    while(!a)
                    {
                        try
                        {
                            System.out.println("Do you want to double your bet? Respond with true or false");
                            a = sc.nextBoolean();
                            worked = true;
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("That is not true or false, try again");
                            a = false;
                            sc.next();
                        }
                    }
                }
                    String choice = "";
                    boolean b = false;
                    while(!b)
                    {
                        try
                        {
                            System.out.println("Inside or outside? ");
                            choice = sc.nextLine();
                            if(choice.equalsIgnoreCase("inside") || choice.equalsIgnoreCase("outside"))
                            {
                                b = true;
                            }
                            else
                            {
                                System.out.println("That wasn't inside or outside. Try again.");
                            }
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("That is not a valid input. Try again");
                            b = false;
                            sc.next();
                        }
                    }

            }
    
 
 

 
    }
}}