package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import static net.mindview.util.SwingConsole.run;

/**
 * Created by Olexiy on 05.05.2018.
 */
public class Symbols_replace extends JFrame {
    private JTextField name = new JTextField(25);
    private JTextArea results = new JTextArea(40, 65);

    class NameL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nm = name.getText();
            if (nm.length() == 0) {
                results.setText("No match");
                return;
            }
            results.setText("");
            String a = "`1234567890-=qwertyuiop[]asdfghjkl;'zxcvbnm,./ ~!@#$%^&*()_+|QWERTYUIOP{}ASDFGHJKL::ZXCVBNM<>?";
            String b = "ґ1234567890-=йцукенгшщзхїфівапролджєячсмитьбю. Ґ! №;%:?*()_+/ЙЦУКЕНГШЩЗХЇФІВАПРОЛДЖЄЯЧСМИТЬБЮ,";
            char[] c = a.toCharArray();
            char[] d = b.toCharArray();
            char t = '\"';
            d[49] = t;
            c[83] = t;
            Map map = new HashMap();
            for (int i = 0; i < c.length; i++) {
                map.put(c[i], d[i]);
            }
            char[] ch = nm.toCharArray();

            StringBuilder sent = new StringBuilder("");
            for (int i = 0; i < nm.length(); i++) {
                sent.append(map.get(ch[i]));
            }
            String res = sent.toString();
            results.setText(res);


        }
    }
    public Symbols_replace() {
        Symbols_replace.NameL nameListener = new Symbols_replace.NameL();
        name.addActionListener(nameListener);

        JPanel top = new JPanel();
        top.add(new JLabel("Вставте рядок:"));
        top.add(name);
        add(BorderLayout.NORTH, top);
        add(new JScrollPane(results));
        // Initial data and test:
        name.setText("");
        nameListener.actionPerformed(
                new ActionEvent("", 0 ,""));
    }
    public static void main(String[] args) {
        run(new Symbols_replace(), 500, 400);
    }
}
