package obligatorio_dda.presentacion;


import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import obligatorio_dda.dominio.Jugador;
import obligatorio_dda.dominio.Mesa;
import obligatorio_dda.dominio.Sesion;
import obligatorio_dda.presentacion.controlador.UnirseMesaControlador;
import obligatorio_dda.presentacion.vista.UnirseMesaVista;


/**
 *
 * @author monte
 */
public class VentanaUnirseMesa extends javax.swing.JFrame implements UnirseMesaVista {

    private UnirseMesaControlador controlador;

    /**
     * Creates new form VentanaJugadorUnirseMesa
     */
    public VentanaUnirseMesa(Sesion sesion) {
        initComponents();
        this.setTitle("Aplicacion Jugador - Unirse a mesa");
        this.setLocationRelativeTo(null);
        list_mesasAbiertas.setCellRenderer(new MesaRenderer());
        this.controlador = new UnirseMesaControlador(sesion, this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_unirseMesa = new javax.swing.JButton();
        b_logoff = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_mesasAbiertas = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        l_nombreJugador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aplicacion Jugador - Unirse a mesa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        b_unirseMesa.setText("Unirse");
        b_unirseMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_unirseMesaActionPerformed(evt);
            }
        });

        b_logoff.setText("Log off");
        b_logoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_logoffActionPerformed(evt);
            }
        });

        list_mesasAbiertas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                list_mesasAbiertasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(list_mesasAbiertas);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mesas abiertas");

        jLabel2.setText("Jugador");

        l_nombreJugador.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(b_unirseMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b_logoff, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(123, 123, 123)
                        .addComponent(l_nombreJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(l_nombreJugador))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_unirseMesa)
                    .addComponent(b_logoff))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_logoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_logoffActionPerformed
        this.logout();
    }//GEN-LAST:event_b_logoffActionPerformed

    private void b_unirseMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_unirseMesaActionPerformed
        unirseMesa();
    }//GEN-LAST:event_b_unirseMesaActionPerformed

    private void list_mesasAbiertasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_list_mesasAbiertasValueChanged
        seleccionarMesa();
    }//GEN-LAST:event_list_mesasAbiertasValueChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.logout();
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_logoff;
    private javax.swing.JButton b_unirseMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_nombreJugador;
    private javax.swing.JList list_mesasAbiertas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarMesasAbiertas(List<Mesa> mesas) {
        list_mesasAbiertas.setListData(mesas.toArray());
        ListSelectionModel selectionModel = list_mesasAbiertas.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void logout() {
        this.controlador.logout();
    }

    @Override
    public void abrilRuletaJugador(Jugador jugador, Mesa mesa) {
        VentanaJugar ventanaNueva = new VentanaJugar(jugador, mesa);
        ventanaNueva.setVisible(true);
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void unirseMesa() {
        this.controlador.unirseMesa();
    }

    private void seleccionarMesa() {
        this.controlador.mesaSeleccionada((Mesa) list_mesasAbiertas.getSelectedValue());
    }

    @Override
    public void cerrar() {
        dispose();
    }

    @Override
    public void nombreJugador(String nombreCompleto) {
        l_nombreJugador.setText(nombreCompleto);
    }

    private class MesaRenderer extends JLabel implements ListCellRenderer<Mesa> {

        @Override
        public Component getListCellRendererComponent(JList list, Mesa mesa, int index, boolean isSelected, boolean cellHasFocus) {
            this.setText("Mesa N°: " + mesa.getNumeroMesa());
            if (isSelected) {
                this.setForeground(Color.BLUE);
            }
            else{
                this.setForeground(list.getForeground());
            }
            return this;
        }
    }

}
