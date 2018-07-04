package co.za.kroutled.view;

import javax.swing.JFrame;

public class Window extends JFrame {

    public void createWindow()
    {
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(200, 200);
       setVisible(true);
       setTitle("Swingy");
    }
}
