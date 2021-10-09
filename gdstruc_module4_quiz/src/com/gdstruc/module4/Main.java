package com.gdstruc.module4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Create a random generator
        Random randVal = new Random();

        // Create a scanner for user-input
        Scanner scanner = new Scanner(System.in);

        // Create ArrayQueue
        ArrayQueue queue = new ArrayQueue(5);
        
        // Create an int array for games
        int[] games = new int[1];
        games [0] = 0;

        // Do loop and stop after 10 games have been made
        while (games[0] < 10)
        {
            // Add players
            create(randVal, queue);
            next(scanner);

            // Start a game and pop players if 5 or more in queue
            start(queue, games);
            next(scanner);

            // Check players in queue;
            checkSize(queue, games);
            next(scanner);
        }

        // Show total cards in discard pile before exiting program
        System.out.println("\n=== GAMES: 10/10 - FULL - ===");
        System.out.println("\nExiting program now. . .");
    }

    public static void create(Random randVal, ArrayQueue queue) {
        int rand = 0;
        int rand2 = 1 + randVal.nextInt(7);

        System.out.println("\n" + rand2 + " players have joined the queue!");

        for (int i = 0; i < rand2; i++) {

            rand = 1 + randVal.nextInt(5);

            switch (rand) {

                case 1:
                    queue.add(new Player(1, "comma", 26));
                    break;
                case 2:
                    queue.add(new Player(2, "NewArrk", 4));
                    break;
                case 3:
                    queue.add(new Player(3, "VovaMint", 211));
                    break;
                case 4:
                    queue.add(new Player(4, "PutridExec", 67));
                    break;
                case 5:
                    queue.add(new Player(5, "Dieshine", 101));
                    break;
            }
        }
    }

    public static void start(ArrayQueue queue, int[] games) {
        if (queue.size() >= 5) {

            System.out.println("\n[5 Players have been found, moving them to a match. . .]");

            for (int i = 0; i < 5; i++) {
                queue.remove();
            }
            games[0] = games[0] + 1;
        } else {
            System.out.println("\n[Not enough players to start a match, searching. . .]");
        }
    }

    public static void checkSize(ArrayQueue queue, int[] games) {
        System.out.println("\n=== PLAYERS IN QUEUE: " + queue.size() + " ===");
        System.out.println("=== ONGOING GAMES: " + games[0] + "/10 ===");
    }

    public static void next(Scanner scan) {
        System.out.print("Press enter to continue . . . ");
        scan.nextLine();
    }
}
