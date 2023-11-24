import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String email;
    private int birthyear;

    public User(String name, String email, int birthyear){
        this.name = name;
        this.email = email;
        this.birthyear = birthyear;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getBirthyear() {
        return birthyear;
    }
}

