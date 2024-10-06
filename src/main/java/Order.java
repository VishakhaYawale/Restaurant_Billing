import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import com.mysql.cj.jdbc.Driver;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Order extends javax.swing.JFrame {

    private Object textarea;

    public Connection getConnection() {
        Connection con = null;
    try {
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","abcd","abcd");

        Class.forName("com.mysql.cj.jdbc.Driver");
        //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "mypassword");
    } catch (Exception e) {
        e.printStackTrace();
    }
    return con;
}
    public Order() {
        initComponents();
        billHeader();
        getConnection();
        loadData();
        //logo();
       // getPayMode();
    }
    String PayMode;
    int Price=0;
    long  total=0;
    public void loadData() {
    DefaultComboBoxModel model = new DefaultComboBoxModel();
    try {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT item_name FROM menuitems");
        while (rs.next()) {
            model.addElement(rs.getString("item_name"));
        }
        combo_menu.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd     \nHH:mm:ss\n");
    LocalDateTime now=LocalDateTime.now();
        
    /*public void  logo(){
        JFrame window =new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(100,500);
        ImageIcon icon=new ImageIcon(getClass().getClassLoader().getResource("icon.jpg"));
      
        
        jtextarea textarea=new jtextarea();
        textarea.setImage(icon);
        window.add(textarea);
        window.setVisible(true);
       
    }*/
    
    private void billHeader()
    {
        txtbill.setText("----------------------------------------------------------------------------------------------"+"\n                                        Hotel Sawant Kitchen"+"\n"+"                                 Address:Shahu Chowk,near\n                              Maruti Mandir Shanivar Peth, karad \n"+"                             Contact:9921067770 , 9975761376\n"+"----------------------------------------------------------------------------------------------"+"\n"+(dtf.format(now))+"\n Item                   \t     Price          Quantity          Amount"+"\n----------------------------------------------------------------------------------------------");  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        btn_addmenu = new javax.swing.JButton();
        combo_menu = new javax.swing.JComboBox<>();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtbill = new javax.swing.JTextArea();
        btnqty = new javax.swing.JTextField();
        btn_pay = new javax.swing.JButton();
        r_back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(100, 200));

        jLabel1.setText("Payment Mode");

        jLabel2.setText("Select Ordered Menu: ");

        jLabel3.setText("Quantity ");

        btn_save.setText("Receipt");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_addmenu.setText("Add ");
        btn_addmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addmenuActionPerformed(evt);
            }
        });

        combo_menu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_menu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_menuItemStateChanged(evt);
            }
        });
        combo_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_menuActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Cash");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Online");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        txtbill.setColumns(20);
        txtbill.setRows(5);
        jScrollPane1.setViewportView(txtbill);

        btnqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnqtyActionPerformed(evt);
            }
        });
        btnqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnqtyKeyTyped(evt);
            }
        });

        btn_pay.setText("PayMode");
        btn_pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_payActionPerformed(evt);
            }
        });

        r_back.setText("Back to Home");
        r_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(jLabel2)
                                    .addGap(64, 64, 64)
                                    .addComponent(combo_menu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_addmenu))
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_pay)
                                    .addComponent(btnqty, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(r_back)
                        .addGap(258, 258, 258)))
                .addGap(159, 159, 159)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1103, 1103, 1103))
            .addGroup(layout.createSequentialGroup()
                .addGap(881, 881, 881)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(combo_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(btnqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_addmenu)
                            .addComponent(btn_pay)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btn_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(r_back)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
ButtonGroup bg = new ButtonGroup();
    private void btn_addmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addmenuActionPerformed
            int qtyValue;
            
            qtyValue=Integer.parseInt(btnqty.getText());
    int amount;
        amount = Price*qtyValue;
       total+=amount;
       // txtbill.append();
txtbill.setText(
                     txtbill.getText() /*+"Payment Method: "+PayMode*/+"\n"+combo_menu.getSelectedItem().toString()+"\t"+String.valueOf(Price)+"\t"+qtyValue+"\t"+amount
             );
             jRadioButton4.setEnabled(false);
             jRadioButton3.setEnabled(false);

    }//GEN-LAST:event_btn_addmenuActionPerformed

    private void combo_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_menuActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == combo_menu) {
            String selectedItem = (String) combo_menu.getSelectedItem();
            if (selectedItem != null) {
                try {
                   Connection con = getConnection();
                   Statement stmt = con.createStatement();
                    ResultSet resultSet = stmt.executeQuery("SELECT item_price FROM menuitems WHERE item_name = '" + selectedItem + "';");
                    if (resultSet.next()) {
                        Price = resultSet.getInt("item_price");
                      // txtbill.setText(String.valueOf(Price));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_combo_menuActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        PayMode="Cash";
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        PayMode="Online";
        
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void btnqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnqtyActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnqtyActionPerformed

    private void btnqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnqtyKeyTyped
        char c=evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
        
    }//GEN-LAST:event_btnqtyKeyTyped

    private void combo_menuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_menuItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_combo_menuItemStateChanged

    private void btn_payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_payActionPerformed
        // TODO add your handling code here:
        txtbill.append("\n===================================================\n\n"+"\t \t\tTotal:"+total+"\n \t \t       Payment Method: "+PayMode+"\n         \n     \t             Thank You \n                \t             Visit again!!!\n");
    }//GEN-LAST:event_btn_payActionPerformed

    private void r_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_backActionPerformed
        // TODO add your handling code here:
         Welcome wl=new Welcome();
        wl.show();
        wl.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_r_backActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed

     
        try{
           
          //  getConnection();
            Connection con=null;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","abcd","abcd");

            Class.forName("com.mysql.cj.jdbc.Driver");
         /* //  Statement stm=con.createStatement();
           // String sql="INSERT INTO customer values(null,java.sql.Date.valueOf(LocalDate.now()),"+total+")";
            //stm.executeUpdate(sql);
            //PreparedStatement pstmt = con.prepareStatement(sql);
            //pstmt.setDate(2,java.sql.Date.valueOf(LocalDate.now()));
           // pstmt.setString(3,total);
           
          // Date date=new Date();
          String sql="INSERT INTO customer(id,bill_date,amount)VALUES(null,?,?) ";
              PreparedStatement pstmt = con.prepareStatement(sql);    
              pstmt.setDate(1,java.sql.Date.valueOf(LocalDate.now())); 
              pstmt.setLong(2,total);
             */
              // PreparedStatement pstmt = con.prepareStatement(sql);
               String sql = "INSERT INTO customer(id, bill_date, amount) VALUES(null, ?, ?)";
               PreparedStatement pstmt = con.prepareStatement(sql);
               
          pstmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
           pstmt.setDouble(2, total);
           pstmt.executeUpdate();
        
            
            txtbill.print();
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btn_saveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addmenu;
    private javax.swing.JButton btn_pay;
    private javax.swing.JButton btn_save;
    private javax.swing.JTextField btnqty;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JComboBox<String> combo_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton r_back;
    private javax.swing.JTextArea txtbill;
    // End of variables declaration//GEN-END:variables
}
