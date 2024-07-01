# Gañac-Rodriguez-Dumadapat-Parong
![image](https://github.com/Ayreshz/Ga-ac-Rodriguez-Dumadapat-Parong_-BSCS1B/assets/163814923/02609814-1fe0-4f95-8c35-186179a2789b)


package com.mycompany.digitalpostcardapp;

import java.awt.*;
import java.awt.event.*;

public class DigitalPostcardApp extends Frame {

    private TextField messageField;
    private Choice colorChoice;
    private Label previewLabel;
    private boolean stampAdded;
    private Color backgroundColor;
    private Image stampImage;

    public DigitalPostcardApp() {
        // Frame setup
        setTitle("Digital Postcard");
        setSize(600, 400);
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // Header
        Panel headerPanel = new Panel();
        headerPanel.setBackground(Color.CYAN);
        Label headerLabel = new Label("Create Your Digital Postcard", Label.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Main Panel
        Panel mainPanel = new Panel();
        mainPanel.setLayout(new GridLayout(3, 1));

        // Message Panel
        Panel messagePanel = new Panel();
        messagePanel.add(new Label("Enter your message:"));
        messageField = new TextField(40);
        messagePanel.add(messageField);
        mainPanel.add(messagePanel);

        // Color Panel
        Panel colorPanel = new Panel();
        colorPanel.add(new Label("Select background color:"));
        colorChoice = new Choice();
        colorChoice.add("White");
        colorChoice.add("Yellow");
        colorChoice.add("Pink");
        colorChoice.add("Green");
        colorChoice.add("Blue");
        colorChoice.addItemListener(new ColorChoiceHandler());
        colorPanel.add(colorChoice);
        mainPanel.add(colorPanel);

        // Stamp Panel
        Panel stampPanel = new Panel();
        Button addStampButton = new Button("Add Stamp");
        addStampButton.addActionListener(new AddStampHandler());
        stampPanel.add(addStampButton);
        Button removeStampButton = new Button("Remove Stamp");
        removeStampButton.addActionListener(new RemoveStampHandler());
        stampPanel.add(removeStampButton);
        mainPanel.add(stampPanel);

        add(mainPanel, BorderLayout.CENTER);

        // Preview Panel
        previewLabel = new Label("", Label.CENTER) {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                if (stampAdded) {
                    g.drawImage(stampImage, getWidth() - 70, 10, this);
                }
            }
        };
        previewLabel.setBackground(Color.WHITE);
        previewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        previewLabel.setPreferredSize(new Dimension(600, 200));
        add(previewLabel, BorderLayout.SOUTH);

        // Frame events
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Initial settings
        stampAdded = false;
        backgroundColor = Color.WHITE;
        stampImage = Toolkit.getDefaultToolkit().getImage("stamp.png");

        setVisible(true);
    }

    private class ColorChoiceHandler implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            switch (colorChoice.getSelectedItem()) {
                case "White": backgroundColor = Color.WHITE; break;
                case "Yellow": backgroundColor = Color.YELLOW; break;
                case "Pink": backgroundColor = Color.PINK; break;
                case "Green": backgroundColor = Color.GREEN; break;
                case "Blue": backgroundColor = Color.CYAN; break;
            }
            updatePreview();
        }
    }

    private class AddStampHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            stampAdded = true;
            updatePreview();
        }
    }

    private class RemoveStampHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            stampAdded = false;
            updatePreview();
        }
    }

    private void updatePreview() {
        previewLabel.setBackground(backgroundColor);
        previewLabel.setText(messageField.getText());
        previewLabel.repaint();
    }

    public static void main(String[] args) {
        new DigitalPostcardApp();
    }
}
