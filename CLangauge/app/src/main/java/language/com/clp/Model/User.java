package language.com.clp.Model;

public class User {
    private String userName;
    private String password;
    private String email;

    public User() {
    }

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;

    }

    public String getEmail() {
        return email;
    }
}
