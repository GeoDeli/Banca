/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package OOP;

import java.util.List;

/**
 *
 * @author delim
 */
public interface ClientInterface {
      public void save(Client students);
    public void update(Client students);
    public void delete(int id);
    public Client get(int id);
     public Client getWithCNP(String cnp);
     public Client autentificare(int id, String cnp);
    public List<Client> list();
}
