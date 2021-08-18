public class MainQueue {

    static class Node {
        int data;
        Node link;
    }

    static class Queue {
        Node front, rear;
    }

    static void addQueue(Queue q, int value) {
        Node temp = new Node();
        temp.data = value;
        if (q.front == null) {
            q.front = temp;
        } else {
            q.rear.link = temp;
        }
        q.rear = temp;
        q.rear.link = q.front;
    }

    static int deleteQueue(Queue q) {
        if (q.front == null) {
            System.out.printf("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int value;
        if (q.front == q.rear) {
            value = q.front.data;
            q.front = null;
            q.rear = null;
        } else {
            Node temp = q.front;
            value = temp.data;
            q.front = q.front.link;
            q.rear.link = q.front;
        }
        return value;
    }

    static void displayQueue(Queue q) {
        Node temp = q.front;
        System.out.printf("Elements in Circular Queue are:");
        while (temp.link != q.front) {
            System.out.printf("%d ", temp.data);
            temp = temp.link;
        }
        System.out.printf("%d ", temp.data);
    }

    public static void main(String args[]) {
        Queue q = new Queue();
        q.front = q.rear = null;

        addQueue(q, 14);
        addQueue(q, 22);
        addQueue(q, 30);

        displayQueue(q);

        System.out.printf("Deleted value = % d \n", deleteQueue(q));
        System.out.printf("Deleted value = % d \n", deleteQueue(q));

        displayQueue(q);

        addQueue(q, 9);
        addQueue(q, 1996);
        displayQueue(q);
    }
}
