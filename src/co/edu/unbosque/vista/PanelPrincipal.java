package co.edu.unbosque.vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta clase representa un panel principal en la interfaz gráfica.
 * Extiende de JPanel y contiene botones y una imagen.
 */
/**
 * Esta clase representa el panel principal de la aplicación.
 * Extiende de JPanel y contiene botones y una imagen.
 */
public class PanelPrincipal extends JPanel {

    private JLabel img;
    private JButton btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7;

    /**
     * Constructor de la clase.
     * Inicializa el panel principal y configura los componentes.
     */
    public PanelPrincipal() {
        setBounds(5, 5, 800, 800);
        setVisible(true);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        // Configuración del botón 1
        btn_1 = new JButton();
        btn_1.setVisible(true);
        configurarBotonTransparente(btn_1);
        btn_1.setActionCommand("1");
        btn_1.setBounds(30, 450, 180, 50);
        add(btn_1);

        // Configuración del botón 2
        btn_2 = new JButton();
        configurarBotonTransparente(btn_2);
        btn_2.setVisible(true);
        btn_2.setActionCommand("2");
        btn_2.setBounds(30, 520, 180, 50);
        add(btn_2);

        // Configuración del botón 3
        btn_3 = new JButton();
        btn_3.setVisible(true);
        configurarBotonTransparente(btn_3);
        btn_3.setActionCommand("3");
        btn_3.setBounds(30, 590, 180, 50);
        add(btn_3);

        // Configuración del botón 4
        btn_4 = new JButton();
        btn_4.setVisible(true);
        configurarBotonTransparente(btn_4);
        btn_4.setActionCommand("4");
        btn_4.setBounds(30, 660, 180, 50);
        add(btn_4);

        // Configuración del botón 5
        btn_5 = new JButton();
        btn_5.setVisible(true);
        configurarBotonTransparente(btn_5);
        btn_5.setActionCommand("5");
        btn_5.setBounds(280, 465, 250, 50);
        add(btn_5);

        // Configuración del botón 6
        btn_6 = new JButton();
        btn_6.setVisible(true);
        configurarBotonTransparente(btn_6);
        btn_6.setActionCommand("6");
        btn_6.setBounds(280, 540, 250, 50);
        add(btn_6);

        // Configuración del botón 7
        btn_7 = new JButton();
        btn_7.setVisible(true);
        configurarBotonTransparente(btn_7);
        btn_7.setActionCommand("7");
        btn_7.setBounds(280, 610, 275, 50);
        add(btn_7);

        // Configuración de la imagen
        img = new JLabel();
        img.setBounds(0, 0, 640, 800);
        img.setVisible(true);
        img.setIcon(new ImageIcon("images\\img_1.gif"));
        add(img);

    }

    // * Configura un botón para que sea transparente, es decir, sin fondo, sin área
    // de contenido y sin borde pintado.
    // *
    // * @param btn el botón a configurar
    // */
    private void configurarBotonTransparente(JButton btn) {
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);

    }

}

    /**
     * @return JLabel
     */
    public JLabel getImg() {
        return img;
    }

    public void setImg(JLabel img) {
        this.img = img;
    }

    public JButton getBtn_1() {
        return btn_1;
    }

    public void setBtn_1(JButton btn_1) {
        this.btn_1 = btn_1;
    }

    public JButton getBtn_2() {
        return btn_2;
    }

    public void setBtn_2(JButton btn_2) {
        this.btn_2 = btn_2;
    }

    public JButton getBtn_3() {
        return btn_3;
    }

    public void setBtn_3(JButton btn_3) {
        this.btn_3 = btn_3;
    }

    public JButton getBtn_4() {
        return btn_4;
    }

    public void setBtn_4(JButton btn_4) {
        this.btn_4 = btn_4;
    }

    public JButton getBtn_5() {
        return btn_5;
    }

    public void setBtn_5(JButton btn_5) {
        this.btn_5 = btn_5;
    }

    public JButton getBtn_6() {
        return btn_6;
    }

    public void setBtn_6(JButton btn_6) {
        this.btn_6 = btn_6;
    }

    public JButton getBtn_7() {
        return btn_7;
    }

    public void setBtn_7(JButton btn_7) {
        this.btn_7 = btn_7;
    }

}
