package linkedlists;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int numOfItems;

    @Override
    public void insert(T data) {
        //first item on the linked list
        if (root == null) {
            root = new Node<>(data);
        } else {
            insertAtBeginning(data);
        }
    }

    private void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        root = newNode;
    }

    //sempre começamos a buscar pelo nó root, então para chegar até o último nó, será O(N) tempo de processmento
    private void insertAtEnd(T data, Node<T> node) {
        if (node.getNextNode() != null) {
            insertAtEnd(data, node.getNextNode());
        } else {
            //We have found the last item
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void remove(T data) {
        if (root == null) return;

        //verificar se não vai remover o nó root
        if (root.getData().compareTo(data) == 0) {
            root = root.getNextNode();
        } else{
            remove(data, root, root.getNextNode());
        }
    }

    private void remove(T data, Node<T> previousNode, Node<T> actual) {
        //Achar o nó que vamos remover
        while (actual != null){
            if(actual.getData().compareTo(data) == 0){
                //atualizo as referencias
                numOfItems--;
                previousNode.setNextNode(actual.getNextNode());
                actual = null;
                return;
            }
        }

    }

    @Override
    public void traverse() {
        if (root == null) return;
        Node<T> actualNode = root;
        while (actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return 0;
    }
}
