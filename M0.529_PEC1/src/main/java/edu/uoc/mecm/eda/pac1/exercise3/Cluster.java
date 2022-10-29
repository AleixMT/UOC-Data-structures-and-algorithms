package edu.uoc.mecm.eda.pac1.exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class stores and manages a cluster of containerized services
 *
 * @author Carles Pairot Gavaldà
 */
public class Cluster {

    // TODO: Add your code here

    /**
     * List containing all services
     */
    private List<Service> services;

    /**
     * Adds a service to this list
     * @param s Service to add
     */
    public void addService (Service s) {
    }

    /**
     * Removes a service from the list
     * @param serviceID Service ID to remove
     */
    public void removeService (String serviceID) {
    }

    /**
     * Gets the cluster size
     * @return The size of the services list
     */
    public int getSize() {
        return -1;
    }

    /**
     * Returns the service identified by this ID
     * @param serviceID The service's ID
     * @return The service identified by this ID
     * @throws NoSuchElementException if the service was not found
     */
    public Service getService (String serviceID) throws NoSuchElementException {
        return null;
    }
}
