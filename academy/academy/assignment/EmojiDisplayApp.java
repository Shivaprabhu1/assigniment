package org.academy.assignment;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JScrollPane;

public class EmojiDisplayApp {

    private JFrame frmEmojiDisplayApp;
    private JTextArea emojiTextArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EmojiDisplayApp window = new EmojiDisplayApp();
                    window.frmEmojiDisplayApp.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public EmojiDisplayApp() {
        initialize();
    }

    private void initialize() {
        frmEmojiDisplayApp = new JFrame();
        frmEmojiDisplayApp.setTitle("Emoji Display App");
        frmEmojiDisplayApp.setBounds(100, 100, 800, 600);
        frmEmojiDisplayApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmEmojiDisplayApp.getContentPane().setLayout(null);

        emojiTextArea = new JTextArea();
        emojiTextArea.setFont(new Font("Arial", Font.PLAIN, 30));
        emojiTextArea.setLineWrap(true);
        emojiTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(emojiTextArea);
        scrollPane.setBounds(10, 10, 760, 500);
        frmEmojiDisplayApp.getContentPane().add(scrollPane);

        JButton displayButton = new JButton("Display");
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayEmojisFromDatabase();
            }
        });
        displayButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        displayButton.setBounds(10, 520, 100, 30);
        frmEmojiDisplayApp.getContentPane().add(displayButton);
    }

    private void displayEmojisFromDatabase() {
        try {
            // Connect to your database (modify the connection URL, username, and password)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sr", "root", "");

            // Create a statement to execute SQL queries
            Statement statement = connection.createStatement();

            // Execute a query to retrieve emojis, colors, and sizes from your database
            String query = "SELECT emoji FROM emoji1"; // Adjust the table name and column names
            ResultSet resultSet = statement.executeQuery(query);

            emojiTextArea.setText(""); // Clear the text area

            while (resultSet.next()) {
                String emoji = resultSet.getString("emoji");
               // String color = resultSet.getString("color");
                //int size = resultSet.getInt("size");

                // Create a Color object based on the color name
                //Color emojiColor = Color.decode(color);

                // Set the font size
               // Font emojiFont = new Font("Arial", Font.PLAIN, size);

                //emojiTextArea.append(emoji + " ");
               // emojiTextArea.setFont(emojiFont);
                //emojiTextArea.setForeground(emojiColor);
            }

            // Close the database connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
