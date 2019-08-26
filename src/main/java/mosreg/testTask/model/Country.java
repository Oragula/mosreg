package mosreg.testTask.model;

import javax.persistence.*;

@Entity
public class Country {

    private String countryName;
    private int ordersPerMinute;

    public Country() {
    }

    public Country(String countryName, int ordersPerMinute) {
        this.countryName = countryName;
        this.ordersPerMinute = ordersPerMinute;
    }

    @Id
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Column(nullable = true)
    public int getOrdersPerMinute() {
        return ordersPerMinute;
    }

    public void setOrdersPerMinute(int ordersPerMinute) {
        this.ordersPerMinute = ordersPerMinute;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Country{");
        sb.append("countryName='").append(countryName).append('\'');
        sb.append(", ordersPerMinute=").append(ordersPerMinute);
        sb.append('}');
        return sb.toString();
    }
}
