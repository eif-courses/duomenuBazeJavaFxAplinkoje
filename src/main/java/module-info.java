module eif.viko.lt.duomenubazejavafxaplinkoje {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens eif.viko.lt.duomenubazejavafxaplinkoje to javafx.fxml;
    exports eif.viko.lt.duomenubazejavafxaplinkoje;
}