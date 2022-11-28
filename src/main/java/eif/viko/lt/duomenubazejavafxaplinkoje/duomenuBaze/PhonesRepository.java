package eif.viko.lt.duomenubazejavafxaplinkoje.duomenuBaze;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhonesRepository {
    private static PhonesRepository instance;
    String url = "localhost";
    int port = 5433;
    String databaseName = "phones";
    String userName = "postgres";
    String password = "root";
    Connection connection = null;

    private PhonesRepository() {
        initializePostgreSQL();
    }

    public static PhonesRepository getInstance() {
        if (instance == null) {
            instance = new PhonesRepository();
        }
        return instance;
    }


    private void initializePostgreSQL() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());

            String dbPath = "jdbc:postgresql://" + url + ":" + port + "/" + databaseName;

            connection = DriverManager.getConnection(dbPath, userName, password);

            System.out.println("SUCESSFULLY CONNECTED TO DB");

        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace(System.err);
        } finally {
            if (connection == null) {
                System.exit(-1);
            }
        }
    }

    public List<Phone> getAllPhones() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM phones");
            ResultSet sqlResultValues = statement.executeQuery();
            List<Phone> data = new ArrayList<>();

            while (sqlResultValues.next()) {
                data.add(new Phone(sqlResultValues.getInt(1),
                        sqlResultValues.getString(2),
                        sqlResultValues.getInt(3)
                ));
            }
            return data;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean createNewPhone(Phone phone) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO phones (name, amount_of_ram) VALUES (?,?);");
            preparedStatement.setString(1, phone.getName());
            preparedStatement.setInt(2, phone.getAmount_of_ram());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
