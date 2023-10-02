module com.pintailconsultingllc.awsexplorer {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires com.google.guice;
    requires jakarta.inject;


    opens com.pintailconsultingllc.awsexplorer.controllers to javafx.fxml;
    exports com.pintailconsultingllc.awsexplorer;
}