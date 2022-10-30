package edu.uoc.mecm.eda.pac1.exercise5;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

/**
 * Class that rearranges an input queue based on absolute values and returns it sorted in ascending order
 *
 * @author Carles Pairot Gavaldà
 */
public class Rearrange {

	/**
	 * Method that rearranges an input queue based on absolute values and returns it sorted in ascending order
 	 * @param q The input queue
	 * @return The sorted queue
	 */
	public Queue<Integer> rearrange (Queue<Integer> q) {
		if (q == null)
		{
			throw new IllegalArgumentException("Input queue cannot be null.");
		}

		// Build stacks for positives and negatives by using dequeue from the input parameter, and emptying it also
		Stack<Integer> positivesTmp = new Stack<>();
		Stack<Integer> negatives = new Stack<>();
		while (! q.isEmpty())
		{
			Integer elem = q.remove();
			if (elem <= 0)
			{
				negatives.push(elem);
			}
			else
			{
				positivesTmp.push(elem);
			}
		}

		// Invert positives
		Stack<Integer> positives = new Stack<>();
		while (! positivesTmp.isEmpty())
		{
			positives.push(positivesTmp.pop());
		}

		// Unstack from positives and negatives to build the return result in the input queue
		while (! negatives.isEmpty())
		{
			q.add(negatives.pop());
		}
		while (! positives.isEmpty())
		{
			q.add(positives.pop());
		}

		return q;
	}
}
