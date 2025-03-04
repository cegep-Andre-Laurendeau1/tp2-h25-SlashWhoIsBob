package ca.cal.tp2.modeles;

public abstract class Utilisateur {
    private int userID;
    private String name;
    private String email;
    private String phoneNumber;

    public Utilisateur(int userID, String name, String email, String phoneNumber) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
