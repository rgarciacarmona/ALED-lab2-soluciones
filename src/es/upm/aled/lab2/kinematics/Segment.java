package es.upm.aled.lab2.kinematics;

import java.util.ArrayList;
import java.util.List;

// SOLUCION
/**
 * Class representing one segment in the kinematic chain of an exoskeleton.
 * Each Segment is characterized by its length (it's assumed to have the shape
 * of a straight line) , the angle it forms with the previous segment in the
 * kinematic chain (in radians), and its children: the next Segments in the
 * chain. Take note that multiple branches are possible, that's why a Segment
 * can have multiple children.
 * 
 * @author rgarciacarmona
 */
// SOLUCION
public class Segment {

	// SOLUCION
	private double length;
	private double angle;
	private List<Segment> children;

	/**
	 * Builds a new Segment from its length and angle.
	 * 
	 * @param x The length of the Segment (in cm.).
	 * @param y The angle with the parent Segment (in radians).
	 */
	public Segment(double length, double angle) {
		this.length = length;
		this.angle = angle;
		this.children = new ArrayList<>();
	}

	/**
	 * Returns the length of the Segment.
	 * 
	 * @return The length.
	 */
	public double getLength() {
		return length;
	}

	/**
	 * Returns the angle that the Segment forms with the parent Segment.
	 * 
	 * @return The angle with the parent Segment.
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * Changes the angle that the Segment form with the parent Segment. This affects
	 * the calculations of the Forward Kinematics algorithm.
	 * 
	 * @param angle The new angle.
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * Returns a List of all the Segments next to this one in the kinematic chain.
	 * 
	 * @return segments The List of Segments connected to this one.
	 */
	public List<Segment> getChildren() {
		return children;
	}

	/**
	 * Adds a new Segment after this one in the kinematic chain. A Segment won't be
	 * added if it's already connected to this one.
	 * 
	 * @param child The Segment to be added.
	 */
	public void addChild(Segment child) {
		if (!children.contains(child))
			children.add(child);
	}
	// SOLUCION

}
