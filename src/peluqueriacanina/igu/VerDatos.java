package peluqueriacanina.igu;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import peluqueriacanina.logica.Controladora;
import peluqueriacanina.logica.Mascota;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class VerDatos extends javax.swing.JFrame {

    // Declaramos la controladora para que sea global en esta clase
    Controladora control = null;

    /**
     * Constructor de la ventana. Inicializa componentes, centra la ventana y
     * carga los datos existentes.
     */
    public VerDatos() {
        control = new Controladora(); // La inicializamos
        initComponents();
        this.setLocationRelativeTo(null); // Con esto la ventana sale centrada
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMascotas = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jPanel1MouseWheelMoved(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Visualización de Datos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Datos de Mascotas");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tablaMascotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaMascotas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tablaMascotas);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/peluqueriacanina/imagenes/eliminar 64x64.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/peluqueriacanina/imagenes/editar 64x64.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/peluqueriacanina/imagenes/volver 64x64.png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(180, 180, 180))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        // 1. Validamos que la tabla no esté vacía y que haya una fila seleccionada
        if (tablaMascotas.getRowCount() > 0) {
            if (tablaMascotas.getSelectedRow() != -1) {

                // --- AQUÍ AGREGAMOS EL MENSAJE DE CONFIRMACIÓN ---
                // Creamos una variable entera para guardar la respuesta del usuario
                int respuesta = JOptionPane.showConfirmDialog(this,
                        "¿Está seguro de que desea eliminar este registro?",
                        "Confirmar Eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                // Si el usuario presiona "SÍ" (YES_OPTION)
                if (respuesta == JOptionPane.YES_OPTION) {

                    // Obtenemos el ID y procedemos al borrado
                    int num_cliente = Integer.parseInt(String.valueOf(tablaMascotas.getValueAt(tablaMascotas.getSelectedRow(), 0)));
                    control.borrarMascota(num_cliente);

                    // Avisamos del éxito y recargamos
                    mostrarMensaje("Mascota eliminada correctamente", "Info", "Borrado Exitoso");
                    cargarTabla();
                }
                // Si presiona "NO", no pasa nada y la ventana se cierra sola.

            } else {
                mostrarMensaje("No seleccionó ninguna mascota para eliminar", "Error", "Error al eliminar");
            }
        } else {
            mostrarMensaje("No hay registros en la tabla para eliminar", "Error", "Tabla vacía");
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        // 1. Validar que la tabla tenga datos
        if (tablaMascotas.getRowCount() > 0) {
            // 2. Validar que se haya seleccionado una fila
            if (tablaMascotas.getSelectedRow() != -1) {

                // Obtener el ID de la mascota a editar
                int num_cliente = Integer.parseInt(String.valueOf(tablaMascotas.getValueAt(tablaMascotas.getSelectedRow(), 0)));

                // Abrir la ventana de modificación y pasarle el ID
                ModificarDatos pantallaModif = new ModificarDatos(num_cliente);
                pantallaModif.setVisible(true);
                pantallaModif.setLocationRelativeTo(null);

                // Cerrar la ventana de lista (opcional)
                this.dispose();

            } else {
                mostrarMensaje("No seleccionó ninguna mascota", "Error", "Error al editar");
            }
        } else {
            mostrarMensaje("No hay nada para editar en la tabla", "Error", "Tabla vacía");
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        // 2. ¡IMPORTANTE! Cerramos la ventana actual JUSTO DESPUÉS
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jPanel1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jPanel1MouseWheelMoved

    }//GEN-LAST:event_jPanel1MouseWheelMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMascotas;
    // End of variables declaration//GEN-END:variables

// Método para configurar la tabla
    private void cargarTabla() {
        // 1. Definir el modelo que queremos que tenga la tabla
        // Usamos DefaultTableModel para definir columnas y filas
        DefaultTableModel modeloTabla = new DefaultTableModel() {

            // 2. Hacemos que la tabla NO sea editable (Override)
            // Esto evita que el usuario doble clic y escriba en la celda
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modeloTabla.setRowCount(0);

        // 3. Establecemos los nombres de las columnas
        String titulos[] = {"Num", "Nombre", "Color", "Raza", "Alergico", "At. Esp.", "Dueño", "Cel"};
        modeloTabla.setColumnIdentifiers(titulos);

        // 1. Traer la lista de mascotas desde la base de datos a través de la lógica
        List<Mascota> listaMascotas = control.traerMascotas();

        // 2. Verificar que la lista no esté vacía y recorrerla
        if (listaMascotas != null) {
            for (Mascota masco : listaMascotas) {
                // Creamos un arreglo de objetos para representar una fila
                Object[] objeto = {
                    masco.getNum_cliente(),
                    masco.getNombre(),
                    masco.getColor(),
                    masco.getRaza(),
                    masco.getAlergico(),
                    masco.getAtencion_especial(),
                    masco.getUnDuenio().getNombre(),
                    masco.getUnDuenio().getCelDuenio()
                };

                // Agregamos la fila al modelo de la tabla
                modeloTabla.addRow(objeto);
            }
        }
        // 4. Asignamos este modelo a la tabla gráfica (JTable)
        // Asegurarnos de que tu tabla en el diseño se llame 'tablaMascotas' o cambiar este nombre
        tablaMascotas.setModel(modeloTabla);

        // Ajustar anchos de columnas específicas
// La columna 0 es "Num", la 4 es "Alergico", la 5 es "At. Esp."
        tablaMascotas.getColumnModel().getColumn(0).setPreferredWidth(30);  // Num
        tablaMascotas.getColumnModel().getColumn(4).setPreferredWidth(50);  // Alergico
        tablaMascotas.getColumnModel().getColumn(5).setPreferredWidth(50);  // At. Esp.

// Darle más espacio a las que se cortan
        tablaMascotas.getColumnModel().getColumn(6).setPreferredWidth(100); // Dueño
        tablaMascotas.getColumnModel().getColumn(7).setPreferredWidth(85); // Cel

    }
    // Este método debe estar DENTRO de la clase VerDatos, pero FUERA de otros métodos

    public void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
}
