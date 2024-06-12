/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ProductService;
import co.com.hyunseda.market.service.ShoppingCartService;


public class GUILOGIN1 extends javax.swing.JFrame {
    
    private CategoryService categoryService;
    private ProductService productService;
    private ShoppingCartService shoppingCartService;

    /**
     * Creates new form GUILOGUIN1
     */
    public GUILOGIN1() {
        initComponents();
    }
     public GUILOGIN1(CategoryService categoryService,ProductService productService, ShoppingCartService shoppingCartService) {
        
        initComponents();
        this.categoryService = categoryService;
        this.productService = productService;
        this.shoppingCartService = shoppingCartService;
        setLocationRelativeTo(null);
        setSize(450, 350);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlbalCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jblContrasenia = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        jLbRol = new javax.swing.JLabel();
        cbRol = new javax.swing.JComboBox<>();

        jButton1.setText("jButton1");

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acceso(1).png"))); // NOI18N
        jPanel1.add(jLabel2);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 24)); // NOI18N
        jLabel1.setText("Iniciar Sesión");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel2.add(btnVolver);

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresar);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.GridLayout(6, 1));

        jlbalCorreo.setText("Email:");
        jPanel3.add(jlbalCorreo);
        jPanel3.add(txtCorreo);

        jblContrasenia.setText("Password:");
        jPanel3.add(jblContrasenia);
        jPanel3.add(txtContrasenia);

        jLbRol.setText("Rol:");
        jPanel3.add(jLbRol);

        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SuperAdministrador", "Administrador", "Editor", " " }));
        jPanel3.add(cbRol);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String correo = txtCorreo.getText();    
        String contrasenia = txtContrasenia.getText();
        String rol = cbRol.getSelectedItem().toString();
        
        if((!correo.isBlank()) && (!contrasenia.isBlank()))
        {
            if(ValidarUsuario(correo,contrasenia,rol)== true)
            {
                 //Messages.showMessageDialog("Bienvenido", "Informacion");
            }else{
                Messages.showMessageDialog("Email o contraseña incorrecta", "Atencion");
            }
        }
        else{
             Messages.showMessageDialog("Campos Vacios", "Atención");
        }
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
       GUILOGIN abrir = new GUILOGIN(categoryService,productService,shoppingCartService);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLbRol;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel jblContrasenia;
    private javax.swing.JLabel jlbalCorreo;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables

    
    public boolean ValidarUsuario(String email, String password,String rol){
        String CorreoAdmi="mAcosta@gmail.com";
        String passwordAdmi ="12345";
        String editor="Editor";
        
        String Correo1="jCaicedo@gmail.com";
        String passwordAdmi1 ="sonic";
        String Admi="Administrador";
        
        if(CorreoAdmi.equals(email)&&passwordAdmi.equals(password)&& editor.equals(rol)){
            if(rol.equalsIgnoreCase("Administrador")){
                GUIMENUPRINCIPAL abrir = new GUIMENUPRINCIPAL(categoryService,productService,shoppingCartService);
                abrir.setVisible(true);
                this.setVisible(false);   
            }
            if(rol.equalsIgnoreCase("Editor")){
                 Messages.showMessageDialog("En construcción,Proximamente", "Atencion");
            }
             return true;
        }else if(Correo1.equals(email)&&passwordAdmi1.equals(password)&& Admi.equals(rol)){
            
            if(rol.equalsIgnoreCase("Administrador")){
                GUIMENUPRINCIPAL abrir = new GUIMENUPRINCIPAL(categoryService,productService,shoppingCartService);
                abrir.setVisible(true);
                this.setVisible(false);   
            }
            if(rol.equalsIgnoreCase("Editor")){
                 Messages.showMessageDialog("En construcción,Proximamente", "Atencion");
            } 
            return true;
        }
        return false;
}

}

