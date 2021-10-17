package com.gdstruc.module5;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Player chicken = new Player( 1, "Chicken", 87);
        Player cornea68 = new Player( 2, "Cornea68", 68);
        Player theChosenOne = new Player( 3, "TheChosenOne", 255);
        Player nullMonster = new Player( 4, "nullmonster", 101);
        Player momKingDad = new Player( 5, "Momkingdad", 238);

        SimpleHashTable hashtable = new SimpleHashTable();
        hashtable.put(chicken.getName(), chicken);
        hashtable.put(cornea68.getName(), cornea68);
        hashtable.put(theChosenOne.getName(), theChosenOne);
        hashtable.put(nullMonster.getName(), nullMonster);
        hashtable.put(momKingDad.getName(), momKingDad);

        // Print hashtable
        System.out.println("\nPRINT OUT THE PLAYER CHICKEN FROM HASHTABLE: ");
        System.out.println(hashtable.get("Chicken"));
        hashtable.printHashtable();
        hashtable.removeKey("Chicken"); // Remove player Chicken

        // Print after removing an element
        System.out.println("\nPRINT OUT THE PLAYER CHICKEN AFTER REMOVING FROM HASHTABLE: ");
        System.out.println(hashtable.get("Chicken"));
        hashtable.printHashtable();
        hashtable.removeKey("Chicken"); // See if player Chicken is still in the hashtable by trying to remove it again
    }
}
