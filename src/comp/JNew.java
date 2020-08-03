/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comp;

import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author Patricio Pérez Pinto
 */
public class JNew extends javax.swing.JPanel implements Runnable{
    private JLabel lbl;

    public JNew(JLabel lbl) {
        this.lbl = lbl;
        initComponents();
    }

    public JNew(JLabel lbl, boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        this.lbl = lbl;
        initComponents();
    }

    public JNew(JLabel lbl, LayoutManager layout) {
        super(layout);
        this.lbl = lbl;
        initComponents();
    }

    public JNew(JLabel lbl, LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        this.lbl = lbl;
        initComponents();
    }
    
    

    @Override
    public void run() {
        try{
            int anchoPanelAux = this.getWidth();
            while(true){
                this.removeAll();
                anchoPanelAux-=1;
                this.add(lbl,new org.netbeans.lib.awtextra.AbsoluteConstraints(anchoPanelAux, //el X
                        (this.getHeight()/2)-(lbl.getHeight()/2), //el Y, esto es para que el jlabel se vea centrado
                        -1, //el width se redimensiona junto con el panel
                        -1));//el height se redimensiona junto con el panel
                this.updateUI();
                pause(15);
                if(anchoPanelAux < (lbl.getWidth() *-1)  ){
                    anchoPanelAux = this.getWidth();
                }
            }
        }catch(Exception e){
            System.out.println("e: "+e.getMessage());
        }
    }
    
    private void pause(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException ex) {
            System.out.println("ex: "+ex.getMessage());
        }
    }

    private void initComponents() {
        this.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        new Thread(this).start();
    }

    public JLabel getLbl() {
        return lbl;
    }

    public void setLbl(JLabel lbl) {
        this.lbl = lbl;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }
    
    
}
