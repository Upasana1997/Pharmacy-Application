
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class admin extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
    public admin() {
        initComponents();
        setMinimumSize(new Dimension(480,380).getSize());
   //setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b2 = new java.awt.Button();
        button2 = new java.awt.Button();
        label1 = new java.awt.Label();
        b1 = new java.awt.Button();
        b3 = new java.awt.Button();
        b4 = new java.awt.Button();
        button1 = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();

        b2.setLabel("users info");

        button2.setLabel("pharmacist info");
        button2.setName(""); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label1.setText("ADMINISTRATION");
        getContentPane().add(label1);
        label1.setBounds(46, 34, 350, 59);

        b1.setLabel("insert chemist info");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1);
        b1.setBounds(70, 130, 117, 24);

        b3.setLabel("medicine analysis");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        getContentPane().add(b3);
        b3.setBounds(70, 200, 116, 24);

        b4.setLabel("chat room");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        getContentPane().add(b4);
        b4.setBounds(260, 200, 101, 24);

        button1.setLabel("Add admin");
        button1.setName(""); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1);
        button1.setBounds(250, 130, 116, 24);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wert.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 460, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
        admin_insert a=new admin_insert();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_b1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        add_admin a=new add_admin();
        a.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_button1ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:
        try
        {
            String q="select * from tbmedicine";
            myconnection obj=new myconnection();
            PreparedStatement pst=obj.db.prepareStatement(q);
            ResultSet rs;
            rs=pst.executeQuery();
            DefaultPieDataset ds=new DefaultPieDataset();
            while(rs.next())
            {
                ds.setValue(rs.getString("pname"),rs.getInt("quantity"));
            }
            JFreeChart j=ChartFactory.createPieChart("medicine quantity", ds, true, true, false);
            File f=new File("piechart.jpeg");
            ChartUtilities.saveChartAsJPEG(f, j, 400, 400);
        }
        catch(IOException | SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_b3ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
       // new Main().setVisible(true);
       new pharmadet().setVisible(true);
        
         /* try
        {
            String q="select * from tbchemist";
            myconnection obj=new myconnection();
            PreparedStatement pst=obj.db.prepareStatement(q);
            ResultSet rs;
            rs=pst.executeQuery();
            JTable table = new JTable();
            DefaultTableModel tableModel = new DefaultTableModel();

        //Retrieve meta data from ResultSet
        ResultSetMetaData metaData = rs.getMetaData();

        //Get number of columns from meta data
        int columnCount = metaData.getColumnCount();

        //Get all column names from meta data and add columns to table model
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
        }

        //Create array of Objects with size of column count from meta data
        Object[] row = new Object[columnCount];

        //Scroll through result set
        while (rs.next()){
            //Get object from column with specific index of result set to array of objects
            for (int i = 0; i < columnCount; i++){
                row[i] = rs.getObject(i+1);
            }
            //Now add row to table model with that array of objects as an argument
            tableModel.addRow(row);
        }

        //Now add that table model to your table and you are done :D
        table.setModel(tableModel);
                  
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }*/
    
        /*try
        {
            
            String q="select * from tbchemist";
            myconnection obj=new myconnection();
            PreparedStatement pst=obj.db.prepareStatement(q);
            ResultSet rs;
            rs=pst.executeQuery();
            while(rs.next())
            {
                DefaultTableModel dtm=new DefaultTableModel(0,0);
                JTable jt=new JTable(dtm);
                int i=0;
                int id;
                String pharmacy,location,city,contact,email,opening_time,closing_time,website;
                while(rs.next())
                {
                   id=rs.getInt("id");
                   pharmacy=rs.getString("pharmacy");
                   location=rs.getString("location");
                   city=rs.getString("city");
                   contact=rs.getString("contact");
                   email=rs.getString("email");
                   opening_time=rs.getString("opening_time");
                   closing_time=rs.getString("closing_time");
                   website=rs.getString("website");
                   dtm.addRow(new Vector());
                   dtm.setValueAt(id, i, 0);
                    dtm.setValueAt(pharmacy, i, 1);
                     dtm.setValueAt(location, i, 2);
                     dtm.setValueAt(city, i, 3);
                     dtm.setValueAt(contact, i, 4);
                     dtm.setValueAt(email, i, 5);
                     dtm.setValueAt(opening_time, i, 6);
                     dtm.setValueAt(closing_time, i, 7);
                     dtm.setValueAt(website, i, 8);
                     i++;
                }
                jt.setModel(dtm);            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }*/
    
    }//GEN-LAST:event_button2ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        // TODO add your handling code here:
        server s=new server();

    }//GEN-LAST:event_b4ActionPerformed

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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new admin().setVisible(true);
            }

            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button b1;
    private java.awt.Button b2;
    private java.awt.Button b3;
    private java.awt.Button b4;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
