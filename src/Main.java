import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //params de config
        //tableau indiquant les cases initialement en feu
        List<String> feuDepart = new ArrayList<>();
        feuDepart.add("3");
        feuDepart.add("12");
        feuDepart.add("20");
        //hauteur et largeur de la grille (foret)
        int h = 5;
        int l = 4;
        //probabilité p qu'une case soit en feu
        double p = 2;

        //création d'un tableau representant la foret
        Case[][] foret;

        //taille du tableau aux dimensions de la grille (foret)
        foret = new Case[h][l];

        //initialisation de la foret
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                //créer une nouvelle case
                Case x = new Case();

                // stocker le numero de la case
                int num = (i)*l+j;
                x.setNumero(num);

                //verifier si la case est en feu
                if (feuDepart.contains(String.valueOf(num + 1))){
                    x.setEtat("feu");
                } else {
                    x.setEtat("arbre");
                }

                foret[i][j] = x;
            }
        }

        //création d'une variable indiquant le nombre de case en feu
        int enFeu = feuDepart.size();

        //création d'une variable étape incrémente
        int etape = 0;

        //stocker les cases actuellement en feu à chaque etapes dans un array list
        List<String> casesBrulants = new ArrayList<>();
        //ajouter les cases en feu au depart à ce tableau
        for (int i = 0; i < feuDepart.size(); i++){
            casesBrulants.add(feuDepart.get(i));
        }
        System.out.println(casesBrulants);

        //continuer les étapes tant qu'au moins une case est en feu
        while (enFeu > 0){
            //changer l'état des cases
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < l; j++) {
                    if (casesBrulants.contains(""+foret[i][j].getNumero())){
                        foret[i][j].setEtat("cendre");
                        System.out.println("condition entered");
                        /*
                        verifier si les cases adjacentes existent et changer
                        leur état
                        */
                        if (i > 0){
                            if (foret[i-1][j].getEtat().equals("arbre")){
                                foret[i-1][j].setEtat("feu");
                            }
                        }
                        if (i < h-1){
                            if (foret[i+1][j].getEtat().equals("arbre")){
                                foret[i+1][j].setEtat("feu");
                            }
                        }
                        if (j > 0){
                            if (foret[i][j-1].getEtat().equals("arbre")){
                                foret[i][j-1].setEtat("feu");
                            }
                        }
                        if (j < l-1){
                            if (foret[i][j+1].getEtat().equals("arbre")){
                                foret[i][j+1].setEtat("feu");
                            }
                        }


                    }
                }
            }
            //effacer le contenu du tableau des cases en feu
            casesBrulants.clear();
            //stocker les cases en feu à la fin de cette étape
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < l; j++) {
                    if (foret[i][j].getEtat().equals("feu")){
                        casesBrulants.add(""+foret[i][j].getNumero());
                    }
                }
            }
            enFeu = casesBrulants.size();
            etape ++;
            System.out.println(casesBrulants);
        }


        System.out.println(etape);
    }
}