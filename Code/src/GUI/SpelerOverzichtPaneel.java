package GUI;

import com.sun.javafx.fxml.expression.LiteralExpression;
import domein.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SpelerOverzichtPaneel extends Pane {
    private Taal keuze;
    private List<Edele> edelenSpeler;
    private List<Ontwikkelingskaart> ontwikkelingskaartSpeler;
    private Stack<Edelsteenfiche> FichesWit;
    private Stack<Edelsteenfiche> FichesBlauw;
    private Stack<Edelsteenfiche> FichesRood;
    private Stack<Edelsteenfiche> FichesGroen;
    private Stack<Edelsteenfiche> FichesZwart;
    private int aantalPunten;

    private Stack<Edelsteenfiche> fichesWit;
    private Stack<Edelsteenfiche> fichesBlauw;
    private Stack<Edelsteenfiche> fichesGroen;
    private Stack<Edelsteenfiche> fichesRood;
    private Stack<Edelsteenfiche> fichesZwart;
    private DomeinController dc;

    private Speler huideSpeler;

    private ListView<String> lijst;

    private boolean refresh;

    public SpelerOverzichtPaneel(DomeinController dc, Taal keuze) {
        this.keuze = keuze;
        this.dc = dc;
        buildGui();
    }

    public void buildGui() {
        int teller = 0;
        this.huideSpeler = dc.getHuidigeSpeler();
        fichesWit = huideSpeler.getWitFiche();
        fichesBlauw = huideSpeler.getBlauwFiche();
        fichesGroen = huideSpeler.getGroenFiche();
        fichesRood = huideSpeler.getRoodFiche();
        fichesZwart = huideSpeler.getZwartFiche();

        if (fichesWit.size() != 0) {
            ImageView witImageView = fichesWit.get(0).getAfbeelding();
            witImageView.setFitWidth(100);
            witImageView.setPreserveRatio(true);
            getChildren().add(witImageView);
            witImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    dc.geefFicheTerug(fichesWit.pop());
                }
            });

            witImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    witImageView.setScaleX(1.1);
                    witImageView.setScaleY(1.1);
                }
            });
            witImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    witImageView.setScaleX(1.0);
                    witImageView.setScaleY(1.0);
                }
            });
        }


        if (fichesBlauw.size() != 0) {
            ImageView blauwImageView = fichesBlauw.get(0).getAfbeelding();
            blauwImageView.setFitWidth(100);
            blauwImageView.setPreserveRatio(true);
            getChildren().add(blauwImageView);
            blauwImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    dc.geefFicheTerug(fichesBlauw.pop());
                }
            });
            blauwImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    blauwImageView.setScaleX(1.1);
                    blauwImageView.setScaleY(1.1);
                }
            });
            blauwImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    blauwImageView.setScaleX(1.0);
                    blauwImageView.setScaleY(1.0);
                }
            });
        }

        if (fichesGroen.size() != 0) {
            ImageView groenImageView = fichesGroen.get(0).getAfbeelding();
            groenImageView.setFitWidth(100);
            groenImageView.setPreserveRatio(true);
            getChildren().add(groenImageView);
            groenImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    dc.geefFicheTerug(fichesGroen.pop());
                }
            });
            groenImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    groenImageView.setScaleX(1.1);
                    groenImageView.setScaleY(1.1);
                }
            });
            groenImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    groenImageView.setScaleX(1.0);
                    groenImageView.setScaleY(1.0);
                }
            });
        }


        if (fichesRood.size() != 0) {
            ImageView roodImageView = fichesRood.get(0).getAfbeelding();
            roodImageView.setFitWidth(100);
            roodImageView.setPreserveRatio(true);
            getChildren().add(roodImageView);
            roodImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    dc.geefFicheTerug(fichesRood.pop());
                }
            });
            roodImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    roodImageView.setScaleX(1.1);
                    roodImageView.setScaleY(1.1);
                }
            });
            roodImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    roodImageView.setScaleX(1.0);
                    roodImageView.setScaleY(1.0);
                }
            });
        }

        if (fichesZwart.size() != 0) {
            ImageView zwartImageView = fichesZwart.get(0).getAfbeelding();
            zwartImageView.setFitWidth(100);
            zwartImageView.setPreserveRatio(true);
            getChildren().add(zwartImageView);
            zwartImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    dc.geefFicheTerug(fichesZwart.pop());
                }
            });
            zwartImageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    zwartImageView.setScaleX(1.1);
                    zwartImageView.setScaleY(1.1);
                }
            });
            zwartImageView.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    zwartImageView.setScaleX(1.0);
                    zwartImageView.setScaleY(1.0);
                }
            });
        }

        lijst = new ListView<>();

        List<String> lijstVanSpelers = new ArrayList<>();
        lijstVanSpelers.add("Speler aan beurt: "+dc.getHuidigeSpeler().getNaam());

        for (Speler speler : dc.getSpelers()) {
            lijstVanSpelers.add(speler.getNaam()+" heeft: "+speler.getAantalPrestigepunten()+" punten, "+speler.getAantalFiches()+" fiches, "+speler.getOntwikkelingskaarten().size()+" ontwikkelingskaarten, "+speler.getEdelen().size()+" edelen.");
        }

        lijst.setItems(FXCollections.observableArrayList(lijstVanSpelers));
        this.getChildren().add(lijst);
        /*for (Speler speler : dc.getSpelers()) {
            edelenSpeler = speler.getEdelen();
            ontwikkelingskaartSpeler = speler.getOntwikkelingskaarten();
            FichesWit = speler.getWitFiche();
            FichesBlauw = speler.getBlauwFiche();
            FichesRood = speler.getRoodFiche();
            FichesGroen = speler.getGroenFiche();
            FichesZwart = speler.getZwartFiche();
            aantalPunten = speler.getAantalPrestigepunten();


            Label naamLabel = new Label(speler.getNaam() + ":");
            naamLabel.setFont(Font.font("Stencil", FontWeight.BOLD, 20));
            naamLabel.setTextFill(Color.GOLD);
            naamLabel.setStyle("-fx-background-radius: 12;" + "-fx-background-color: MIDNIGHTBLUE;");
            naamLabel.setLayoutX(0);
            naamLabel.setLayoutY(teller);
            getChildren().add(naamLabel);
            teller += 80;

            Label aanDeBeurtLabel = new Label("Is " + (speler.isAanBeurt() ? "Aan de beurt" : "Niet aan de Beurt"));
            aanDeBeurtLabel.setFont(Font.font("Stencil", FontWeight.BOLD, 20));
            aanDeBeurtLabel.setTextFill(Color.GOLD);
            aanDeBeurtLabel.setStyle("-fx-background-radius: 12;" + "-fx-background-color: MIDNIGHTBLUE;");
            aanDeBeurtLabel.setLayoutY(teller);
            aanDeBeurtLabel.setLayoutX(0);
            getChildren().add(aanDeBeurtLabel);
            teller += 80;

            Label fichesLabel = new Label("Aantal fiches: " + speler.getAantalFiches());
            fichesLabel.setFont(Font.font("Stencil", FontWeight.BOLD, 20));
            fichesLabel.setTextFill(Color.GOLD);
            fichesLabel.setStyle("-fx-background-radius: 12;" + "-fx-background-color: MIDNIGHTBLUE;");
            aanDeBeurtLabel.setLayoutY(teller);
            aanDeBeurtLabel.setLayoutX(0);
            getChildren().add(fichesLabel);
            teller += 80;

            Label kaartenLabel = new Label("Aantal kaarten: " + speler.getOntwikkelingskaarten().size());
            kaartenLabel.setFont(Font.font("Stencil", FontWeight.BOLD, 20));
            kaartenLabel.setTextFill(Color.GOLD);
            kaartenLabel.setStyle("-fx-background-radius: 12;" + "-fx-background-color: MIDNIGHTBLUE;");
            kaartenLabel.setLayoutY(teller);
            kaartenLabel.setLayoutX(0);
            getChildren().add(kaartenLabel);
            teller += 80;

            Label edelenLabel = new Label("Aantal edelen: " + speler.getEdelen().size());
            edelenLabel.setFont(Font.font("Stencil", FontWeight.BOLD, 20));
            edelenLabel.setTextFill(Color.GOLD);
            edelenLabel.setStyle("-fx-background-radius: 12;" + "-fx-background-color: MIDNIGHTBLUE;");
            edelenLabel.setLayoutY(teller);
            edelenLabel.setLayoutX(0);
            getChildren().add(edelenLabel);
            teller += 80;

            Label puntenLabel = new Label("Aantal punten: " + speler.getAantalPrestigepunten());
            puntenLabel.setFont(Font.font("Stencil", FontWeight.BOLD, 20));
            puntenLabel.setTextFill(Color.GOLD);
            edelenLabel.setStyle("-fx-background-radius: 12;" + "-fx-background-color: MIDNIGHTBLUE;");
            puntenLabel.setLayoutY(teller);
            puntenLabel.setLayoutX(0);
            teller += 80;

        }*/

            /*for (Speler speler : dc.getSpelers())
            {
                aanDeBeurtLabel.setText(speler.getNaam()+ ":" + (speler.isAanBeurt() ? "Aan de beurt" : "Niet aan de Beurt" ));
                fichesLabel.setText("Edelsteenfiches: "+ speler.getAantalFiches());
                kaartenLabel.setText("Ontwikkelingskaarten: " + speler.getOntwikkelingskaarten().size());
                edelenLabel.setText("Edelen: " + speler.getEdelen().size());
                puntenLabel.setText("Prestigepunten: " + speler.getAantalPrestigepunten());

                Label aanDeBeurtKopie = new Label(aanDeBeurtLabel.getText());
                aanDeBeurtKopie.setFont(Font.font("Stencil", FontWeight.BOLD, 20));
                aanDeBeurtKopie.setTextFill(Color.GOLD);
                aanDeBeurtKopie.setStyle("-fx-background-radius: 12;"+ "-fx-background-color: MIDNIGHTBLUE;");
                infoBox.getChildren().add(aanDeBeurtKopie);
            }*/

        /*if (edelenSpeler.size() != 0) {
            for (Edele edele : edelenSpeler) {
                ImageView edeleFoto = edele.getAfbeelding();
                edeleFoto.setFitWidth(140);
                edeleFoto.setPreserveRatio(true);
                edeleFoto.setLayoutY(0);
                edeleFoto.setLayoutX(100);
                edeleFoto.setX(edeleFoto.getX() + 200 * edelenSpeler.indexOf(edele));
                getChildren().add(edeleFoto);
            }
        }

        if (ontwikkelingskaartSpeler.size() != 0) {
            for (Ontwikkelingskaart ontwikkelingskaart : ontwikkelingskaartSpeler) {
                ImageView ontwikkelingskaartFoto = ontwikkelingskaart.getAfbeelding();
                ontwikkelingskaartFoto.setFitWidth(140);
                ontwikkelingskaartFoto.setPreserveRatio(true);
                ontwikkelingskaartFoto.setLayoutY(0);
                ontwikkelingskaartFoto.setLayoutX(100);
                ontwikkelingskaartFoto.setX(ontwikkelingskaartFoto.getX() + 200 * ontwikkelingskaartSpeler.indexOf(ontwikkelingskaart));
                getChildren().add(ontwikkelingskaartFoto);
            }
        }

        if (FichesWit.size() != 0) {
            for (Edelsteenfiche fiche : FichesWit) {
                ImageView FicheFoto = fiche.getAfbeelding();
                FicheFoto.setFitWidth(100);
                FicheFoto.setPreserveRatio(true);
                FicheFoto.setLayoutX(150);
                FicheFoto.setLayoutY(0);
                getChildren().add(FicheFoto);
            }
        }

        if (FichesBlauw.size() != 0) {
            for (Edelsteenfiche fiche : FichesBlauw) {
                ImageView FicheFoto = fiche.getAfbeelding();
                FicheFoto.setFitWidth(100);
                FicheFoto.setPreserveRatio(true);
                FicheFoto.setLayoutX(250);
                FicheFoto.setLayoutY(0);
                getChildren().add(FicheFoto);
            }
        }

        if (FichesGroen.size() != 0) {
            for (Edelsteenfiche fiche : FichesGroen) {
                ImageView FicheFoto = fiche.getAfbeelding();
                FicheFoto.setFitWidth(100);
                FicheFoto.setPreserveRatio(true);
                FicheFoto.setLayoutX(350);
                FicheFoto.setLayoutY(0);
                getChildren().add(FicheFoto);
            }
        }

        if (FichesRood.size() != 0) {
            for (Edelsteenfiche fiche : FichesRood) {
                ImageView FicheFoto = fiche.getAfbeelding();
                FicheFoto.setFitWidth(100);
                FicheFoto.setPreserveRatio(true);
                FicheFoto.setLayoutX(450);
                FicheFoto.setLayoutY(0);
                getChildren().add(FicheFoto);
            }
        }

        if (FichesZwart.size() != 0) {
            for (Edelsteenfiche fiche : FichesZwart) {
                ImageView FicheFoto = fiche.getAfbeelding();
                FicheFoto.setFitWidth(100);
                FicheFoto.setPreserveRatio(true);
                FicheFoto.setLayoutX(550);
                FicheFoto.setLayoutY(0);
                getChildren().add(FicheFoto);
            }
        }*/
    }

            /*if(dc.isEindeBeurt() && !dc.isEindeSpel()){
                buildGui();
            }*/


        /*public void update(){
        if (this.speler != dc.getHuidigeSpeler()){
            buildGui();
            }
        }*/


}

