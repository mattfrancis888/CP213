package cp213;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

/**
 * Creates a panel to hold an animated circle.
 *
 * @author David Brown
 * @version 2019-03-21
 */
@SuppressWarnings("serial")
public class CircleView extends JPanel implements Runnable {
                                            // Constants
    private static final int INCREMENT     = 4;
    public  static final int INITIAL_SPEED = 10;
    public  static final int MAX_SPEED     = 100;
    public  static final int MIN_SPEED     = 0;

                                            // Attributes.
    private final Point            center = new Point(this.getWidth() / 2, this.getHeight() / 2);
    private final Point            corner = new Point();
    private final Ellipse2D.Double circle = new Ellipse2D.Double();
//  private       Color            color  = Color.GREEN;
    private       Color            color  = Color.YELLOW;
    private       int              speed  = INITIAL_SPEED;
                                            // The stop run() flag. 'volatile' means that it is not cached.
    private volatile boolean exit = false;
    private boolean          grow = true;
                                            // The suspend / resume flag.
    private boolean suspended = false;
    private int     width     = 0;

    /**
     *
     */
    public CircleView() {
	   this.registerListeners();
    }

    /**
     *
     */
    private void registerListeners() {
	                                                   // Add a listener for when the window is resized.
    	                                               // Required to update center point.
	   this.addComponentListener(new ComponentAdapter() {
	      @Override
	      public void componentResized(final ComponentEvent componentEvent) {
		     CircleView.this.center.x = CircleView.this.getWidth() / 2;
		     CircleView.this.center.y = CircleView.this.getHeight() / 2;
	      }
	   });
    }

    /**
     * @return the current value of <code>suspended</code>.
     */
    public boolean isSuspended() {
	   return this.suspended;
    }

    @Override
    public void paintComponent(final Graphics g) {
	   final Graphics2D g2d = (Graphics2D) g;
	   g2d.setColor(this.color);
	   g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
	   g2d.fill(this.circle);
	   return;
    }

    /**
     * Resizes the circle.
     */
    public void resizeCircle() {

	   if (!this.contains(this.corner)) {
	      this.grow = false;
	   } else if (this.width <= 0) {
	      this.grow = true;
	   }
	   if (this.grow) {
	      this.width += INCREMENT;
	   } else {
	      this.width -= INCREMENT;
	   }
	                                            // Set the corner point.
	   this.corner.x = this.center.x + this.width;
	   this.corner.y = this.center.y + this.width;
	                                            // Redefine the circle frame by assigning a center and corner.
	   this.circle.setFrameFromCenter(this.center, this.corner);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Runnable#run()
     *
     * Must define block as 'synchronized' in order to call <code>wait</code>
     */
    @Override
    public synchronized void run() {
	   this.exit = false;
	   this.suspended = false;

	   try {
	      while (!this.exit) {
		                              // Continue processing until the current thread is cancelled by
		                              // an interrupt.
		                              // Put the current thread to sleep.
		     Thread.sleep(MAX_SPEED - this.speed);
		     this.resizeCircle();

		     if (this.suspended) {
		        this.wait();
		     }
		     this.repaint();
	      }
	   } catch (final InterruptedException e) {
	                                  // Thread has been interrupted including during sleep or wait.
	                                  // Stops immediately in either case.
	       System.out.println("Interrupted!");
	   } finally {
	       System.out.println("Stopped!");
	   }
	   return;
    }

    /**
     * Sets the circle fill color.
     *
     * @param color The new fill color.
     */
    public void setColor(final Color color) {
	   this.color = color;
    }

    /**
     * Sets circle resizing speed. Suspends the changes if the speed is 0.
     *
     * @param speed The delay in ms.
     */
    public void setSpeed(final int speed) {
	   this.speed = speed;

	   if (this.speed == MIN_SPEED) {
	      this.suspended = true;
	   } else {
	      this.suspended = false;
	   }
    }

    /**
     * Sets the value of <code>suspend</code>
     *
     * @param suspended The new value for <code>suspend</code>
     */
    public void setSuspended(final boolean suspended) {
	   this.suspended = suspended;
    }

    /**
     * Stops the thread entirely.
     */
    public void stop() {
	   this.exit = true;
    }
}