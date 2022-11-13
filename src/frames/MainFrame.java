package frames;

import com.sun.tools.javac.Main;

import javax.sound.sampled.AudioInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JPanel panel = new JPanel();
    private JButton currentSetNewTimerButton = null;

    public MainFrame(String name) {
        super(name);
    }

    public void frameStartBuilding() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.getContentPane().add(BorderLayout.NORTH, this.buildMenuBar());
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(this.setNewTimerButton());
        this.getContentPane().add(BorderLayout.CENTER, panel);
        this.setVisible(true);
    }

    private JMenuBar buildMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenuTest = new JMenu("Test1");
        JMenu jMenuTest2 = new JMenu("Test2");
        jMenuBar.add(jMenuTest);
        jMenuBar.add(jMenuTest2);
        JMenuItem jMenuItem1 = new JMenuItem("TestItem1");
        JMenuItem jMenuItem2 = new JMenuItem("TestItem2");
        jMenuTest.add(jMenuItem1);
        jMenuTest.add(jMenuItem2);
        return jMenuBar;
    }

    private JPanel buildPanel() {
        JPanel jPanel = new JPanel();
        JLabel label = new JLabel("Test Label");
        JButton testButton = new JButton("Test Button");
        JButton testButton2 = new JButton("Test Button2");
        JTextField jTextField = new JTextField(15);
        jPanel.add(label);
        jPanel.add(jTextField);
        jPanel.add(testButton);
        jPanel.add(testButton2);
        return jPanel;
    }

    private JButton setNewTimerButton() {
        if(!(currentSetNewTimerButton == null)) {
            panel.remove(currentSetNewTimerButton);
            panel.add(setTimerLabel());
        }
        JButton button = new JButton("Set new timer");
        currentSetNewTimerButton = button;
        button.setAlignmentX(0.5F);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.add(setNewTimerButton());
                panel.updateUI();
            }
        });
        return button;
    }

    private JPanel setTimerLabel() {
        JPanel timerPanel = new JPanel();
        timerPanel.setLayout(new FlowLayout());
        JTextField numberField = new JTextField();
        numberField.setPreferredSize(new Dimension(100, 30));
        JButton startButton = new JButton("Start");
        JRadioButton radioButtonMinutes = new JRadioButton("Minutes");
        JRadioButton radioButtonHours = new JRadioButton("Hours");
        JRadioButton radioButtonSeconds = new JRadioButton("Seconds");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonSeconds);
        buttonGroup.add(radioButtonMinutes);
        buttonGroup.add(radioButtonHours);
        timerPanel.add(numberField);
        timerPanel.add(radioButtonHours);
        timerPanel.add(radioButtonMinutes);
        timerPanel.add(radioButtonSeconds);
        timerPanel.add(startButton);
        return timerPanel;
    }
}
