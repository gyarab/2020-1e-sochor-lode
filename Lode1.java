package lode1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Lode1 extends Application {

    public void tlacitko(Button a) {
        a.setStyle("-fx-background-color: green");
    }

    Button tlac = null;

    boolean[][] lode1 = new boolean[10][10];
    boolean[][] lode2 = new boolean[10][10];
    List<Button> buttonList = new ArrayList<>();
    List<Button> buttonList2 = new ArrayList<>();
    Random random = new Random();

    @Override
    public void start(Stage stage) {
        Label label = new Label("Hra probíhá");
        GridPane pole = new GridPane();
        pole.add(label, 2, 2);
        GridPane pole1 = new GridPane();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button tlac = new Button();
                tlac.setMinSize(35, 35);
                pole1.add(tlac, i, j);
                pole1.setMinWidth(400);
                GridPane.setConstraints(tlac, j, i);
                tlac.setStyle("-fx-background-color: lightGrey");

            }

        }
        GridPane pole2 = new GridPane();
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                Button tlac = new Button();
                tlac.setMinSize(35, 35);
                pole2.add(tlac, a, b);
                GridPane.setConstraints(tlac, a, b);
                tlac.setStyle("-fx-background-color: lightGrey");
                int f = a;
                int e = b;

                tlac.setOnAction((c) -> {
                    if (tlac.getMaxWidth() != 999) {
                        if (tlac.getMaxWidth() == 1000) {
                            tlac.setStyle("-fx-background-color: red");
                            tlac.setMaxWidth(999);
                            int pocet = 0;
                            for (int i = 0; i < 100; i++) {
                                if (buttonList2.get(i).getMaxWidth() == 1000) {
                                    pocet++;
                                    System.out.println(pocet);
                                }
                            }
                            if (pocet == 0) {
                                System.out.println("hrac vyhral");
                                label.setText("Hráč vyhrál hru");
                            }
                        } else {
                            tlac.setStyle("-fx-background-color: blue");
                            tlac.setMaxWidth(999);
                        }
                        Boolean opakovat = true;
                        while (opakovat) {

                            lode2[f][e] = true;
                            System.out.println(f + " " + e);
                            int random3 = getRandomPosition(0);
                            if (buttonList.get(random3).getMaxWidth() != 999) {
                                opakovat = false;
                                if (buttonList.get(random3).getMaxWidth() == 1000) {
                                    buttonList.get(random3).setStyle("-fx-background-color: red");
                                    buttonList.get(random3).setMaxWidth(999);
                                    int pocet = 0;
                                    for (int i = 0; i < 100; i++) {
                                        if (buttonList.get(i).getMaxWidth() == 1000) {
                                            pocet++;
                                            System.out.println(pocet);
                                        }
                                    }
                                    if (pocet == 0) {
                                        System.out.println("bot vyhral");
                                        label.setText("Počítač vyhrál hru");
                                    }
                                } else {
                                    buttonList.get(random3).setStyle("-fx-background-color: blue");
                                    buttonList.get(random3).setMaxWidth(999);
                                }
                            }
                        }
                    }
                }
                );

            }

        }
        for (Node currentNode : pole1.getChildren()) {
            if (currentNode instanceof Button) {
                buttonList.add((Button) currentNode);
            }
        }
        for (Node currentNode : pole2.getChildren()) {
            if (currentNode instanceof Button) {
                buttonList2.add((Button) currentNode);
            }
        }
        pole.add(pole1, 0, 0);
        pole.add(pole2, 2, 0);
        pole.setMinWidth(2000);
        pole.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pole, 800, 370);
        lodeNahodne();
        lodeNahodne2();
        stage.setScene(scene);
        stage.show();

    }

    public void lodeNahodne() {
        for (int p = 0; p < 5; p++) {
            int random = getRandomPosition(100);
            tlacitko(buttonList.get(random));
            buttonList.get(random).setMaxWidth(1000);

        }

    }

    public void lodeNahodne2() {
        for (int p = 0; p < 5; p++) {
            int random2 = getRandomPosition(100);
            buttonList2.get(random2).setMaxWidth(1000);

        }

    }

    public static void main(String[] args) {

        launch();

    }

    private int getRandomPosition(int i) {
        int h = random.nextInt(99 - 0 + 1) + 0;
        return h;
    }

}
