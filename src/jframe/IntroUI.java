package jframe;
import javax.swing.*; // Main ones are JFrame and JTable for this package
import javax.swing.table.TableColumn;

public class IntroUI extends JFrame{
    public IntroUI(){
        super("Example GUI");                       // super() to extend from JFrame javax class, allowing us to omit "window." in "window.FUNCTION()"
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // terminates program once you close the window
        setSize(640,480);
        setLocationRelativeTo(null);                     // must be called after initializing size, centers window upon start
        setLayout(null);
        setResizable(false);                             // prevent the user from dragging corners
        setVisible(true);                                // now you can see the window, default is false

            // table implementation
        // the headers & data for the table
        String[] columnNames = {"Assignment Name", "Score", "Curved Score", "Due Date"};    // The headers for our table; not the actual data
        Object[][] data = {{"Assignment 1", 92, 95, "July 2nd, 2025"},
                           {"Assignment 2", 96, 101, "July 15th, 2025"},
                           {"Assignment 3", 100, 104, "July 26th, 2025"},
                           {"Midterm Exam", 78, 85, "June 15th, 2025"},
                           {"Final Exam", 89, 105, "July 30th, 2025"},
                           {"Quiz 1", 95, 95, "June 2nd, 2025"},
                           {"Quiz 2", 100, 100, "June 29th, 2025"},
                           {"Quiz 3", 100, 100, "July 14th, 2025"},
                           {"Quiz 4", 100, 100, "July 26th, 2025"},
        };                                                                                  // 2D Object array (Object; allowing for multiple data types) of data

        JTable jtable = new JTable(data, columnNames);

        // table & header sizing; tinkering with table header sizes might take some trial and error
        jtable.getTableHeader().setBounds(0, 0, 640, 30);
        jtable.setBounds(0, 30, 640, 250);

        TableColumn column = null;
        for (int i = 0; i < data[0].length; i++) {          //data[0].length = 4, there are 4 items in each row of data
            column = jtable.getColumnModel().getColumn(i);
            if (i == 0 || i == 3) {                         // 1st and 4th row of data
                column.setPreferredWidth(150);
            } else {                                        // any other row of data
                column.setPreferredWidth(25);
            }
        }

        add(jtable.getTableHeader());
        add(jtable);

        /*
            // button implementation
        JButton button = new JButton("Button");
        add(button);
         */

        // updates the window so it can load the button
        repaint();
        revalidate();

        /* THIS IS THE CODE WITHOUT THE "super("Example GUI")
        JFrame window = new JFrame("Example GUI");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(640,480);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);

        JButton button = new JButton("Button");
        window.add(button);

        window.repaint();
        window.revalidate();
         */
    }
}
