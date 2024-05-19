/*task 2 tic-tak-toe game for letsgrowmore*/



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener 
{

    private JButton[] buttons = new JButton[9];
    private boolean xTurn = true;
    private Random random = new Random();

    public TicTacToe() 
	{
        super("Tic Tac Toe");
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) 
		{
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
        //Frame size
        setSize(500, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
	{
        for (int i = 0; i < 9; i++) 
		{
            if (e.getSource() == buttons[i]) 
			{
                if (xTurn) 
				{
                    buttons[i].setText("X");
                }
				else 
				{
                    buttons[i].setText("O");
                }
                buttons[i].setEnabled(false);
                xTurn = !xTurn;
                checkForWinner();
            }
        }
    }

    public void checkForWinner() 
	{
        for (int i = 0; i < 9; i += 3) 
		{
            if (buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && !buttons[i].isEnabled()) 
			{
                JOptionPane.showMessageDialog(this, "Player " + buttons[i].getText() + " wins!");
                resetGame();
            }
        }
        for (int i = 0; i < 3; i++) 
		{
            if (buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText()) && !buttons[i].isEnabled()) 
			{
                JOptionPane.showMessageDialog(this, "Player " + buttons[i].getText() + " wins!");
                resetGame();
            }
        }
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].isEnabled()) 
		{
            JOptionPane.showMessageDialog(this, "Player " + buttons[0].getText() + " wins!");
            resetGame();
        }
        if (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].isEnabled()) 
		{
            JOptionPane.showMessageDialog(this, "Player " + buttons[2].getText() + " wins!");
            resetGame();
        }
    }

    public void resetGame() 
	{
        for (int i = 0; i < 9; i++) 
		{
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        xTurn = true;
    }

    public static void main(String[] args) 
	{
       TicTacToe ttt= new TicTacToe();
    }
}