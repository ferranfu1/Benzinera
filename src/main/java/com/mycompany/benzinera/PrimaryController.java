package com.mycompany.benzinera;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    RadioButton diesel;
    @FXML
    RadioButton gasolina;
    @FXML
    TextField preu;
    @FXML
    TextField quantitat;
    @FXML
    TextField total;
    
    @FXML
    DatePicker datap;
    @FXML
    TextArea ticket;
    @FXML
    TextField matricula;
     
    double dpreu;
    
     private String dataCompra() {
        LocalDate data = datap.getValue();
        if (data == null) {
            data = LocalDate.now();
        }
        DateTimeFormatter formatData = 
           DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String avuiFormat = data.format(formatData);
        return avuiFormat;
    }
    
    @FXML    
    void calcular() {      
        
      try {
          
        if(matricula.getText().equals("")) 
            throw new NumberFormatException("Matricula incorrecta");
            
        String squantitat = quantitat.getText();
        double dquant = Double.parseDouble(squantitat);
        double dtotal = dquant * dpreu;
        
        total.setText(dtotal+"");
        ticket.setText(matricula.getText()+"\n"
                       + dataCompra());
      }
      catch(NumberFormatException e) {
          
      }
        
        
    }
    
    @FXML    
    void canviPreu() {
        
        if(diesel.isSelected()) {
            dpreu = 1.60;
            preu.setText(dpreu+"");
        } else
        if(gasolina.isSelected()) {
            dpreu = 1.70;
            preu.setText(dpreu+"");
        }
        else {
            dpreu = 0;
            preu.setText(dpreu+"");
        }
    }
    
    @FXML    
    void initialize() {
        
       canviPreu();
   }
}
