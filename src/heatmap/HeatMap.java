package heatmap;//Programmer:

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class HeatMap extends JPanel implements MouseListener {

	private static final Color BACKGROUND = new Color(204, 204, 204);

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
					tempGrid[i][j] = -150;
				} else {
					tempGrid[i][j] = 150;
				}
			}
		}
		// TODO: uncomment timer start once you get the color methods to work.
		Timer t = new Timer(40, new Listener());
		t.start();

		addMouseListener(this);

		// Tests get colors methods. Prints results to console.
		for (int temp = (int) minTemp; temp < maxTemp; temp += 10) {
			System.out.printf("%5d: %4d, %4d, %4d\n", temp, getRed(temp), getGreen(temp), getBlue(temp));
		}
	}

	// TODO: complete methods - given a temp value return proper R G or B value.
	public int getRed(double temp) {
		if(temp > maxTemp) {
			temp = maxTemp;
		}
		if(temp < minTemp) {
			temp = minTemp;
		}
		if(temp<=-80) return 0;
		if(temp<=-10) return 255 - (int)(temp/10*-1) * 35;
		if(temp>=0) return 255;
		return 0;
	}

	public int getGreen(double temp) {
		if(temp > maxTemp) {
			temp = maxTemp;
		}
		if(temp < minTemp) {
			temp = minTemp;
		}
		if(temp <=140 && temp >= 80) return 0;
		if(temp<=-80) return (int) (((-150-temp)/10)*-1*35);
		if(temp>=-70 && temp<= 70) return 255;
		if(temp>=80) return (int) (((150-temp)/10)*35);
		return 0;
	}

	public int getBlue(double temp) {
		if(temp > maxTemp) {
			temp = maxTemp;
		}
		if(temp < minTemp) {
			temp = minTemp;
		}
		if(temp <= 0) return 255;
		if(temp>=80) return 0;
		if(temp<80 && temp>=10) return (255-(((int) temp/10)*35));
		return 0;
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

		int blockHeight = getHeight() / tempGrid.length + 1;
		int blockWidth = getWidth() / tempGrid[0].length + 1;

		clickedRow = y / blockHeight;
		clickedCol = x / blockWidth;

		if (event.getButton() == MouseEvent.BUTTON1) {
			clickTemp = (int) (10 * maxTemp);
		} else if (event.getButton() == MouseEvent.BUTTON3) {
			clickTemp = (int) (10 * minTemp);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO: Part 3, reset clickedRow and clickedCol
		clickedRow = -1;
		clickedCol = -1;
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


			double[][] newTempGrid = new double[tempGrid.length][tempGrid[0].length];

			for (int i = 0; i < tempGrid.length; i++) {

				for (int j = 0; j < tempGrid[i].length; j++) {
					double sum = tempGrid[i][j];
					int count = 1;

					if (i > 0) {
						sum += tempGrid[i-1][j];
						count++;
					}
					if (i < tempGrid.length - 1) {
						sum += tempGrid[i+1][j];
						count++;
					}
					if (j > 0) {
						sum += tempGrid[i][j-1];
						count++;
					}
					if (j < tempGrid[i].length - 1) {
						sum += tempGrid[i][j+1];
						count++;
					}
					newTempGrid[i][j] = sum / count;
				}
			}
			for (int i = 0; i < tempGrid.length; i++) {
				for (int j = 0; j < tempGrid[i].length; j++) {
					tempGrid[i][j] = newTempGrid[i][j];
				}
			}
			// TODO: in part 3 you will add an if statement here before repaint
			if (clickedRow != -1 && clickedCol != -1) {
				tempGrid[clickedRow][clickedCol] = clickTemp;
			}
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
