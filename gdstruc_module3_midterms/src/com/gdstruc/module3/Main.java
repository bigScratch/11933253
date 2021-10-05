package com.gdstruc.module3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scan for pausing console
        Scanner scan = new Scanner(System.in);

        // Create deck for player
        CardStack stack = new CardStack();

        // Create pile for discarded cards
        CardStack pile = new CardStack();

        // Create a random generator
        Random randVal = new Random();

        // Create initial deck of 30 cards
        for(int i = 0; i < 30; i ++)
        {
            // Generate a card based on given value
            int x = 1 + randVal.nextInt(5);
            stack.createCard(x);
        }

        // Print out the stack first before running while loop
        stack.printStack();

        // Pause program before running more code
        System.out.print("Press any key to continue . . . ");
        scan.nextLine();

        // While loop
        while(stack.isEmpty() == false)
        {
            // Flush System
            System.out.flush();

            System.out.println("\n=== Randomly Choosing Turn... ===");

            System.out.print("Press any key to continue . . . ");
            scan.nextLine();

            int randomTurn = 1 + randVal.nextInt(3); // For random turns
            int x = 1 + randVal.nextInt(5); // For random value for each command

            // Do 1 of 3 functions
            if(randomTurn == 1) // Draw cards
            {
                drawCard(x, randVal, stack);
            }
            else if(randomTurn == 2) // Discard cards
            {
                discardCard(x, randVal, stack, pile);
                if(stack.count() == 0) {break;}
            }
            else if(randomTurn == 3) // Get cards from discarded pile
            {
                int y = 0;

                // If pile is not empty draw from pile, otherwise generate random number for drawCard and discardCard
                if (pile.count() >= x) // Draw from pile
                {
                    drawPile(x, randVal, stack, pile);
                }
                else if (pile.count() < x && pile.count() != 0) // Set x = discard pile before drawing from pile
                {
                    x = pile.count();
                    drawPile(x, randVal, stack, pile);
                }
                else // Else do either of the remaining functions
                {
                    y = 1 + randVal.nextInt(2);
                }

                // Do either functions if pile is less than x
                if(y == 1)
                {
                    drawCard(x, randVal, stack);
                }
                else if (y == 2)
                {
                    discardCard(x, randVal, stack, pile);
                    if(stack.count() == 0) {break;}
                }
            }

            // Pause program before running more code
            System.out.print("Press any key to continue . . . ");
            scan.nextLine();

            // Show info on Player deck, number of remaining cards in stack and discard pile
            System.out.println("\n=== PLAYER DECK ===");
            stack.printStack();

            System.out.println("=== CARD COUNT ====\n [PLAYER DECK]: " + stack.count());
            System.out.println("\n [DISCARDED PILE]: " + pile.count());

            System.out.print("Press any key to continue . . . ");
            scan.nextLine();
        }

        // Show total cards in discard pile before exiting program
        System.out.println("\n=== NO MORE CARDS!! ===");
        System.out.println("[TOTAL DISCARDED PILE]: " + pile.count());
        System.out.println("[REMAINING CARDS IN PLAYER DECK]: " + stack.count());
    }

    public static void drawCard(int x, Random randVal, CardStack stack)
    {
        System.out.println("\n=== DRAW " + x + " CARDS! ===");
        System.out.println("[REMAINING PLAYER CARDS: " + (stack.count() + x) + "]");

        for(int i = 0; i < x; i++)
        {
            // Generate a card based on given value
            int y = 1 + randVal.nextInt(5);
            stack.createCard(x);
        }
    }

    public static void discardCard(int x, Random randVal, CardStack stack, CardStack pile)
    {
        // If x is greater than stack, set value to stack count. Else, triple x to be discarded;
        if(x > stack.count())
        {
            x = stack.count();
        }
        else
        {
            x = x * 3;

            if(x > stack.count())
            {
                x = stack.count();
            }
        }

        System.out.println("\n=== DISCARD " + x + " CARDS! ===");
        System.out.println("[REMAINING PLAYER CARDS: " + (stack.count() - x) + "]");

        for(int i = 0; i < x; i++)
        {
            // Push cards to pile which will be popped
            pile.push(stack.pop());
        }
    }


    public static void drawPile(int x, Random randVal, CardStack stack,  CardStack pile)
    {
        System.out.println("\n=== DRAW " + x + " CARDS FROM DISCARDED PILE! CARDS ADDED TO PLAYER DECK ===");
        System.out.println("[REMAINING PLAYER CARDS: " + (stack.count() + x) + "]");

        for(int i = 0; i < x; i++)
        {
            // Push cards to stack from discard pile, then pop cards from pile
            stack.push(pile.pop());
        }
    }
}
