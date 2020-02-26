package org.frozenfish.models;

import org.frozenfish.service.UserService;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer serviceId;
    private String serviceName;
    private Double servicePrice;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserServices> userServicesSet;

    public Service() {
    }

    public Service(String serviceName, Double servicePrice,Set<UserServices> userServicesSet) {
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.userServicesSet = userServicesSet;
    }


    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Set<UserServices> getUserServicesSet() {
        return userServicesSet;
    }

    public void setUserServiceSet(Set<UserServices> userServicesSet) {
        this.userServicesSet = userServicesSet;
    }
}
