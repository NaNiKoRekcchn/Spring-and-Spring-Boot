import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity  // marking as entity , so now it will map with the user table in DB
public class UserClassHibernate {
    @Id
    private long id;
    private String name;

    public UserClassHibernate() {
    }

    public UserClassHibernate(long id, String name) {
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
