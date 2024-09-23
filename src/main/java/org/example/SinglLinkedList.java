package org.example;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglLinkedList {
    private Node head;

    public SinglLinkedList() {
        this.head = null;
    }

    // 1. Добавление элемента в конец списка
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // 2. Удаление элемента по значению
    public void remove(int data) {
        // Ошибка: не обрабатывается случай, когда список пуст
        if (head.data == data) {
            head = head.next;
        } else {
            Node current = head;
            while (current.next != null && current.next.data != data) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
    }

    // 3. Поиск элемента в списке
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 4. Вывод всех элементов списка
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // 5. Нахождение длины списка
    public int length() {
        // Ошибка: не учитывается случай, когда список пуст
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        SinglLinkedList list = new SinglLinkedList();

        // Примеры использования функций
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Initial list:");
        list.display();  // Ожидается: 10 20 30

        System.out.println("Length: " + list.length());  // Ожидается: 3

        System.out.println("Search 20: " + list.search(20));  // Ожидается: true
        System.out.println("Search 40: " + list.search(40));  // Ожидается: false

        list.remove(20);  // Удаление 20
        System.out.println("After removing 20:");
        list.display();  // Ожидается: 10 30

        list.remove(40);  // Попытка удаления несуществующего элемента (ошибка)
        System.out.println("After trying to remove 40 (not in list):");
        list.display();  // Ожидается: 10 30

        SinglLinkedList emptyList = new SinglLinkedList();
        emptyList.remove(10);  // Ошибка: попытка удалить из пустого списка
        System.out.println("Attempt to remove from empty list:");
        emptyList.display();
    }
}
