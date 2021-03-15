package tictactoe;


import javax.swing.JOptionPane;
import javax.swing.UIManager;



public class Main {
	

	public static void main(String[] args) {
		
	
		UIManager.put("OptionPane.okButtonText", "Start!");
		JOptionPane.showMessageDialog(null, "TicTacToe !!!\n\nYou are X\nAI is O\n\nFirst move is random ", "TicTacToe",JOptionPane.INFORMATION_MESSAGE);
		
		board b = new board() ;
		int i = (int) (Math.random()*3);
	    if(i==2){
	    	b.aiMove();
	    }
	    else{
	    	
	    }
	}

}
