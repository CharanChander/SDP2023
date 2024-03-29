package GUI;

import domein.DomeinController;
import domein.Ontwikkelingskaart;
import domein.OntwikkelingskaartRepository;
import domein.Taal;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OntwikkelingsKaartPaneel extends Pane {
    private Taal keuze;
    private DomeinController dc;
    private List<Ontwikkelingskaart> ontwikkelingskaartN1;
    private List<Ontwikkelingskaart> ontwikkelingskaartN2;
    private List<Ontwikkelingskaart> ontwikkelingskaartN3;
    public OntwikkelingsKaartPaneel(DomeinController dc, Taal keuze) {
        this.keuze = keuze;
        this.dc = dc;
        buildGui();
    }

    private void buildGui() {
        ontwikkelingskaartN1 = dc.getOntwikkelingskaartenNiveau1();
        ontwikkelingskaartN2 = dc.getOntwikkelingskaartenNiveau2();
        ontwikkelingskaartN3 = dc.getOntwikkelingskaartenNiveau3();
        for (Ontwikkelingskaart ontwikkelingskaart : ontwikkelingskaartN1.subList(0, 4)) {
            ImageView ontwikkelingskaartImageView = ontwikkelingskaart.getAfbeelding();
            ontwikkelingskaartImageView.setFitWidth(150);
            ontwikkelingskaartImageView.setPreserveRatio(true);
            ontwikkelingskaartImageView.setLayoutY(550);
            ontwikkelingskaartImageView.setX(50);
            ontwikkelingskaartImageView.setX(ontwikkelingskaartImageView.getX() + 200 * ontwikkelingskaartN1.indexOf(ontwikkelingskaart));
            getChildren().add(ontwikkelingskaartImageView);
            ontwikkelingskaartImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        test();
                        dc.koopKaart(ontwikkelingskaart);
                        test();
                        Alert aSucces = new Alert(Alert.AlertType.INFORMATION);
                        aSucces.setTitle(keuze.getBundleTaal().getString("kaartGekocht"));
                        aSucces.setHeaderText(keuze.getBundleTaal().getString("kaartGekocht"));
                        aSucces.show();
                    } catch (Exception e) {
                        test();
                        Alert aError = new Alert(Alert.AlertType.ERROR);
                        aError.setTitle(keuze.getBundleTaal().getString(e.getMessage()));
                        aError.setHeaderText(keuze.getBundleTaal().getString(e.getMessage()));
                        aError.show();
                    }
                }

            });




            ontwikkelingskaartImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ontwikkelingskaartImageView.setScaleX(1.1);
                    ontwikkelingskaartImageView.setScaleY(1.1);
                }
            });

            ontwikkelingskaartImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ontwikkelingskaartImageView.setScaleX(1.0);
                    ontwikkelingskaartImageView.setScaleY(1.0);
                }
            });

        }

        if (ontwikkelingskaartN1.size() > 0)
        {
            Image ontwikkelingskaartN1Stack = new Image("images/KaartN1/Achterkant.png");
            ImageView StackN1 = new ImageView(ontwikkelingskaartN1Stack);
            StackN1.setFitWidth(150);
            StackN1.setPreserveRatio(true);
            StackN1.setLayoutY(550);
            StackN1.setX(900);
            getChildren().add(StackN1);
        }
if (ontwikkelingskaartN2.size() > 0)
{
    Image OntwikkelingskaartN2Stack = new Image("images/KaartN2/Achterkant.png");
    ImageView StackN2 = new ImageView(OntwikkelingskaartN2Stack);
    StackN2.setFitWidth(150);
    StackN2.setPreserveRatio(true);
    StackN2.setLayoutY(300);
    StackN2.setX(900);
    getChildren().add(StackN2);
}

if ( ontwikkelingskaartN3.size() > 0){
        Image OntwikkelingskaartN3Stack = new Image("images/KaartN3/Achterkant.png");
        ImageView StackN3 = new ImageView(OntwikkelingskaartN3Stack);
        StackN3.setFitWidth(150);
        StackN3.setPreserveRatio(true);
        StackN3.setLayoutY(50);
        StackN3.setX(900);
        getChildren().add(StackN3);
}





        /*for (int i = 1; i <= ontwikkelingskaartN1.size() - 4; i++)
        {
            ImageView ontwikkelingskaartImageViewStack = ontwikkelingskaartN1.get(i).getAfbeelding();
            ontwikkelingskaartImageViewStack.setFitWidth(150);
            ontwikkelingskaartImageViewStack.setPreserveRatio(true);
            ontwikkelingskaartImageViewStack.setLayoutY(550);
            ontwikkelingskaartImageViewStack.setX(900);
            getChildren().add(ontwikkelingskaartImageViewStack);
        }
        */



        for (Ontwikkelingskaart ontwikkelingskaart : ontwikkelingskaartN2.subList(0, 4)) {

            ImageView ontwikkelingskaartImageView = ontwikkelingskaart.getAfbeelding();
            ontwikkelingskaartImageView.setLayoutY(300);
            ontwikkelingskaartImageView.setFitWidth(150);
            ontwikkelingskaartImageView.setX(50);
            ontwikkelingskaartImageView.setX(ontwikkelingskaartImageView.getX() + 200 * ontwikkelingskaartN2.indexOf(ontwikkelingskaart));
            ontwikkelingskaartImageView.setPreserveRatio(true);
            getChildren().add(ontwikkelingskaartImageView);

            ontwikkelingskaartImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        test();
                        dc.koopKaart(ontwikkelingskaart);
                        test();
                        Alert aSucces = new Alert(Alert.AlertType.INFORMATION);
                        aSucces.setTitle(keuze.getBundleTaal().getString("kaartGekocht"));
                        aSucces.setHeaderText(keuze.getBundleTaal().getString("kaartGekocht"));
                        aSucces.show();
                    } catch (Exception e) {
                        test();
                        Alert aError = new Alert(Alert.AlertType.ERROR);
                        aError.setTitle(keuze.getBundleTaal().getString(e.getMessage()));
                        aError.setHeaderText(keuze.getBundleTaal().getString(e.getMessage()));
                        aError.show();
                    }
                }
            });

            ontwikkelingskaartImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ontwikkelingskaartImageView.setScaleX(1.1);
                    ontwikkelingskaartImageView.setScaleY(1.1);
                }
            });

            ontwikkelingskaartImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ontwikkelingskaartImageView.setScaleX(1.0);
                    ontwikkelingskaartImageView.setScaleY(1.0);
                }
            });
        }

        for (Ontwikkelingskaart ontwikkelingskaart : ontwikkelingskaartN3.subList(0, 4)) {


            ImageView ontwikkelingskaartImageView = ontwikkelingskaart.getAfbeelding();
            ontwikkelingskaartImageView.setFitWidth(150);
            ontwikkelingskaartImageView.setLayoutY(50);
            ontwikkelingskaartImageView.setX(50);
            ontwikkelingskaartImageView.setX(ontwikkelingskaartImageView.getX() + 200 * ontwikkelingskaartN3.indexOf(ontwikkelingskaart));
            ontwikkelingskaartImageView.setPreserveRatio(true);
            getChildren().add(ontwikkelingskaartImageView);
            ontwikkelingskaartImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        test();
                        dc.koopKaart(ontwikkelingskaart);
                        test();
                        Alert aSucces = new Alert(Alert.AlertType.INFORMATION);
                        aSucces.setTitle(keuze.getBundleTaal().getString("kaartGekocht"));
                        aSucces.setHeaderText(keuze.getBundleTaal().getString("kaartGekocht"));
                        aSucces.show();
                    } catch (Exception e) {
                        test();
                        Alert aError = new Alert(Alert.AlertType.ERROR);
                        aError.setTitle(keuze.getBundleTaal().getString(e.getMessage()));
                        aError.setHeaderText(keuze.getBundleTaal().getString(e.getMessage()));
                        aError.show();
                    }
                }
            });



            ontwikkelingskaartImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ontwikkelingskaartImageView.setScaleX(1.1);
                    ontwikkelingskaartImageView.setScaleY(1.1);
                }
            });

            ontwikkelingskaartImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ontwikkelingskaartImageView.setScaleX(1.0);
                    ontwikkelingskaartImageView.setScaleY(1.0);
                }
            });
        }
        if(dc.isEindeBeurt() && !dc.isEindeSpel()){
            buildGui();
        }


    }
    public void test(){
        System.out.println(dc.getHuidigeSpeler().getNaam());
    }

}
