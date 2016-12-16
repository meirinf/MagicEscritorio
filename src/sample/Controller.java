package sample;



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Controller extends Component {

    @FXML
    public ListView<Carta> lvLlistaCartes;
    public ImageView imagen;
    public TextArea Texto;
    public TextArea nombre;
    public TextArea rareza;
    public TextArea color;
    public String menRareza;
    public String menColor;


    public void initialize() {

        ApiCartas apicart = new ApiCartas();
        ArrayList<Carta> listacartas = apicart.getCardsTypes();

        lvLlistaCartes.setCellFactory(new Callback<ListView<Carta>, ListCell<Carta>>() {
            @Override
            public ListCell<Carta> call(ListView<Carta> p) {

                ListCell<Carta> cell = new ListCell<Carta>() {

                    @Override
                    protected void updateItem(Carta t, boolean bln) {
                        super.updateItem(t, bln);
                        if (t != null) {
                            String titulo="Nombre: "+t.getNombre();
                            String rareza="rareza: "+t.getRareza();
                            String color="color: "+t.getColor();
                            String texto=titulo+"\n"+rareza+"\n"+color;
                            setText(texto);
                        }
                    }
                };
                return cell;
            }
        });

        // Afegir llista observable d'items
        ObservableList<Carta> items = FXCollections.observableArrayList(
                listacartas);
        lvLlistaCartes.setItems(items);

        if (items.size()==0){
           Texto.setText("Has elejido una opción que no exite");
            Image image = new Image((getClass().getResourceAsStream("image/no_disponible.png")));
            imagen.setImage(image);
            nombre.setText("...");
            rareza.setText("...");
            color.setText("...");
        }
        else {
            Texto.setText(items.get(0).getTexto());
            Image image = new Image(items.get(0).getImagen());
            imagen.setImage(image);
            nombre.setText(items.get(0).getNombre());
            rareza.setText(items.get(0).getRareza());
            color.setText(items.get(0).getColor());
        }




        lvLlistaCartes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Carta>() {

            @Override
            public void changed(ObservableValue<? extends Carta> observable, Carta oldValue, Carta newValue) {

                Texto.setText("Descripción : "+newValue.getTexto());
                Image image1 = new Image(newValue.getImagen());
                imagen.setImage(image1);
                nombre.setText("Nombre : "+newValue.getNombre());
                rareza.setText("Rareza : "+newValue.getRareza());
                color.setText("Color : "+newValue.getColor());

            }
        });
    }

    public void Special(){
        menRareza = "Special";
        initialize();
    }
    public void Common(){
        menRareza = "Common";
        initialize();
    }
    public void Rare(){
        menRareza = "Rare";
        initialize();
    }
    public void Uncommon(){
        menRareza = "Uncommon";
        initialize();
    }
    public void Mythic_Rare(){
        menRareza = "Mythic Rare";
        initialize();
    }
    public void Basic_Land(){
        menRareza = "Basic Land";
        initialize();
    }


    public void Red(){
        menColor = "Red";
        initialize();
    }
    public void Black(){
        menColor = "Black";
        initialize();
    }
    public void White(){
        menColor = "White";
        initialize();
    }
    public void Blue(){
        menColor = "Blue";
        initialize();
    }

    public void Green() {
        menColor = "Green";
        initialize();
    }
}
