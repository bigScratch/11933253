package com.gdstruc.module2;

import java.util.Objects;

public class PlayerLinkedList {
    private PlayerNode head;

    public void addToFront(Player player)
    {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        head = playerNode;
    }

    public void remove()
    {
        PlayerNode playerNode = head; // set current node to head
        head = head.getNextPlayer(); // skip head to next node on the list
        playerNode = null; // delete current node
    }

    public int count()
    {
        int x = 0;
        PlayerNode current = head;
        while (current != null) {
            current = current.getNextPlayer();
            x++;
        }
        return x;
    }

    public boolean contains(Player player) {
        boolean itExists = false;
        PlayerNode current = head;
        while (current != null) {
            if(current.getPlayer().equals(player)) {
                itExists = true;
                break;
            }
            else {
                current = current.getNextPlayer();
            }
        }
        return itExists;
    }

    /*public void indexOf(Player player) {
        int index = 0;
        boolean itExists = false;
        PlayerNode current = head;
        while (current != null) {
            if(current.getPlayer().equals(player)) {
                break;
            }
            else {
                index++;
                current = current.getNextPlayer();
            }
        }
        if(current.getPlayer().equals(player) && current != null) {
            System.out.println("Index position: " + index);
        } else if (current == null) {
            System.out.println("Does not exist, unable to find index.");
        }
    }*/

    public void indexOf(Player player) {
        int index = 0;
        boolean itExists = false;
        PlayerNode current = head;
        while (current != null) {
            if(current.getPlayer().equals(player)) {
                itExists = true;
                break;
            }
            else {
                index++;
                current = current.getNextPlayer();
            }
        }
        if(itExists != true) {
            System.out.println("Does not exist.");
        } else {
            System.out.println("Position of Index: " + index);
        }
    }

    public void printList() {
        PlayerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.println(current.getPlayer().getName() + ", Level: " +
                    current.getPlayer().getLevel() + ", ID: " + current.getPlayer().getId());
            System.out.println(" -> ");
            current = current.getNextPlayer();
        }
        System.out.println("null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerLinkedList that = (PlayerLinkedList) o;
        return Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head);
    }
}
