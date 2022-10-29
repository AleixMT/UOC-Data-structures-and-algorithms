package edu.uoc.mecm.eda.pac1.exercise3;

import java.net.InetAddress;
import java.util.Date;

/**
 * Class that implements a simple software Container
 *
 * @author Carles Pairot Gavaldà
 */
public class Container {

    /**
     * Container ID
     */
    private String containerID;

    /**
     * Container name
     */
    private String name;

    /**
     * Container rating
     */
    private String owner;

    /**
     * Container init date
     */
    private Date initDate;

    /**
     * Container internal IP
     */
    private InetAddress ipAddress;

    /**
     * Constructor for the Container ADT
     * @param containerID The container's ID
     * @param name The container's name
     * @param owner The container's owner
     * @param initDate The container's init date
     * @param ipAddress The container's internal IP Address
     */
    public Container (String containerID, String name, String owner, Date initDate, InetAddress ipAddress) {
    }

    /**
     * Get the container's ID
     * @return The container's ID
     */
    public String getID() {
        return null;
    }

    /**
     * Set the container's ID
     * @param containerID The container's ID to be set
     */
    public void setID (String containerID) {
    }

    /**
     * Get the container's name
     * @return The container's name
     */
    public String getName() {
        return null;
    }

    /**
     * Set the container's name
     * @param name The container's name to be set
     */
    public void setName (String name) {
    }

    /**
     * Get the container's owner
     * @return The container's owner
     */
    public String getOwner() {
        return null;
    }

    /**
     * Set the container's owner
     * @param owner The container's owner to be set
     */
    public void setOwner (String owner) {
    }

    /**
     * Get the container's init date
     * @return The container's init date
     */
    public Date getInitDate() {
        return null;
    }

    /**
     * Set the container's init date
     * @param initDate The container's init date
     */
    public void setInitDate (Date initDate) {
    }

    /**
     * Get the container's internal IP Address
     * @return The container's internal IP Address
     */
    public InetAddress getIPAddress() {
        return null;
    }

    /**
     * Set the container's internal IP Address
     * @param ipAddress The container's internal IP Address
     */
    public void setIPAddress (InetAddress ipAddress) {
    }
}
