package fran0880_l04;
/**
 * The Rectangle class calculates the area of a rectangle, given the length and width as parameters.
 * Also, an "optional" third parameter, called "units", is used to indicate if a units conversion is required, and if so,
 * the type of conversion. This units conversion specifier is explained as follows:
 * 
 *   ci = Assumes that the length and width values are in centimeters. Area is reported in inches
 *   ic = Assumes that the length and width values are in inches. Area is reported in centimeters.
 *   
 * When the "units" parameter is NOT given, that is, the rectangle class is invoked without this
 * parameter, no units conversion is performed. The Area is calculated as if the length and width are
 * dimensionless.
 * 
 * @author rmagnotta
 *
 */
public class Rectangle {
	
	public static double area(float width, float length, String conv) {
		double area = 0;
		if(conv.equals("ic")) {
			area = width *Convert.i_to_c *  length * Convert.i_to_c;
		} else if(conv.equals("ci")) {
			area = width *   Convert.c_to_i * length * Convert.c_to_i;
		}
		return area;
	}
	public static double area(float width, float length) {
		double area = 0;
		area=  width * length;
		return area;
	}
	//<*** YOUR CODE HERE ***>

}
