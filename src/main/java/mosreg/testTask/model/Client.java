package mosreg.testTask.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Client {
    private long idClient;
    private String name;
    private String surname;

    public Client() {
    }

    public Client(long idClient, String name, String surname) {
        this.idClient = idClient;
        this.name = name;
        this.surname = surname;
    }

    @Id
    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Client{");
        sb.append("idClient=").append(idClient);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return getIdClient() == client.getIdClient() &&
                Objects.equals(getName(), client.getName()) &&
                Objects.equals(getSurname(), client.getSurname());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdClient(), getName(), getSurname());
    }
}
