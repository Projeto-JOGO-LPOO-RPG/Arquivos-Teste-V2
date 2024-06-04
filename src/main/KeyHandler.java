package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener{

    public boolean paraCima, paraBaixo, paraEsqrd, paraDireita;

    @Override
    public void keyPressed(KeyEvent e) {
        int input = e.getKeyCode();

        if(input == KeyEvent.VK_W){
            paraCima = true;
        }
        if(input == KeyEvent.VK_S){
            paraBaixo = true;
        }
        if(input == KeyEvent.VK_A){
            paraEsqrd = true;
        }
        if(input == KeyEvent.VK_D){
            paraDireita = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int input = e.getKeyCode();

        if(input == KeyEvent.VK_W){
            paraCima = false;
        }
        if(input == KeyEvent.VK_S){
            paraBaixo = false;
        }
        if(input == KeyEvent.VK_A){
            paraEsqrd = false;
        }
        if(input == KeyEvent.VK_D){
            paraDireita = false;
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
