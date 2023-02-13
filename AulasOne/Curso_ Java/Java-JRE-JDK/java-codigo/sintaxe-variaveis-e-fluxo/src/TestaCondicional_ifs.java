/*
programa sobre Imposto de Renda (IR),regras de alíquota:

De 1900.0 até 2800.0, o IR é de 7.5% e pode deduzir na declaração o valor de R$ 142
De 2800.01 até 3751.0, o IR é de 15% e pode deduzir R$ 350
De 3751.01 até 4664.00, o IR é de 22.5% e pode deduzir R$ 636
*/

public class TestaCondicional_ifs {
  public static void main(String[] args) {
    double salario = 3300;
    if(salario >= 1900.0 && salario <= 2800.0){
      System.out.println("A sua aliquota é de 7,5%");
      System.out.println("Você pode deduzir até R$ 142");
    }else if(salario >= 2800.01 && salario<= 3751.0){
      System.out.println("A sua aliquota é de 15%");
      System.out.println("Você pode deduzir até R$ 350");
    }else if(salario >= 3751.01 && salario <= 4664.00 ){
      System.out.println("A sua aliquota é de 22.5%");
      System.out.println("Você pode deduzir até R$ 636");
    }else{
      System.out.println("Seu salario precisa estar entre '1900.0' á '4664.00' para verificar seu IR");
    }   
  }
}
