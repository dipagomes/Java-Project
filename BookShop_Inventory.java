
package algorithm_project;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.MessageFormat;
import javax.swing.border.TitledBorder;
import javax.swing.JFrame;
import javax.swing.table.TableRowSorter;

public class BookShop_Inventory extends JFrame implements ActionListener {
        
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;  // Create table without table or column
    Container c;
    private Font HeadFont, font;
    private JLabel headingLabel, bNameLabel, aNameLabel, bCodeLabel, priceLabel,qtyLabel;
    private JTextField bNameTf, aNameTf, bCodeTf, priceTf,totalTf,qtyTf;
    private JButton addButton, updateButton, printButton, deleteButton, clearButton;

    private String[] columns = {"Book Name", "Author Name", "Book Code", "Price","Qty"};
    private String[] rows = new String[5];

    private JPanel infoPanel, buttonPanel, tablePanel;
    private JSpinner spinner;
  
   
    BookShop_Inventory(){
        frame_components();
        sort();
    }
 
  private void frame_components() {
        /*====================This section is for Frame====================*/
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(755,720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle(("BookShop Management"));

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(240, 240, 240));
        /*====================This section is for Frame====================*/

        /*====================This section is for Font creation====================*/
        //Font(Font name,Font style,Font Size)
        HeadFont = new Font("Arial Black", Font.BOLD, 40);
        font = new Font("Arial Rounded MT Bold", Font.PLAIN, 16);
        /*====================This section is for Font creation====================*/

        /*====================This section is for HEADING====================*/
        headingLabel = new JLabel("BookShop Inventory System");
        headingLabel.setHorizontalAlignment(JLabel.CENTER);
        headingLabel.setOpaque(true);
        headingLabel.setBackground(new Color(51,153, 255));
        headingLabel.setFont(HeadFont);
        headingLabel.setBounds(0, 0, 755, 100);
        c.add(headingLabel);
        /*====================This section is for HEADING====================*/

       

        /*====================This section is for infoPanel===infoPanel=================*/
        infoPanel = new JPanel(new GridLayout(6, 2, 8, 20));
        infoPanel.setBounds(30, 120, 600, 270);
        infoPanel.setBorder(BorderFactory.createTitledBorder(null,"", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 18)));
        c.add(infoPanel);

        bNameLabel = new JLabel(" Book Name: ");
        bNameLabel.setFont(font);
        infoPanel.add(bNameLabel);
        bNameTf = new JTextField();
        bNameTf.setFont(font);
        infoPanel.add(bNameTf);

        aNameLabel = new JLabel(" AuthorName: ");
        aNameLabel.setFont(font);
        infoPanel.add(aNameLabel);
        aNameTf = new JTextField();
        aNameTf.setFont(font);
        infoPanel.add(aNameTf);

        bCodeLabel = new JLabel(" Book Code: ");
        bCodeLabel.setFont(font);
        infoPanel.add(bCodeLabel);
        bCodeTf = new JTextField();
        bCodeTf.setFont(font);
        infoPanel.add(bCodeTf);

        priceLabel = new JLabel(" Price    : ");
        priceLabel.setFont(font);
        infoPanel.add(priceLabel);
        priceTf = new JTextField();
        priceTf.setFont(font);
        infoPanel.add(priceTf);
        
        qtyLabel = new JLabel(" Qty    : ");
        qtyLabel.setFont(font);
        infoPanel.add(qtyLabel);
        qtyTf = new JTextField();
        qtyTf.setFont(font);
        infoPanel.add(qtyTf);
      
     
        /*====================This section is for infoPanel====================*/

        /*====================This section is for buttonPanel====================*/
        buttonPanel = new JPanel(new GridLayout(1, 6));
        buttonPanel.setBounds(30, 420, 650, 30);
        c.add(buttonPanel);

        addButton = new JButton("Add");
        addButton.setFont(font);
        buttonPanel.add(addButton);

        updateButton = new JButton("Update");
        updateButton.setFont(font);
        buttonPanel.add(updateButton);

        printButton = new JButton("Print");
        printButton.setFont(font);
        buttonPanel.add(printButton);

        deleteButton = new JButton("Delete");
        deleteButton.setFont(font);
        buttonPanel.add(deleteButton);

        clearButton = new JButton("Clear");
        clearButton.setFont(font);
        buttonPanel.add(clearButton);
        
   
        /*====================This section is for buttonPanel====================*/

        /*====================This section is for tablePanel====================*/
        tablePanel = new JPanel(new CardLayout());
        tablePanel.setBounds(30, 450, 650, 215);
        c.add(tablePanel);

        table = new JTable();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(font);
        table.setSelectionBackground(new Color(0, 120, 215));
        table.setSelectionForeground(new Color(255, 255, 255));
        table.setGridColor(new Color(128, 128, 128));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);

        scroll = new JScrollPane(table);
        scroll.setBounds(0, 0, 700, 215);
        tablePanel.add(scroll);
        /*====================This section is for tablePanel====================*/

        /*====================This section is for ActionListener====================*/
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        printButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        
     

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int numberofRow = table.getSelectedRow();

                bNameTf.setText(model.getValueAt(numberofRow, 0).toString());
                aNameTf.setText(model.getValueAt(numberofRow, 1).toString());
                bCodeTf.setText(model.getValueAt(numberofRow, 2).toString());
                priceTf.setText(model.getValueAt(numberofRow, 3).toString());
                qtyTf.setText(model.getValueAt(numberofRow, 4).toString());
              
  
            }
        });
   
        /*====================This section is for ActionListener====================*/
    }
     private void sort(){
      TableRowSorter<DefaultTableModel>  sorter = new TableRowSorter<DefaultTableModel> (model);
       table.setRowSorter(sorter);
       
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // if user press Add button
        if (e.getSource().equals(addButton)) {
            rows[0] = bNameTf.getText();
            rows[1] = aNameTf.getText();
            rows[2] = bCodeTf.getText();
            rows[3] = priceTf.getText();
            rows[4] = qtyTf.getText();
            
          
         
           

            model.addRow(rows);
        }
        // if user press Update button
        else if (e.getSource().equals(updateButton)) {
            int numberofRow = table.getSelectedRow();

            model.setValueAt(bNameTf.getText(),numberofRow, 0);
            model.setValueAt(aNameTf.getText(),numberofRow, 1);
            model.setValueAt(bCodeTf.getText(),numberofRow, 2);
            model.setValueAt(priceTf.getText(),numberofRow, 3);
            model.setValueAt(qtyTf.getText(),numberofRow, 4);
            

        }
        // if user press Print button
        else if (e.getSource().equals(printButton)) {

            //MessageFormat for=new MessageFormat()
            MessageFormat header = new MessageFormat("BookShop");

            try {
                table.print(JTable.PrintMode.FIT_WIDTH, header, null);
            } catch (Exception ec) {
                JOptionPane.showMessageDialog(rootPane, ec);
            }
        }// if user press Delete button
        else if (e.getSource().equals(deleteButton)) {
            int numberofRow = table.getSelectedRow();
            if (numberofRow >= 0) {
                model.removeRow(numberofRow);
            } else {
                JOptionPane.showMessageDialog(null, "No row has been selected");
            }
        }// if user press Clear button
        else if (e.getSource().equals(clearButton)) {
            bNameTf.setText("");
            aNameTf.setText("");
            bCodeTf.setText("");
            priceTf.setText("");
            qtyTf.setText("");
            
        } 
        
    }
    public static void main(String[] args) {
        BookShop_Inventory frame = new BookShop_Inventory();
        frame.setVisible(true);
    }
}


