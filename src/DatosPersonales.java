import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class DatosPersonales extends JFrame {
    private JPanel JpanelDatos;
    private JTextField JtextFieldPNombre;
    private JTextField JtextFieldSNombre;
    private JTextField JtextFieldPApellido;
    private JTextField JtextFieldSApellido;
    private JComboBox JcomboBoxGenero;
    private JButton JbuttonMostrar;
    private JButton JButtonLimpiar;
    private JRadioButton JradioSoltero;
    private JRadioButton JradioCasado;
    private JCheckBox JcheckboxTieneHijos;



    public DatosPersonales()  {
        setContentPane(JpanelDatos);
        setTitle("Bienvenido a Datos Personales");
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        JbuttonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDatos();
            }
        });
        JButtonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });

        ButtonGroup estadoCivilGroup = new ButtonGroup();
        JradioSoltero = new JRadioButton("Soltero");
        JradioCasado = new JRadioButton("Casado");
        estadoCivilGroup.add(JradioSoltero);
        estadoCivilGroup.add(JradioCasado);

        JcheckboxTieneHijos = new JCheckBox("Tiene hijos");

        JpanelDatos.add(JradioSoltero);
        JpanelDatos.add(JradioCasado);
        JpanelDatos.add(JcheckboxTieneHijos);
    }

    //Método que permita mostrar los datos formulario
    private void mostrarDatos(){
        String pnombre="";
        String snombre ="";
        String papellido="";
        String sapellido="";
        String genero="";
        String estadoCivil = mostrarEstadoCivil();
        boolean tieneHijos = JcheckboxTieneHijos.isSelected();

        pnombre = JtextFieldPNombre.getText();
        snombre = JtextFieldSNombre.getText();
        papellido = JtextFieldPApellido.getText();
        sapellido = JtextFieldSApellido.getText();
        genero = mostrarGenero();

        JOptionPane.showMessageDialog(null, "El nombre completo de la persona es:\n"+ pnombre+" " +
                ""+snombre+" "+papellido+" "+sapellido+"\n" +
                " Su genero es:"+" "+ genero);
        limpiar();

        String mensaje = "El nombre completo de la persona es:\n" +
                pnombre + " " + snombre + " " + papellido + " " + sapellido + "\n" +
                "Su genero es: " + genero + "\n" +
                "Estado civil: " + estadoCivil + "\n" +
                "Tiene hijos: " + (tieneHijos ? "Sí" : "No");

        JOptionPane.showMessageDialog(null, mensaje);
        limpiar();

    }

    //Método Para cualquier combobox // genero
    private String mostrarGenero(){
        String msj="";
        int gen =0;
        gen = JcomboBoxGenero.getSelectedIndex();

        if(gen ==0){
            JOptionPane.showMessageDialog(null, "Seleccione la opción correcta");
        }else if(gen == 1){
            msj = "Femenino";
        }else if(gen == 2){
            msj = "Masculino";
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione algo por fa vo");
        }
        return msj;
    }

    ///Metodo de limpiar
    private void limpiar(){
        JtextFieldPNombre.setText("");
        JtextFieldSNombre.setText("");
        JtextFieldPApellido.setText("");
        JtextFieldSApellido.setText("");

        // Limpiar los radio buttons y el checkbox
        JradioSoltero.setSelected(false);
        JradioCasado.setSelected(false);
        JcheckboxTieneHijos.setSelected(false);

        JcomboBoxGenero.setSelectedIndex(0);
    }

    // Método para obtener el estado civil seleccionado
    private String mostrarEstadoCivil() {
        if (JradioSoltero.isSelected()) {
            return "Soltero";
        } else if (JradioCasado.isSelected()) {
            return "Casado";
        } else {
            return "No especificado";
        }
    }

    //Método ejecución
    public static void main(String[] args) {
        DatosPersonales d = new DatosPersonales();
    }


}
