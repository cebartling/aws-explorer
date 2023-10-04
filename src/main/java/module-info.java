module com.pintailconsultingllc.awsexplorer {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires com.google.guice;
    requires jakarta.inject;


    opens com.pintailconsultingllc.awsexplorer.controllers to javafx.fxml, com.google.guice;
    opens com.pintailconsultingllc.awsexplorer.services to com.google.guice;
    exports com.pintailconsultingllc.awsexplorer;
}