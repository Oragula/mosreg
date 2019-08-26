package mosreg.testTask.model;

import javax.persistence.*;

@Entity
public class Credit {

    private int idCredit;
    private int sum;
    private short term;
    private Client client;
    private Country country;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(int idCredit) {
        this.idCredit = idCredit;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public short getTerm() {
        return term;
    }

    public void setTerm(short term) {
        this.term = term;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "idClient")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne()
    @JoinColumn(referencedColumnName = "countryName")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Credit{");
        sb.append("idCredit=").append(idCredit);
        sb.append(", sum=").append(sum);
        sb.append(", term=").append(term);
        sb.append(", client=").append(client);
        sb.append(", country=").append(country);
        sb.append('}');
        return sb.toString();
    }
}
