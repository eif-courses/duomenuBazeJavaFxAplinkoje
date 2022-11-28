package eif.viko.lt.duomenubazejavafxaplinkoje;

import eif.viko.lt.duomenubazejavafxaplinkoje.duomenuBaze.Phone;
import eif.viko.lt.duomenubazejavafxaplinkoje.duomenuBaze.PhonesRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    PhonesRepository phonesRepository = PhonesRepository.getInstance();
    @FXML
    private Label tekstas;
    @FXML
    private TextField pavadinimas;


    @FXML
    void insertToDatabase(ActionEvent event) {
        boolean isCreated = phonesRepository.createNewPhone(new Phone(null, pavadinimas.getText(), 8));
        if(isCreated){
            tekstas.setText("Telefonas sekmingai sukurtas");
        }
        var data = phonesRepository.getAllPhones();

        for(var phone: data){
            System.out.println(phone);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}