package src;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RadioButtonFrame frame = new RadioButtonFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(420, 280);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

class RadioButtonFrame extends JFrame {
    private final JLabel imageLabel = new JLabel();
    private final JRadioButton birdButton = new JRadioButton("Bird");
    private final JRadioButton catButton = new JRadioButton("Cat");
    private final JRadioButton dogButton = new JRadioButton("Dog");
    private final JRadioButton rabbitButton = new JRadioButton("Rabbit");
    private final JRadioButton pigButton = new JRadioButton("Pig");

    private final ImageIcon birdIcon = new ImageIcon("pets/bird.png");
    private final ImageIcon catIcon = new ImageIcon("pets/cat.png");
    private final ImageIcon dogIcon = new ImageIcon("pets/dog.png");
    private final ImageIcon rabbitIcon = new ImageIcon("pets/rabbit.png");
    private final ImageIcon pigIcon = new ImageIcon("pets/pig.png");

    public RadioButtonFrame() {
        super("RadioButtonDemo");

        setLayout(new BorderLayout(10, 10));

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        add(radioPanel, BorderLayout.WEST);

        imageLabel.setPreferredSize(new Dimension(250, 220));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        PetSelectionListener listener = new PetSelectionListener();
        birdButton.addActionListener(listener);
        catButton.addActionListener(listener);
        dogButton.addActionListener(listener);
        rabbitButton.addActionListener(listener);
        pigButton.addActionListener(listener);

        birdButton.setSelected(true);
        updatePet("Bird", birdIcon);
    }

    private void updatePet(String petName, ImageIcon icon) {
        imageLabel.setIcon(icon);
        imageLabel.setText(null);
        JOptionPane.showMessageDialog(this,
                "You selected: " + petName,
                "Pet Selection",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private class PetSelectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            Object source = event.getSource();
            if (source == birdButton) {
                updatePet("Bird", birdIcon);
            } else if (source == catButton) {
                updatePet("Cat", catIcon);
            } else if (source == dogButton) {
                updatePet("Dog", dogIcon);
            } else if (source == rabbitButton) {
                updatePet("Rabbit", rabbitIcon);
            } else if (source == pigButton) {
                updatePet("Pig", pigIcon);
            }
        }
    }
}
