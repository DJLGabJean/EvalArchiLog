module iut.fr.evalarchilog {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens iut.fr.evalarchilog to javafx.fxml;
    opens iut.fr.evalarchilog.Modele to javafx.base;
    exports iut.fr.evalarchilog;
}