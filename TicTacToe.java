package BroCodeTicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    Random random=new Random();
    JFrame frame;
    JPanel text_panel;
    JPanel button_panel;
    JLabel label;
    JButton[] buttons=new JButton[9];
    boolean player1_turn;

    TicTacToe() throws InterruptedException {
        frame=new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);

        label=new JLabel();
        label.setText("Tic Tac Toe");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.green);
        label.setFont(new Font("Ink Free",Font.ITALIC,50));

        text_panel=new JPanel();
        text_panel.setBackground(new Color(75,75,75));
        text_panel.setBounds(0,0,800,100);
        text_panel.add(label);

        button_panel=new JPanel(new GridLayout(3,3));
        button_panel.setBackground(Color.pink);

        for(int i=0;i<9;i++){
            buttons[i]=new JButton("");
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,150));
            button_panel.add(buttons[i]);
        }

        frame.add(text_panel,BorderLayout.NORTH);
        frame.add(button_panel);
        firstturn();
    }

    private void firstturn() throws InterruptedException {
        Thread.sleep(2000);
        if(random.nextInt(2)==0){
            player1_turn=true;
            label.setText("X Turn");
        }
        else {
            player1_turn=false;
            label.setText("O Turn");
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if (player1_turn){
                    if (buttons[i].getText()==""){
                        buttons[i].setText("X");
                        player1_turn=false;
                        label.setText("O Turn");
                        check();
                    }
                }
                else {
                    if (buttons[i].getText()==""){
                        buttons[i].setText("O");
                        player1_turn=true;
                        label.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }
    private void check(){

        //for X
        if(buttons[0].getText()=="X" && buttons[1].getText()=="X" && buttons[2].getText()=="X")
            xWins(0,1,2);
        else if(buttons[3].getText()=="X" && buttons[4].getText()=="X" && buttons[5].getText()=="X")
            xWins(3,4,5);
        else  if(buttons[6].getText()=="X" && buttons[7].getText()=="X" && buttons[8].getText()=="X")
            xWins(6,7,8);
        else  if(buttons[0].getText()=="X" && buttons[3].getText()=="X" && buttons[6].getText()=="X")
            xWins(0,3,6);
        else  if(buttons[1].getText()=="X" && buttons[4].getText()=="X" && buttons[7].getText()=="X")
            xWins(1,4,7);
        else  if(buttons[2].getText()=="X" && buttons[5].getText()=="X" && buttons[8].getText()=="X")
            xWins(2,5,8);
        else  if(buttons[0].getText()=="X" && buttons[4].getText()=="X" && buttons[8].getText()=="X")
            xWins(0,4,8);
        else  if(buttons[2].getText()=="X" && buttons[4].getText()=="X" && buttons[6].getText()=="X")
            xWins(2,4,6);
        
        
        // for O

        else if(buttons[0].getText()=="O" && buttons[1].getText()=="O" && buttons[2].getText()=="O")
            oWins(0,1,2);
        else if(buttons[3].getText()=="O" && buttons[4].getText()=="O" && buttons[5].getText()=="O")
            oWins(3,4,5);
        else  if(buttons[6].getText()=="O" && buttons[7].getText()=="O" && buttons[8].getText()=="O")
            oWins(6,7,8);
        else  if(buttons[0].getText()=="O" && buttons[3].getText()=="O" && buttons[6].getText()=="O")
            oWins(0,3,6);
        else  if(buttons[1].getText()=="O" && buttons[4].getText()=="O" && buttons[7].getText()=="O")
            oWins(1,4,7);
        else  if(buttons[2].getText()=="O" && buttons[5].getText()=="O" && buttons[8].getText()=="O")
            oWins(2,5,8);
        else  if(buttons[0].getText()=="O" && buttons[4].getText()=="O" && buttons[8].getText()=="O")
            oWins(0,4,8);
        else  if(buttons[2].getText()=="O" && buttons[4].getText()=="O" && buttons[6].getText()=="O")
            oWins(2,4,6);

        //tie
        else if(buttons[0].getText()!="" && buttons[1].getText()!="" && buttons[2].getText()!=""
                && buttons[3].getText()!="" && buttons[4].getText()!="" && buttons[5].getText()!="" &&
                buttons[8].getText()!="" && buttons[7].getText()!="" && buttons[6].getText()!=""){
            tie();
        }
    }

    private void xWins(int a,int b,int c){
        for(int i=0;i<9;i++)
            buttons[i].setEnabled(false);
        label.setText("X Wins");
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
    }

    private void oWins(int a,int b,int c){
        for(int i=0;i<9;i++)
            buttons[i].setEnabled(false);
        label.setText("O Wins");
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
    }

    private void tie(){
        for(int i=0;i<9;i++)
            buttons[i].setBackground(Color.red);
        label.setText("Match Tie");
    }
}
