package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class Credit {
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 1100, 600);

        String musicFile = "src/main/resources/Sound/Bruit/bonk-sound-effect.wav";
        String sound = (new File(musicFile).toURI().toString());
        AudioClip bonk = new AudioClip(sound);
        bonk.play();

        Button retour = new Button("Retour");
        retour.setMinWidth(60);
        retour.setMinHeight(24);
        retour.setTranslateY(250);
        retour.setTranslateX(3);
        retour.setCancelButton(true);

        retour.setOnAction(ev -> {
            OptionSon.playSelectedButton();
            Menu m = new Menu();
            m.start(primaryStage);
            ev.consume();
        });

        Text Credit = new Text("Crédits");
        Credit.setTranslateY(-230);
        Credit.setFont(Font.font("", FontWeight.BOLD,50));
        Text Chef = new Text("Chef :");
        Chef.setFont(new Font(20));
        Chef.setStyle("-fx-font-weight: bold");
        Chef.setTranslateY(-160);
        Text nomChef = new Text("Marques-Martins Mattyas");
        nomChef.setTranslateY(-130);
        Text Programmeurs = new Text("Programmeurs :");
        Programmeurs.setTranslateY(-80);
        Programmeurs.setStyle("-fx-font-weight: bold");
        Programmeurs.setFont(new Font(20));
        Text nomsProgrammeurs = new Text(
                "Marques-Martins Mattyas\n            Lim Julien\n    Tiberghien Corentin\n             Lin Michel\n        Grangean Justin");
        nomsProgrammeurs.setTranslateY(-5);
        Text Beta = new Text("Beta testeurs :");
        Beta.setFont(new Font(20));
        Beta.setStyle("-fx-font-weight: bold");
        Beta.setTranslateY(70);
        Text nomsBeta = new Text("          Charlotte\nLa Soeur de Mattyas\n           Giovanni");
        nomsBeta.setTranslateY(120);
        Text SpecialThanks = new Text("Remerciement spécial à Giovanni pour le c dans contact.csv");
        SpecialThanks.setTranslateY(170);
        Button btnBonk = new Button("BONK!");
        btnBonk.setTranslateX(-500);
        btnBonk.setTranslateY(-275);
        btnBonk.setOnAction(ev -> {
            bonk.play();
            ev.consume();
        });

        scene.setOnKeyPressed(key -> {
            if(key.getCode() == KeyCode.B || key.getCode() == KeyCode.O || key.getCode() == KeyCode.N || key.getCode() == KeyCode.K){
                btnBonk.fire();
            }
        });

        primaryStage.setScene(scene);

        root.setId("root");
        scene.getStylesheets().addAll(Objects.requireNonNull(getClass().getResource("stylesheet/creditstylesheet.css")).toExternalForm());
        root.getChildren().addAll(retour, Chef, nomChef, Programmeurs, nomsProgrammeurs, Beta, nomsBeta, SpecialThanks,
                Credit , btnBonk);
        root.requestFocus();
    }
}
