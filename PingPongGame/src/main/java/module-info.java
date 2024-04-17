module ie.mtu.pingponggame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ie.mtu.pingponggame to javafx.fxml;
    exports ie.mtu.pingponggame;
    exports ie.mtu.pingponggame.controller;
    opens ie.mtu.pingponggame.controller to javafx.fxml;
}