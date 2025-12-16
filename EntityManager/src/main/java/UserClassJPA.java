import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  // marking as entity , so now it will map with the user table in DB
public class UserClassJPA {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;
    private String name;

    public UserClassJPA() {
    }

    public UserClassJPA(String name) {
        this.name = name;
    }

    public UserClassJPA(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
