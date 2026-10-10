import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * PROG209 Event Driven Programming - Basic Interactive GUI
 * Student: Mohamed E Amara
 * Environment: Java 8 (JDK 1.8) / Java Swing
 */
public class SwingAssignment {

    // Required variable declarations as specified in the assignment brief
    private JFrame frame;
    private JPanel panel;
    private JLabel label;

    // Interactive control components
    private JTextField textInputField;
    private JButton updateTextButton;
    private JButton changeBgColorButton;
    private JButton resetDefaultsButton;

    // Default constants
    private static final String DEFAULT_WELCOME_TEXT = "Welcome to Java Swing First Individual Assignment by Mohamed E Amara";
    private static final Color DEFAULT_PANEL_BG = new Color(240, 244, 248);

    // Custom JPanel subclass to demonstrate OOP Inheritance
    public static class CustomPanel extends JPanel {
        public CustomPanel() {
            super();
            setLayout(new GridBagLayout());
            setBackground(DEFAULT_PANEL_BG);
        }
    }

    /**
     * Constructor initializing the GUI frame and components.
     */
    public SwingAssignment() {
        // 1. Initialize Frame with Title and Exact Required Size (800x800)
        frame = new JFrame("Java Swing Assignment");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // 2. Set Application Icon using ImageIcon with Fallback
        loadApplicationIcon();

        // 3. Initialize Main Display Panel (Subclass of JPanel demonstrating inheritance)
        panel = new CustomPanel();
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));

        // 4. Initialize Welcome Label and Card Display Container
        JPanel heroCard = createHeroCard();
        panel.add(heroCard);

        // 5. Create Header and Interactive Control Panels
        JPanel headerPanel = createHeaderPanel();
        JPanel controlContainer = createControlPanel();

        // 6. Layout Assembly in Frame (BorderLayout)
        frame.setLayout(new BorderLayout());
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(controlContainer, BorderLayout.SOUTH);
    }

    /**
     * Helper to load app-icon.png with fallback.
     */
    private void loadApplicationIcon() {
        File iconFile = new File("assets/app-icon.png");
        if (iconFile.exists()) {
            ImageIcon icon = new ImageIcon("assets/app-icon.png");
            frame.setIconImage(icon.getImage());
        } else {
            // Fallback icon generation if file missing
            Image fallbackIcon = new java.awt.image.BufferedImage(64, 64, java.awt.image.BufferedImage.TYPE_INT_ARGB);
            Graphics g = fallbackIcon.getGraphics();
            g.setColor(new Color(37, 99, 235));
            g.fillRect(0, 0, 64, 64);
            g.dispose();
            frame.setIconImage(fallbackIcon);
        }
    }

    /**
     * Creates a compact top header bar for application identity.
     */
    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(15, 23, 42)); // Modern slate dark theme
        header.setBorder(new EmptyBorder(14, 24, 14, 24));

        JLabel titleLabel = new JLabel("PROG209: Event Driven Programming");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);

        JLabel subtitleLabel = new JLabel("Student: Mohamed E Amara  |  First Individual Assignment");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        subtitleLabel.setForeground(new Color(148, 163, 184));

        header.add(titleLabel, BorderLayout.WEST);
        header.add(subtitleLabel, BorderLayout.EAST);

        return header;
    }

    /**
     * Creates a visually distinct card to host the main welcome label inside the central panel.
     */
    private JPanel createHeroCard() {
        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(203, 213, 225), 1, true),
                new EmptyBorder(35, 45, 35, 45)
        ));

        // Required Label Initialization
        label = new JLabel();
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(new Color(30, 41, 59));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        updateLabelDisplay(DEFAULT_WELCOME_TEXT);

        card.add(label);
        return card;
    }

    /**
     * Formats label text nicely using HTML auto-wrapping for multi-line support.
     */
    private void updateLabelDisplay(String text) {
        String htmlText = "<html><div style='text-align: center; width: 520px; line-height: 1.4;'>"
                        + text.replace("<", "&lt;").replace(">", "&gt;")
                        + "</div></html>";
        label.setText(htmlText);
    }

    /**
     * Creates the structured control panel for interactive customization.
     */
    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(2, 1, 10, 10));
        controlPanel.setBackground(new Color(248, 250, 252));
        controlPanel.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(226, 232, 240)),
                BorderFactory.createTitledBorder(
                        BorderFactory.createEmptyBorder(10, 15, 10, 15),
                        " Interactive Controls ",
                        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION,
                        new Font("Segoe UI", Font.BOLD, 13),
                        new Color(51, 65, 85)
                )
        ));

        // Row 1: Text Customization
        JPanel textRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 6));
        textRow.setOpaque(false);

        JLabel textRowLabel = new JLabel("Label Text:");
        textRowLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        textRowLabel.setForeground(new Color(51, 65, 85));

        textInputField = new JTextField(DEFAULT_WELCOME_TEXT, 34);
        textInputField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        textInputField.setPreferredSize(new Dimension(420, 34));

        updateTextButton = new JButton("Update Label Text");
        updateTextButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        updateTextButton.setPreferredSize(new Dimension(150, 34));

        updateTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newText = textInputField.getText().trim();
                if (!newText.isEmpty()) {
                    updateLabelDisplay(newText);
                }
            }
        });

        textRow.add(textRowLabel);
        textRow.add(textInputField);
        textRow.add(updateTextButton);

        // Row 2: Color Customization & Reset
        JPanel colorRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 6));
        colorRow.setOpaque(false);

        changeBgColorButton = new JButton("Change Background Color");
        changeBgColorButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        changeBgColorButton.setPreferredSize(new Dimension(210, 34));

        resetDefaultsButton = new JButton("Reset Defaults");
        resetDefaultsButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        resetDefaultsButton.setPreferredSize(new Dimension(140, 34));

        // Action Listener to pick background color
        changeBgColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color selectedColor = JColorChooser.showDialog(frame, "Select Panel Background Color", panel.getBackground());
                if (selectedColor != null) {
                    panel.setBackground(selectedColor);
                }
            }
        });

        // Action Listener to reset defaults
        resetDefaultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateLabelDisplay(DEFAULT_WELCOME_TEXT);
                textInputField.setText(DEFAULT_WELCOME_TEXT);
                panel.setBackground(DEFAULT_PANEL_BG);
            }
        });

        colorRow.add(changeBgColorButton);
        colorRow.add(resetDefaultsButton);

        controlPanel.add(textRow);
        controlPanel.add(colorRow);

        return controlPanel;
    }

    /**
     * Display the application.
     */
    public void show() {
        frame.setVisible(true);
    }

    /**
     * Main Entry Point.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingAssignment app = new SwingAssignment();
                app.show();
            }
        });
    }
}

