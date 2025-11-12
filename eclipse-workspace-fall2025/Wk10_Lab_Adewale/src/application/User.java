package application;

public class User {

    private int id;
    private String fullName;
    private String currentAddress;
    private String contactNumber;
    private String emailAddress;
    private String highestEducation;
    private String gender;
    private String dateAvailable;
    private String desiredPosition;
    private double desiredSalary;
    private boolean legallyAuthorized;
    private boolean hasRelatives;
    private String relativesDetails;

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(int id, String fullName, String currentAddress, String contactNumber,
                String emailAddress, String highestEducation, String gender, String dateAvailable,
                String desiredPosition, double desiredSalary, boolean legallyAuthorized,
                boolean hasRelatives, String relativesDetails) {
        this.id = id;
        this.fullName = fullName;
        this.currentAddress = currentAddress;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.highestEducation = highestEducation;
        this.gender = gender;
        this.dateAvailable = dateAvailable;
        this.desiredPosition = desiredPosition;
        this.desiredSalary = desiredSalary;
        this.legallyAuthorized = legallyAuthorized;
        this.hasRelatives = hasRelatives;
        this.relativesDetails = relativesDetails;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(String dateAvailable) {
        this.dateAvailable = dateAvailable;
    }

    public String getDesiredPosition() {
        return desiredPosition;
    }

    public void setDesiredPosition(String desiredPosition) {
        this.desiredPosition = desiredPosition;
    }

    public double getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(double desiredSalary) {
        this.desiredSalary = desiredSalary;
    }

    public boolean isLegallyAuthorized() {
        return legallyAuthorized;
    }

    public void setLegallyAuthorized(boolean legallyAuthorized) {
        this.legallyAuthorized = legallyAuthorized;
    }

    public boolean hasRelatives() {
        return hasRelatives;
    }

    public void setHasRelatives(boolean hasRelatives) {
        this.hasRelatives = hasRelatives;
    }

    public String getRelativesDetails() {
        return relativesDetails;
    }

    public void setRelativesDetails(String relativesDetails) {
        this.relativesDetails = relativesDetails;
    }

    // For debugging: easy to print user info
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", currentAddress='" + currentAddress + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", highestEducation='" + highestEducation + '\'' +
                ", gender='" + gender + '\'' +
                ", dateAvailable='" + dateAvailable + '\'' +
                ", desiredPosition='" + desiredPosition + '\'' +
                ", desiredSalary=" + desiredSalary +
                ", legallyAuthorized=" + legallyAuthorized +
                ", hasRelatives=" + hasRelatives +
                ", relativesDetails='" + relativesDetails + '\'' +
                '}';
    }
}


