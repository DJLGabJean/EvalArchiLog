package iut.fr.evalarchilog.DAO;

import iut.fr.evalarchilog.Modele.Pizza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {
    public List<Pizza> getPizza(){
        List<Pizza> pizzas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddrestaurant", "root", "root");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from pizza;");
            while (rs.next()) {
                pizzas.add(new Pizza(rs.getString(2), rs.getFloat(3), rs.getInt(4)));
            }
            con.close();
        } catch (Exception e){
            System.out.println(e);
        }
        return pizzas;
    }

    public void ajouterPizza(Pizza pizza){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddrestaurant", "root", "root");

            PreparedStatement statement = con.prepareStatement("insert into pizza (nom, prix, nb_ing) values (?, ?, ?);");
            statement.setString(1, pizza.getNom());
            statement.setFloat(2, pizza.getPrix());
            statement.setInt(3, pizza.getNb_ing());

            statement.executeUpdate();
            con.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void supprimerLesPizzas(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddrestaurant", "root", "root");

            PreparedStatement statement = con.prepareStatement("delete from pizza;");

            statement.executeUpdate();
            con.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

}
