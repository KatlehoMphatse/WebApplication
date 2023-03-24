module com.example.webview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.webview to javafx.fxml;
    exports com.example.webview;
}