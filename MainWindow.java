import draw_tools.*;
import shapes.*;
import shapes.Polygon;
import shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class MainWindow extends JPanel {
    static ShapesDrawer sd = new ShapesDrawer();
    public MainWindow() throws IOException {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(sd, BorderLayout.WEST);
        // initialize button in panel
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        // serialization
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("shapes.txt"));
        objectOutputStream.writeObject(jPanel.add(new LineDrawTool(sd).getChooseToolBtn()));
        objectOutputStream.writeObject( jPanel.add(new RectangleDrawTool(sd).getChooseToolBtn()));
        objectOutputStream.writeObject(jPanel.add(new TriangleDrawTool(sd).getChooseToolBtn()));
        objectOutputStream.writeObject(jPanel.add(new EllipseDrawTool(sd).getChooseToolBtn()));
        objectOutputStream.writeObject(jPanel.add(new CircleDrawTool(sd).getChooseToolBtn()));
        objectOutputStream.writeObject(jPanel.add(new PolygonDrawTool(sd).getChooseToolBtn()));
        objectOutputStream.close();

        // deserialization
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("shapes.txt"));
        try {
            Line line = (Line)objectInputStream.readObject();
            Polygon polygon = (Polygon) objectInputStream.readObject();
            Polyline polyline = (Polyline) objectInputStream.readObject();
            Circle circle = (Circle) objectInputStream.readObject();
            Rectangle rectangle = (Rectangle) objectInputStream.readObject();
            Ellipse ellipse = (Ellipse) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        jPanel.add(sd.getUndoButton());
        add(jPanel, BorderLayout.CENTER);
    }


    public static void main(String[] args) throws IOException {
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
