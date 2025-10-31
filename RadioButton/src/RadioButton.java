import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;

public class RadioButton extends JFrame implements ActionListener {

    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private JLabel imageLabel;

    public RadioButton() {
        setTitle("RadioButton Demo - Working Images");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout());

        // Create radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        // Group the buttons
        ButtonGroup group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        // Add buttons to panel
        radioPanel.add(birdButton);
        radioPanel.add(catButton);
        radioPanel.add(dogButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(pigButton);

        // Add listeners
        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        rabbitButton.addActionListener(this);
        pigButton.addActionListener(this);

        // Label to display image
        imageLabel = new JLabel("", SwingConstants.CENTER);

        add(radioPanel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String petName = "";
        String imagePath = "";

        if (e.getSource() == birdButton) {
            petName = "Bird";
            imagePath = "images/bird.jpg";
        } else if (e.getSource() == catButton) {
            petName = "Cat";
            imagePath = "images/cat.jpg";
        } else if (e.getSource() == dogButton) {
            petName = "Dog";
            imagePath = "images/dog.jpg";
        } else if (e.getSource() == rabbitButton) {
            petName = "Rabbit";
            imagePath = "images/rabbit.jpg";
        } else if (e.getSource() == pigButton) {
            petName = "Pig";
            imagePath = "images/pig.jpg";
        }

        JOptionPane.showMessageDialog(this, "You selected: " + petName, "Message", JOptionPane.INFORMATION_MESSAGE);

        try {
            Image img = ImageIO.read(new File(imagePath));
            Image scaled = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaled));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading image for " + petName + ": " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RadioButton frame = new RadioButton();
            frame.setVisible(true);
        });
    }
}
