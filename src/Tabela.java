
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JTable;


public class Tabela extends javax.swing.JFrame {
    
    int[] m = {31,28,31,30,31,30,31,31,30,31,30,31};
    String [] name_m = {"Styczeń","Luty","Marzec","Kwiecień","Maj","Czerwiec","Lipiec","Sierpień","Wrzesień","Październik","Listopad","Grudzień"};
    int activeMonth = 0;
    int activeYear = 0;
    int activeDay = 0;
    public Tabela() {
        initComponents();
        editTabela();
    }
    
      
     void createTabela(Calendar calendar)
    {
        int day=1;
        String[] d = {"Poniedziałek","Wtorek","Środa","Czwartek","Piątek","Sobota","Niedziela"};
        int j;
        jTable1.setValueAt("<<<", 0, 0);
        jTable1.setValueAt(">>>", 0, 6);
        
        for(int i=0;i<7;i++)
        {
            jTable1.setValueAt(d[i], 1, i);
        }
        activeMonth = calendar.get(Calendar.MONTH)+1;
        activeYear = calendar.get(Calendar.YEAR);
        jTable1.setValueAt(name_m[activeMonth-1], 0, 2);
        jTable1.setValueAt(activeYear, 0, 4);
            for(int i=2;i<=7;i++)
            {
                if(i==2)
                {
                    for(j=getFirstDay(calendar)-1;j<=6;j++)
                    {
                        jTable1.setValueAt(day, i, j);
                        day++;
                    }
                }
                else
                {
                for(j=0;j<=6;j++)
                    {   
                        if(day>getDayOfMonth(calendar))
                         {
                             break;
                         }
                         else
                        {
                           jTable1.setValueAt(day, i, j);
                           day++; 
                        }
                    }
                
                }
            }
    }
    void editTabela()
    {   
        jScrollPane1.setBorder(null);
        jScrollPane1.setColumnHeaderView(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        for(int i=2;i<7;i++)
        {
            jTable1.getColumnModel().getColumn(i).setPreferredWidth(75);
        }
            jTable1.setRowHeight(75);
            jTable1.setRowHeight(0, 20);
            jTable1.setRowHeight(1, 20);
    }
    void clear()
    {
        for (int i = 0; i <=7; i++) 
        {
            for (int j = 0; j <7; j++) 
            {
                jTable1.setValueAt("", i, j);
            } 
        }
    }
    int getDayOfMonth(Calendar calendar)
    {   
        int month = calendar.get(Calendar.MONTH);
        if(calendar.get(Calendar.YEAR)%4==0)
        {
            m[1]=29;
        }
        return m[month];
    }
    Calendar prewMonth()
    {   
        Calendar calendar = Calendar.getInstance();
        if(activeMonth==0)
        {
            calendar.set(Calendar.MONTH, 12);
            calendar.set(Calendar.YEAR, activeYear-1);
        }
        calendar.set(Calendar.YEAR, activeYear);
        
        calendar.set(Calendar.MONTH, activeMonth-2);
        return calendar;
    }
    Calendar nextMonth()
    {   
        Calendar calendar = Calendar.getInstance();
        if(activeMonth==12)
        {
            calendar.set(Calendar.MONTH, 0);
            calendar.set(Calendar.YEAR, activeYear+1);  
        }
        calendar.set(Calendar.MONTH, activeMonth);
        calendar.set(Calendar.YEAR, activeYear);
        return calendar;
    }
  
    int getFirstDay(Calendar calendar)
    {
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK)-1;
        
        while(day!=1)
        {              
            day--; 
            if(day_of_week==0)
            {
                day_of_week=7;
            }
            day_of_week--;
        }
        if(day_of_week==0)
        {
            return 7;
        }
        return day_of_week;
    }
    public JTable getjTable1() {
        return jTable1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Drukuj");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
       /* int row = jTable1.rowAtPoint(evt.getPoint());
        int col = jTable1.columnAtPoint(evt.getPoint());
        //activeDay = Integer.parseInt(jTable1.getValueAt(row, col).toString());
        if (evt.getClickCount() == 2 && row>1 ) 
        {   
            r = new Rezerwacja();
            r.setVisible(true);
        }
        if(jTable1.getValueAt(row, col)=="<<<" )
        {
            clear();
            createTabela(prewMonth());
        }
        else if(jTable1.getValueAt(row, col)==">>>" )
        {
            clear();
            createTabela(nextMonth());
        }
                                    
*/
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Tabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
