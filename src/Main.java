import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //params de config
        //tableau indiquant les cases initialement en feu
        String[] feuDepart = {"1", "12"};
        //hauteur et largeur de la grille (foret)
        int h = 4;
        int l = 4;

        //création d'un tableau
        int[][] foret;

        //taille du tableau aux dimensions de la grille (foret)
        foret = new int[h][l];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                //créer une nouvelle case
                Case x = new Case();

                // stocker et afficher le numero de la case
                int num = (i)*l+j;
                x.setNumero(num);

                //transformer mon tableau en array list pour pouvoir utiliser contains
                List<String> liste = Arrays.asList(feuDepart);

                if (liste.contains(String.valueOf(num + 1))){
                    System.out.println("case num " + x.getNumero());
                }

            }
        }
    }
}