import java.time.Duration;
import java.time.Instant;

public class TestandoArrays {
    public static void main(String[] args) {
        //Arrays não são dinâmicos, portanto precisamos declarar a quantidade de itens durante inicialização
        //A vantagem do array é que são alocadas posições subsequentes na memória para cada item do array,
        //tornando a busca por índice O(1)
        //Arrays são muito performáticos para busca por index, para incluir e remover itens ao final da lista
        //Caso vc não saiba o index, torna-se uma complexidade linear O(n)
        //Ao remover ou incluir itens no início da lista, deve ser feito um shift dos demais itens, tornando
        //menos performática a operação.
        int[] array = new int[10000000];

        Instant start = Instant.now();
        for (int i=0; i<array.length; i++) {
            array[i] = (int) ((Math.random() * (1000000 - 0)) + 1000000);
        }
        System.out.println( " ");
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Generated new array with " + array.length + " positions in " +
                timeElapsed.toMillis() +" milliseconds");

        start = Instant.now();
        int[] copy = new int[array.length];
        for (int i=0; i<array.length; i++) {
            copy[i] = array[array.length - i - 1];
        }
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Inversed array into a new array in " +
                timeElapsed.toMillis() +" milliseconds");


        //Na forma abaixo fazemos o swap, sem precisar alocar memória para criar um novo array
        //O(N) tempo linear de processamento
        start = Instant.now();
        int lowestIndex = 0;
        int highestIndex = array.length - 1;
        int temp = 0;
        while (lowestIndex < highestIndex) {
            temp = array[lowestIndex];
            array[lowestIndex] = array[highestIndex];
            array[highestIndex] = temp;
            lowestIndex++;
            highestIndex--;
        }
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Inversed array without creating a new one in " +
                timeElapsed.toMillis() +" milliseconds");



    }
}
