import java.util.ArrayList;
import java.util.Collections;

/*Exercicio:
* Crie uma classe e declare seu método main.
* Essa classe deverá ter uma lista de Strings com 3 nomes de cursos
* que você gosta do Alura e em seguida imprimí-los.
* */
public class TestandoListasExercicio {
    public static void main(String[] args) {
        String cursoFavorito1= "JDK";
        String cursoFavorito2= "Herança";
        String cursoFavorito3= "OO";

        ArrayList<String> cursos = new ArrayList<>();
        cursos.add(cursoFavorito1);
        cursos.add(cursoFavorito2);
        cursos.add(cursoFavorito3);

        System.out.println(cursos);

        cursos.remove(1);//removendo o segundo elemento da lista

        System.out.println(cursos);
        System.out.println("O primeiro curso da lista eh o: "+ cursos.get(0)); //pegando o primeiro elemento da lista

        Collections.sort(cursos);//ordenando a lista em ordem alfabetica
        System.out.println(cursos);


    }
}
