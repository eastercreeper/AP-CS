package heatMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class HeatMap extends JPanel implements MouseListener {

	private static final Color BACKGROUND = new Color(204, 204, 204);

	private static final int[] TEMP_RANGES = {-150,-140, -130, -120, -110, -100, -90, -80, -70, -60, -50, -40, -30, -20, -10, 0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140};

	private static final int[] RED_VALUES = {0,0, 0, 0, 0, 0, 0, 0, 17, 51, 85, 119, 153, 187, 221, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255};
	private static final int[] GREEN_VALUES = {0, 34, 68, 102, 136, 170, 204, 238, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 241, 207, 173, 139, 105, 71, 37};
	private static final int[] BLUE_VALUES = {255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 217, 183, 149, 115, 81, 47, 13, 0, 0, 0, 0, 0, 0, 0};

	private double[][] tempGrid = new double[50][50];
	private double maxTemp = 150;
	private double minTemp = -150;

	// for part 3, leave them alone
	private int clickedRow = -1;
	private int clickedCol = -1;
	private int clickTemp = 0;

	public HeatMap() {
		// TODO: initialize the heat map, half cold, half hot
		for (int i = 0; i < tempGrid.length; i++) {
			for (int j = 0; j < tempGrid[i].length; j++) {
				if (j < tempGrid[i].length / 2) {
					tempGrid[i][j] = -150;  // Left half is cold (-150)
				} else {
					tempGrid[i][j] = 150;   // Right half is hot (150)
				}
			}
		}
		// TODO: uncomment timer start once you get the color methods to work.
		Timer t = new Timer(40, new Listener());
		// t.start();

		addMouseListener(this);

		// Tests get colors methods. Prints results to console.
		for (int temp = (int) minTemp; temp < maxTemp; temp += 10) {
			System.out.printf("%5d: %4d, %4d, %4d\n", temp, getRed(temp), getGreen(temp), getBlue(temp));
		}
	}

	// TODO: complete methods - given a temp value return proper R G or B value.
	public int getRed(double temp) {
		for (int i = 0; i < TEMP_RANGES.length; i++) {
			if (temp <= TEMP_RANGES[i]) {
				return RED_VALUES[i];
			}
		}
		return RED_VALUES[RED_VALUES.length - 1];
	}

	public int getGreen(double temp) {
		for (int i = 0; i < TEMP_RANGES.length; i++) {
			if (temp <= TEMP_RANGES[i]) {
				return GREEN_VALUES[i];
			}
		}
		return GREEN_VALUES[GREEN_VALUES.length - 1];
	}

	public int getBlue(double temp) {
		for (int i = 0; i < TEMP_RANGES.length; i++) {
			if (temp <= TEMP_RANGES[i]) {
				return BLUE_VALUES[i];
			}
		}
		return BLUE_VALUES[BLUE_VALUES.length - 1];
	}

	// draws squares representing the temp in each cell
	// method completed for you, nothing to do here
	public void paintComponent(Graphics g) {
		g.setColor(BACKGROUND);
		g.fillRect(0, 0, getWidth(), getHeight());

		int blockHeight = getHeight() / tempGrid.length + 1;
		int blockWidth = getWidth() / tempGrid[0].length + 1;
		for (int r = 0; r < tempGrid.length; r++) {
			for (int c = 0; c < tempGrid[r].length; c++) {

				double tVal = tempGrid[r][c];
				g.setColor(new Color(getRed(tVal), getGreen(tVal), getBlue(tVal)));

				int x = c * blockWidth; // (x,y) is the upper left hand corner of the rectangle
				int y = r * blockHeight;
				g.fillRect(x, y, blockWidth, blockHeight);
			}
		}

		// Display temperatures of both sides
		String avgLeftTempStr = String.format("%7.2f", tempGrid[tempGrid.length / 2][0]);
		String avgRightTempStr = String.format("%7.2f", tempGrid[tempGrid.length / 2][tempGrid[0].length - 1]);

		g.setColor(Color.black);
		g.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 60));
		g.drawString("Left Side Temp", 10, 60);
		g.drawString(avgLeftTempStr, 100, 120);
		g.drawString("Right Side Temp", getWidth() - 450, 60); // TODO: you might need to adjust location
		g.drawString(avgRightTempStr, getWidth() - 350, 120);
	}

	@Override
	public void mousePressed(MouseEvent event) {
		// TODO: Part 3, complete the method
		// Convert x/y click to row/col and set clickedTemp
		int x = event.getX();
		int y = event.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO: Part 3, reset clickedRow and clickedCol

	}

	// these mouse methods are unneeded for this lab
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO: recalculate every element of the 2D array
			// update the temperature values in tempGrid

			// TODO: in part 3 you will add an if statement here before repaint

			repaint(); // leave this as the last line of code in actionPerformed
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Heat Map");
		frame.setSize(1400, 1005);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new HeatMap());
		frame.setVisible(true);
	}
}