package GUI;

import domein.DomeinController;
import domein.Taal;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SpelScherm extends BorderPane {

    private Taal keuze;
    private DomeinController dc;
    private EdelenPaneel edelenPaneel;
    private EdelsteenPaneel edelsteenPaneel;
    private SpelerOverzichtPaneel spelerOverzichtPaneel;
    private OntwikkelingsKaartPaneel ontwikkelingsKaartPaneel;


public SpelScherm(StartScherm startScherm, DomeinController dc, Taal keuze) {
    this.keuze = keuze;
    this.dc = dc;
    this.setPadding(new Insets(20));
    buildGUI();

    Button btnSkipBeurt = new Button(keuze.getBundleTaal().getString("skipBeurt"));
    this.setBottom(btnSkipBeurt);
    btnSkipBeurt.setMinWidth(70);
    btnSkipBeurt.setMinHeight(40);
    btnSkipBeurt.setCursor(Cursor.HAND);
    btnSkipBeurt.setStyle("-fx-background-radius: 12;" + "-fx-background-color: MIDNIGHTBLUE;");
    btnSkipBeurt.setTextFill(Color.GOLD);
    btnSkipBeurt.setFont(Font.font("Stencil", FontWeight.BOLD, 20));
    this.setBottom(btnSkipBeurt);
    GridPane.setHalignment(btnSkipBeurt, HPos.LEFT);
    GridPane.setValignment(btnSkipBeurt, VPos.BASELINE);

    btnSkipBeurt.setOnMouseClicked(nextTurn -> {
        dc.volgendeSpeler();
    });




}
    private void buildGUI()
    {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage achtergrond = new BackgroundImage(new Image(("/images/Achtergrond/istockphoto-1145602814-612x612.jpg"), 760, 427, false, false), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        this.setBackground(new Background(achtergrond));
        edelenPaneel = new EdelenPaneel(dc, keuze);
        edelsteenPaneel = new EdelsteenPaneel(dc, keuze);
        ontwikkelingsKaartPaneel = new OntwikkelingsKaartPaneel(dc, keuze);
        spelerOverzichtPaneel = new SpelerOverzichtPaneel(dc,keuze);
        setTop(edelenPaneel);
        setLeft(edelsteenPaneel);
        setCenter(ontwikkelingsKaartPaneel);
        setRight(spelerOverzichtPaneel);
    }

    private void eindScherm(DomeinController dc, Taal keuze)
    {


    }





}
