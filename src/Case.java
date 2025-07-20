public class Case {
    //Variable d'instance
    private int numero;
    private String etat;

    //constructeur sans parametres
    public Case(){
        this.numero = numero;
        this.etat = etat;
    }

    //constructeur avec parametres
    public Case(int numero, String etat){
        this.numero = numero;
        this.etat = etat;
    }

    //getters
    public int getNumero() {
        return numero;
    }
    public String getEtat(){
        return etat;
    }

    //setters
    public void setNumero(int numero){
        this.numero = numero;
    }
    public void setEtat(String etat){
        this.etat = etat;
    }
}
