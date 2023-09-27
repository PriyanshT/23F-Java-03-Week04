package com.georgiancollege.week04;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StringController implements Initializable {
    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Label resultLabel;

    @FXML
    private Label noSpaceLabel;

    @FXML
    private Label formattedLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("I am in the controller - initialize method.");

        String s1 = new String("I am a string!");
        String s2 = "I am a string!"; // String s2 = "I am a string!";

        // using ==
        if(s1 == s2){
            System.out.println("Both the strings are equal.");
        } else {
            System.out.println("Both the strings are not equal.");
        }

        // using equals method
        if(s1.equals(s2)){
            System.out.println("Both the strings are equal.");
        } else {
            System.out.println("Both the strings are not equal.");
        }

        // string builder class
        StringBuilder sb1 = new StringBuilder("ABC");
        System.out.println(sb1);
        sb1.append("XYZ");
        System.out.println(sb1);

        // regex
        // adding phone number text field change listener using lambda function
        phoneNumberTextField.textProperty().addListener(((observableValue, s, phoneNum) -> {
            // System.out.println(phoneNum);

            // display to show user if phone number is correct or not
            if(phoneNum.matches("\\(?[2-9][0-9][0-9]\\)?[-.\\s]?[2-9]\\d{2}[-.\\s]?\\d{4}")){
                resultLabel.setText(phoneNum + " is a valid phone number.");
            } else {
                resultLabel.setText(phoneNum + " is not a valid phone number.");
            }

            // remove the space/expressions, so that it can be used to store it in database or anywhere else
            String noSpacePhoneNum = phoneNum.replaceAll("[-\\s\\(\\).]", ""); // 7052413456
            noSpaceLabel.setText(noSpacePhoneNum);

            // format the string so that user can see it properly
            if(noSpacePhoneNum.length() == 10){
                String areaCode = noSpacePhoneNum.substring(0, 3);
                String secondPart = noSpacePhoneNum.substring(3, 6);
                String lastPart = noSpacePhoneNum.substring(6);
                formattedLabel.setText(String.format("(%s) %s-%s", areaCode, secondPart, lastPart)); // (705) 241-3456
            }
        }));
    }
}
