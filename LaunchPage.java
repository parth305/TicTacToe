package BroCodeTicTacToe;

import javax.swing.*;
import java.util.function.LongUnaryOperator;

public class LaunchPage {
    int responce;
    LaunchPage() throws InterruptedException {
        responce=JOptionPane.showOptionDialog(null,"New Game ?","Tic Tac Toe",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,1);
        if (responce==0){
            try {
                new TicTacToe();
            }
            catch (InterruptedException u){}
        }
        else {
            System.exit(0);
        }
    }

}
