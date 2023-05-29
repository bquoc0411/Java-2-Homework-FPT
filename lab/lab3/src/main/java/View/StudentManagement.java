/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Student;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class StudentManagement extends javax.swing.JFrame {
    
    DefaultTableModel tblModel;
    private List<Student> list = new ArrayList<>();
    
    String path = "Student.txt";
    /**
     * Creates new form StudentManagement
     */
    public StudentManagement() {
        initComponents();
        setLocationRelativeTo(null);
        initMajor();
        initTable();
        initData();
        fillToTable();
    }
    
    public void initData() {
        list.add(new Student("Giang", 10.0, "Phat trien phan mem"));
        list.add(new Student("Binh", 7.0, "Phat trien phan mem"));
        list.add(new Student("MHuong", 9.0, "Phat trien phan mem"));
        list.add(new Student("AnhHong", 5.0, "Phat trien phan mem"));
    }
    
    public void initMajor() {
        String[] major = new String[]{"Phat trien phan mem", "Xu li du lieu", "Phan tich nghiep vu", "Kiem thu"};
        DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>(major);
        cboMajor.setModel(boxModel);
    }
    
    public void initTable() {
        tblModel = (DefaultTableModel) tblStudent.getModel();
        String[] cols = new String[]{"Ho ten", "Diem", "Nganh", "Hoc luc", "Thuong"};
        tblModel.setColumnIdentifiers(cols);
    }
    
    public void fillToTable() {
        tblModel.setRowCount(0);
        for (Student per : list) {
            Object[] row = new Object[]{per.getName(), per.getMarks(), per.getMajor(), per.getRank(), per.isBonus()};
            tblModel.addRow(row);
        }
    }
    
    public void addStudent() {
        Student sv = new Student();
        sv.setName(txtName.getText());
        sv.setMarks(Double.parseDouble(txtPoints.getText()));
        sv.setMajor((String) cboMajor.getSelectedItem());
        txtRank.setText(sv.getRank());
        chkGift.setSelected(sv.isBonus());
        list.add(sv);
        fillToTable();
        JOptionPane.showMessageDialog(this, "Added successfull");
    }
    
    public void showDetail() {
        int index = tblStudent.getSelectedRow();
        txtName.setText(list.get(index).getName());
        txtPoints.setText(String.valueOf(list.get(index).getMarks()));
        cboMajor.setSelectedItem(list.get(index).getMajor());
        txtRank.setText(list.get(index).getRank());
        chkGift.setSelected(list.get(index).isBonus());
    }
    
    public void removeStudent() {
        int index = tblStudent.getSelectedRow();
        list.remove(index);
        fillToTable();
        JOptionPane.showMessageDialog(this, "Deleted successfully");
    }
    
    public void updateStudent() {
        int index = tblStudent.getSelectedRow();
        if (index > 0) {
            Student sv = new Student();
            sv.setName(txtName.getText());
            sv.setMarks(Double.parseDouble(txtPoints.getText()));
            sv.setMajor((String) cboMajor.getSelectedItem());
            txtRank.setText(sv.getRank());
            chkGift.setSelected(sv.isBonus());
            fillToTable();
            JOptionPane.showMessageDialog(this, "Updated successfull");
        } else {
            JOptionPane.showMessageDialog(this, "Pls, select a row to update");
        }
        
    }
    
    public void sortName() {
        Collections.sort(list, (sv1, sv2) -> (sv1.getName().compareTo(sv2.getName())));
        fillToTable();
    }
    
    public void sortByMarks() {
        Collections.sort(list, (sv1, sv2) -> (int) (sv1.getMarks() - sv2.getMarks()));
        fillToTable();
    }
    
    
    public void WriterFile1(String path) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            int a = 5;
            fos.write(a);
            fos.close();
            System.out.println("Xuat thanh cong");
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
    
    public void ReadFile1(String path) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            int a = fis.read();
            System.out.println(a);
            System.out.println("Ghi file thanh cong");
            fis.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
    
    //Doc ghi doi tuong hoc sinh: 
    public void WriteFile2(String path) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            System.out.println("Ghi file thanh cong");
            fos.close();
            oos.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
    
    public void ReadFile2(String path) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            list = (ArrayList<Student>) ois.readObject();
            System.out.println(list);
            fis.close();
            ois.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        cboMajor = new javax.swing.JComboBox<>();
        txtName = new javax.swing.JTextField();
        txtRank = new javax.swing.JTextField();
        txtPoints = new javax.swing.JTextField();
        chkGift = new javax.swing.JCheckBox();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnOrderByName = new javax.swing.JButton();
        btnOrderbyMarks = new javax.swing.JButton();
        btnWrite = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        jLabel2.setText("HỌ VÀ TÊN");

        jLabel3.setText("ĐIỂM");

        jLabel4.setText("NGÀNH");

        jLabel5.setText("HỌC LỰC");

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudent);

        cboMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtRank.setEnabled(false);
        txtRank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRankActionPerformed(evt);
            }
        });

        txtPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPointsActionPerformed(evt);
            }
        });

        chkGift.setText("Có phần thưởng?");
        chkGift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkGiftActionPerformed(evt);
            }
        });

        btnRemove.setText("XÓA");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAdd.setText("THÊM");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnReset.setText("NHẬP MỚI");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnUpdate.setText("CẬP NHẬT");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnOrderByName.setText("Sap xep theo ten");
        btnOrderByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderByNameActionPerformed(evt);
            }
        });

        btnOrderbyMarks.setText("Sap xep theo diem");
        btnOrderbyMarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderbyMarksActionPerformed(evt);
            }
        });

        btnWrite.setText("write");
        btnWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWriteActionPerformed(evt);
            }
        });

        btnRead.setText("Read");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRank, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkGift)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemove)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnReset))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnOrderByName)
                        .addGap(70, 70, 70)
                        .addComponent(btnOrderbyMarks))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(btnWrite)
                        .addGap(108, 108, 108)
                        .addComponent(btnRead)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtRank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chkGift)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove)
                    .addComponent(btnReset)
                    .addComponent(btnUpdate))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnWrite)
                    .addComponent(btnRead))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOrderByName)
                    .addComponent(btnOrderbyMarks))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRankActionPerformed

    private void txtPointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPointsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPointsActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void chkGiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkGiftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkGiftActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        addStudent();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtName.setText("");
        txtPoints.setText("");
        txtRank.setText("");
        chkGift.setSelected(false);
    }//GEN-LAST:event_btnResetActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        // TODO add your handling code here:
        showDetail();

    }//GEN-LAST:event_tblStudentMouseClicked

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        removeStudent();
        btnResetActionPerformed(evt);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        updateStudent();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnOrderByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderByNameActionPerformed
        // TODO add your handling code here:
        sortName();
    }//GEN-LAST:event_btnOrderByNameActionPerformed

    private void btnOrderbyMarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderbyMarksActionPerformed
        // TODO add your handling code here:
        sortByMarks();
    }//GEN-LAST:event_btnOrderbyMarksActionPerformed

    private void btnWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWriteActionPerformed
        // TODO add your handling code here:
        WriterFile1(path);
        WriteFile2(path);
    }//GEN-LAST:event_btnWriteActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReadActionPerformed

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
            java.util.logging.Logger.getLogger(StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnOrderByName;
    private javax.swing.JButton btnOrderbyMarks;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnWrite;
    private javax.swing.JComboBox<String> cboMajor;
    private javax.swing.JCheckBox chkGift;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPoints;
    private javax.swing.JTextField txtRank;
    // End of variables declaration//GEN-END:variables
}
