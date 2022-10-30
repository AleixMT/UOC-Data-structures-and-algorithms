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

    /**
     * List containing all services
     */
    private List<Service> services = new ArrayList<>();

    /**
     * Adds a service to this list
     * @param s Service to add
     */
    public void addService (Service s) {
        this.services.add(s);
    }

    /**
     * Removes a service from the list
     * @param serviceID Service ID to remove
     */
    public void removeService (String serviceID) {
        this.services.removeIf(
                (Service service) ->
                {
                    return service.getID().equals(serviceID);
                }
        );

    }

    /**
     * Gets the cluster size
     * @return The size of the services list
     */
    public int getSize() {
        return this.services.size();
    }

    /**
     * Returns the service identified by this ID
     * @param serviceID The service's ID
     * @return The service identified by this ID
     * @throws NoSuchElementException if the service was not found
     */
    public Service getService (String serviceID) throws NoSuchElementException {
        return this.services.stream()
                .filter(
                    (Service service) ->
                    {
                        return service.getID().equals(serviceID);
                    }
                )
                .findFirst()
                .orElseThrow(
                        () ->
                        {
                            return new NoSuchElementException("The Service with ID = " + serviceID + " was not found.");
                        }
                );
    }
}
