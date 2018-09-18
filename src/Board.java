import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private int boardWidth = 300;
    private int boardHeight = 300;
    private int delay = 100;

    private int x = 0;
    private int y = 0;

    private Timer timer;


    public Board() {
        initBoard();
    }

    private void initBoard() {

        setBackground(Color.black);
        setFocusable(true);
        setDoubleBuffered(true);

        setPreferredSize(new Dimension(boardWidth, boardHeight));
        initGame();
    }

    private void initGame() {
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        g.drawRect(x, y, 10, 10);
        x += 10;
        y += 10;

        if(x > boardWidth)
            x = 0;
        if(y > boardHeight)
            y = 0;


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }


}