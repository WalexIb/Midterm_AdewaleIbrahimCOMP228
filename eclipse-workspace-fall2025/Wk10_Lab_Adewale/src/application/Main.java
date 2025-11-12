package application;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        UserDao userDao = new UserDao();
        primaryStage.setTitle("Employment Application");

        VBox root = new VBox(15);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: white;");

        // Title
        HBox titleBox = new HBox();
        titleBox.setStyle("-fx-background-color: black;");
        titleBox.setPadding(new Insets(10));
        Text title = new Text("Employment Application");
        title.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        title.setStyle("-fx-fill: white;");
        titleBox.getChildren().add(title);
        titleBox.setAlignment(Pos.CENTER);

        // Personal Information Section
        VBox personalInfoBox = new VBox(10);
        Text personalTitle = new Text("Personal Information");
        personalTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        personalInfoBox.getChildren().add(personalTitle);

        GridPane personalGrid = new GridPane();
        personalGrid.setHgap(10);
        personalGrid.setVgap(10);
        personalGrid.setPadding(new Insets(10));

        // Full Name
        Label nameLabel = new Label("Full Name:");
        TextField nameField = new TextField();
        personalGrid.add(nameLabel, 0, 0);
        personalGrid.add(nameField, 1, 0);

        // Current Address
        Label addressLabel = new Label("Current Address:");
        TextField addressField = new TextField();
        personalGrid.add(addressLabel, 0, 1);
        personalGrid.add(addressField, 1, 1);

        // Contact Number
        Label contactLabel = new Label("Contact Number:");
        TextField contactField = new TextField();
        personalGrid.add(contactLabel, 0, 2);
        personalGrid.add(contactField, 1, 2);

        // Email Address
        Label emailLabel = new Label("Email Address:");
        TextField emailField = new TextField();
        personalGrid.add(emailLabel, 2, 2);
        personalGrid.add(emailField, 3, 2);

        // Highest Education
        Label eduLabel = new Label("Highest Education:");
        TextField eduField = new TextField();
        personalGrid.add(eduLabel, 0, 3);
        personalGrid.add(eduField, 1, 3);

        // Gender
        Label genderLabel = new Label("Gender:");
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        RadioButton other = new RadioButton("Other");
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);
        other.setToggleGroup(genderGroup);
        HBox genderBox = new HBox(10, male, female, other);
        personalGrid.add(genderLabel, 2, 3);
        personalGrid.add(genderBox, 3, 3);

        personalInfoBox.getChildren().add(personalGrid);

        // Employment Eligibility Section
        VBox employmentBox = new VBox(10);
        Text empTitle = new Text("Employment Eligibility");
        empTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        employmentBox.getChildren().add(empTitle);

        GridPane empGrid = new GridPane();
        empGrid.setHgap(10);
        empGrid.setVgap(10);
        empGrid.setPadding(new Insets(10));

        // Date Available
        Label dateLabel = new Label("Date Available:");
        DatePicker datePicker = new DatePicker();
        empGrid.add(dateLabel, 0, 0);
        empGrid.add(datePicker, 1, 0);

        // Desired Position
        Label posLabel = new Label("Desired Position:");
        TextField posField = new TextField();
        empGrid.add(posLabel, 2, 0);
        empGrid.add(posField, 3, 0);

        // Desired Salary
        Label salaryLabel = new Label("Desired Salary:");
        TextField salaryField = new TextField();
        empGrid.add(salaryLabel, 0, 1);
        empGrid.add(salaryField, 1, 1);

        // Legally Authorized
        Label legalLabel = new Label("Legally Authorized:");
        ToggleGroup legalGroup = new ToggleGroup();
        RadioButton yesLegal = new RadioButton("Yes");
        RadioButton noLegal = new RadioButton("No");
        yesLegal.setToggleGroup(legalGroup);
        noLegal.setToggleGroup(legalGroup);
        HBox legalBox = new HBox(10, yesLegal, noLegal);
        empGrid.add(legalLabel, 0, 2);
        empGrid.add(legalBox, 1, 2);

        // Has Relatives
        Label relLabel = new Label("Relatives in Company:");
        ToggleGroup relGroup = new ToggleGroup();
        RadioButton yesRel = new RadioButton("Yes");
        RadioButton noRel = new RadioButton("No");
        yesRel.setToggleGroup(relGroup);
        noRel.setToggleGroup(relGroup);
        HBox relBox = new HBox(10, yesRel, noRel);
        empGrid.add(relLabel, 0, 3);
        empGrid.add(relBox, 1, 3);

        // Relatives Details
        Label relDetailsLabel = new Label("If yes, explain:");
        TextField relDetailsField = new TextField();
        empGrid.add(relDetailsLabel, 0, 4);
        empGrid.add(relDetailsField, 1, 4, 3, 1); // Span 3 columns

        employmentBox.getChildren().add(empGrid);

        // Submit Section
        Label agreementLabel = new Label("By submitting this application, you agree to adhere to company policies and provide accurate information throughout the employment process.");
        TextField signatureField = new TextField();
        signatureField.setPromptText("Applicant's Signature");
        VBox submitBox = new VBox(5, agreementLabel, signatureField);

        // Save Button
        Button saveButton = new Button("Submit Application");
        saveButton.setOnAction(e -> {
            try {
                String fullName = nameField.getText().trim();
                String address = addressField.getText().trim();
                String contact = contactField.getText().trim();
                String email = emailField.getText().trim();
                String education = eduField.getText().trim();
                String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "Other";
                String dateAvailable = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
                String position = posField.getText().trim();
                double salary = Double.parseDouble(salaryField.getText().trim());
                boolean legallyAuthorized = yesLegal.isSelected();
                boolean hasRelatives = yesRel.isSelected();
                String relativesDetails = relDetailsField.getText().trim();

                if (!fullName.isEmpty() && !email.isEmpty()) {
                    if (!userDao.userExists(email)) {
                        User user = new User();
                        user.setFullName(fullName);
                        user.setCurrentAddress(address);
                        user.setContactNumber(contact);
                        user.setEmailAddress(email);
                        user.setHighestEducation(education);
                        user.setGender(gender);
                        user.setDateAvailable(dateAvailable);
                        user.setDesiredPosition(position);
                        user.setDesiredSalary(salary);
                        user.setLegallyAuthorized(legallyAuthorized);
                        user.setHasRelatives(hasRelatives);
                        user.setRelativesDetails(relativesDetails);
                        int userId = userDao.saveUser(user);
                        if (userId > 0) {
                            showAlert(Alert.AlertType.INFORMATION, "Success", "Application submitted!");
                        } else {
                            showAlert(Alert.AlertType.ERROR, "Error", "Failed to save application!");
                        }
                    } else {
                        showAlert(Alert.AlertType.ERROR, "Error", "User already exists!");
                    }
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Full Name and Email are required!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                showAlert(Alert.AlertType.ERROR, "Error", "Database error occurred!");
            } catch (NumberFormatException nfe) {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid salary format!");
            }
        });

        root.getChildren().addAll(titleBox, personalInfoBox, employmentBox, submitBox, saveButton);

        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}





