package GUI;

import domein.DomeinController;
import domein.Edelsteenfiche;
import domein.Speler;
import domein.Taal;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class EdelsteenPaneel extends Pane {

    private Taal keuze;
    private Stack<Edelsteenfiche> fichesWit;
    private Stack<Edelsteenfiche> fichesBlauw;
    private Stack<Edelsteenfiche> fichesGroen;
    private Stack<Edelsteenfiche> fichesRood;
    private Stack<Edelsteenfiche> fichesZwart;
    private DomeinController dc;
    private Speler huidigeSpeler;
    private boolean refresh;

    private List<Edelsteenfiche> gekozen;
    public EdelsteenPaneel(DomeinController dc, Taal keuze) {
        this.keuze = keuze;
        this.dc = dc;
        gekozen = new ArrayList<>();
        buildGui();
    }
        public void buildGui() {
            fichesWit = dc.getFicheWit();
            fichesBlauw = dc.getFicheBlauw();
            fichesGroen = dc.getFicheGroen();
            fichesRood = dc.getFicheRood();
            fichesZwart = dc.getFicheZwart();
            huidigeSpeler = dc.getHuidigeSpeler();

            if (fichesWit.size() != 0) {
                ImageView witImageView = fichesWit.get(0).getAfbeelding();
                witImageView.setFitWidth(100);
                witImageView.setPreserveRatio(true);
                witImageView.setLayoutY(100);
                getChildren().add(witImageView);
                witImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        gekozen.add(new Edelsteenfiche("wit"));
                        neemFiches(gekozen);
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
                blauwImageView.setLayoutY(225);
                getChildren().add(blauwImageView);
                blauwImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        gekozen.add(new Edelsteenfiche("blauw"));
                        neemFiches(gekozen);
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
                groenImageView.setLayoutY(350);
                getChildren().add(groenImageView);
                groenImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        gekozen.add(new Edelsteenfiche("groen"));
                        neemFiches(gekozen);
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
                roodImageView.setLayoutY(475);
                getChildren().add(roodImageView);
                roodImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        gekozen.add(new Edelsteenfiche("rood"));
                        neemFiches(gekozen);
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
                zwartImageView.setLayoutY(600);
                getChildren().add(zwartImageView);
                zwartImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        gekozen.add(new Edelsteenfiche("zwart"));
                        neemFiches(gekozen);
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

}
   public void neemFiches(List<Edelsteenfiche> gekozen){
       if (gekozen.size()==2 && gekozen.get(0).getKleur().equals(gekozen.get(1).getKleur())){
           try{
               test();
               dc.neemFiches(gekozen);
               Alert aSucces = new Alert(Alert.AlertType.INFORMATION);
                aSucces.setTitle(keuze.getBundleTaal().getString("fichesGenomen"));
                aSucces.setHeaderText(keuze.getBundleTaal().getString("fichesGenomen"));
                aSucces.show();
               this.gekozen = new ArrayList<>();
               update();
               test();
           }catch (Exception e){
               test();
               Alert aError = new Alert(Alert.AlertType.ERROR);
               aError.setTitle(keuze.getBundleTaal().getString(e.getMessage()));
               aError.setHeaderText(keuze.getBundleTaal().getString(e.getMessage()));
               aError.show();
               update();
               test();
           }
       } else if (gekozen.size()==3&&!Objects.equals(gekozen.get(0).getKleur(), gekozen.get(1).getKleur()) && !Objects.equals(gekozen.get(0).getKleur(), gekozen.get(2).getKleur()) && !Objects.equals(gekozen.get(1).getKleur(), gekozen.get(2).getKleur())){
           try{
               test();
               dc.neemFiches(gekozen);
                Alert aSucces = new Alert(Alert.AlertType.INFORMATION);
                aSucces.setTitle(keuze.getBundleTaal().getString("fichesGenomen"));
                aSucces.setHeaderText(keuze.getBundleTaal().getString("fichesGenomen"));
                aSucces.show();
               this.gekozen = new ArrayList<>();
               update();
               test();
           }catch (Exception e){
               test();
               Alert aError = new Alert(Alert.AlertType.ERROR);
               aError.setTitle(keuze.getBundleTaal().getString(e.getMessage()));
               aError.setHeaderText(keuze.getBundleTaal().getString(e.getMessage()));
               aError.show();
               update();
               test();
           }
       }
   }

   public void update()
   {


   }
    public void test() {
        System.out.println(dc.getHuidigeSpeler().getNaam()+dc.getHuidigeSpeler().getAantalFiches());
    }

}

