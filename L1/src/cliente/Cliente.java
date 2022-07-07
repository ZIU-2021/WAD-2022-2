package cliente;

import java.awt.Desktop;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import servidor.Producto;
import org.apache.pdfbox.pdmodel.PDDocument;  
import org.apache.pdfbox.pdmodel.PDPage;  
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;

public final class Cliente extends javax.swing.JFrame implements Serializable {
    
    public static String dir = "";
    public static String pto = "";
    public String recibido = "";
    public static Socket sc;
    InputStream entrada;
    OutputStream salida;
    ObjectInputStream entradaObjetos;
    ObjectOutputStream salidaObjetos;
    DataOutputStream opc;
    
    static ArrayList<Producto> carrito = new ArrayList();
    static ArrayList<Producto> productos = new ArrayList();
    
    
    public Cliente() throws IOException, FileNotFoundException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        vcatalogo.setVisible(false);
        vcarrito.setVisible(false);
        
        dir = Datos.direccion;
        pto = Datos.puerto;
        
        try {
            //Creo el socket para conectarme con el cliente
            sc = new Socket(dir, Integer.parseInt(pto));

            //Envio un mensaje al cliente
            System.out.println("¡Hola mundo desde el cliente!");
            
            //Definimos entrada y salida
            entrada = sc.getInputStream();
            salida = sc.getOutputStream();
            
            //Cargamos el objeto
            entradaObjetos = new ObjectInputStream(entrada);
            productos = (ArrayList<Producto>) entradaObjetos.readObject();
            opc = new DataOutputStream(salida);
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BFinalizar = new javax.swing.JButton();
        BComprar = new javax.swing.JButton();
        BCarrito = new javax.swing.JButton();
        BVer = new javax.swing.JButton();
        vcarrito = new javax.swing.JPanel();
        LCarrito = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TCarrito = new javax.swing.JTable();
        BEliminar = new javax.swing.JButton();
        LTotal = new javax.swing.JLabel();
        BDisminuir = new javax.swing.JButton();
        BAumentar = new javax.swing.JButton();
        LSinexistenciascarrito = new javax.swing.JLabel();
        vcatalogo = new javax.swing.JPanel();
        LProductos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TProductos = new javax.swing.JTable();
        BAgregar = new javax.swing.JButton();
        LSinexistenciascatalogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BFinalizar.setText("Finalizar sesion");
        BFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFinalizarActionPerformed(evt);
            }
        });

        BComprar.setText("Comprar");
        BComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BComprarActionPerformed(evt);
            }
        });

        BCarrito.setText("Ver carrito");
        BCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCarritoActionPerformed(evt);
            }
        });

        BVer.setText("Ver catalogo");
        BVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVerActionPerformed(evt);
            }
        });

        LCarrito.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        LCarrito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LCarrito.setText("Carrito");

        TCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Imagenes", "Producto", "Descripcion", "Precio", "Existencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TCarrito.setColumnSelectionAllowed(true);
        TCarrito.setRowHeight(60);
        jScrollPane2.setViewportView(TCarrito);
        TCarrito.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        BEliminar.setText("Eliminar Producto");
        BEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminarActionPerformed(evt);
            }
        });

        BDisminuir.setText("Disminuir");
        BDisminuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDisminuirActionPerformed(evt);
            }
        });

        BAumentar.setText("Aumentar");
        BAumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAumentarActionPerformed(evt);
            }
        });

        LSinexistenciascarrito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout vcarritoLayout = new javax.swing.GroupLayout(vcarrito);
        vcarrito.setLayout(vcarritoLayout);
        vcarritoLayout.setHorizontalGroup(
            vcarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vcarritoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vcarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(LCarrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
            .addGroup(vcarritoLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(vcarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vcarritoLayout.createSequentialGroup()
                        .addComponent(BAumentar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BDisminuir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LSinexistenciascarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(vcarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        vcarritoLayout.setVerticalGroup(
            vcarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vcarritoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LCarrito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(vcarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LSinexistenciascarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(vcarritoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BAumentar)
                    .addComponent(BEliminar)
                    .addComponent(BDisminuir))
                .addContainerGap())
        );

        LProductos.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        LProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LProductos.setText("Catalogo");

        TProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Imagen", "Producto", "Descripcion", "Precio", "Existencias"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TProductos.setColumnSelectionAllowed(true);
        TProductos.setRowHeight(60);
        TProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TProductos);
        TProductos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (TProductos.getColumnModel().getColumnCount() > 0) {
            TProductos.getColumnModel().getColumn(0).setMinWidth(25);
            TProductos.getColumnModel().getColumn(0).setPreferredWidth(25);
            TProductos.getColumnModel().getColumn(0).setMaxWidth(20);
            TProductos.getColumnModel().getColumn(1).setMinWidth(100);
            TProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
            TProductos.getColumnModel().getColumn(1).setMaxWidth(300);
            TProductos.getColumnModel().getColumn(4).setMinWidth(60);
            TProductos.getColumnModel().getColumn(4).setPreferredWidth(60);
            TProductos.getColumnModel().getColumn(4).setMaxWidth(60);
            TProductos.getColumnModel().getColumn(5).setMinWidth(80);
            TProductos.getColumnModel().getColumn(5).setPreferredWidth(80);
            TProductos.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        BAgregar.setText("Agregar al carrito");
        BAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgregarActionPerformed(evt);
            }
        });

        LSinexistenciascatalogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout vcatalogoLayout = new javax.swing.GroupLayout(vcatalogo);
        vcatalogo.setLayout(vcatalogoLayout);
        vcatalogoLayout.setHorizontalGroup(
            vcatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vcatalogoLayout.createSequentialGroup()
                .addGroup(vcatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vcatalogoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(vcatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)))
                    .addGroup(vcatalogoLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(vcatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LSinexistenciascatalogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        vcatalogoLayout.setVerticalGroup(
            vcatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vcatalogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LSinexistenciascatalogo, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BAgregar)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BVer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BComprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BCarrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BFinalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vcatalogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(129, Short.MAX_VALUE)
                    .addComponent(vcarrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(BVer)
                .addGap(18, 18, 18)
                .addComponent(BCarrito)
                .addGap(18, 18, 18)
                .addComponent(BComprar)
                .addGap(18, 18, 18)
                .addComponent(BFinalizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vcatalogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(vcarrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFinalizarActionPerformed
        System.out.println("Sesion Finalizada");
        try {
            opc.writeUTF("Finalizar");
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_BFinalizarActionPerformed

    private void BVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVerActionPerformed
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 1: return ImageIcon.class;
                    default: return String.class;
                }
            }
        };
        model.addColumn("Id");
        model.addColumn("Imagen");
        model.addColumn("Producto");
        model.addColumn("Descripcion");
        model.addColumn("Precio");
        model.addColumn("Existencias");

        for(int aux = 0; productos.size() > aux ; aux++){
            model.addRow(new Object[]{productos.get(aux).getId(), productos.get(aux).getImagen(), productos.get(aux).getNombre(), productos.get(aux).getDescripcion(), productos.get(aux).getPrecio(), productos.get(aux).getInventario()});
        }

        TProductos.setModel(model);
        TProductos.getColumnModel().getColumn(0).setPreferredWidth(20);
        TProductos.getColumnModel().getColumn(1).setPreferredWidth(40);
        TProductos.getColumnModel().getColumn(2).setPreferredWidth(110);
        TProductos.getColumnModel().getColumn(3).setPreferredWidth(160);
        TProductos.getColumnModel().getColumn(4).setPreferredWidth(60);
        TProductos.getColumnModel().getColumn(5).setPreferredWidth(65);
        TProductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        vcarrito.setVisible(false);
        vcatalogo.setVisible(true);
    }//GEN-LAST:event_BVerActionPerformed

    private void BCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCarritoActionPerformed
        float totalcarrito = 0;
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 1: return ImageIcon.class;
                    default: return String.class;
                }
            }
        };
        model.addColumn("Id");
        model.addColumn("Imagen");
        model.addColumn("Producto");
        model.addColumn("Descripcion");
        model.addColumn("Precio");
        model.addColumn("Existencias");

        for(int aux = 0; carrito.size() > aux ; aux++){
            model.addRow(new Object[]{carrito.get(aux).getId(), carrito.get(aux).getImagen(), carrito.get(aux).getNombre(), carrito.get(aux).getDescripcion(), carrito.get(aux).getPrecio(), carrito.get(aux).getInventario()});
            totalcarrito = totalcarrito + carrito.get(aux).getPrecio() * carrito.get(aux).getInventario();
        }
        
        LTotal.setText("Total: $" + String.valueOf(totalcarrito));
        
        TCarrito.setModel(model);
        TCarrito.getColumnModel().getColumn(0).setPreferredWidth(20);
        TCarrito.getColumnModel().getColumn(1).setPreferredWidth(40);
        TCarrito.getColumnModel().getColumn(2).setPreferredWidth(110);
        TCarrito.getColumnModel().getColumn(3).setPreferredWidth(160);
        TCarrito.getColumnModel().getColumn(4).setPreferredWidth(60);
        TCarrito.getColumnModel().getColumn(5).setPreferredWidth(65);
        vcatalogo.setVisible(false);
        vcarrito.setVisible(true);
        
    }//GEN-LAST:event_BCarritoActionPerformed

    private void BComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BComprarActionPerformed
        //Generamos pdf
        try (PDDocument doc= new PDDocument();  ){
            PDPage myPage = new PDPage(PDRectangle.A4);
            doc.addPage(myPage);
            PDFont font = new PDType1Font(FontName.HELVETICA_BOLD);
            PDFont font2 = new PDType1Font(FontName.HELVETICA);
            int bot = 700;
            float totalprod = 0;
            
            try(PDPageContentStream cont = new PDPageContentStream(doc, myPage)){
                cont.beginText();
                
                cont.setFont(font, 18);
                cont.setLeading(14.5f);
                cont.newLineAtOffset(230, 760);
                String title = "Recibo de compra";
                cont.showText(title);
                
                cont.endText();
                
                cont.beginText();
                
                cont.setFont(font2, 14);
                cont.setLeading(14.5f);
                cont.newLineAtOffset(250, 740);
                String title2 = "Tiendita 'El Amigo'";
                cont.showText(title2);
                
                cont.endText();
                
                cont.beginText();
                
                cont.setFont(font, 12);
                cont.setLeading(14.5f);
                cont.newLineAtOffset(30, 700);
                String line2 = "Cantidad";
                cont.showText(line2);
                
                //Aqui va un for
                for(int aux = 0; carrito.size() > aux; aux++){
                    cont.newLine();
                    cont.newLine();
                    cont.showText(String.valueOf(carrito.get(aux).getInventario()));
                    bot = bot - 31;
                }
                
                cont.endText();
                
                cont.beginText();
                
                cont.setFont(font, 12);
                cont.setLeading(14.5f);
                cont.newLineAtOffset(120, 700);
                String line3 = "Nombre";
                cont.showText(line3);
                
                //Aqui va un for
                for(int aux = 0; carrito.size() > aux; aux++){
                    
                    cont.newLine();
                    cont.newLine();
                    cont.showText(carrito.get(aux).getNombre());
                }
                
                cont.endText();
                
                cont.beginText();
                
                cont.setFont(font, 12);
                cont.setLeading(14.5f);
                cont.newLineAtOffset(400, 700);
                String line4 = "Precio Unitario";
                cont.showText(line4);
                
//                Aqui va un for
                for(int aux = 0; carrito.size() > aux; aux++){
                    cont.newLine();
                    cont.newLine();
                    cont.showText(String.valueOf(carrito.get(aux).getPrecio()));
                }
                
                cont.endText();
                
                cont.beginText();
                
                cont.setFont(font, 12);
                cont.setLeading(14.5f);
                cont.newLineAtOffset(520, 700);
                String line5 = "Precio";
                cont.showText(line5);
                
                //Aqui va un for
                for(int aux = 0; carrito.size() > aux; aux++){
                    cont.newLine();
                    cont.newLine();
                    cont.showText(String.valueOf(carrito.get(aux).getPrecio() * carrito.get(aux).getInventario()));
                    totalprod = carrito.get(aux).getPrecio() * carrito.get(aux).getInventario() + totalprod;
                }
                
                cont.endText();
                
                cont.moveTo(585, 695);
                cont.lineTo(10, 695);
                cont.stroke();
                cont.moveTo(585, bot - 15);
                cont.lineTo(10, bot - 15);
                cont.stroke();
                
                cont.beginText();
                
                cont.newLineAtOffset(400, (bot - 30));
                
                String tot = "Total:";
                cont.showText(tot);
                
                cont.endText();
                
                cont.beginText();
                
                cont.newLineAtOffset(520, (bot - 30));
                
                String res = String.valueOf("$" + totalprod);
                cont.showText(res);
                
                cont.endText();
                
                cont.beginText();
                
                cont.newLineAtOffset(400, (bot - 70));
                
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now(); 
                cont.showText(dtf.format(now));
                
                cont.endText();
                
                
            }
            //path where the PDF file will be store
            String directorio = System.getProperty("user.dir");
            doc.save(directorio + "\\src\\cliente\\ticket.pdf");
            //closes the document
            doc.close();
            File pdf = new File(directorio + "\\src\\cliente\\ticket.pdf");
            Desktop.getDesktop().open(pdf);
            //Enviamos cambios
            try {
                opc.writeUTF("Comprar");
                salidaObjetos = new ObjectOutputStream (salida);
                salidaObjetos.writeObject(productos);
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        boolean removeAll = carrito.removeAll(carrito);
        vcarrito.setVisible(false);
    }//GEN-LAST:event_BComprarActionPerformed

    private void BEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEliminarActionPerformed
        float totalcarrito = 0;
        int row = TCarrito.getSelectedRow();
        int producto = (Integer)TCarrito.getValueAt(row, 0);
        for(int aux = 0; carrito.size() >= aux ; aux++){
            if(carrito.get(aux).getId() == producto){
                for(int x = 0; productos.size() > x; x++){
                    if(productos.get(x).getId() == carrito.get(aux).getId()){
                        productos.get(x).setInventario(carrito.get(aux).getInventario() + productos.get(x).getInventario());
                    }
                }
                carrito.remove(aux);
                break;
            }
        }
        
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 1: return ImageIcon.class;
                    default: return String.class;
                }
            }
        };
        model.addColumn("Id");
        model.addColumn("Imagen");
        model.addColumn("Producto");
        model.addColumn("Descripcion");
        model.addColumn("Precio");
        model.addColumn("Existencias");

        for(int aux = 0; carrito.size() > aux ; aux++){
            model.addRow(new Object[]{carrito.get(aux).getId(), carrito.get(aux).getImagen(), carrito.get(aux).getNombre(), carrito.get(aux).getDescripcion(), carrito.get(aux).getPrecio(), carrito.get(aux).getInventario()});
            totalcarrito = totalcarrito + carrito.get(aux).getPrecio() * carrito.get(aux).getInventario();
        }
        
        LTotal.setText("Totoal: $" + String.valueOf(totalcarrito));
        
        TCarrito.setModel(model);
        TCarrito.getColumnModel().getColumn(0).setPreferredWidth(20);
        TCarrito.getColumnModel().getColumn(1).setPreferredWidth(40);
        TCarrito.getColumnModel().getColumn(2).setPreferredWidth(110);
        TCarrito.getColumnModel().getColumn(3).setPreferredWidth(160);
        TCarrito.getColumnModel().getColumn(4).setPreferredWidth(60);
        TCarrito.getColumnModel().getColumn(5).setPreferredWidth(65);
        vcatalogo.setVisible(false);
        vcarrito.setVisible(true);
    }//GEN-LAST:event_BEliminarActionPerformed

    private void BAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarActionPerformed
        boolean noexiste = true;
        int producto = TProductos.getSelectedRow() + 1;
        for(int aux = 0; productos.size() > aux ; aux++){
            if(productos.get(aux).getId() == producto){
                if(productos.get(aux).getInventario() > 0){
                    for(int x = 0; carrito.size() > x; x++){
                        if(carrito.get(x).getId() == productos.get(aux).getId()){
                            carrito.get(x).setInventario(carrito.get(x).getInventario()+1);
                            productos.get(aux).setInventario(productos.get(aux).getInventario() - 1);
                            noexiste = false;
                        }
                    }
                    if(noexiste){
                        Producto prodaux = new Producto(productos.get(aux).getId(), productos.get(aux).getNombre(), productos.get(aux).getImagen(), productos.get(aux).getDescripcion(), productos.get(aux).getPrecio(), 1);
                        carrito.add(prodaux);
                        productos.get(aux).setInventario(productos.get(aux).getInventario() - 1);
                    }
                    LSinexistenciascatalogo.setText("");
                }
                else{
                    LSinexistenciascatalogo.setText("SIN EXISTENCIAS");
                }
            }
        }
        
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 1: return ImageIcon.class;
                    default: return String.class;
                }
            }
        };
        model.addColumn("Id");
        model.addColumn("Imagen");
        model.addColumn("Producto");
        model.addColumn("Descripcion");
        model.addColumn("Precio");
        model.addColumn("Existencias");

        for(int aux = 0; productos.size() > aux ; aux++){
            model.addRow(new Object[]{productos.get(aux).getId(), productos.get(aux).getImagen(), productos.get(aux).getNombre(), productos.get(aux).getDescripcion(), productos.get(aux).getPrecio(), productos.get(aux).getInventario()});
        }

        TProductos.setModel(model);
        TProductos.getColumnModel().getColumn(0).setPreferredWidth(20);
        TProductos.getColumnModel().getColumn(1).setPreferredWidth(40);
        TProductos.getColumnModel().getColumn(2).setPreferredWidth(110);
        TProductos.getColumnModel().getColumn(3).setPreferredWidth(160);
        TProductos.getColumnModel().getColumn(4).setPreferredWidth(60);
        TProductos.getColumnModel().getColumn(5).setPreferredWidth(65);
        vcarrito.setVisible(false);
        vcatalogo.setVisible(true);
    }//GEN-LAST:event_BAgregarActionPerformed

    private void BAumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAumentarActionPerformed
        float totalcarrito = 0;
        int row = TCarrito.getSelectedRow();
        if(row != -1){
            int producto = (Integer)TCarrito.getValueAt(row, 0);
            for(int aux = 0; carrito.size() > aux ; aux++){
                if(carrito.get(aux).getId() == producto){
                    if(productos.get(aux).getInventario() > 1){
                        carrito.get(aux).setInventario(carrito.get(aux).getInventario() + 1);
                        productos.get(aux).setInventario(productos.get(aux).getInventario() - 1);
                    }
                    else{
                        LSinexistenciascarrito.setText("SIN EXISTENCIAS");
                    }
                }
            }
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public Class<?> getColumnClass(int column) {
                    switch (column) {
                        case 1: return ImageIcon.class;
                        default: return String.class;
                    }
                }
            };
            model.addColumn("Id");
            model.addColumn("Imagen");
            model.addColumn("Producto");
            model.addColumn("Descripcion");
            model.addColumn("Precio");
            model.addColumn("Existencias");

            for(int aux = 0; carrito.size() > aux ; aux++){
                model.addRow(new Object[]{carrito.get(aux).getId(), carrito.get(aux).getImagen(), carrito.get(aux).getNombre(), carrito.get(aux).getDescripcion(), carrito.get(aux).getPrecio(), carrito.get(aux).getInventario()});
                totalcarrito = totalcarrito + carrito.get(aux).getPrecio() * carrito.get(aux).getInventario();
            }

            LTotal.setText("Totoal: $" + String.valueOf(totalcarrito));

            TCarrito.setModel(model);
            TCarrito.getColumnModel().getColumn(0).setPreferredWidth(20);
            TCarrito.getColumnModel().getColumn(1).setPreferredWidth(40);
            TCarrito.getColumnModel().getColumn(2).setPreferredWidth(110);
            TCarrito.getColumnModel().getColumn(3).setPreferredWidth(160);
            TCarrito.getColumnModel().getColumn(4).setPreferredWidth(60);
            TCarrito.getColumnModel().getColumn(5).setPreferredWidth(65);
            vcatalogo.setVisible(false);
            vcarrito.setVisible(true);
        }
    }//GEN-LAST:event_BAumentarActionPerformed

    private void BDisminuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDisminuirActionPerformed
        float totalcarrito = 0;
        int row = TCarrito.getSelectedRow();
        if(row != -1){
            int producto = (Integer)TCarrito.getValueAt(row, 0);
            for(int aux = 0; carrito.size() > aux ; aux++){
                if(carrito.get(aux).getId() == producto){
                    if(carrito.get(aux).getInventario() > 1){
                        carrito.get(aux).setInventario(carrito.get(aux).getInventario() - 1);
                        productos.get(aux).setInventario(productos.get(aux).getInventario() + 1);
                    }
                    else{
                        productos.get(aux).setInventario(productos.get(aux).getInventario() + 1);
                        carrito.remove(aux);
                    }
                }
            }
            DefaultTableModel model = new DefaultTableModel() {
                @Override
                public Class<?> getColumnClass(int column) {
                    switch (column) {
                        case 1: return ImageIcon.class;
                        default: return String.class;
                    }
                }
            };
            model.addColumn("Id");
            model.addColumn("Imagen");
            model.addColumn("Producto");
            model.addColumn("Descripcion");
            model.addColumn("Precio");
            model.addColumn("Existencias");

            for(int aux = 0; carrito.size() > aux ; aux++){
                model.addRow(new Object[]{carrito.get(aux).getId(), carrito.get(aux).getImagen(), carrito.get(aux).getNombre(), carrito.get(aux).getDescripcion(), carrito.get(aux).getPrecio(), carrito.get(aux).getInventario()});
                totalcarrito = totalcarrito + carrito.get(aux).getPrecio() * carrito.get(aux).getInventario();
            }

            LTotal.setText("Totoal: $" + String.valueOf(totalcarrito));

            TCarrito.setModel(model);
            TCarrito.getColumnModel().getColumn(0).setPreferredWidth(20);
            TCarrito.getColumnModel().getColumn(1).setPreferredWidth(40);
            TCarrito.getColumnModel().getColumn(2).setPreferredWidth(110);
            TCarrito.getColumnModel().getColumn(3).setPreferredWidth(160);
            TCarrito.getColumnModel().getColumn(4).setPreferredWidth(60);
            TCarrito.getColumnModel().getColumn(5).setPreferredWidth(65);
            vcatalogo.setVisible(false);
            vcarrito.setVisible(true);
        }
    }//GEN-LAST:event_BDisminuirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Cliente().setVisible(true);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAgregar;
    private javax.swing.JButton BAumentar;
    private javax.swing.JButton BCarrito;
    private javax.swing.JButton BComprar;
    private javax.swing.JButton BDisminuir;
    private javax.swing.JButton BEliminar;
    private javax.swing.JButton BFinalizar;
    private javax.swing.JButton BVer;
    private javax.swing.JLabel LCarrito;
    private javax.swing.JLabel LProductos;
    private javax.swing.JLabel LSinexistenciascarrito;
    private javax.swing.JLabel LSinexistenciascatalogo;
    private javax.swing.JLabel LTotal;
    private javax.swing.JTable TCarrito;
    private javax.swing.JTable TProductos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel vcarrito;
    private javax.swing.JPanel vcatalogo;
    // End of variables declaration//GEN-END:variables
}
