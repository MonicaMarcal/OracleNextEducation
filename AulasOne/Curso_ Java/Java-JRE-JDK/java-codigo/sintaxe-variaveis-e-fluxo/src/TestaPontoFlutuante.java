public class TestaPontoFlutuante {
  public static void main(String[] args){

    double salario = 1250.70;

    System.out.println(salario);

    //int valor = 12.5;             //não compila.

    //int valor2 = 0.0;             //não compila.

    //double teste = 125.50;        // compila

    //int valor3 = teste;           //não compila.

    int divisao = 5 / 2; //arredonda a divisão em vez de trazer o resultado correto de 2.5
    System.out.println(divisao);

    double divisaoDois = 5.0 / 2; // Para resolver o problema, coloque em um dos valores da divisão com alguma casa decimal, além de mudar o tipo da variável para double:
    System.out.println(divisaoDois);

}
}
