package arrays;

public class InvertendoIntegers {

    public static void main(String[] args) {
        System.out.println(solve(1234));
    }

    public static int solve(int value){
        int invertido = 0;
        int resto = 0;

        //Tempo de complexidade linear O(N), pois as iterações acontecem de acordo com a quntidade de números
        //Para inverter qualquer número natural basta seguir os passos abaixo,
        // obter o resto da divisão por 10
        // dividir o valor por 10 e em seguida o primeiro número invertido é = invertido * 10 + resto
        while(value > 0){
            resto = value % 10;
            value = value / 10;
            invertido = invertido * 10 + resto;
        }
        return invertido;
    }
}
