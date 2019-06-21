package models;

public class AdoptionFormData {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String address2;
    private String country;
    private String state;
    private String zip;
    private String bestGoat;
    private String comments;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getBestGoat() {
        return bestGoat;
    }

    public void setBestGoat(String bestGoat) {
        this.bestGoat = bestGoat;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public static AdoptionFormData getDefaultRequiredFormData() {
        // Returns an object with sample data for only the required fields
        // TODO: generate random data instead of static data
        AdoptionFormData formData = new AdoptionFormData();
        formData.setFirstName("Demo");
        formData.setLastName("User");
        formData.setAddress("1060 W Addison St");
        formData.setCountry("United States");
        formData.setState("Illinois");
        formData.setZip("60613");
        formData.setBestGoat("LogicGoat");
        return formData;
    }

    public static AdoptionFormData getDefaultFormData() {
        // Returns an object with sample data for all form fields
        AdoptionFormData formData = AdoptionFormData.getDefaultRequiredFormData();
        formData.setEmail("test@demo.com");
        formData.setAddress2("Apt 2B");
        formData.setComments("I like goats!");
        return formData;
    }
}
