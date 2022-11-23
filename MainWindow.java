import draw_tools.*;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JPanel {
    static ShapesDrawer sd = new ShapesDrawer();
    public MainWindow(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(sd, BorderLayout.WEST);
        // initialize button in panel
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        jPanel.add(new LineDrawTool(sd).getChooseToolBtn());
        jPanel.add(new RectangleDrawTool(sd).getChooseToolBtn());
        jPanel.add(new TriangleDrawTool(sd).getChooseToolBtn());
        jPanel.add(new EllipseDrawTool(sd).getChooseToolBtn());
        jPanel.add(new CircleDrawTool(sd).getChooseToolBtn());
        jPanel.add(new PolygonDrawTool(sd).getChooseToolBtn());
        jPanel.add(sd.getUndoButton());
        add(jPanel, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        // main method
        JFrame jFrame = new JFrame("ООП");
        jFrame.setVisible(true);
        jFrame.setMinimumSize(new Dimension(500, 400));
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setContentPane(new MainWindow());
        jFrame.pack();
    }
}
