/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzariadiferente;

import Bean.Cliente;
import DAO.ClienteDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author George
 */
public class NovoCliente extends javax.swing.JFrame {

    Cliente cliente= new Cliente();
    /**
     * Creates new form novoCliente
     */
    public NovoCliente() {
        initComponents();
    }
    
    public void setCliente(Cliente cliente)
    {
        this.cliente  = cliente;
        if(cliente.getId() != 0){
            nomeTextField.setText(cliente.getNome());
            sobrenomeTextField.setText(cliente.getSobreNome());
            telefoneTextField.setText(cliente.getTelefone());
            enderecoTextField.setText(cliente.getEndereco());
            clienteTituloLabel.setText("Atualizar Cliente");
            salvarButton.setVisible(false);
            Atualizar.setVisible(true);
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

        clienteTituloLabel = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        sobrenomeLabel = new javax.swing.JLabel();
        sobrenomeTextField = new javax.swing.JTextField();
        telefoneLabel = new javax.swing.JLabel();
        telefoneTextField = new javax.swing.JTextField();
        enderecoLabel = new javax.swing.JLabel();
        enderecoTextField = new javax.swing.JTextField();
        salvarButton = new javax.swing.JButton();
        Atualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clienteTituloLabel.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        clienteTituloLabel.setText("Novo Cliente");

        nomeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nomeLabel.setText("Nome");

        nomeTextField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        sobrenomeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sobrenomeLabel.setText("Sobrenome");

        sobrenomeTextField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        telefoneLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        telefoneLabel.setText("Telefone");

        telefoneTextField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        telefoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneTextFieldActionPerformed(evt);
            }
        });

        enderecoLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        enderecoLabel.setText("Endereco");

        enderecoTextField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        salvarButton.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        salvarButton.setText("Salvar");
        salvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarButtonActionPerformed(evt);
            }
        });

        Atualizar.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Atualizar.setText("Atualizar");
        Atualizar.setActionCommand("Atualizar");
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeLabel)
                            .addComponent(sobrenomeLabel)
                            .addComponent(telefoneLabel)
                            .addComponent(enderecoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enderecoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nomeTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sobrenomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(telefoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Atualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salvarButton)
                                .addGap(278, 278, 278))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(clienteTituloLabel)
                                .addGap(318, 318, 318)))))
                .addGap(46, 46, 46))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {enderecoTextField, nomeTextField, sobrenomeTextField, telefoneTextField});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {enderecoLabel, telefoneLabel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clienteTituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(sobrenomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telefoneLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sobrenomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telefoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enderecoLabel)
                    .addComponent(enderecoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarButton)
                    .addComponent(Atualizar))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {enderecoLabel, enderecoTextField, nomeLabel, nomeTextField, sobrenomeLabel, sobrenomeTextField, telefoneLabel, telefoneTextField});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void salvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarButtonActionPerformed
        Cliente c = new Cliente();
        ClienteDAO cd = new ClienteDAO();
        TelaCliente tc = new TelaCliente();
        NovoCliente nc = new NovoCliente();
        boolean valido = true;
      
        if (nomeTextField.getText().trim().length() == 0 ){
            JOptionPane.showMessageDialog(nc, "Voce precisa preencher o campo nome","ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }else{
            c.setNome(nomeTextField.getText());
        }
        
        if (sobrenomeTextField.getText().trim().length() == 0 ){
            JOptionPane.showMessageDialog(nc, "Voce precisa preencher o campo sobrenome","ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }else{
            c.setSobreNome(sobrenomeTextField.getText());
        } 
        
        if (telefoneTextField.getText().trim().length() == 0 ){
            JOptionPane.showMessageDialog(nc, "Voce precisa preencher o campo telefone","ERRO", JOptionPane.ERROR_MESSAGE);
           return;
        }else{
            c.setTelefone(telefoneTextField.getText());
        }
        
        if (enderecoTextField.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(nc, "Voce precisa preencher o campo endereço","ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }else{
            c.setEndereco(enderecoTextField.getText());
        }
        if(valido){
            cd.insert(c);
            dispose();
            tc.setVisible(true);
        }
    }//GEN-LAST:event_salvarButtonActionPerformed

    private void telefoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneTextFieldActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
        // TODO add your handling code here:
        
        Cliente c = this.cliente;
        ClienteDAO cd = new ClienteDAO();
        TelaCliente tc = new TelaCliente();
        NovoCliente nc = new NovoCliente();
        boolean valido = true;
      
        if (nomeTextField.getText().trim().length() == 0 ){
            JOptionPane.showMessageDialog(nc, "Voce precisa preencher o campo nome");
            return;
        }else{
            c.setNome(nomeTextField.getText());
        }
        
        if (sobrenomeTextField.getText().trim().length() == 0 ){
            JOptionPane.showMessageDialog(nc, "Voce precisa preencher o campo sobrenome");
            return;
        }else{
            c.setSobreNome(sobrenomeTextField.getText());
        } 
        
        if (telefoneTextField.getText().trim().length() == 0 ){
            JOptionPane.showMessageDialog(nc, "Voce precisa preencher o campo telefone");
           return;
        }else{
            c.setTelefone(telefoneTextField.getText());
        }
        
        if (enderecoTextField.getText().trim().length() == 0){
            JOptionPane.showMessageDialog(nc, "Voce precisa preencher o campo endereco");
            return;
        }else{
            c.setEndereco(enderecoTextField.getText());
        }
        if(valido){
            cd.insert(c);
            dispose();
            tc.setVisible(true);
        }
    }//GEN-LAST:event_AtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(NovoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atualizar;
    private javax.swing.JLabel clienteTituloLabel;
    private javax.swing.JLabel enderecoLabel;
    private javax.swing.JTextField enderecoTextField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JButton salvarButton;
    private javax.swing.JLabel sobrenomeLabel;
    private javax.swing.JTextField sobrenomeTextField;
    private javax.swing.JLabel telefoneLabel;
    private javax.swing.JTextField telefoneTextField;
    // End of variables declaration//GEN-END:variables
}
