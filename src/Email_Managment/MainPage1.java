package Email_Managment;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MainPage1 extends javax.swing.JFrame {

    /**
     * Creates new form MainPage
     */
    public MainPage1() {
        initComponents();
        tabpanel.setSelectedIndex(1);
        from.setText(LoginPage.n);
        recover.setVisible(false);
        buttons.setText("Inbox - Gmail");
        mailAccount.setText(user);
        Table.setBackground(Color.WHITE);
        tableShow();
        setExtendedState(MAXIMIZED_BOTH);

    }

    public String user = LoginPage.n;
    public static int id = 1;
    public String isStarred;

    public void tableShow() {
        Table.setShowGrid(true);
        try {
            Connection con = (Connection) connection.dbconnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from data order by id desc ");
            DefaultTableModel dm;
            dm = (DefaultTableModel) Table.getModel();

            int te = 0;
            String header[] = new String[]{"From"};
            dm.setColumnIdentifiers(header);
            dm.setRowCount(0);
            while (rs.next()) {
                Vector data = new Vector();
                String ss = rs.getString("toward");
                String isTrash = rs.getString("Trash");
                if (ss.equals(user) && isTrash.equals("n")) {
                    // data.add(rs.getString("Frm"));
                    String temp1 = (rs.getString("Frm"));
                    String temp2 = (rs.getString("Subject"));
                    String msg = "<b>" + temp1 + "</b>\n" + temp2;
                    msg = msg.replaceAll("\n", "<br>");
                    data.add("<html>" + msg + "</html>");
                    data.add(rs.getString("Subject"));
                    dm.addRow(data);
                    te++;
                }

            }
            Vector data = new Vector();
            data.add("");
            while (te != 10) {
                dm.addRow(data);
                te++;
            }
            /**
             * @param args the command line arguments
             */
        } catch (Exception ex) {
            Logger.getLogger(MainPage1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void starredButton() {
        Table.setShowGrid(true);
        try {
            Connection con = (Connection) connection.dbconnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from data order by id desc ");
            DefaultTableModel dm;
            dm = (DefaultTableModel) Table.getModel();
            str.setVisible(true);
            int te = 0;
            String header[] = new String[]{"From"};
            dm.setColumnIdentifiers(header);
            dm.setRowCount(0);
            while (rs.next()) {
                Vector data = new Vector();
                String ss = rs.getString("toward");
                String starred = rs.getString("Star");
                String Trash = rs.getString("Trash_Sent");
                System.out.println(starred);
                if (ss.equals(user) && starred.equals("y") && Trash.equals("n")) {
                    // data.add(rs.getString("Frm"));
                    String temp1 = (rs.getString("Frm"));
                    String temp2 = (rs.getString("Subject"));
                    String msg = "<b>" + temp1 + "</b>\n" + temp2;
                    msg = msg.replaceAll("\n", "<br>");
                    data.add("<html>" + msg + "</html>");
                    data.add(rs.getString("Subject"));
                    dm.addRow(data);
                    te++;
                }

            }
            Vector data = new Vector();
            data.add("");
            while (te != 10) {
                dm.addRow(data);
                te++;
            }
            /**
             * @param args the command line arguments
             */
        } catch (Exception ex) {
            Logger.getLogger(MainPage1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void trashShow() {
        trash.setFont(new Font("calibri Light", Font.BOLD, 24));
        Table.setShowGrid(true);
        try {
            Connection con = (Connection) connection.dbconnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from data order by id desc ");
            DefaultTableModel dm;
            dm = (DefaultTableModel) Table.getModel();

            int te = 0;
            String header[] = new String[]{"From"};
            dm.setColumnIdentifiers(header);
            dm.setRowCount(0);
            while (rs.next()) {
                Vector data = new Vector();
                String ss = rs.getString("toward");
                String isTrash = rs.getString("Trash");
                if (ss.equals(user) && isTrash.equals("y") && rs.getString("Trash_Sent").equals("n")) {
                    // data.add(rs.getString("Frm"));
                    String temp1 = (rs.getString("Frm"));
                    String temp2 = (rs.getString("Subject"));
                    String msg = "<b>" + temp1 + "</b>\n" + temp2;
                    msg = msg.replaceAll("\n", "<br>");
                    data.add("<html>" + msg + "</html>");
                    data.add(rs.getString("Subject"));
                    dm.addRow(data);
                    te++;
                }

            }

            Vector data = new Vector();
            data.add("");
            while (te != 10) {
                dm.addRow(data);
                te++;
            }
            /**
             * @param args the command line arguments
             */
        } catch (Exception ex) {
            Logger.getLogger(MainPage1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTable2 = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        buttons = new javax.swing.JLabel();
        compose = new javax.swing.JButton();
        inbox = new javax.swing.JButton();
        sentmail = new javax.swing.JButton();
        account = new javax.swing.JButton();
        back = new javax.swing.JButton();
        starred = new javax.swing.JButton();
        trash = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        mailAccount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabpanel = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        delete = new javax.swing.JButton();
        str = new javax.swing.JButton();
        recover = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        subject = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        fr = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        send1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        tooooo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        from = new javax.swing.JLabel();
        subjectttttttt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        body = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 970));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttons.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        buttons.setForeground(new java.awt.Color(204, 204, 204));
        buttons.setText("Gmail");
        jPanel2.add(buttons, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        compose.setBackground(new java.awt.Color(255, 255, 255));
        compose.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        compose.setForeground(new java.awt.Color(255, 255, 255));
        compose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intershipproject/icons8-plus-25.png"))); // NOI18N
        compose.setText("   New mail");
        compose.setActionCommand("New mail");
        compose.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 91, 168)));
        compose.setBorderPainted(false);
        compose.setContentAreaFilled(false);
        compose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                composeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                composeMouseExited(evt);
            }
        });
        compose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                composeActionPerformed(evt);
            }
        });
        jPanel2.add(compose, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, 79, 480, 50));

        inbox.setBackground(new java.awt.Color(255, 255, 255));
        inbox.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        inbox.setForeground(new java.awt.Color(255, 255, 255));
        inbox.setText("Inbox");
        inbox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 91, 168), 1, true));
        inbox.setBorderPainted(false);
        inbox.setContentAreaFilled(false);
        inbox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        inbox.setPreferredSize(new java.awt.Dimension(159, 39));
        inbox.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                inboxMouseDragged(evt);
            }
        });
        inbox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inboxFocusGained(evt);
            }
        });
        inbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inboxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inboxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inboxMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inboxMousePressed(evt);
            }
        });
        inbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inboxActionPerformed(evt);
            }
        });
        jPanel2.add(inbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 310, 510, -1));

        sentmail.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        sentmail.setForeground(new java.awt.Color(255, 255, 255));
        sentmail.setText("Sent mail");
        sentmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 91, 168), 1, true));
        sentmail.setBorderPainted(false);
        sentmail.setContentAreaFilled(false);
        sentmail.setPreferredSize(new java.awt.Dimension(159, 39));
        sentmail.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                sentmailMouseDragged(evt);
            }
        });
        sentmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sentmailFocusGained(evt);
            }
        });
        sentmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sentmailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sentmailMouseExited(evt);
            }
        });
        sentmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sentmailActionPerformed(evt);
            }
        });
        jPanel2.add(sentmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 360, 490, -1));

        account.setFont(new java.awt.Font("Calibri", 1, 28)); // NOI18N
        account.setForeground(new java.awt.Color(255, 255, 255));
        account.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intershipproject/icons8-user-32 (1).png"))); // NOI18N
        account.setText("   Account");
        account.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 91, 168)));
        account.setBorderPainted(false);
        account.setContentAreaFilled(false);
        account.setPreferredSize(new java.awt.Dimension(159, 39));
        account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountMouseExited(evt);
            }
        });
        account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountActionPerformed(evt);
            }
        });
        jPanel2.add(account, new org.netbeans.lib.awtextra.AbsoluteConstraints(-160, 160, 520, 50));

        back.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 91, 168)));
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 510, 480, 40));

        starred.setBackground(new java.awt.Color(255, 255, 255));
        starred.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        starred.setForeground(new java.awt.Color(255, 255, 255));
        starred.setText("Starred");
        starred.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 91, 168), 1, true));
        starred.setBorderPainted(false);
        starred.setContentAreaFilled(false);
        starred.setPreferredSize(new java.awt.Dimension(159, 39));
        starred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                starredMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                starredMouseExited(evt);
            }
        });
        starred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                starredActionPerformed(evt);
            }
        });
        jPanel2.add(starred, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 410, 470, -1));

        trash.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        trash.setForeground(new java.awt.Color(255, 255, 255));
        trash.setText("Trash");
        trash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 91, 168)));
        trash.setBorderPainted(false);
        trash.setContentAreaFilled(false);
        trash.setPreferredSize(new java.awt.Dimension(159, 39));
        trash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                trashMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                trashMouseExited(evt);
            }
        });
        trash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trashActionPerformed(evt);
            }
        });
        jPanel2.add(trash, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 460, 450, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mail");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        mailAccount.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        mailAccount.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(mailAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 240, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intershipproject/Presentation61 (3).png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 1513));

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 1484, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(2360, 0, -1, 1500));
        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 140, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        delete.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intershipproject/delete.png"))); // NOI18N
        delete.setText(" Delete");
        delete.setContentAreaFilled(false);
        delete.setFocusTraversalPolicyProvider(true);
        delete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        delete.setVerifyInputWhenFocusTarget(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel3.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, -1, 60));

        str.setBackground(new java.awt.Color(204, 204, 204));
        str.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intershipproject/star_black.png"))); // NOI18N
        str.setText(" Star");
        str.setContentAreaFilled(false);
        str.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                strMouseClicked(evt);
            }
        });
        str.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strActionPerformed(evt);
            }
        });
        jPanel3.add(str, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 110, 60));

        recover.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        recover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intershipproject/recover_logo.png"))); // NOI18N
        recover.setText(" Recover");
        recover.setContentAreaFilled(false);
        recover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recoverActionPerformed(evt);
            }
        });
        jPanel3.add(recover, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, -1, 60));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1103, 62));

        jLabel10.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Subject :");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 77, -1, -1));

        subject.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jPanel5.add(subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 77, 941, 30));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setPreferredSize(new java.awt.Dimension(1250, 65));

        jLabel11.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("From :");

        fr.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        fr.setPreferredSize(new java.awt.Dimension(0, 30));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(15, 15, 15))
        );

        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 130, 1450, -1));

        jLabel7.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("To :");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 40, -1));

        to.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        to.setForeground(new java.awt.Color(102, 102, 102));
        jPanel5.add(to, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 1018, 31));

        message.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        message.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        message.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        message.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel5.add(message, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1054, 670));

        tabpanel.addTab("inbox", jPanel5);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intershipproject/rocky-mountains-canada-mountains-forest-green-trees.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabpanel.addTab("bg", jPanel7);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 25)); // NOI18N
        jLabel9.setText("New Message");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, 40));

        send1.setBackground(new java.awt.Color(153, 153, 153));
        send1.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        send1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intershipproject/send.png"))); // NOI18N
        send1.setText(" Send");
        send1.setBorder(null);
        send1.setContentAreaFilled(false);
        send1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                send1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                send1MouseExited(evt);
            }
        });
        send1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send1ActionPerformed(evt);
            }
        });
        jPanel10.add(send1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, 90, 40));

        jPanel6.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1186, 80));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        tooooo.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        tooooo.setBorder(null);
        tooooo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toooooActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("To :");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(tooooo, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tooooo, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel6.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 140, 1250, 60));

        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("From : ");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        from.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        from.setForeground(new java.awt.Color(153, 153, 153));
        jPanel6.add(from, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 950, 30));

        subjectttttttt.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        subjectttttttt.setBorder(null);
        subjectttttttt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjecttttttttActionPerformed(evt);
            }
        });
        jPanel6.add(subjectttttttt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 930, 40));

        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Subject :");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, 20));

        body.setColumns(20);
        body.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        body.setLineWrap(true);
        body.setRows(5);
        body.setBorder(null);
        body.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        body.setHighlighter(null);
        body.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(body);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1060, 680));

        tabpanel.addTab("compose", jPanel6);

        jPanel1.add(tabpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, -30, 1060, 1000));

        Table.setAutoCreateRowSorter(true);
        Table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Table.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        Table.setGridColor(new java.awt.Color(0, 0, 0));
        Table.setName("dvfvdf"); // NOI18N
        Table.setRowHeight(100);
        Table.setRowMargin(0);
        Table.setSelectionBackground(new java.awt.Color(209, 229, 245));
        Table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TableMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(Table);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, -30, 530, 1280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_TableMouseEntered

    }// GEN-LAST:event_TableMouseEntered

    private void starredActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_starredActionPerformed
        // TODO add your handling code here:
        buttons.setText("Starred - Gmail");
        recover.setVisible(false);
        tabpanel.setSelectedIndex(1);
        delete.setVisible(false);
        starredButton();
    }// GEN-LAST:event_starredActionPerformed

    private void trashActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_trashActionPerformed
        // TODO add your handling code here:
        recover.setVisible(true);
        tabpanel.setSelectedIndex(1);
        buttons.setText("Trash - Gmail");
        str.setVisible(true);
        delete.setVisible(true);
        trashShow();
    }

    private void backMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
        back.setContentAreaFilled(false);
        back.setBorderPainted(true);

        back.setFont(new Font("calibri Light", Font.BOLD, 24));
    }// GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_backMouseExited
        // TODO add your handling code here:
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);

        back.setFont(new Font("calibri Light", Font.PLAIN, 24));
    }// GEN-LAST:event_backMouseExited

    private void starredMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_starredMouseEntered
        // TODO add your handling code here:
        starred.setContentAreaFilled(false);
        starred.setBorderPainted(true);

        starred.setFont(new Font("calibri Light", Font.BOLD, 24));
        // starred.setBackground(new Color(17,80,129,255));
    }// GEN-LAST:event_starredMouseEntered

    private void starredMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_starredMouseExited
        // TODO add your handling code here:
        starred.setContentAreaFilled(false);
        starred.setBorderPainted(false);
        starred.setFont(new Font("calibri Light", Font.PLAIN, 24));
    }// GEN-LAST:event_starredMouseExited

    private void trashMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_trashMouseEntered
        // TODO add your handling code here:
        // Font myFont1 = new Font("Serif", Font.BOLD, 12);
        // jLabel1.setFont(myFont1); new Font("Serif", Font.BOLD, 12)
        trash.setFont(new Font("calibri Light", Font.BOLD, 24));
        trash.setContentAreaFilled(false);
        trash.setBorderPainted(true);
    }// GEN-LAST:event_trashMouseEntered

    private void trashMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_trashMouseExited
        trash.setFont(new Font("calibri Light", Font.PLAIN, 24));
        trash.setContentAreaFilled(false);
        trash.setBorderPainted(false);
    }// GEN-LAST:event_trashMouseExited

    private void composeMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_composeMouseEntered
        // TODO add your handling code here:
        compose.setContentAreaFilled(false);
        compose.setBorderPainted(true);
    }// GEN-LAST:event_composeMouseEntered

    private void composeMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_composeMouseExited
        // TODO add your handling code here:
        compose.setContentAreaFilled(false);
        compose.setBorderPainted(false);

    }// GEN-LAST:event_composeMouseExited

    private void accountMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_accountMouseEntered
        // TODO add your handling code here:
        account.setContentAreaFilled(false);
        account.setBorderPainted(true);
    }// GEN-LAST:event_accountMouseEntered

    private void accountMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_accountMouseExited
        account.setContentAreaFilled(false);
        account.setBorderPainted(false);
    }// GEN-LAST:event_accountMouseExited

    private void inboxMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_inboxMouseClicked
        // TODO add your handling code here:
        inbox.setFont(new Font("calibri Light", Font.BOLD, 24));
    }// GEN-LAST:event_inboxMouseClicked

    private void inboxMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_inboxMousePressed
        // TODO add your handling code here:
    }// GEN-LAST:event_inboxMousePressed

    private void accountActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_accountActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_accountActionPerformed

    private void toooooActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_toooooActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_toooooActionPerformed

    private void send1MouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_send1MouseEntered
        // TODO add your handling code here:
        send1.setBorderPainted(false);
        send1.setContentAreaFilled(true);
        send1.setBackground(new Color(182, 182, 182));
    }// GEN-LAST:event_send1MouseEntered

    private void send1MouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_send1MouseExited
        // TODO add your handling code here:
        send1.setBorderPainted(false);
        send1.setContentAreaFilled(false);
    }// GEN-LAST:event_send1MouseExited

    private void strActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_strActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Connection con1;
            con1 = (Connection) connection.dbconnection();
            Statement st1 = con1.createStatement();
            int a = 1;
            String te = LoginPage.n;
            String mes = message.getText();
            String t = to.getText();
            String sss = subject.getText();
            if (isStarred.equals("y")) {
                String starred = "n";
                a = st1.executeUpdate("update data set Star = '" + starred + "' where Id='" + id + "' ");
                str.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intershipproject/star_black.png")));
                if (buttons.getText().equals("Starred - Gmail")) {
                    tabpanel.setSelectedIndex(1);
                    starredButton();
                }
            } else {
                String starred = "y";
                a = st1.executeUpdate("update data set Star = '" + starred + "' where Id='" + id + "' ");
                str.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intershipproject/star_colored.png")));

            }
            if (a == 1) {
                JOptionPane.showMessageDialog(rootPane, "Starred Sucessfully");
                if (buttons.getText().equals("Starred - Gmail")) {
                    starredButton();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Problem Detected in Starred");
            }
        } catch (Exception ex) {
            Logger.getLogger(MainPage1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// GEN-LAST:event_strActionPerformed

    private void strMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_strMouseClicked

        // TODO add your handling code here:
    }// GEN-LAST:event_strMouseClicked

    private void recoverActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_recoverActionPerformed
        // TODO add your handling code here:

        try {

            Connection con1;
            con1 = (Connection) connection.dbconnection();
            Statement st1 = con1.createStatement();
            int a;
            if (buttons.getText().equals("Trash - Gmail")) {

                String starred1 = "n";
                a = st1.executeUpdate("update data set Trash = '" + starred1 + "' where Id='" + id + "' ");

                if (a == 1) {
                    JOptionPane.showMessageDialog(rootPane, "Mail recovered Sucessfully");
                    trashShow();
                    tabpanel.setSelectedIndex(1);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Problem Detected in recovering mail");
                }

            }
        } // GEN-LAST:event_deleteActionPerformed
        catch (Exception ex) {
            Logger.getLogger(MainPage1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// GEN-LAST:event_recoverActionPerformed

    private void composeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_composeActionPerformed
        // TODO add your handling code here:
        buttons.setText("New Mail - Gmail");
        tabpanel.setSelectedIndex(2);
    }// GEN-LAST:event_composeActionPerformed

    private void inboxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_inboxActionPerformed
        // TODO add your handling code here:
        // inbox.setFont(new Font("calibri Light", Font.BOLD, 24));
        buttons.setText("Inbox - Gmail");
        delete.setVisible(true);
        tabpanel.setSelectedIndex(1);
        recover.setVisible(false);
        str.setVisible(true);
        tableShow();

    }// GEN-LAST:event_inboxActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        tabpanel.setSelectedIndex(0);
        try {
            int row = Table.getSelectedRow();
            String from = (String) Table.getValueAt(row, 0);
            String sub;

            int itr2 = from.indexOf("<br>");
            sub = from.substring(itr2 + 4, from.length() - 7);

            int itr1 = from.indexOf("</b>");
            from = from.substring(9, itr1);

            Connection con = (Connection) connection.dbconnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from data ");
            subject.setText(sub);
            fr.setText(from);
            to.setText(user);

            DefaultTableModel dm;
            dm = (DefaultTableModel) Table.getModel();

            String col_name = dm.getColumnName(0);

            if (col_name.equals("From")) {
                while (rs.next()) {
                    Vector data = new Vector();
                    String from1 = rs.getString("Frm");
                    String sub1 = rs.getString("Subject");
                    String to1 = rs.getString("toward");
                    if (from1.equals(from) && sub.equals(sub1) && to1.equals(user)) {
                        String msg = rs.getString("Message");

                        id = rs.getInt("Id");
                        msg = msg.replaceAll("\n", "<br>");
                        message.setText("<html>" + msg + "</html>");
                        System.out.println(rs.getString("Message"));
                        isStarred = rs.getString("Star");

                        if (isStarred.equals("y")) {
                            str.setIcon(new javax.swing.ImageIcon(
                                    getClass().getResource("/intershipproject/star_colored.png")));
                        } else {
                            str.setIcon(new javax.swing.ImageIcon(
                                    getClass().getResource("/intershipproject/star_black.png")));
                        }
                    }

                }
            } else {
                fr.setText(user);
                to.setText(from);
                while (rs.next()) {
                    Vector data = new Vector();
                    String from1 = rs.getString("toward");
                    String sub1 = rs.getString("Subject");
                    String to1 = rs.getString("Frm");
                    if (from1.equals(from) && sub.equals(sub1) && to1.equals(user)) {
                        String msg = rs.getString("Message");
                        msg = msg.replaceAll("\n", "<br>");
                        message.setText("<html>" + msg + "</html>");

                    }
                }
            }

            /**
             * @param args the command line arguments
             */
        } catch (StringIndexOutOfBoundsException ex) {
            tabpanel.setSelectedIndex(1);
        } catch (Exception ex) {
            Logger.getLogger(MainPage1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }// GEN-LAST:event_TableMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        LoginPage LP = new LoginPage();
        LP.show();
    }// GEN-LAST:event_backActionPerformed

    private void inboxMouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_inboxMouseDragged
        // TODO add your handling code here:
    }// GEN-LAST:event_inboxMouseDragged

    private void inboxFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_inboxFocusGained
        // TODO add your handling code here:
        inbox.setFont(new Font("calibri Light", Font.BOLD, 24));

    }// GEN-LAST:event_inboxFocusGained

    private void inboxMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_inboxMouseEntered
        // TODO add your handling code here:
        inbox.setContentAreaFilled(false);
        inbox.setBorderPainted(true);

        inbox.setFont(new Font("calibri Light", Font.BOLD, 24));
    }// GEN-LAST:event_inboxMouseEntered

    private void inboxMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_inboxMouseExited
        // TODO add your handling code here:
        inbox.setContentAreaFilled(false);
        inbox.setBorderPainted(false);

        inbox.setFont(new Font("calibri Light", Font.PLAIN, 24));
    }// GEN-LAST:event_inboxMouseExited

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // GEN-FIRST:event_deleteActionPerformed
            // TODO add your handling code here:
            // TODO add your handling code here:
            Connection con1;
            con1 = (Connection) connection.dbconnection();
            Statement st1 = con1.createStatement();
            int a;
            if (buttons.getText().equals("Inbox - Gmail")) {
                try {
                    String starred1 = "y";
                    a = st1.executeUpdate("update data set Trash = '" + starred1 + "' where Id='" + id + "' ");
                    if (a == 1) {
                        JOptionPane.showMessageDialog(rootPane, "Mail added to Trash");
                        tableShow();
                        tabpanel.setSelectedIndex(1);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Problem Detected in Trash button");
                    }
                } catch (Exception ex) {
                    // Logger.getLogger(MainPage1.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("12");
                }
            } else if (buttons.getText().equals("Trash - Gmail")) {
                try {
                    a = st1.executeUpdate("update data set Trash_Sent = '" + "y" + "' where Id='" + id + "' ");

                    if (a == 1) {
                        JOptionPane.showMessageDialog(rootPane, "Mail deleted");
                        tabpanel.setSelectedIndex(1);
                        trashShow();

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Problem Detected in deleting mail");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(MainPage1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } // GEN-LAST:event_deleteActionPerformed
        catch (Exception ex) {
            Logger.getLogger(MainPage1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sentmailMouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sentmailMouseDragged
        // TODO add your handling code here:
    }// GEN-LAST:event_sentmailMouseDragged

    private void sentmailFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_sentmailFocusGained
        // TODO add your handling code here:
    }// GEN-LAST:event_sentmailFocusGained

    private void sentmailMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sentmailMouseEntered
        // TODO add your handling code here:
        sentmail.setContentAreaFilled(false);
        sentmail.setBorderPainted(true);

        sentmail.setFont(new Font("calibri Light", Font.BOLD, 24));
    }// GEN-LAST:event_sentmailMouseEntered

    private void sentmailMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_sentmailMouseExited
        // TODO add your handling code here:
        sentmail.setContentAreaFilled(false);
        sentmail.setBorderPainted(false);
        sentmail.setFont(new Font("calibri Light", Font.PLAIN, 24));
    }// GEN-LAST:event_sentmailMouseExited

    private void sentmailActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_sentmailActionPerformed
        try {
            // TODO add your handling code here:
            recover.setVisible(false);
            delete.setVisible(false);
            buttons.setText("Sent Mail - Gmail");
            str.setVisible(false);
            Table.setShowGrid(true);
            tabpanel.setSelectedIndex(1);
            Connection con = (Connection) connection.dbconnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from data order by id desc ");
            DefaultTableModel dm;
            dm = (DefaultTableModel) Table.getModel();
            String header[] = new String[]{"To"};
            dm.setColumnIdentifiers(header);
            int te = 0;
            dm.setRowCount(0);
            while (rs.next()) {
                Vector data = new Vector();
                String ss = rs.getString("Frm");
                if (ss.equals(user)) {

                    String temp1 = (rs.getString("toward"));
                    String temp2 = (rs.getString("Subject"));
                    String msg = "<b>" + temp1 + "</b>\n" + temp2;
                    msg = msg.replaceAll("\n", "<br>");
                    data.add("<html>" + msg + "</html>");
                    data.add(rs.getString("Subject"));
                    dm.addRow(data);
                    te++;
                }
                // data.add(rs.getString("To"));
                // data.add(rs.getString("Message"));

            }
            Vector data = new Vector();
            data.add("");
            while (te != 10) {
                dm.addRow(data);
                te++;
            }
        } catch (Exception ex) {
            Logger.getLogger(MainPage1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_sentmailActionPerformed

    private void subjecttttttttActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_subjecttttttttActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_subjecttttttttActionPerformed

    private void send1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_send1ActionPerformed

        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Connection con1;
            con1 = (Connection) connection.dbconnection();
            Statement st1 = con1.createStatement();
            int a = 1;
            String te = LoginPage.n;
            String mes = body.getText();
            String t = tooooo.getText();
            String sss = subjectttttttt.getText();

            Connection con = (Connection) connection.dbconnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from credentials where MailId='" + t + "' ");
            if (rs.next()) {
                a = st1.executeUpdate("insert into data (Frm,toward,Subject,Message) values('" + te + "','" + t + "','"
                        + sss + "','" + mes + "')");

                if (a == 1) {
                    JOptionPane.showMessageDialog(rootPane, "Mail sent Sucessfully");
                    tabpanel.setSelectedIndex(1);

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Problem Detected");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error : Enter a valid Mail-Id");

            }

        } catch (Exception ex) {
            Logger.getLogger(MainPage1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_send1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton account;
    private javax.swing.JButton back;
    private javax.swing.JTextArea body;
    private javax.swing.JLabel buttons;
    private javax.swing.JButton compose;
    private javax.swing.JButton delete;
    private javax.swing.JLabel fr;
    private javax.swing.JLabel from;
    private javax.swing.JButton inbox;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel mailAccount;
    private javax.swing.JLabel message;
    private javax.swing.JButton recover;
    private javax.swing.JButton send1;
    private javax.swing.JButton sentmail;
    private javax.swing.JButton starred;
    private javax.swing.JButton str;
    private javax.swing.JLabel subject;
    private javax.swing.JTextField subjectttttttt;
    private javax.swing.JTabbedPane tabpanel;
    private javax.swing.JLabel to;
    private javax.swing.JTextField tooooo;
    private javax.swing.JButton trash;
    // End of variables declaration//GEN-END:variables
}
