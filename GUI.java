import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;

//import static java.util.concurrent.TimeUnit.*; --have to figure out how to do or I can't get rid of the vestigial methods.--

public class GUI implements ActionListener {
    private JFrame frame = new JFrame("Miner");
    private JPanel screen = new JPanel();

    private JButton mine = new JButton();
    private JButton buyTool = new JButton();
    // private JButton hireMiners = new JButton(); --Vestigial--
    // private JButton buyBetterMinersTools = new JButton(); --Vestigial--
    private NumberFormat numFmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);

    private JLabel goldAmount = new JLabel();
    private ImageIcon icon = new ImageIcon("assets/icon.png");

    public GUI() {
        // int midX = screen.getWidth() / 2;
        // int midY = screen.getHeight() / 2;

        // loads on start so that the variables are set to their correct values
        frame.setIconImage(icon.getImage());
        frame.setBackground(new Color(193, 176, 163));

        numFmt.setMinimumFractionDigits(3);
        mySystem.load();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                mySystem.save();
            }
        });

        buyTool.setText("buy tool for: " + numFmt.format(score.getPlayerPrice()));
        buyTool.setIcon(new ImageIcon("assets/betterMine.png"));
        buyTool.setMaximumSize(new Dimension(300, 300));
        mine.setText("Mine for " + numFmt.format(score.getStrength()));
        mine.setIcon(icon);
        mine.setMaximumSize(new Dimension(300, 300));
        goldAmount.setText("gold: " + numFmt.format(score.getPoints()));
        goldAmount.setIcon(new ImageIcon("assets/gold.png"));

        mine.addActionListener(this);

        buyTool.addActionListener(this);

        mine.setFocusable(false);
        buyTool.setFocusable(false);

        screen.setLayout(new GridLayout());
        screen.add(goldAmount);

        screen.add(mine);
        screen.add(buyTool);
        frame.add(screen);
        // screen.add(hireMiners); --Vestigial--
        // screen.add(buYMinersTools); --Vestigial--
        // Display the window.

        frame.setMinimumSize(new Dimension(1280, 800));
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mine) { // when clicking a specific button it will add gold and display it.
            score.changePoints(score.getStrength());
            goldAmount.setText("gold: " + numFmt.format(score.getPoints()));
        } else if (e.getSource() == buyTool) { // when chaning the amount of gold earned when clicking the 1st button
                                               // that adds gold. Will subtract gold and will not change the amount of
                                               // gold if there isn't enough.
            if (score.getPoints() >= score.getPlayerPrice()) {
                score.changeStrength(2 * score.getMod() + 2);
                score.changePoints(score.getPlayerPrice() * -1);
                score.changePrice(score.getMod() + 0.5);
                buyTool.setText("buy tool for: " + numFmt.format(score.getPlayerPrice())); // so that each subsequent
                                                                                           // purchase will
                // cost more.
                // so thta every action to buy more costs more later and also the strength of
                // the miners and the player.
                goldAmount.setText("gold: " + numFmt.format(score.getPoints()));
                mine.setText("Mine for " + numFmt.format(score.getStrength()));
                score.changeMod(0.03);
            } // below are vestigial functinons that cannot work as intended unless I figure
              // out how to run a funcion based on a timer.
        } // else if (e.getSource() == hireMiners) { // adds one automatic miner so that
          // the player earns passive gold
          // // income.
          // if (score.getPoints() >= score.getMinerPrice()) {
          // score.changePoints(score.getMinerPrice() * -1);

        // }
        // } else if (e.getSource() == buyBetterMinersTools) {
        // if (score.getPoints() >= score.getMinerPrice()) {
        // score.changePoints(score.getMinerToolPrice() * -1);
        // score.changeMinerStrength(score.getMod() * 0.5);
        // }
        // }
    }
}
