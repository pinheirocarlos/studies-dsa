package linkedlists;

public class LinkedList<T extends Comparable<T>> implements List<T> {


    /*
    * LinkedLists são estrutura dinâmica, que podem crescer organicamente.
    * Possuem um armazenamento maior que o de arrays, por exemplo, por cada nó ter que armazenar uma referência
    * para o próximo nó.
    * Diferentemente de arrays, que são armazenados sequencialmente na memória, cada nó é armazenado em um local
    * diferente na memória.
    * O tempo de complexidade para armazenamento na primeira posição é O(1)
    * Para buscar item arbitrário é O(N)
    * Se for uma lista encadeada dupla (doubly linked list) o armazenamento em memória eh ainda maior
    * pois além de guardar a referência para o próximo elemento, há também o armazenamento do item anterior
    * Em linkedlist simples há a referência ao primeiro item (head), para lista dupla há para a cauda (tail)
    * */

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
            previousNode = actual;
            actual = actual.getNextNode();
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

    public Node<T> findMiddle(){
        Node<T> current = root;
        Node<T> nextNode = root;

        while (nextNode.getNextNode() != null && nextNode.getNextNode().getNextNode() != null){
            current = current.getNextNode();
            nextNode = nextNode.getNextNode().getNextNode();
        }
        return current;
    }

    @Override
    public void reverse(){
        Node<T> current = root;
        Node<T> previous = null;
        Node<T> next = null;

        while(current.getNextNode()!=null){
            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
        }

        this.root = previous;
    }

    @Override
    public int size() {
        return 0;
    }
}
