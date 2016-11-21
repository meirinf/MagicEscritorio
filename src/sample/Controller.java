package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.util.ArrayList;

public class Controller {

    @FXML
    public ListView<Carta> lvLlistaCartes;
    public ImageView imagen;
    public TextField Texto;

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
                            setText(t.getNombre());
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
    }
}
