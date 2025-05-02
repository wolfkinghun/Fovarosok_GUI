package com.example.fovaros;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class HelloController {

    @FXML public ListView lsLista;

    public class Varos{
        public String orszag;
        public String rovid;
        public Integer orszglakossag;
        public String fovaros;
        public Integer fovaroslakossag;
        public Varos(String sor){
            String[] s = sor.split(";");
            orszag = s[0];
            rovid = s[1];
            orszglakossag = Integer.parseInt(s[2]);
            fovaros = s[3];
            orszglakossag = Integer.parseInt(s[4]);
        }
    }
    public ArrayList<Varos> orszag_varosok = new ArrayList<>();
    private FileChooser fc = new FileChooser();

    public void initialize() {
        fc.setInitialDirectory(new File("./"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV fájlok", "*.csv"));
    }
    @FXML private void onMegnyitasClick() {
        File fbe = fc.showOpenDialog(lsLista.getScene().getWindow());
        if (fbe != null) {
            orszag_varosok.clear();
            lsLista.getItems().clear();
            betolt(fbe);
            for (Varos var : orszag_varosok) lsLista.getItems().add(String.format("%s (%,d fő): %s", var.orszag, var.orszglakossag, var.rovid));
            lsLista.getSelectionModel().select(0);
        }
    }
    public void betolt(File fajl){
        Scanner be = null;
        try {
            be = new Scanner(fajl,"utf-8");
            be.nextLine();
            while (be.hasNextLine()){
                orszag_varosok.add(new Varos(be.nextLine()));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error not find file.");
        }
        finally {
            if(be!=null) be.close();
        }
    }

    @FXML private void onKilepesClick() {
        // Alkalmazás bezárása
        Platform.exit();
    }
    @FXML private void onNevjegyClick() {
        // Névjegy megjelenítése információs ablakban
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Névjegy");
        info.setHeaderText(null);
        info.setContentText("Névnap v1.0\n(C) Kandó");
        info.showAndWait();
    }
}