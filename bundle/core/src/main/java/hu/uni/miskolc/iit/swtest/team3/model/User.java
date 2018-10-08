package hu.uni.miskolc.iit.swtest.team3.model;

public abstract class User {

    private int userId;
    private String passwordHash;
    private String name;
    private String email;

    public User(int userId, String passwordHash, String name, String email) {
        this.userId = userId;
        this.passwordHash = passwordHash;
        this.name = name;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
