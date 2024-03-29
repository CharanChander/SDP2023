package GUI;

import javafx.geometry.*;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import java.util.Optional;
import domein.DomeinController;
import domein.Taal;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StartScherm extends GridPane {

	private final DomeinController dc;
    private Label lblMessage;
    Taal keuze;

    public StartScherm(DomeinController dc) {
    	this.dc = dc;
        keuze = new Taal();
    	dc.maakNieuwSpel();
        buildGui();
    }

    private void buildGui(){
        this.setPadding(new Insets(20));
        this.setHgap(10);
        this.setVgap(10);

        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage splendor = new BackgroundImage(new Image(("/images/Splendor.jpg"), 1920, 1080, false, false), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        this.setBackground(new Background(splendor));

        ColumnConstraints kolom1 = new ColumnConstraints();
        kolom1.setHgrow(Priority.ALWAYS);
        ColumnConstraints kolom2 = new ColumnConstraints();
        this.getColumnConstraints().addAll(kolom1, kolom2);


        Image taal1 = new Image("/images/flag.png");
        ImageView nl = new ImageView(taal1);
        nl.setFitHeight(70);
        nl.setFitWidth(70);

        Image taal2 = new Image("/images/united-kingdom.png");
        ImageView eng = new ImageView(taal2);
        eng.setFitHeight(70);
        eng.setFitWidth(70);

        Button Speel = new Button(keuze.getBundleTaal().getString("speel"));
        setHalignment(Speel, HPos.RIGHT);
        Speel.setMinWidth(70);
        Speel.setMinHeight(40);
        Speel.setCursor(Cursor.HAND);
        Speel.setStyle("-fx-background-radius: 12;" + "-fx-background-color: MIDNIGHTBLUE;");
        Speel.setTextFill(Color.GOLD);
        Speel.setFont(Font.font("Stencil", FontWeight.BOLD, 20));
        this.add(Speel, 6,24 );
        GridPane.setHalignment(Speel, HPos.RIGHT);
        GridPane.setValignment(Speel, VPos.BOTTOM);
        Speel.setOnAction(event ->
        {
            SpelScherm ss = new SpelScherm(this, dc,keuze);
            Scene scene = new Scene(ss, 1280, 720);
            Stage stage = (Stage) StartScherm.this.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        });

        Label lblUsername = new Label(keuze.getBundleTaal().getString("naam"));
        lblUsername.setTextFill(Color.GOLD);
        lblUsername.setFont(Font.font("Stencil", FontWeight.BOLD, 15));
        lblUsername.setUnderline(true);
        this.add(lblUsername, 6, 20);

        TextField txtNaam = new TextField();
        this.add(txtNaam, 7, 20);
        Tooltip tNaam = new Tooltip();
        tNaam.setText(keuze.getBundleTaal().getString("DR_SPELER"));
        txtNaam.setTooltip(tNaam);
        
        Label lblJaar = new Label(keuze.getBundleTaal().getString("geboortejaar"));
        lblJaar.setTextFill(Color.GOLD);
        lblJaar.setUnderline(true);
        lblJaar.setFont(Font.font("Stencil", FontWeight.BOLD, 15));
        this.add(lblJaar, 6, 21);

        TextField txtJaar = new TextField();
        this.add(txtJaar, 7, 21);
        Tooltip tJaar = new Tooltip();
        tJaar.setText(keuze.getBundleTaal().getString("DR_JAAR"));
        txtJaar.setTooltip(tJaar);

        Button btnSignIn = new Button(keuze.getBundleTaal().getString("voegToe"));
        setHalignment(btnSignIn, HPos.RIGHT);
        btnSignIn.setMinWidth(70);
        btnSignIn.setMinHeight(40);
        btnSignIn.setCursor(Cursor.HAND);
        btnSignIn.setStyle("-fx-background-radius: 12;" + "-fx-background-color: MIDNIGHTBLUE;");
        btnSignIn.setTextFill(Color.GOLD);
        btnSignIn.setFont(Font.font("Stencil", FontWeight.BOLD, 20));
        this.add(btnSignIn, 6, 23);
        
        btnSignIn.setOnMouseClicked(event -> {
        	
        	try {
				dc.registreerGegevens(txtNaam.getText(), Integer.parseInt(txtJaar.getText()));
                Label lblAantal = new Label(keuze.getBundleTaal().getString("aantalSpelers")+dc.aantalSpelers());
                this.add(lblAantal, 6, 22);
                lblAantal.setTextFill(Color.GOLD);
                lblAantal.setFont(Font.font("Stencil", FontWeight.NORMAL, 15));
				if(dc.aantalSpelers() >= 2 && dc.aantalSpelers()<4) {
                    ButtonType JA = new ButtonType(keuze.getBundleTaal().getString("ja"),ButtonBar.ButtonData.YES);
                    ButtonType NEE = new ButtonType(keuze.getBundleTaal().getString("nee"),ButtonBar.ButtonData.NO);
					Alert aNogToevoegen = new Alert(AlertType.CONFIRMATION,"",JA,NEE);
					aNogToevoegen.setTitle(keuze.getBundleTaal().getString("toevoegen"));
					aNogToevoegen.setHeaderText(keuze.getBundleTaal().getString("toevoegen"));
					
					Optional<ButtonType> jaNee = aNogToevoegen.showAndWait();
					if(jaNee.get() == NEE) {
						beginnen();
					}
				}if(dc.aantalSpelers() == 4) {
					beginnen();
				}
				
        	}catch( NumberFormatException nf) {
				Alert aError = new Alert(AlertType.ERROR);
				aError.setTitle(keuze.getBundleTaal().getString("fout_geboortejaar"));
				aError.setHeaderText(keuze.getBundleTaal().getString("fout_geboortejaar"));
				aError.show();
        	} catch (Exception e) {
                Alert aError = new Alert(AlertType.ERROR);
                aError.setTitle(keuze.getBundleTaal().getString(e.getMessage()));
                aError.setHeaderText(keuze.getBundleTaal().getString(e.getMessage()));
                aError.show();
			}
        });

        Button taalButton = new Button();
        taalButton.setGraphic(nl);
        taalButton.setStyle("-fx-background-color: transparent;");
        taalButton.setCursor(Cursor.HAND);
        this.add(taalButton, 0, 19);
        GridPane.setHalignment(taalButton, HPos.LEFT);
        taalButton.setOnAction(evt -> {
            keuze.setTaal(1);
            Speel.setText(keuze.getBundleTaal().getString("speel"));
            btnSignIn.setText(keuze.getBundleTaal().getString("voegToe"));
            lblUsername.setText(keuze.getBundleTaal().getString("naam"));
            lblJaar.setText(keuze.getBundleTaal().getString("geboortejaar"));


        });

        Button taalButton2 = new Button();
        taalButton2.setGraphic(eng);
        taalButton2.setStyle("-fx-background-color: transparent;");
        taalButton2.setCursor(Cursor.HAND);
        this.add(taalButton2, 0, 20);
        GridPane.setHalignment(taalButton2, HPos.LEFT);
        taalButton2.setOnAction(evt2 -> {
            keuze.setTaal(2);
            Speel.setText(keuze.getBundleTaal().getString("speel"));
            btnSignIn.setText(keuze.getBundleTaal().getString("voegToe"));
            lblUsername.setText(keuze.getBundleTaal().getString("naam"));
            lblJaar.setText(keuze.getBundleTaal().getString("geboortejaar"));


        });
    }
    private void beginnen() {
    	Alert aBeginnen = new Alert(AlertType.INFORMATION);
		aBeginnen.setTitle("We gaan beginnen");
		aBeginnen.setHeaderText(keuze.getBundleTaal().getString("stand_spelers")+dc.aantalSpelers());
		aBeginnen.show();
        dc.speelSpel();

    }



    /* public void naarOverzichtScherm (Event event)
    {
        OverzichtScherm os = new OverzichtScherm(this, dc);
        Scene sceneOverzicht = new Scene(os, 1280, 720);
        Stage stage = (Stage) StartScherm.this.getScene().getWindow();
        stage.setScene(sceneOverzicht);
        stage.show();
    }
    */


}
