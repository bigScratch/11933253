package com.gdstruc.module3;

import java.util.LinkedList;
import java.util.ListIterator;

public class CardStack {
    private LinkedList<Card> stack;

    public CardStack()
    {
        stack = new LinkedList<Card>();
    }

    public void push(Card card)
    {
        stack.push(card);
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public Card pop()
    {
        return stack.pop();
    }

    public Card peak()
    {
        return stack.peek();
    }

    // Prints CardStack
    public void printStack()
    {
        ListIterator<Card> iterator = stack.listIterator();
        int x = 0;

        if(stack.isEmpty() == false) {x = 1;}

        System.out.println("Current Deck: ");
        while (iterator.hasNext())
        {
            System.out.println(x + ". " + iterator.next());
            x++;
        }
        System.out.println("\n");
    }

    // Counts the CardStack
    public int count()
    {
        int x = 0;
        for(int i = 0; i < stack.size(); i++)
        {
            x++;
        }

        return x;
    }

    // Create and push a random card
    public void createCard(int x)
    {
        // Generate a card based on given value
        if(x == 1) // Create 'King' Card
        {
            stack.push(new Card("King"));
        }
        else if(x == 2) // Create 'Queen' Card
        {
            stack.push(new Card("Queen"));
        }
        else if(x == 3) // Create 'Jester' Card
        {
            stack.push(new Card("Jester"));
        }
        else if(x == 4) // Create 'Knight' Card
        {
            stack.push(new Card("Knight"));
        }
        else if(x == 5) // Create 'Peasant' Card
        {
            stack.push(new Card("Peasant"));
        }
    }
}
