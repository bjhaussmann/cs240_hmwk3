/**
 * 
 */
package cs240_hmwk3;

/**
 * @author bjhau
 *
 */
public class EmptyQueueException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyQueueException() {
		System.out.println("Queue is Empty!");
	}
}
