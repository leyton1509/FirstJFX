module com.example.firstjfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.firstjfx to javafx.fxml;
    exports com.example.firstjfx;
}