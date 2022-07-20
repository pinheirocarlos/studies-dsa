package linkedlists;

public class App {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.insert("Carlos");
        names.insert("João");
        names.insert("Maria");
        names.insert("Zé");
        names.insert("Maria2");

        names.traverse();
        names.reverse();
        names.traverse();
        System.out.println();
    }
}
