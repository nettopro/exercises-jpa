package model.composition;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    
    private String address;
    private String supplement;


    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getSupplement() {
        return supplement;
    }
    public void setSupplement(String supplement) {
        this.supplement = supplement;
    }

    
}
