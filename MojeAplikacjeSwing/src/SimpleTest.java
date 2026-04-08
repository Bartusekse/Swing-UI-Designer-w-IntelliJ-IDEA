import javax.swing.*;
import java.awt.*;

public class SimpleTest extends JFrame {
    private JPanel mainPanel;
    private JLabel myLabel;
    private JButton actionButton;

    public SimpleTest() {
        // Ustawienie wyglądu systemowego
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}

        setContentPane(mainPanel);
        setTitle("Ćwiczenie: Zmieniacz Tekstu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // WIĘKSZE OKNO I CENTROWANIE
        setSize(450, 250);
        setLocationRelativeTo(null);

        // Logika
        actionButton.addActionListener(e -> {
            myLabel.setText("BRAWO! Tekst został zmieniony.");
            myLabel.setForeground(Color.BLUE); // Dodatkowy efekt koloru
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleTest();
    }
}