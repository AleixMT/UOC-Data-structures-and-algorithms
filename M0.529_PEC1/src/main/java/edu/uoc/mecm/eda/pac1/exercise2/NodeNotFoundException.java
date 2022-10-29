package edu.uoc.mecm.eda.pac1.exercise2;

/**
 * Class that models a general exception regarding an expression validation
 *
 * @author Carles Pairot Gavaldà
 */
public class NodeNotFoundException extends Exception {

    private static final long serialVersionUID = -2912102877785213126L;

    public NodeNotFoundException (String msg) {
        super (msg);
    }
}
