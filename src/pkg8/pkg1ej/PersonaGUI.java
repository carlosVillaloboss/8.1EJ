package pkg8.pkg1ej;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonaGUI extends JFrame {
    private JTextField nombreField, apellidosField, direccionField, telefonoField;
    private JList<String> listaPersonas;
    private DefaultListModel<String> modeloLista;
    private JButton agregarButton, eliminarButton, eliminarTodosButton;
    
    public PersonaGUI() {
        setTitle("Gestión de Personas");
        setSize(500, 300);  // Aumenta el tamaño de la ventana si es necesario
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        
        // Crear componentes
        nombreField = new JTextField(20);  // Aumenta el número de columnas
        apellidosField = new JTextField(20);  // Aumenta el número de columnas
        direccionField = new JTextField(20);  // Aumenta el número de columnas
        telefonoField = new JTextField(20);  // Aumenta el número de columnas
        
        modeloLista = new DefaultListModel<>();
        listaPersonas = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaPersonas);
        
        agregarButton = new JButton("Agregar");
        eliminarButton = new JButton("Eliminar");
        eliminarTodosButton = new JButton("Eliminar Todos");
        
        // Configurar Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Permite que los componentes se expandan horizontalmente
        
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.gridwidth = 2;  // Ocupa dos columnas
        add(nombreField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 1;  // Restablece el ancho de columna
        add(new JLabel("Apellidos:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.gridwidth = 2;  // Ocupa dos columnas
        add(apellidosField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Dirección:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.gridwidth = 2;  // Ocupa dos columnas
        add(direccionField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.gridwidth = 2;  // Ocupa dos columnas
        add(telefonoField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.gridwidth = 1;  // Restablece el ancho de columna
        add(agregarButton, gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        add(eliminarButton, gbc);
        gbc.gridx = 2; gbc.gridy = 4;
        add(eliminarTodosButton, gbc);
        
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;  // Permite que el componente se expanda en ambas direcciones
        add(scrollPane, gbc);
        
        // Configurar ActionListeners
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPersona();
            }
        });
        
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPersona();
            }
        });
        
        eliminarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarTodasPersonas();
            }
        });
    }
    
    private void agregarPersona() {
        String nombre = nombreField.getText();
        String apellidos = apellidosField.getText();
        String direccion = direccionField.getText();
        String telefono = telefonoField.getText();
        
        if (nombre.isEmpty() || apellidos.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }
        
        String persona = String.format("%s %s, %s, %s", nombre, apellidos, direccion, telefono);
        modeloLista.addElement(persona);
        
        // Limpiar campos
        nombreField.setText("");
        apellidosField.setText("");
        direccionField.setText("");
        telefonoField.setText("");
    }
    
    private void eliminarPersona() {
        int indiceSeleccionado = listaPersonas.getSelectedIndex();
        if (indiceSeleccionado != -1) {
            modeloLista.remove(indiceSeleccionado);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una persona para eliminar.");
        }
    }
    
    private void eliminarTodasPersonas() {
        modeloLista.removeAllElements();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PersonaGUI().setVisible(true);
            }
        });
    }
}
