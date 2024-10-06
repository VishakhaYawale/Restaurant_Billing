import java.sql.*;
import javax.swing.*;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AddMenu extends javax.swing.JFrame {
Connection con = null;
PreparedStatement ps;
PreparedStatement pst,pstt;
ResultSet rs;
ResultSetMetaData rd;
DefaultTableModel model; 
    public AddMenu() {
        initComponents();
        connect();
        table_load(); 
    }
public void connect()
{
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","abcd","abcd");
    }
        catch(Exception ex){
            ex.printStackTrace();
        }
}
void setTableData()
{
    try{
        int rows=0;
        int rowIndex=0;
        Statement smt= con.createStatement();
        ResultSet rs=smt.executeQuery("select * from menuitems");
        if(rs.next())
        {
            rs.last();
            rows=rs.getRow();
            rs.beforeFirst();
            System.out.println(rows);
        }
    } catch(Exception ex){
        ex.printStackTrace();
    }
    }

public void table_load(){
          int a;
         try{
             //connect();
              pst=con.prepareStatement("select * from menuitems");
              rs=pst.executeQuery();
               
              rd=rs.getMetaData();
              a=rd.getColumnCount(); 
              model=(DefaultTableModel)jTable1.getModel();
              model.setRowCount(0);
              
              while(rs.next())
              {
                  Vector v= new Vector();
                  for(int i=1;i<=a;i++)
                  {
                      v.add(rs.getString("menu_item_id"));
                      v.add(rs.getString("item_name"));
                      v.add(rs.getString("item_price")); 
                  }
                  model.addRow(v); 
              }
         }
         catch(Exception ex){
             ex.printStackTrace();
         }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        menu_name = new javax.swing.JTextField();
        menu_price = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Menu Item");

        jLabel2.setText("Price");

        menu_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                menu_priceKeyTyped(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(242, 242, 242));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_add.setForeground(new java.awt.Color(51, 0, 51));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(242, 242, 242));
        btn_update.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(242, 242, 242));
        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "menu_item_id", "item_name", "item_price"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        back.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        back.setText(" Go Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(back)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_add)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_update)))
                        .addGap(12, 12, 12)
                        .addComponent(btn_delete))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(menu_name, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(menu_price))))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(menu_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(menu_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_add)
                            .addComponent(btn_update)
                            .addComponent(btn_delete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(back)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        
        try{

        String menu = menu_name.getText(); 
        int price = Integer.parseInt(menu_price.getText());
         ps = con.prepareStatement("INSERT INTO menuitems(menu_item_id, item_name, item_price) VALUES (NULL, ?, ?)");
        ps.setString(1, menu);
        ps.setInt(2, price);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Insert Successfully");
        
        menu_name.setText("");
        menu_price.setText(""); 
        menu_name.requestFocus();
    }
        catch(Exception ex){
            
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void menu_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menu_priceKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
        
    }//GEN-LAST:event_menu_priceKeyTyped
String menu;int price;
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      /* try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","abcd","abcd");
        Statement st=con.createStatement();
        ResultSet res=st.executeQuery("Select * from menuitems");
        res.last();
        int row=res.getRow();
        int col=res.getMetaData().getColumnCount();
        res.beforeFirst();
        String rowData[][]=new String[row][col];
        int r=0;
        while(res.next()){
            for(int i=0;i<col;i++){
                rowData[r][i]=res.getString(i+1);
            }
            r++;
        }
        String[] columnName={"menu_item_id","item_name","item_price"};
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setDataVector(rowData,columnName);
    }catch(Exception E)
    {
        E.printStackTrace();
    }
        */
    }//GEN-LAST:event_formWindowOpened

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if(menu_id!=0){
        try{
            menu = menu_name.getText(); 
         price = Integer.parseInt(menu_price.getText());
            Statement st= con.createStatement();
            st.execute("update menuitems set item_name='"+menu+"',item_price='"+price+"' where menu_item_id="+menu_id);
           JOptionPane.showMessageDialog(this, "Updated Successfully!");
           setTableData(); 
           menu_name.setText(" ");
           menu_price.setText("");
           //menu_id=0;
    }
        catch(Exception ex){
            //ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        }
        
    }//GEN-LAST:event_btn_updateActionPerformed
int menu_id;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     
       try{
        
        menu_id=Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
         Statement smt=con.createStatement();
         ResultSet rs=smt.executeQuery("select * from menuitems where menu_item_id="+menu_id);
         
         // check if there is a row in the result set
         if(rs.next())
         {
             menu_name.setText(rs.getString(2));
             menu_price.setText(rs.getInt(3)+"");
         }
         else {
             // handle the case when there is no row in the result set
             JOptionPane.showMessageDialog(null, "No record found for this menu item ID", "Error", JOptionPane.ERROR_MESSAGE);
         }
    }
    catch(Exception Ex){
        Ex.printStackTrace();
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed

try{
    menu_id=Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
    Statement smt=con.createStatement();
    String sql="delete from menuitems where menu_item_id=?";
    pstt=con.prepareStatement(sql);
    pstt.setInt(1, menu_id);
    pstt.executeUpdate();
    
    JOptionPane.showMessageDialog(null,"delete successfully ");
}catch(SQLException ex){
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
       
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Welcome wl=new Welcome();
        wl.show();
        wl.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(AddMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField menu_name;
    private javax.swing.JTextField menu_price;
    // End of variables declaration//GEN-END:variables
}
