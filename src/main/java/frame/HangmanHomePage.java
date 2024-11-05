/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frame;

import javax.swing.JFrame;

/**
 *
 * @author rabey
 */
public class HangmanHomePage extends javax.swing.JFrame {

    /**
     * Creates new form HangmanHomePage
     */
    public HangmanHomePage() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rulesbutton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        playbutton = new javax.swing.JButton();
        scorebutton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rulesbutton.setIcon(new javax.swing.ImageIcon("C:\\Users\\rabey\\OneDrive\\Documents\\hangmangraphics\\rulesbutton.png")); // NOI18N
        rulesbutton.setBorder(null);
        rulesbutton.setContentAreaFilled(false);
        rulesbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rulesbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(rulesbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 212, 75));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 255));
        jLabel2.setText("Credit: Rabeya Binte Ali, Assistant Tech Master, Info Tech Club");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        playbutton.setIcon(new javax.swing.ImageIcon("C:\\Users\\rabey\\OneDrive\\Documents\\hangmangraphics\\playbutton.png")); // NOI18N
        playbutton.setBorder(null);
        playbutton.setContentAreaFilled(false);
        playbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(playbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 212, 75));

        scorebutton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\rabey\\OneDrive\\Documents\\hangmangraphics\\scorebutton.png")); // NOI18N
        scorebutton1.setBorder(null);
        scorebutton1.setContentAreaFilled(false);
        scorebutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scorebutton1ActionPerformed(evt);
            }
        });
        getContentPane().add(scorebutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 580, 212, 75));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\rabey\\OneDrive\\Documents\\hangmangraphics\\Hangman.png")); // NOI18N
        jLabel1.setText("                         ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rulesbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rulesbuttonActionPerformed
        // TODO add your handling code here:
        HangmanRulesFrame hrf=new HangmanRulesFrame();
        hrf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rulesbuttonActionPerformed

    private void scorebutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scorebutton1ActionPerformed
        // TODO add your handling code here:
        HighScoreForm hsf= new HighScoreForm();
        hsf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_scorebutton1ActionPerformed

    private void playbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playbuttonActionPerformed
        // TODO add your handling code here:
        String filepath=null;
        PlayMenuFrame pmf=new PlayMenuFrame();
        pmf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_playbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(HangmanHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HangmanHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HangmanHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HangmanHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HangmanHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton playbutton;
    private javax.swing.JButton rulesbutton;
    private javax.swing.JButton scorebutton1;
    // End of variables declaration//GEN-END:variables
}
