package es.altair.hibernate.dao;

import java.util.List;

import es.altair.hibernate.bean.Cliente;

public interface ClienteDAO {
	public void guardar(Cliente c);
	public List<Cliente> listarClientes();
	public Cliente get(int id); 
	public void update(Cliente id);
	public void delete(Cliente id);
	public void mostrarClientesPaginacion(int tamayo);
}
