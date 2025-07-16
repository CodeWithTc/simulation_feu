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
        Case[][] foret;

        //taille du tableau aux dimensions de la grille (foret)
        foret = new Case[h][l];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                //créer une nouvelle case
                Case x = new Case();

                // stocker et afficher le numero de la case
                int num = (i)*l+j;
                x.setNumero(num);

                //transformer mon tableau en array list pour pouvoir utiliser contains
                List<String> liste = Arrays.asList(feuDepart);

                //verifier si la case est en feu
                if (liste.contains(String.valueOf(num + 1))){
                    x.setEtat("feu");
                } else {
                    x.setEtat("arbre");
                }

                foret[i][j] = x;
                System.out.println("case num " + x.getNumero() + x.getEtat());
            }
        }
        System.out.println(foret[0][1].getEtat());
    }
}