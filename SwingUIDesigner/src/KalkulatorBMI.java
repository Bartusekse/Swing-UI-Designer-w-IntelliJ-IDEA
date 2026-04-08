import javax.swing.*;
import java.awt.*;

public class KalkulatorBMI extends JFrame {
    private JPanel mainPanel;
    private JTextField wagaInput;
    private JTextField wzrostInput;
    private JButton obliczBtn;
    private JLabel wynikLabel;

    public KalkulatorBMI() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        setContentPane(mainPanel);
        setTitle("Kalkulator BMI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Rozmiar okna i centrowanie
        setSize(450, 200);
        setLocationRelativeTo(null);

        // LOGIKA PRZYCISKU
        obliczBtn.addActionListener(e -> {
            try {
                // 1. Pobieranie danych
                double wagaKg = Double.parseDouble(wagaInput.getText().replace(",", "."));
                double wzrostCm = Double.parseDouble(wzrostInput.getText().replace(",", "."));

                // 2. PRZELICZENIE: wzrost w cm na wzrost w metrach
                double wzrostM = wzrostCm / 100.0;

                // 3. WZÓR: waga / (wzrost_m * wzrost_m)
                double bmi = wagaKg / (wzrostM * wzrostM);

                // 4. KOLOROWANIE I STATUS
                if (bmi < 18.5) {
                    wynikLabel.setForeground(Color.BLUE);
                    wynikLabel.setText(String.format("Wynik: %.2f (Niedowaga)", bmi));
                } else if (bmi < 25) {
                    wynikLabel.setForeground(new Color(0, 153, 0)); // Zielony
                    wynikLabel.setText(String.format("Wynik: %.2f (Norma)", bmi));
                } else {
                    wynikLabel.setForeground(Color.RED);
                    wynikLabel.setText(String.format("Wynik: %.2f (Nadwaga)", bmi));
                }

            } catch (NumberFormatException ex) {
                // Jeśli użytkownik wpisze tekst zamiast liczb
                wynikLabel.setForeground(Color.RED);
                wynikLabel.setText("Błąd: Wpisz liczby!");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new KalkulatorBMI();
    }
}