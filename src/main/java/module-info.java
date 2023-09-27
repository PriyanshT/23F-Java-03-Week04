module com.georgiancollege.week04 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.georgiancollege.week04 to javafx.fxml;
    exports com.georgiancollege.week04;
}