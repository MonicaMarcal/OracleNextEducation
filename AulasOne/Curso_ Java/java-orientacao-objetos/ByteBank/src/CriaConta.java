public class CriaConta {
  public static void main(String[] args) {
    Conta primeiraConta = new Conta(); //instancia a classe Conta
    primeiraConta.saldo = 200; //adiciciona 200 no objeto
    System.out.println(primeiraConta.saldo); 

    primeiraConta.saldo += 100; //vale o que ele já tem + 100
    System.out.println(primeiraConta.saldo);

    Conta segundaConta = new Conta();//instanciando uma segunda conta/um segundo objeto
    segundaConta.saldo = 50;//nessa segunda conta nosso objeto tera 50

    System.out.println("primeira conta tem " + primeiraConta.saldo);
    System.out.println("segunda conta tem " + segundaConta.saldo);
    segundaConta.agencia = 146;
    System.out.println(primeiraConta.agencia);
    System.out.println(primeiraConta.numero);

        System.out.println(segundaConta.agencia);

    segundaConta.agencia = 146;
    System.out.println("agora a segunda conta está na agencia " + segundaConta.agencia);

    if(primeiraConta == segundaConta) {
        System.out.println("mesma conta");
    } else {
        System.out.println("contas diferentes");
    }

    System.out.println(primeiraConta);
    System.out.println(segundaConta);
  }
     
}
