package tictactoe;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class board extends JFrame implements ActionListener {

	protected JButton grid[][];
	protected int run;

	// ImageIcon img1 = new ImageIcon("src/rsz_212.png");
	// ImageIcon img2 = new ImageIcon("src/rsz_misha.png");

	public board() {
		display();

	}

	public final void display() {

		setTitle("TicTacToe");
		setLayout(new GridLayout(3, 3));
		grid = new JButton[3][3];

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				grid[row][col] = new JButton("");
				grid[row][col].setMargin(new Insets(1, 1, 1, 1));
				grid[row][col].addActionListener(this);
				grid[row][col].setBackground(Color.WHITE);
				// grid[row][col].setIcon(img1);

				add(grid[row][col]);
			}
		}
		setSize(3 * 100, 3 * 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void reset() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				grid[row][col].setText("");
				grid[row][col].setForeground(Color.BLACK);
			}
		}
	}

	public void actionPerformed(ActionEvent event) {
		JButton target = (JButton) (event.getSource());

		if (!target.getText().equals("")) {

		} else {

			target.setText("X");
			target.setForeground(Color.RED);
			if (checkifWin("X")) {
				UIManager.put("OptionPane.okButtonText", "Close");
				JOptionPane.showMessageDialog(null, "You won!", "Result", JOptionPane.INFORMATION_MESSAGE);
				System.exit(1);
				reset();
			}

			int flag = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (grid[i][j].getText() == "") {
						flag = 1;
					}
				}
			}
			if (flag == 0) {
				UIManager.put("OptionPane.okButtonText", "Close");
				JOptionPane.showMessageDialog(null, "Its a tie :/", "Result", JOptionPane.INFORMATION_MESSAGE);
				System.exit(1);
			}

			else {
				aiMove();
				if (checkifWin("O")) {
					UIManager.put("OptionPane.okButtonText", "Close");
					JOptionPane.showMessageDialog(null, "AI won  :P", "Result", JOptionPane.INFORMATION_MESSAGE);
					System.exit(1);
				}
			}
		}

	}

	// win conditions
	public boolean checkifWin(String a) {

		if (grid[0][0].getText() == a && grid[0][1].getText() == a && grid[0][2].getText() == a
				|| grid[0][0].getText() == a && grid[1][1].getText() == a && grid[2][2].getText() == a
				|| grid[0][0].getText() == a && grid[1][0].getText() == a && grid[2][0].getText() == a
				|| grid[0][1].getText() == a && grid[1][1].getText() == a && grid[2][1].getText() == a
				|| grid[0][2].getText() == a && grid[1][2].getText() == a && grid[2][2].getText() == a
				|| grid[0][2].getText() == a && grid[1][1].getText() == a && grid[2][0].getText() == a
				|| grid[1][0].getText() == a && grid[1][1].getText() == a && grid[1][2].getText() == a
				|| grid[2][0].getText() == a && grid[2][1].getText() == a && grid[2][2].getText() == a) {

			return true;
		}

		return false;
	}

	// AI logic starts here, sphagetti code at its finest :D
	public void aiMove() {
		// ai trying to win
		if (grid[0][0].getText() == "O" && grid[0][1].getText() == "O" && grid[0][2].getText() == "") {

			grid[0][2].setText("O");
			grid[0][2].setHorizontalTextPosition(JButton.CENTER);

			return;
		} else if (grid[0][0].getText() == "O" && grid[0][2].getText() == "O" && grid[0][1].getText() == "") {
			grid[0][1].setText("O");
			grid[0][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][0].getText() == "O" && grid[1][0].getText() == "O" && grid[2][0].getText() == "") {
			grid[2][0].setText("O");
			grid[2][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][0].getText() == "O" && grid[2][0].getText() == "O" && grid[1][0].getText() == "") {
			grid[1][0].setText("O");
			grid[1][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][0].getText() == "O" && grid[2][2].getText() == "O" && grid[1][1].getText() == "") {
			grid[1][1].setText("O");
			grid[1][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][0].getText() == "O" && grid[1][1].getText() == "O" && grid[2][2].getText() == "") {
			grid[2][2].setText("O");
			grid[2][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][1].getText() == "O" && grid[0][2].getText() == "O" && grid[0][0].getText() == "") {
			grid[0][0].setText("O");
			grid[0][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][1].getText() == "O" && grid[1][1].getText() == "O" && grid[2][1].getText() == "") {
			grid[2][1].setText("O");
			grid[2][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][1].getText() == "O" && grid[2][1].getText() == "O" && grid[1][1].getText() == "") {
			grid[1][1].setText("O");
			grid[1][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][2].getText() == "O" && grid[2][2].getText() == "O" && grid[1][2].getText() == "") {
			grid[1][2].setText("O");
			grid[1][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][2].getText() == "O" && grid[1][2].getText() == "O" && grid[2][2].getText() == "") {
			grid[2][2].setText("O");
			grid[2][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][2].getText() == "O" && grid[1][1].getText() == "O" && grid[2][0].getText() == "") {
			grid[2][0].setText("O");
			grid[2][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][2].getText() == "O" && grid[2][0].getText() == "O" && grid[1][1].getText() == "") {
			grid[1][1].setText("O");
			grid[1][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][0].getText() == "O" && grid[2][0].getText() == "O" && grid[0][0].getText() == "") {
			grid[0][0].setText("O");
			grid[0][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][0].getText() == "O" && grid[1][1].getText() == "O" && grid[1][2].getText() == "") {
			grid[1][2].setText("O");
			grid[1][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][0].getText() == "O" && grid[1][2].getText() == "O" && grid[1][1].getText() == "") {
			grid[1][1].setText("O");
			grid[1][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][1].getText() == "O" && grid[2][1].getText() == "O" && grid[0][1].getText() == "") {
			grid[0][1].setText("O");
			grid[0][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][1].getText() == "O" && grid[1][2].getText() == "O" && grid[1][0].getText() == "") {
			grid[1][0].setText("O");
			grid[1][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][1].getText() == "O" && grid[2][0].getText() == "O" && grid[0][2].getText() == "") {
			grid[0][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][1].getText() == "O" && grid[2][2].getText() == "O" && grid[0][0].getText() == "") {
			grid[0][0].setText("O");
			grid[0][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][2].getText() == "O" && grid[2][2].getText() == "O" && grid[0][2].getText() == "") {
			grid[0][2].setText("O");
			grid[0][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[2][0].getText() == "O" && grid[2][2].getText() == "O" && grid[2][1].getText() == "") {
			grid[2][1].setText("O");
			grid[2][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[2][0].getText() == "O" && grid[2][1].getText() == "O" && grid[2][2].getText() == "") {
			grid[2][2].setText("O");
			grid[2][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[2][1].getText() == "O" && grid[2][2].getText() == "O" && grid[2][0].getText() == "") {
			grid[2][0].setText("O");
			grid[2][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		}

		// ai trying to block

		else if (grid[0][0].getText() == "X" && grid[0][1].getText() == "X" && grid[0][2].getText() == "") {
			grid[0][2].setText("O");
			grid[0][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][0].getText() == "X" && grid[0][2].getText() == "X" && grid[0][1].getText() == "") {
			grid[0][1].setText("O");
			grid[0][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][0].getText() == "X" && grid[1][0].getText() == "X" && grid[2][0].getText() == "") {
			grid[2][0].setText("O");
			grid[2][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][0].getText() == "X" && grid[2][0].getText() == "X" && grid[1][0].getText() == "") {
			grid[1][0].setText("O");
			grid[1][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][0].getText() == "X" && grid[2][2].getText() == "X" && grid[1][1].getText() == "") {
			grid[1][1].setText("O");
			grid[1][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][0].getText() == "X" && grid[1][1].getText() == "X" && grid[2][2].getText() == "") {
			grid[2][2].setText("O");
			grid[2][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][1].getText() == "X" && grid[0][2].getText() == "X" && grid[0][0].getText() == "") {
			grid[0][0].setText("O");
			grid[0][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][1].getText() == "X" && grid[1][1].getText() == "X" && grid[2][1].getText() == "") {
			grid[2][1].setText("O");
			grid[2][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][1].getText() == "X" && grid[2][1].getText() == "X" && grid[1][1].getText() == "") {
			grid[1][1].setText("O");
			grid[1][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][2].getText() == "X" && grid[2][2].getText() == "X" && grid[1][2].getText() == "") {
			grid[1][2].setText("O");
			grid[1][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][2].getText() == "X" && grid[1][2].getText() == "X" && grid[2][2].getText() == "") {
			grid[2][2].setText("O");
			grid[2][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][2].getText() == "X" && grid[1][1].getText() == "X" && grid[2][0].getText() == "") {
			grid[2][0].setText("O");
			grid[2][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[0][2].getText() == "X" && grid[2][0].getText() == "X" && grid[1][1].getText() == "") {
			grid[1][1].setText("O");
			grid[1][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][0].getText() == "X" && grid[2][0].getText() == "X" && grid[0][0].getText() == "") {
			grid[0][0].setText("O");
			grid[0][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][0].getText() == "X" && grid[1][1].getText() == "X" && grid[1][2].getText() == "") {
			grid[1][2].setText("O");
			grid[1][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][0].getText() == "X" && grid[1][2].getText() == "X" && grid[1][1].getText() == "") {
			grid[1][1].setText("O");
			grid[1][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][1].getText() == "X" && grid[2][1].getText() == "X" && grid[0][1].getText() == "") {
			grid[0][1].setText("O");
			grid[0][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][1].getText() == "X" && grid[1][2].getText() == "X" && grid[1][0].getText() == "") {
			grid[1][0].setText("O");
			grid[1][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][1].getText() == "X" && grid[2][0].getText() == "X" && grid[0][2].getText() == "") {
			grid[0][2].setText("O");
			grid[0][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][1].getText() == "X" && grid[2][2].getText() == "X" && grid[0][0].getText() == "") {
			grid[0][0].setText("O");
			grid[0][0].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[1][2].getText() == "X" && grid[2][2].getText() == "X" && grid[0][2].getText() == "") {
			grid[0][2].setText("O");
			grid[0][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[2][0].getText() == "X" && grid[2][2].getText() == "X" && grid[2][1].getText() == "") {
			grid[2][1].setText("O");
			grid[2][1].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[2][0].getText() == "X" && grid[2][1].getText() == "X" && grid[2][2].getText() == "") {
			grid[2][2].setText("O");
			grid[2][2].setHorizontalTextPosition(JButton.CENTER);
			return;
		} else if (grid[2][1].getText() == "X" && grid[2][2].getText() == "X" && grid[2][0].getText() == "") {
			grid[2][0].setText("O");
			grid[2][0].setHorizontalTextPosition(JButton.CENTER);
			return;

		}

		// when no win or block, just put in a random one
		else {
			int flag = 0;
			while (flag != 1) {
				int i = (int) (Math.random() * 3);
				int j = (int) (Math.random() * 3);

				if (grid[i][j].getText() == "") {
					grid[i][j].setText("O");
					grid[i][j].setHorizontalTextPosition(JButton.CENTER);
					flag = 1;

					return;
				}

			}

		}

	}

}