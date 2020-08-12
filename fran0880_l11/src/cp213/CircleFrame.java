package cp213;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
 
 
@SuppressWarnings("serial")
public class CircleFrame extends JFrame {
                                                     // Class variables.
    private static int circleCount = 0;
                                                     // Class attributes.
    private       CircleView circlePanel = null;
    private final JPanel     mainPanel   = new JPanel();
    private final JSlider    slider      = new JSlider(JSlider.HORIZONTAL,
                                                       CircleView.MIN_SPEED,
                                                       CircleView.MAX_SPEED,
                                                       CircleView.INITIAL_SPEED);
    private final JButton button = new JButton("Change");
 
    /**
     * Constructor.
     *
     * @param circlePanel The circle model to display.
     */
    public CircleFrame(final CircleView circlePanel) {
                                                    // Build and set title of CircleFrame, with frame counting.
       this.setTitle("Circle " + CircleFrame.circleCount);
       CircleFrame.circleCount++;
       
       this.circlePanel = circlePanel;
       this.setLayout();
       this.registerListeners();
       this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
   
    /**
     * Alters circle display speed.
     */
    private class SliderListener implements ChangeListener {
 
       @Override
       public void stateChanged(final ChangeEvent arg0) {
 
          if (!CircleFrame.this.slider.getValueIsAdjusting()) {
                                                             // Update the delay when the slider stops moving.
             final int speed = CircleFrame.this.slider.getValue();
 
             if (CircleFrame.this.circlePanel.isSuspended() && speed > 0) {
                                                             // Restart the circle resizing.
                synchronized (CircleFrame.this.circlePanel) {
                                                             // Remove thread from wait()
                   CircleFrame.this.circlePanel.notify();
                }
             }
             CircleFrame.this.circlePanel.setSpeed(speed);
          }
       }
    }
   
    private class ColorListener implements ActionListener {
 
       @Override
       public void actionPerformed(final ActionEvent evt) {
          circlePanel.setColor(Color.BLACK);
       }
     }
   
   
   
 
    /**
     * Defines the frame layout.
     */
    private void setLayout() {
       this.mainPanel.setLayout(new BorderLayout());
 
       this.slider.setMajorTickSpacing(CircleView.MAX_SPEED / 4);
       this.slider.setMinorTickSpacing(CircleView.MAX_SPEED / 10);
       this.slider.setPaintTicks(true);
       this.slider.setPaintLabels(true);
       this.mainPanel.add(this.button, BorderLayout.NORTH);
       this.mainPanel.add(this.slider, BorderLayout.SOUTH);
       this.mainPanel.add(this.circlePanel, BorderLayout.CENTER);
 
       this.setContentPane(this.mainPanel);
       return;
    }
   
    /**
     * Registers the slider and button listeners.
     */
    private void registerListeners() {
       this.slider.addChangeListener(new SliderListener());
       this.button.addActionListener(new ColorListener());
       this.addWindowListener(new DisposeListener());
       return;
    }
   
    /**
     * Kills the model's thread when the window closes.
     */
    private class DisposeListener extends WindowAdapter {
 
       @Override
       public void windowClosing(final WindowEvent e) {
                            // Cancel the currently running thread.
          CircleFrame.this.circlePanel.stop();
       }
    }
}