module com.example.kpfx1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kpfx1 to javafx.fxml;
    exports com.example.kpfx1;
}