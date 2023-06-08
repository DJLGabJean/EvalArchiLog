package iut.fr.evalarchilog.Modele;

public class Pizza {
    private String nom;
    private Integer id;
    private Float prix;
    private Integer nb_ing;

    public Pizza(String nom, Float prix, Integer nbIng) {
        this.nom = nom;
        this.prix = prix;
        this.nb_ing = nbIng;
    }

    public String getNom() {
        return nom;
    }
    public float getPrix() {
        return prix;
    }
    public int getNb_ing() {
        return nb_ing;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrix(Float prix) {
        this.prix = prix;
    }
    public void setNb_ing(Integer nb_ing) {
        this.nb_ing = nb_ing;
    }
}
