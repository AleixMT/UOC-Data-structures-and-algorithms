package edu.uoc.mecm.eda.pac1.exercise3;

/**
 * Class that models a general exception regarding a container whose IP is already bound
 *
 * @author Carles Pairot Gavaldà
 */
public class ContainerIPAlreadyBoundException extends Exception {

    private static final long serialVersionUID = -2912102657785213158L;

    public ContainerIPAlreadyBoundException (String msg) {
        super (msg);
    }
}
