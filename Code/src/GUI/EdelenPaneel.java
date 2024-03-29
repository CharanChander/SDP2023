package GUI;

import domein.DomeinController;
import domein.Edele;
import domein.Taal;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EdelenPaneel extends Pane {

    private Taal keuze;
    private DomeinController dc;

    public EdelenPaneel(DomeinController dc, Taal keuze) {
        this.keuze = keuze;
        this.dc = dc;
        buildGui();
    }

    public void buildGui() {
        List<Edele> edelen = dc.getEdelen();

        for (Edele edele : edelen) {
            ImageView edeleImageView = edele.getAfbeelding();
            edeleImageView.setFitWidth(140);
            edeleImageView.setPreserveRatio(true);
            edeleImageView.setY(0);
            edeleImageView.setX(50);
            edeleImageView.setX(edeleImageView.getX() + 200 * edelen.indexOf(edele));
            getChildren().add(edeleImageView);
            edeleImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    try {
                        test();
                        dc.koopEdele(edele);
                        test();
                        Alert aSucces = new Alert(Alert.AlertType.INFORMATION);
                        aSucces.setTitle(keuze.getBundleTaal().getString("edeleGekocht"));
                        aSucces.setHeaderText(keuze.getBundleTaal().getString("edeleGekocht"));
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

            edeleImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    edeleImageView.setScaleX(1.1);
                    edeleImageView.setScaleY(1.1);
                }
            });

            edeleImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    edeleImageView.setScaleX(1.0);
                    edeleImageView.setScaleY(1.0);
                }
            });

        }
        if(dc.isEindeBeurt() && dc.isEindeSpel()){
            buildGui();
        }
    }
    public void test(){
        System.out.println(dc.getHuidigeSpeler().getNaam());
    }

}

