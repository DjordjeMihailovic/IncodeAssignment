package Helpers;

public class TestUser {

    private String username;
    private String password;
    private String ClientID;

    public TestUser(String user) {

        switch (user) {
            case "Bob":
                this.username = "qa.auto3@incode.com";
                this.password = "QYD4gby1fqr-efh*yfx";
                this.ClientID = "qaautotest4901";
                break;
            case "admin":
                this.username = "admin";
                this.password = "password";
                this.ClientID = "admin123";
        }
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getClientID() { return ClientID; }


    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setClientID(String ClientID) { this.ClientID = ClientID; }

}


