package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable {

    Thread t1;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JLabel[] label = new JLabel[10];
    JLabel caption;

    public void run() {
        String[] text = new String[]{
                "JW Marriott Hotel",
                "Mandarin Oriental Hotel",
                "Four Seasons Hotel",
                "Radisson Blu Hotel",
                "Cassio Hotel",
                "The Bay Club Hotel",
                "Breeze Blow Hotel",
                "The Taj Hotel",
                "Happy Morning Hotel",
                "River View Hotel"
        };

        try {
            for (int i = 0; i < 9; i++) {
                label[i].setVisible(true);
                caption.setText(text[i]);
                Thread.sleep(2500);
                label[i].setVisible(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Destinations() {
        setBounds(500, 200, 800, 600);
        caption = new JLabel();
        caption.setBounds(50, 500, 1000, 70);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        caption.setForeground(Color.WHITE);
        add(caption);

        ImageIcon[] image = new ImageIcon[10];
        Image[] jimage = new Image[10];
        ImageIcon[] kimage = new ImageIcon[10];

        for (int i = 0; i < 9; i++) {
            String imagePath = "icons/dest" + (i + 1) + ".jpg";
            java.net.URL imageURL = getClass().getClassLoader().getResource(imagePath);
            if (imageURL != null) {
                image[i] = new ImageIcon(imageURL);
                jimage[i] = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
                kimage[i] = new ImageIcon(jimage[i]);
                label[i] = new JLabel(kimage[i]);
                label[i].setBounds(0, 0, 800, 600);
                add(label[i]);
            } else {
                System.err.println("Image not found: " + imagePath);
            }
        }

        t1 = new Thread(this);
        t1.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Destinations();
    }
}