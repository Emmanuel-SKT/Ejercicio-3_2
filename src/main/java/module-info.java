module com.main.ejercicio3_2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.main.ejercicio3_2 to javafx.fxml;
    exports com.main.ejercicio3_2;
}
