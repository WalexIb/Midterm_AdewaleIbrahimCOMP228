package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    // Check if a user exists by email address (unique identifier)
    public boolean userExists(String emailAddress) throws SQLException {
        String query = "SELECT id FROM users WHERE email_address = ?";
        try (Connection connection = Database.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, emailAddress);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // true if a record exists
            }
        }
    }

    // Save a new user and return the generated ID
    public int saveUser(User user) throws SQLException {
        String query = "INSERT INTO users(full_name, current_address, contact_number, email_address, highest_education," +
                " gender, date_available, desired_position, desired_salary, legally_authorized, has_relatives, relatives_details)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = Database.getDBConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);
            int counter = 1;
            statement.setString(counter++, user.getFullName());
            statement.setString(counter++, user.getCurrentAddress());
            statement.setString(counter++, user.getContactNumber());
            statement.setString(counter++, user.getEmailAddress());
            statement.setString(counter++, user.getHighestEducation());
            statement.setString(counter++, user.getGender());
            statement.setString(counter++, user.getDateAvailable());
            statement.setString(counter++, user.getDesiredPosition());
            statement.setDouble(counter++, user.getDesiredSalary());
            statement.setBoolean(counter++, user.isLegallyAuthorized());
            statement.setBoolean(counter++, user.hasRelatives());
            statement.setString(counter++, user.getRelativesDetails());

            statement.executeUpdate();
            connection.commit();

            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1); // Return generated user ID
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return 0;
    }
}
