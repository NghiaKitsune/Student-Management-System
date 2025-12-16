package student.management.system;
import student.management.system.Biz;
import student.management.system.GD;
import student.management.system.IT;
import student.management.system.ManagementStudent;
import student.management.system.Person;
import java.awt.Color;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class MainForm extends javax.swing.JFrame {

    private List<Person> list = new ArrayList<>();
    private DefaultTableModel model;
    public MainForm() {
        initComponents();
        setSize(800,500);
        setLocationRelativeTo(null); 
        setTitle("Student Management System - Soft Development ABK");
        
        String[] headers = {"ID", "Name", "Age", "Major", "Marks Detail", "Avg", "Rank"};
        model = new DefaultTableModel(headers, 0);
        tblStudents.setModel(model);
       
        
        
        list = ManagementStudent.getStudents();
        fillTable(list);
        
        cboMajor.setSelectedIndex(0); 


        tblStudents.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        tblStudents.getColumnModel().getColumn(0).setPreferredWidth(80); 

        tblStudents.getColumnModel().getColumn(1).setPreferredWidth(180); 

        tblStudents.getColumnModel().getColumn(2).setPreferredWidth(50); 

        tblStudents.getColumnModel().getColumn(3).setPreferredWidth(60); 

        tblStudents.getColumnModel().getColumn(4).setPreferredWidth(250); 

        tblStudents.getColumnModel().getColumn(5).setPreferredWidth(60); 

        tblStudents.getColumnModel().getColumn(6).setPreferredWidth(100);

        tblStudents.setRowHeight(25);
        
        tblStudents.setFont(new java.awt.Font("Segoe UI", 0, 14));
    }

    private void fillTable(List<Person> displayList) {
        model.setRowCount(0); 
        
        for (Person s : displayList) { 
            String marksDetail = "";
            if (s instanceof IT) {
                IT it = (IT) s;
                marksDetail = String.format("HTML:%.1f | CSS:%.1f | Math:%.1f", it.getHtml(), it.getCss(), it.getMath());
            } else if (s instanceof Biz) {
                Biz biz = (Biz) s;
                marksDetail = String.format("Sale:%.1f | Mkt:%.1f", biz.getSale(), biz.getMarketing());
            } else if (s instanceof GD) {
                GD gd = (GD) s;
                marksDetail = String.format("Color:%.1f | Pts:%.1f | AI:%.1f", gd.getColor(), gd.getPts(), gd.getAi());
            }
            
            Object[] row = {
                s.getId(), s.getName(), s.getAge(), s.getMajor(),
                marksDetail,
                String.format("%.2f", s.calculateAverageMark()),
                s.getRank()
            };
            model.addRow(row);
        }
    }

    private void clearForm() {
        txtId.setText(""); txtName.setText(""); txtAge.setText("");
        txtMark1.setText(""); txtMark2.setText(""); txtMark3.setText("");
        txtId.setEditable(true); 
        txtId.setBackground(java.awt.Color.WHITE);
        cboMajor.setSelectedIndex(0);
        txtId.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        cboMajor = new javax.swing.JComboBox<>();
        lblId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        cboFilter = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();
        label1 = new java.awt.Label();
        lblMark1 = new javax.swing.JLabel();
        lblMark2 = new javax.swing.JLabel();
        lblMark3 = new javax.swing.JLabel();
        txtMark1 = new javax.swing.JTextField();
        txtMark2 = new javax.swing.JTextField();
        txtMark3 = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        cboSearchType = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cboMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "Biz", "GD" }));
        cboMajor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMajorActionPerformed(evt);
            }
        });

        lblId.setText("Student ID: ");

        lblName.setText("Full Name: ");

        lblAge.setText("Age: ");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSort.setText("SORT ( Insertion )");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRefresh.setText("REFRESH");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblStudents);

        cboFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "IT", "BIZ", "GD" }));

        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2)
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnSort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(cboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnSort)
                    .addComponent(btnUpdate)
                    .addComponent(btnRefresh)
                    .addComponent(cboFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        label1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        label1.setName(""); // NOI18N
        label1.setText("STUDENT MANAGEMENT SYSTEM");

        lblMark1.setText("HTML");

        lblMark2.setText("CSS");

        lblMark3.setText("MATH");

        jLabel1.setText("Major");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cboSearchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "ID" }));

        jLabel2.setText("Search Student ( Name,ID)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAge)
                            .addComponent(lblName)
                            .addComponent(lblId)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblMark1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMark1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblMark2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMark2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblMark3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMark3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(118, 118, 118))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lblAge))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMark1)
                            .addComponent(txtMark1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMark2)
                            .addComponent(txtMark2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMark3)
                            .addComponent(txtMark3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboMajorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMajorActionPerformed
        String major = cboMajor.getSelectedItem().toString();
        txtMark1.setText(""); txtMark2.setText(""); txtMark3.setText("");
        txtMark1.setEnabled(true); txtMark2.setEnabled(true); txtMark3.setEnabled(true);
        txtMark3.setBackground(java.awt.Color.WHITE);

        if (major.equals("IT")) {
            lblMark1.setText("HTML"); lblMark2.setText("CSS"); lblMark3.setText("MATH");
        } else if (major.equals("Biz")) {
            lblMark1.setText("Sale"); lblMark2.setText("Market");
            lblMark3.setText("---");
            txtMark3.setText("0");
            txtMark3.setEnabled(false);
            txtMark3.setBackground(new java.awt.Color(230, 230, 230));
        } else if (major.equals("GD")) {
            lblMark1.setText("Color"); lblMark2.setText("PTS"); lblMark3.setText("AI");
        }
    }//GEN-LAST:event_cboMajorActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
    String idDel = "";
    int selectedRow = tblStudents.getSelectedRow();
    
    if (selectedRow >= 0) {
        idDel = (String) model.getValueAt(selectedRow, 0); 
    } else {
        idDel = txtId.getText().trim().toUpperCase(); 
    }

    if (idDel.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a student to delete!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Delete Student " + idDel + "?", "Confirm", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        final String finalId = idDel;
        boolean removed = list.removeIf(p -> p.getId().equals(finalId));
        
        if (removed) {
            fillTable(list);
            clearForm();
            JOptionPane.showMessageDialog(this, "Successfully Deleted!");
        } else {
            JOptionPane.showMessageDialog(this, "Student ID not found!");
        }
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
        if (txtId.getText().trim().isEmpty() || txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Student ID and Name!");
            return;
        }
        
        String id = txtId.getText().trim().toUpperCase();
        for (Person p : list) {
            if (p.getId().equals(id)) {
                JOptionPane.showMessageDialog(this, "Student ID already exists!");
                return;
            }
        }

        String name = txtName.getText().trim();
        int age = 0;
        try {
            age = Integer.parseInt(txtAge.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a number!");
            return;
        }
        
        String major = cboMajor.getSelectedItem().toString();
        //Get Mark
        double m1 = txtMark1.getText().isEmpty() ? 0 : Double.parseDouble(txtMark1.getText().trim());
        double m2 = txtMark2.getText().isEmpty() ? 0 : Double.parseDouble(txtMark2.getText().trim());
        double m3 = txtMark3.getText().isEmpty() ? 0 : Double.parseDouble(txtMark3.getText().trim());

        // Validate Mark(0-10)
        if (m1 < 0 || m1 > 10 || m2 < 0 || m2 > 10 || m3 < 0 || m3 > 10) {
            JOptionPane.showMessageDialog(this, "Marks must be between 0 and 10!");
            return;
        }
        
        Person p = null;
        if (major.equals("IT")) {
            p = new IT(id, name, age, "IT", m1, m2, m3);
        } else if (major.equals("Biz")) {
            p = new Biz(id, name, age, "Biz", m1, m2);
        } else if (major.equals("GD")) {
            p = new GD(id, name, age, "GD", m1, m2, m3);
        }

        // Save and Refresh
        list.add(p);
        fillTable(list);
        clearForm(); 
        
        JOptionPane.showMessageDialog(this, "Successfully Added!");

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error: Marks must be valid numbers!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
       
    ManagementStudent.sortStudentsByMarksInsertion();
    
  
    fillTable(list);
    
    JOptionPane.showMessageDialog(this, "Successfully Sorted by Marks (Descending)!");
    }//GEN-LAST:event_btnSortActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        txtSearch.setText(""); 
    fillTable(list);      
    clearForm();        
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String idToUpdate = txtId.getText().trim();
    
    if (idToUpdate.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a student from table to update!");
        return;
    }

    try {
        boolean found = false;
        for (Person p : list) {
            if (p.getId().equalsIgnoreCase(idToUpdate)) {
                found = true;
  
                p.setName(txtName.getText().trim());
                p.setAge(Integer.parseInt(txtAge.getText().trim()));
                
                double m1 = Double.parseDouble(txtMark1.getText().trim());
                double m2 = Double.parseDouble(txtMark2.getText().trim());
                double m3 = 0;
  
                if (txtMark3.isEnabled() && !txtMark3.getText().isEmpty()) {
                    m3 = Double.parseDouble(txtMark3.getText().trim());
                }

                // Validate
                if (m1 < 0 || m1 > 10 || m2 < 0 || m2 > 10 || (txtMark3.isEnabled() && (m3 < 0 || m3 > 10))) {
                     JOptionPane.showMessageDialog(this, "Marks must be between 0 and 10!");
                     return;
                }

                if (p instanceof IT) { 
                    ((IT)p).setHtml(m1); ((IT)p).setCss(m2); ((IT)p).setMath(m3); 
                } else if (p instanceof Biz) { 
                    ((Biz)p).setSale(m1); ((Biz)p).setMarketing(m2); 
                } else if (p instanceof GD) { 
                    ((GD)p).setColor(m1); ((GD)p).setPts(m2); ((GD)p).setAi(m3); 
                }

                // Save
               
                fillTable(list);
                clearForm();
                JOptionPane.showMessageDialog(this, "Successfully Updated!");
                break;
            }
        }
        
        if (!found) {
            JOptionPane.showMessageDialog(this, "Student ID not found in list!");
        }
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error: Age and Marks must be numbers!");
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        int selectedRow = tblStudents.getSelectedRow();
    if (selectedRow >= 0) {

        String id = model.getValueAt(selectedRow, 0).toString();
        
        for (Person p : list) {
            if (p.getId().equals(id)) {

                txtId.setText(p.getId());
                txtName.setText(p.getName());
                txtAge.setText(String.valueOf(p.getAge()));
                cboMajor.setSelectedItem(p.getMajor()); 
                
                
                if (p instanceof IT) {
                    IT s = (IT) p;
                    txtMark1.setText(String.valueOf(s.getHtml()));
                    txtMark2.setText(String.valueOf(s.getCss()));
                    txtMark3.setText(String.valueOf(s.getMath()));
                } else if (p instanceof Biz) {
                    Biz s = (Biz) p;
                    txtMark1.setText(String.valueOf(s.getSale()));
                    txtMark2.setText(String.valueOf(s.getMarketing()));
                    txtMark3.setText("0"); // Biz không có môn 3
                } else if (p instanceof GD) {
                    GD s = (GD) p;
                    txtMark1.setText(String.valueOf(s.getColor()));
                    txtMark2.setText(String.valueOf(s.getPts()));
                    txtMark3.setText(String.valueOf(s.getAi()));
                }
                
                txtId.setEditable(false);
                txtId.setBackground(new Color(230, 230, 230)); 
                break;
            }
        }
    }
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
 
    String selectedMajor = cboFilter.getSelectedItem().toString();
    
    model.setRowCount(0);
    

    for (Person s : list) {

        if (selectedMajor.equals("All") || s.getMajor().equals(selectedMajor)) {
            
            String marksDetail = "";
            if (s instanceof IT) {
                IT it = (IT) s;
                marksDetail = String.format("HTML:%.1f | CSS:%.1f | Math:%.1f", it.getHtml(), it.getCss(), it.getMath());
            } else if (s instanceof Biz) {
                Biz biz = (Biz) s;
                marksDetail = String.format("Sale:%.1f | Mkt:%.1f", biz.getSale(), biz.getMarketing());
            } else if (s instanceof GD) {
                GD gd = (GD) s;
                marksDetail = String.format("Color:%.1f | Pts:%.1f | AI:%.1f", gd.getColor(), gd.getPts(), gd.getAi());
            }
            
            Object[] row = {
                s.getId(), s.getName(), s.getAge(), s.getMajor(),
                marksDetail,
                String.format("%.2f", s.calculateAverageMark()),
                s.getRank()
            };
            model.addRow(row);
            // -----------------------------------------------
        }
    }
    
    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No students found for major: " + selectedMajor);
    }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // 1. Remove
        String keyword = txtSearch.getText().trim().toLowerCase();
        
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a keyword to search!");
            return;
        }

        String searchType = cboSearchType.getSelectedItem().toString();
        List<Person> searchResult = new ArrayList<>();
        
        // 2. Search
        for (Person p : list) {
            if (searchType.equals("ID")) { 
                if (p.getId().toLowerCase().contains(keyword)) {
                    searchResult.add(p);
                }
            } else if (searchType.equals("Name")) { // Sửa "By Name" thành "Name"
                if (p.getName().toLowerCase().contains(keyword)) {
                    searchResult.add(p);
                }
            }
        }
        
       
        if (searchResult.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No student found!");
            fillTable(list); // Reset lại bảng gốc
        } else {
            fillTable(searchResult); 
            JOptionPane.showMessageDialog(this, "Found " + searchResult.size() + " student(s)!");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSort;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboFilter;
    private javax.swing.JComboBox<String> cboMajor;
    private javax.swing.JComboBox<String> cboSearchType;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMark1;
    private javax.swing.JLabel lblMark2;
    private javax.swing.JLabel lblMark3;
    private javax.swing.JLabel lblName;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMark1;
    private javax.swing.JTextField txtMark2;
    private javax.swing.JTextField txtMark3;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
