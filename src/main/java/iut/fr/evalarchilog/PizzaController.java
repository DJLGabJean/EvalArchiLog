package iut.fr.evalarchilog;

import iut.fr.evalarchilog.DAO.PizzaDAO;
import iut.fr.evalarchilog.Modele.Pizza;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.*;


public class PizzaController implements Initializable {

    @FXML
    private TableView<Pizza> tabPizza;
    @FXML
    private TableColumn<Pizza, String> colNom;
    @FXML
    private TableColumn<Pizza, Float> colPrix;
    @FXML
    private TableColumn<Pizza, Integer> colNbIng;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfNbIng;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnVider;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colNbIng.setCellValueFactory(new PropertyValueFactory<>("nb_ing"));
        ObservableList<Pizza> olPizza = tabPizza.getItems();

        List<Pizza> pizzas = new PizzaDAO().getPizza();
        for (Pizza pizzaelement : pizzas) {
            Pizza pizzaAMettre = new Pizza(pizzaelement.getNom(), pizzaelement.getPrix(), pizzaelement.getNb_ing());
            olPizza.add(pizzaAMettre);
            tabPizza.setItems(olPizza);
        }
    }


    public void ajouterPizzaDansTableau(String nom, Float prix, Integer nb_ing){
        Pizza pizza = new Pizza(nom, prix, nb_ing);

        pizza.setNom(nom);
        pizza.setPrix(prix);
        pizza.setNb_ing(nb_ing);

        ObservableList<Pizza> pizzas = tabPizza.getItems();
        pizzas.add(pizza);
        tabPizza.setItems(pizzas);
    }

    @FXML
    private void ajouterPizza(){
        String nom = tfNom.getText();
        String prix = tfPrix.getText();
        String nb_ing = tfNbIng.getText();

        if (nom.equals("") || prix.equals("") || nb_ing.equals("")){
            erreurAjouterPizza();
        }
        else {
            Pizza pizza = new Pizza(nom, Float.parseFloat(prix), Integer.parseInt(nb_ing));
            new PizzaDAO().ajouterPizza(pizza);
            ajouterPizzaDansTableau(nom, Float.parseFloat(prix), Integer.parseInt(nb_ing));
        }

        tfNom.clear();
        tfPrix.clear();
        tfNbIng.clear();
    }

    private void erreurAjouterPizza(){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Un ou des données sont vides pour ajouter la pizza dans le tableau!", "Message d'erreur", JOptionPane.WARNING_MESSAGE);
    }

    private static void testAfficherPizzas() {
        List<Pizza> pizzas = new PizzaDAO().getPizza();
        for (Pizza pizza : pizzas) {
            System.out.println( "Recette : " + pizza.getNom() + ", Prix : " + pizza.getPrix() + ", Nombre d'ingrédients : " + pizza.getNb_ing());
        }
        System.out.println();
    }

    @FXML
    private void viderPizzas() {
        new PizzaDAO().supprimerLesPizzas();
        tabPizza.getItems().clear();
    }

}