package com.main.ejercicio3_2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class PrimaryController implements Initializable {

    @FXML
    private Button btnIniciar;
    @FXML
    private Label lblLiebre;
    @FXML
    private ProgressBar progLiebre;
    @FXML
    private Label lblTortuga;
    @FXML
    private ProgressBar progTortuga;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void btnIniciarOnAction(ActionEvent event) {
        btnIniciar.setDisable(true);
        progLiebre.setProgress(0);
        progTortuga.setProgress(0);

      
        Thread hiloLiebre = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   
                    for (int i = 1; i <= 50; i++) {
                        final double avance = (double) i / 100.0;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                progLiebre.setProgress(avance);
                                lblLiebre.setText("La Liebre: ¡Va corriendo muy rápido!");
                            }
                        });
                        Thread.sleep(50);
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lblLiebre.setText("La Liebre: ¡Se durmió Zzz...!");
                        }
                    });

                   
                    Thread.sleep(4000);

                   
                    for (int i = 51; i <= 100; i++) {
                        final double avance = (double) i / 100.0;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                progLiebre.setProgress(avance);
                                lblLiebre.setText("La Liebre: ¡Despertó y corre!");
                            }
                        });
                        Thread.sleep(60);
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lblLiebre.setText("La Liebre: ¡Llegó a la meta!");
                        }
                    });

                } catch (InterruptedException e) {
                }
            }
        });

       
        Thread hiloTortuga = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 1; i <= 100; i++) {
                        final double avance = (double) i / 100.0;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                progTortuga.setProgress(avance);
                                lblTortuga.setText("La Tortuga: ¡Va paso a paso constante!");
                            }
                        });
                      
                        Thread.sleep(80);
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lblTortuga.setText("JAJAJAJA UNA TORTUGA TE GANO YYYYYYYY");
                            btnIniciar.setDisable(false);
                        }
                    });

                } catch (InterruptedException e) {
                }
            }
        });

        hiloLiebre.start();
        hiloTortuga.start();
    }
}
