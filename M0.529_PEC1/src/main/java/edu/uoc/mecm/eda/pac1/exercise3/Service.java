package edu.uoc.mecm.eda.pac1.exercise3;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class that implements a containerized Service
 *
 * @author Carles Pairot Gavaldà
 */
public class Service {

    /**
     * Service ID
     */
    private String serviceID;

    // TODO: Choose the best ADT for storing this service's containers

    /**
     * List of containers stored within this service
     */
    private List<Container> containers;

    /**
     * Service's name
     */
    private String name;

    /**
     * Service's external IP address
     */
    private InetAddress externalIPAddress;

    /**
     * Service's DNS name
     */
    private String dnsName;

    public Service (String serviceID, String serviceName, List<Container> containers, InetAddress externalIPAddress, String dnsName) throws ContainerIPAlreadyBoundException {
        int pos = this.verifyContainerIPs(containers);
        if (pos != -1)
        {
            throw new ContainerIPAlreadyBoundException("Container " + containers.get(pos).getName() + " cannot be added because its internal IP address is already bound by another container.");
        }

        // Implicit else
        this.serviceID = serviceID;
        this.name = serviceName;
        this.containers = containers;
        this.externalIPAddress = externalIPAddress;
        this.dnsName = dnsName;
    }

    /**
     * Get Service's ID
     * @return Service's ID
     */
    public String getID() {
        return this.serviceID;
    }

    /**
     * Set Service's ID
     * @param serviceID The ID to set this Service to
     */
    public void setID (String serviceID) {
        this.serviceID = serviceID;
    }

    /**
     * Get Service's name
     * @return Service's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set this Service's name
     * @param name The name to set this service to
     */
    public void setName (String name) {
        this.name = name;
    }

    /**
     * Get Service's external IP address
     * @return Service's external IP address
     */
    public InetAddress getIPAddress() {
        return this.externalIPAddress;
    }

    /**
     * Set this Service's external IP Address
     * @param ipAddress The external IP address for this service
     */
    public void setExternalIPAddress (InetAddress ipAddress) {
        this.externalIPAddress = ipAddress;
    }

    /**
     * Get Service's DNS name
     * @return Service's DNS name
     */
    public String getDNSName() {
        return this.dnsName;
    }

    /**
     * Set this Service's DNS name
     * @param dnsName The DNS name to set this service to
     */
    public void setDNSName (String dnsName) {
        this.dnsName = dnsName;
    }

    /**
     * Get Service's running containers
     * @return Service's running containers
     */
    public List<Container> getContainers() {
        return this.containers;
    }

    /**
     * Set service's containers.
     *
     * @param containers The containers running for this service
     * @throws ContainerIPAlreadyBoundException if trying to add a container with the same internal IP as another
     */
    public void setContainers (List<Container> containers) throws ContainerIPAlreadyBoundException {
        int pos = this.verifyContainerIPs(containers);
        if (pos != -1)
        {
            throw new ContainerIPAlreadyBoundException("Container " + containers.get(pos).getName() + " cannot be added because its internal IP address is already bound by another container.");
        }
        this.containers = containers;
    }

    /**
     * Private method that checks whether there are repeated IPs on the container list.
     *
     * @param containers The container list
     * @return The index in which the container IP is repeated (-1 if all IPs are unique)
     */
    private int verifyContainerIPs (List<Container> containers) {
        Map<InetAddress, Integer> temp = new HashMap<>();

        for (int i = 0; i < containers.size(); i++)
        {
            if (temp.containsKey(containers.get(i).getIPAddress()))
            {
                return temp.get(containers.get(i).getIPAddress());  // return the first offending position
            }

            // Implicit else
            temp.put(containers.get(i).getIPAddress(), i);
        }

        return -1;
    }
}
