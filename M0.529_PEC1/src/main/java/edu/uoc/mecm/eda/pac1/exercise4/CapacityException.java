package edu.uoc.mecm.eda.pac1.exercise4;

/**
 * Class that models a general exception regarding a container whose IP is already bound
 *
 * @author Carles Pairot Gavaldà
 */
public class CapacityException extends Exception {

    private static final long serialVersionUID = -2912102657765213158L;

    public CapacityException (String msg) {
        super (msg);
    }
}
