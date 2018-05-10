
package principal;


public interface AccionesFuncionario {
    
    public boolean existe(String rut);
    public boolean agregarLista(String nombre,String rut,String sexo);
    public boolean eliminarLista(String rut);
    public Funcionario buscar(String rut );
    public boolean modificar(String nombre, String rut, String sexo);    
    
}
