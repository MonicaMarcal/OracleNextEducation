//caixa de asteristico
/*public class TestaLacosEncadeadosDois {
    public static void main(String[] args) {
        for(int linha = 0; linha < 10; linha++) {
            for(int coluna = 0; coluna < 10; coluna++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
*/
/*
//triangulo de asteristicos
public class TestaLacosEncadeadosDois {
  public static void main(String[] args) {
      for(int linha = 0; linha < 10; linha++) {
          for(int coluna = 0; coluna < 10; coluna++) {
              if(coluna > linha) {
                  break; 
              }
              System.out.print("*");
          }
          System.out.println();
      }
  }
}
*/
/* 
public class TestaLacosEncadeadosDois {
  public static void main(String args[]) {
      for(int linha = 0; linha < 5; linha++) {
          for (int coluna = 0; coluna < 5; coluna++) {
              if ( coluna > linha ) {
                  break;
              }
              System.out.print( coluna+1 );
          }
          System.out.println();
      }
  }
}
*/

/* 
//arvore de asteristicos
public class TestaLacosEncadeadosDois {
  public static void main(String[] args) {
    int numLinhas = 10;
    for(int linha = 1; linha<=numLinhas; linha++){
      for(int coluna = 1; coluna<=numLinhas-linha; coluna++){
          System.out.print(" ");
      }
      for(int asteriscos=1; asteriscos<=(linha*2)-1; asteriscos++){
          System.out.print("*");
      }
      System.out.println();
    }
    System.out.println("Então é natal, o que você fez...?");
  }
}
*/
/* 
public class TestaLacosEncadeadosDois {
  public static void main(String[] args) {
      for (int i = 1; i < 100; i++ ){
          if (i % 3 == 0)    {
              System.out.println(i);
          }
      }
  }
}
*/

//escreva um for que inicie uma variável n (número atual)
// como 1 e fatorial (resultado total) como 1.
// Faça seu laço entre 1 a 10 e calcule o resultado!

public class TestaLacosEncadeadosDois {
    public static void main(String[] args) {
        int fatorial = 1;
        for (int i = 1; i < 11; i++) {
            fatorial *= i;
            System.out.println("Fatorial de " + i + " = " + fatorial);
        }
    }
}
