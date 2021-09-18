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

    public void printList() {
        int size = 0;
        PlayerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.println(current.getPlayer().getName() + ", Level: " +
                    current.getPlayer().getLevel() + ", ID: " + current.getPlayer().getId());
            System.out.println(" -> ");
            current = current.getNextPlayer();
            size++;
        }
        System.out.println("null\n -> \nSize of List: " + size);
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
