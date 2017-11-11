
/**
 * @author Eric Pacheco
 *
 */
import java.util.function.DoubleFunction;

public interface Continuous extends DoubleFunction<Object> {
	Polynomial derivative(double[] poly);
}