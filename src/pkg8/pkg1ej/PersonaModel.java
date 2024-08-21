/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg8.pkg1ej;
import javax.swing.DefaultListModel;

public class PersonaModel extends DefaultListModel<Persona> {
    public PersonaModel() {
        super();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append(get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}
