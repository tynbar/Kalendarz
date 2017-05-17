
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.omg.CORBA.Environment;


public class Main extends javax.swing.JFrame {
    Rezerwacja r = new Rezerwacja();
     List<Wydarzenie> lista = new ArrayList<Wydarzenie>();
    public Main() throws ParseException, IOException {
        //r.setVisible(false);
        initComponents();
        load();
        Calendar calendar = Calendar.getInstance();
        Tabela t = new Tabela();
        t.setVisible(true);
        t.createTabela(calendar);
        TableClick(t);
 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(false);
                } catch (ParseException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    void TableClick(Tabela t)
    {
        t.getjTable1().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e) 
            {   
                int row = t.getjTable1().rowAtPoint(e.getPoint());
                int col = t.getjTable1().columnAtPoint(e.getPoint());
                if (e.getClickCount() == 2 && row>1 ) 
                {   
                    
                    t.activeDay = Integer.parseInt(t.jTable1.getValueAt(row, col).toString());
                    r = new Rezerwacja();
                    r.setVisible(true);
                    delete(r);
                    r.getLbData().setText(t.activeDay+" "+t.name_m[t.activeMonth-1]);
                    showEvent(t,r);
                    r.getjButton1().addMouseListener(new MouseAdapter()
                    {
                        @Override
                         public void mousePressed(MouseEvent e) 
                         {   
                            try {
                                checkEvent(r,t);
                                addEvent(t, r);
                                save();
                                r.dispose();
                            } catch (ParseException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                         }
                    });
                }
                if(t.getjTable1().getValueAt(row, col)=="<<<" )
                {
                    t.clear();
                    t.createTabela(t.prewMonth());
                }
                else if(t.getjTable1().getValueAt(row, col)==">>>" )
                {
                    t.clear();
                    t.createTabela(t.nextMonth());
                }
                
            }
        });
       
    }
    boolean checkEvent(Rezerwacja r, Tabela t)
    {  
        for (Wydarzenie lista1 : lista)
        {
            
        }
        return false;
    }
    
    void save() throws IOException
    {   
        File file = new File(System.getenv("APPDATA")+"\\Kalendarz");
        if(!file.exists())
        {
            file.mkdir();
        }
        FileOutputStream f = null;
        ObjectOutputStream output = null;
        try 
        {
            f = new FileOutputStream(System.getenv("APPDATA")+"\\Kalendarz\\dane.ser");
            output = new ObjectOutputStream(f);
            output.writeObject(lista);
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally
        {
            output.close();
            f.close();
        }
	
    }
    void delete(Rezerwacja r)
    {
        r.getjTable3().addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e) 
            {
              
               
               r.getjButton2().addMouseListener(new MouseAdapter()
               {
                    @Override
                    public void mousePressed(MouseEvent e) 
                    {
                        String nazwa = r.getjTable3().getValueAt(r.getjTable3().getSelectedRow(), 3).toString();
                        System.out.println(r.getjTable3().getSelectedRow());
                        ((DefaultTableModel)r.getjTable3().getModel()).removeRow(r.getjTable3().getSelectedRow());
                        
                       for (Wydarzenie lista1 : lista)
                        {   
                           if(nazwa==lista1.name) 
                           {
                               lista.remove(lista1);
                               
                           }
                        }
                         
                    }
               });
            }    
        });
    }
    void load() throws IOException
    {   
        InputStream f = null;
        ObjectInput input = null;
        try
        {
            f = new FileInputStream(System.getenv("APPDATA")+"\\Kalendarz\\dane.ser");
            input = new ObjectInputStream (f);
            lista = (List<Wydarzenie>)input.readObject();

        }  
        catch(ClassNotFoundException e)       
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            input.close();
            f.close();
        }
    }
    Date beginDate(Tabela t, Rezerwacja r) throws ParseException
    {   
        SimpleDateFormat begin = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String begin_date = t.activeYear+"-"+t.activeMonth+"-"+t.activeDay+"T"+r.getpGodzina().getSelectedItem()+":"+r.getpMinuta().getSelectedItem();
        return begin.parse(begin_date);
         
    }
    Date endDate(Tabela t, Rezerwacja r) throws ParseException
    {
         SimpleDateFormat end = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
         String end_date = t.activeYear+"-"+t.activeMonth+"-"+t.activeDay+"T"+r.getkGodzina().getSelectedItem()+":"+r.getkMinuta().getSelectedItem();
         return end.parse(end_date);
    }
    void addEvent(Tabela t, Rezerwacja r) throws ParseException
    {   
         lista.add(new Wydarzenie(r.getTfOpis().getText(),r.getSala().getSelectedItem().toString(),beginDate(t, r),endDate(t, r)));  
    }
     
    void showEvent(Tabela t,Rezerwacja r)
    { 
        for (Wydarzenie lista1 : lista)
        {   
            if(lista1.begin.getDate()==t.activeDay && lista1.begin.getMonth()==t.activeMonth-1&& (lista1.begin.getYear()-100)==(t.activeYear-2000))
            {  

            DefaultTableModel model = (DefaultTableModel) r.getjTable3().getModel();
            model.addRow(new Object[]{lista1.begin.getHours()+":"+lista1.begin.getMinutes(),lista1.end.getHours()+":"+lista1.end.getMinutes(),lista1.room,lista1.name});
            }
        }
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
