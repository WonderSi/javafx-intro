module org.example.javafxintro {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires javafx.graphics;

    opens org.example.javafxintro to javafx.fxml;
    exports org.example.javafxintro;
    exports org.example.javafxintro.calculator;
    opens org.example.javafxintro.calculator to javafx.fxml;
    exports org.example.javafxintro.textflag;
    opens org.example.javafxintro.textflag to javafx.fxml;
    exports org.example.javafxintro.shiftingwords;
    opens org.example.javafxintro.shiftingwords to javafx.fxml;
    exports org.example.javafxintro.showhidewidget;
    opens org.example.javafxintro.showhidewidget to javafx.fxml;
    exports org.example.javafxintro.restaurantorder;
    opens org.example.javafxintro.restaurantorder to javafx.fxml;
}