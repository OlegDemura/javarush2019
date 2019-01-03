package parts.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "PART")
public class Part {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DEVICETITLE")
    @NotEmpty(message = "Введите название.")
    private String deviceTitle;

    @Column(name = "DEVICENAME")
    @NotEmpty(message = "Введите комплектующее.")
    private String deviceName;

    @Column(name = "NESSESERY")
    private boolean nessesery;

    @Column(name = "amount")
    @PartAmountConstraint
    private String amount;

    public Part() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceTitle() {
        return deviceTitle;
    }

    public void setDeviceTitle(String deviceTitle) {
        this.deviceTitle = deviceTitle;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean getNessesery() {
        return nessesery;
    }

    public void setNessesery(boolean nessesery) {
        this.nessesery = nessesery;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        if (nessesery != part.nessesery) return false;
        if (amount != part.amount) return false;
        if (id != null ? !id.equals(part.id) : part.id != null) return false;
        if (deviceTitle != null ? !deviceTitle.equals(part.deviceTitle) : part.deviceTitle != null) return false;
        return deviceName != null ? deviceName.equals(part.deviceName) : part.deviceName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (deviceTitle != null ? deviceTitle.hashCode() : 0);
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (nessesery ? 1 : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", deviceTitle='" + deviceTitle + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", nessesery=" + nessesery +
                ", amount=" + amount +
                '}';
    }
}
