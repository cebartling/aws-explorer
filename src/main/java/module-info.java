module com.pintailconsultingllc.awsexplorer {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.pintailconsultingllc.awsexplorer to javafx.fxml;
    exports com.pintailconsultingllc.awsexplorer;
}