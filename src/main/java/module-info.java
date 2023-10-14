module com.pintailconsultingllc.awsexplorer {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires com.google.guice;
    requires jakarta.inject;
    requires software.amazon.awssdk.auth;
    requires software.amazon.awssdk.regions;
    requires software.amazon.awssdk.services.cloudformation;


    opens com.pintailconsultingllc.awsexplorer.controllers to javafx.fxml, com.google.guice;
    opens com.pintailconsultingllc.awsexplorer.services to com.google.guice;
    opens com.pintailconsultingllc.awsexplorer.modules to com.google.guice;
    opens com.pintailconsultingllc.awsexplorer.guice to com.google.guice;
    exports com.pintailconsultingllc.awsexplorer;
}