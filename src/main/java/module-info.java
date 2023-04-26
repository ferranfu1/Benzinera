module com.mycompany.benzinera {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.benzinera to javafx.fxml;
    exports com.mycompany.benzinera;
}
