package es.altair.hibernate.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import es.altair.hibernate.bean.Cliente;
import es.altair.hibernate.bean.Coches;
import es.altair.hibernate.bean.CochesRevisiones;
import es.altair.hibernate.bean.Revision;
import es.altair.hibernate.dao.ClienteDAO;
import es.altair.hibernate.dao.ClienteDAOImplHibernate;
import es.altair.hibernate.dao.CocheDAOImplHibernate;
import es.altair.hibernate.dao.CochesDAO;
import es.altair.hibernate.dao.CochesRevisionDAO;
import es.altair.hibernate.dao.CochesRevisionDAOImplHibernate;
import es.altair.hibernate.dao.RevisionDAO;
import es.altair.hibernate.dao.RevisionDAOImplHibernate;


public class App 
{
	private static Scanner sc = new Scanner(System.in);
	public static ClienteDAO clienteDAO = new ClienteDAOImplHibernate(); 
	public static CochesDAO cochesDAO = new CocheDAOImplHibernate(); 
	public static RevisionDAO revisionDAO = new RevisionDAOImplHibernate();
	public static CochesRevisionDAO cochesRevisionDAO = new CochesRevisionDAOImplHibernate();
	
	public static List<Cliente> clientes = null;
	public static List<Coches> coches = null;
	public static List<Revision> revisiones = null;
	public static List<CochesRevisiones> cochesRevisiones = null;
	public static List<Object[]> cochesRevisionesPorCoches = new ArrayList<Object[]>() ;

	
    public static void main( String[] args )
    {
    	String nombreCliente, apellidosClientes, dniClientes , matricula; 

    	int opcion = -1;
    	do {
			System.out.println("\t\t\t\t╔════════════════════════════╗");
	        System.out.println("\t\t\t\t║            MENU            ║");
	        System.out.println("\t\t\t\t╠════════════════════════════╣");
	        System.out.println("\t\t\t\t║                            ║");
	        System.out.println("\t\t\t\t║    1.- Cliente      	     ║");
	        System.out.println("\t\t\t\t║                      	     ║");
	        System.out.println("\t\t\t\t║    2.- Coches              ║");
	        System.out.println("\t\t\t\t║                            ║");
	        System.out.println("\t\t\t\t║    3.- Revisiones	     ║");
	        System.out.println("\t\t\t\t║                            ║");
	        System.out.println("\t\t\t\t║    4.- Coche y Revision    ║");
	        System.out.println("\t\t\t\t║                            ║");
	        System.out.println("\t\t\t\t╠════════════════════════════╣");
	        System.out.println("\t\t\t\t║                            ║");
	        System.out.println("\t\t\t\t║       0) Salir             ║");
	        System.out.println("\t\t\t\t║                            ║");
	        System.out.println("\t\t\t\t╚════════════════════════════╝");
	           
	        System.out.print("\t\t\t\tEscribe una de las opciones: ");
	        opcion = sc.nextInt();
	        
	       
	        switch (opcion) {
	        	
	        	 case 1: // Clientes
	        		int opcion1 = -1;
	            	do {
	            		System.out.println("\t\t\t\t╔═════════════════════════════╗");
	        	        System.out.println("\t\t\t\t║          CLIENTES           ║");
	        	        System.out.println("\t\t\t\t╠═════════════════════════════╣");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    1.- Añadir Cliente       ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    2.- Mostrar Clientes     ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    3.- Actualizar Cliente   ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    4.- Eliminar             ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t╠═════════════════════════════╣");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║          0) Salir           ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t╚═════════════════════════════╝");
	        	           
	        	        System.out.print("\t\t\t\tEscribe una de las opciones: ");
	        	        opcion1 = sc.nextInt();
	        	        
	        	       
	        	        switch (opcion1) {
	        	        	
	        	        	case 1: // Añadir Cliente
	        	        		System.out.println("\t\t\t\t----------------- Añadir Cliente ------------------");
	        	        		
	        	        		System.out.print("\t\t Nombre: ");
	        	        		nombreCliente = sc.next();
	        	        		
	        	        		System.out.println("\t\t Apellidos: ");
	        	        		apellidosClientes = sc.next(); 
	        	        		
	        	        		System.out.println("\t\t DNI: ");
	        	        		dniClientes = sc.next();
	        	        		
	        	        		Cliente cliente1 = new Cliente(nombreCliente, apellidosClientes, dniClientes);
	        	        		
	        	        		clienteDAO.guardar(cliente1);
	        	        		System.out.println("\t\t\t\t----------------------------------------------------");
	        	        		break;
	        	        	case 2: // Mostrar Clientes
	        	        		mostrarClientes();
	        	        		break;
	        	        	case 3: // Actualizar Cliente
	        	        		mostrarClientes();
	        	        		System.out.print("\t\tElije un cliente a editar: (Solo ID)");
	        	        		int idCliente = sc.nextInt();
	        	        		
	        	        		System.out.print("\t\t Nombre: ");
	        	        		nombreCliente = sc.next();
	        	        		
	        	        		System.out.println("\t\t Apellidos: ");
	        	        		apellidosClientes = sc.next(); 
	        	        		
	        	        		System.out.println("\t\t DNI: ");
	        	        		dniClientes = sc.next();
	        	        		
	        	        		Cliente clienteEditar = clienteDAO.get(idCliente);
	        	        		clienteEditar.setNombre(nombreCliente);
	        	        		clienteEditar.setApellidos(apellidosClientes);
	        	        		clienteEditar.setDni(dniClientes);
	        	        		
	        	        		clienteDAO.update(clienteEditar);
	        	        		break;
	        	        	case 4: // Eliminar 
	        	        		mostrarClientes();
	        	        		System.out.print("\t\tElije un cliente a editar: (Solo ID)");
	        	        		int idClienteDelete = sc.nextInt();
	        	        		Cliente clienteDelete = clienteDAO.get(idClienteDelete);
	        	        		clienteDAO.delete(clienteDelete);
	        	        		break;
	        	        }
	        	        
	            	} while (opcion1 != 0);
	        		break;
	        	
	        	case 2:  // Coches 
	        		int opcion2 = -1;
	            	do {
	            		System.out.println("\t\t\t\t╔═════════════════════════════╗");
	        	        System.out.println("\t\t\t\t║           COCHES            ║");
	        	        System.out.println("\t\t\t\t╠═════════════════════════════╣");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    1.- Añadir Coche         ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    2.- Mostrar Coche        ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    3.- Actualizar Coche     ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    4.- Eliminar  Coche      ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t╠═════════════════════════════╣");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║          0) Salir           ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t╚═════════════════════════════╝");
	        	           
	        	        System.out.print("\t\t\t\tEscribe una de las opciones: ");
	        	        opcion2 = sc.nextInt();
	        	        
	        	        switch (opcion2) {
						case 1:// Añadir Coche
							System.out.print("\t\t Matricula: ");
        	        		matricula = sc.next();
        	        		
        	        		
        	        		mostrarClientes();
        	        		System.out.println("\t\t Seleccione un cliente (ID): ");
        	        		int id = sc.nextInt();
        	        		
        	        		Cliente cliente = clienteDAO.get(id);
        	        		
        	        		Coches cochesAnadir = new Coches(matricula, cliente);
        	        		cochesDAO.guardar(cochesAnadir);
							break;
						case 2: // Mostrar Coche
							mostrarCoches();
							break; 
						case 3: // Actualizar Coche
							mostrarCoches();
							
							System.out.print("\t\t Seleccione un coche (ID): ");
        	        		int id2 = sc.nextInt();
        	        		
        	        		Coches c = cochesDAO.get(id2);
        	        		System.out.print("\t\t Indique la nueva Matricula: ");
        	        		String matricula2 = sc.next();
        	        		c.setMatricula(matricula2);
        	        		cochesDAO.update(c);
        	        		mostrarCoches();
							break;
						case 4: // Eliminar  Coche
							mostrarCoches();
							System.out.print("\t\t Seleccione un coche (ID): ");
        	        		int id3 = sc.nextInt();
        	        		
        	        		Coches c3 = cochesDAO.get(id3);
        	        		cochesDAO.delete(c3);
							
							break;

						}
	            	}while(opcion2 != 0); 
	        		break; 
	        	case 3: // Revisiones
	        		int opcion3 = -1;
	            	do {
	            		System.out.println("\t\t\t\t╔═════════════════════════════╗");
	        	        System.out.println("\t\t\t\t║          REVISIÓN           ║");
	        	        System.out.println("\t\t\t\t╠═════════════════════════════╣");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    1.- Añadir Revisión      ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    2.- Mostrar Revisión     ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    3.- Actualizar Revisión  ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    4.- Eliminar  Revisión   ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t╠═════════════════════════════╣");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║          0) Salir           ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t╚═════════════════════════════╝");
	        	           
	        	        System.out.print("\t\t\t\tEscribe una de las opciones: ");
	        	        opcion3 = sc.nextInt();
	        	        
	        	        switch (opcion3) {
						case 1:// Añadir Revisión
							System.out.println("\t\t\t\t----------------- Añadir Revision ------------------");
							
							System.out.print("\t\tIndique el nombre: ");
							String nombreR = sc.next();
							
							System.out.print("\t\tIndique el tipo: ");
							String tipoR = sc.next();
							
							Revision revisionNueva = new Revision(nombreR, tipoR);
							revisionDAO.save(revisionNueva);
							System.out.println("\t\t\t\t----------------------------------------------------");

						case 2: // Mostrar Revisión
							mostrarRevisiones();
							
							break; 
						case 3: // Actualizar Revisión
							mostrarRevisiones();
							
							System.out.print("\t\t Seleccione una revision (ID): ");
        	        		int id = sc.nextInt();
        	        		
        	        		Revision r = revisionDAO.get(id);
        	        		
        	        		System.out.print("\t\t Indique el nombre nuevo: ");
        	        		String nombreNuevo = sc.next(); 
        	        		System.out.print("\t\t Indique el tipo nuevo: ");
        	        		String tipoNuevo = sc.next(); 

        	        		r.setNombre(nombreNuevo);
        	        		r.setTipo(tipoNuevo);
        	        		
        	        		revisionDAO.update(r);
        	        		mostrarRevisiones();
							break;
						case 4: // Eliminar Revisión
							mostrarRevisiones();
							
							System.out.print("\t\t Seleccione una revision (ID): ");
        	        		int idDelete = sc.nextInt();
        	        		
        	        		Revision rDelete = revisionDAO.get(idDelete); 
        	        		revisionDAO.delete(rDelete);
        	        		mostrarRevisiones();
							break;

						}
	            	}while(opcion3 != 0); 
	        		break;
	        	case 4: // CochesRevision
	        		int opcion4 = -1;
	            	do {
	            		System.out.println("\t\t\t\t╔═════════════════════════════╗");
	        	        System.out.println("\t\t\t\t║      CochesRevision         ║");
	        	        System.out.println("\t\t\t\t╠═════════════════════════════╣");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    1.- Añadir               ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    2.- Mostrar              ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    3.- Actualizar           ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║    4.- Eliminar             ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t╠═════════════════════════════╣");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t║          0) Salir           ║");
	        	        System.out.println("\t\t\t\t║                             ║");
	        	        System.out.println("\t\t\t\t╚═════════════════════════════╝");
	        	           
	        	        System.out.print("\t\t\t\tEscribe una de las opciones: ");
	        	        opcion4 = sc.nextInt();
	        	        
	        	        switch (opcion4) {
						case 1:// Añadir CochesRevision
								mostrarCoches();
								System.out.print("\t\t Seleccione un coche (ID): ");
	        	        		int idCoche = sc.nextInt();
	        	        		Coches c = cochesDAO.get(idCoche);
	        	        		
	        	        		mostrarRevisiones();
	        	        		System.out.print("\t\t Seleccione una revision (ID): ");
	        	        		int idRevision = sc.nextInt();
	        	        		Revision r = revisionDAO.get(idRevision);
	        	        		
	        	        		System.out.print("\t\t Fecha (AA/MM/DD): ");
	        	        		String fechaS = sc.next(); 
	        	        		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	        	                Date fecha = null;
	        	                String date = fechaS;
	        	                try{
	        	                    fecha = df.parse(date);	
	        	                } catch (Exception e){ System.out.println("invalid format");
	        	                }
	        	        		System.out.print("\t\t Kilometros: ");
	        	        		String kilometros = sc.next();
	        	        		
	        	        		CochesRevisiones cochesRevisiones = new CochesRevisiones(c, r, fecha, kilometros);
	        	        		
	        	        		cochesRevisionDAO.guardar(cochesRevisiones);
							
							break;
							
						case 2: // Mostrar CochesRevision
							mostrarCochesRevisiones();
							break; 
						case 3: // Actualizar CochesRevision
							mostrarCochesRevisiones(); 
							System.out.print("\t\t Seleccione una registro (ID): ");
        	        		int id = sc.nextInt();
        	        		
        	        		CochesRevisiones cR = cochesRevisionDAO.get(id);
        	        		
        	        		mostrarCoches();
							System.out.print("\t\t Seleccione un coche (ID): ");
        	        		int idCoche2 = sc.nextInt();
        	        		Coches c2 = cochesDAO.get(idCoche2);
        	        		cR.setCoche(c2);
        	        		
							mostrarRevisiones();
							System.out.print("\t\t Seleccione una revision (ID): ");
				        	int idRevision2 = sc.nextInt();
				        	Revision r2 = revisionDAO.get(idRevision2);
				        	cR.setRevision(r2);
				        	
				        	System.out.print("\t\t Fecha (AA/MM/DD): ");
        	        		String fechaSdos = sc.next(); 
        	        		SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
        	                Date fecha2 = null;
        	                String date2 = fechaSdos;
        	                try{
        	                    fecha2 = df2.parse(date2);	
        	                } catch (Exception e){ System.out.println("invalid format");
        	                }
        	                cR.setFecha(fecha2);
        	                
        	                System.out.print("\t\t Kilometros: ");
        	                String kilometrosA = sc.next();
        	                cR.setKilometros(kilometrosA);
        	                
        	                cochesRevisionDAO.update(cR);
        	                mostrarCochesRevisiones();
							break;
						case 4: // Eliminar CochesRevisiones
							mostrarCochesRevisiones();
							System.out.print("\t\t Seleccione una registro (ID): ");
        	        		int idDelete = sc.nextInt();
        	        		
        	        		CochesRevisiones cDelete = cochesRevisionDAO.get(idDelete);
        	        		cochesRevisionDAO.delete(cDelete);
        	        		mostrarCochesRevisiones();
							break;
						

						}
	            	}while(opcion4 != 0); 
	        		break;
	        }
	        
    	} while (opcion != 0);
    	
    }
    private static void mostrarClientes() {
    	clientes = clienteDAO.listarClientes();
		System.out.println("\t\t\t\t----------------- Mostrar Cliente ------------------");

		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
		System.out.println("\t\t\t\t----------------------------------------------------");
    }
    private static void mostrarCoches() {
    	coches = cochesDAO.listarCoches(); 
		System.out.println("\t\t\t\t----------------- Mostrar Coches ------------------");
		
		for (Coches  coche : coches) {
			System.out.println("\t\t\t\t\t\t    " + coche.getIdCoches() + ")" + coche.getMatricula());
		}
		
		System.out.println("\t\t\t\t----------------------------------------------------");

    }
    private static void mostrarRevisiones() {
    	revisiones = revisionDAO.listarRevisiones(); 
    	System.out.println("\t\t\t\t----------------- Mostrar Revisiones ------------------");
    	for (Revision revision : revisiones) {
			System.out.println("\t\t\t\t\t" + revision.getIdRevisiones()  + ") "+ revision.getNombre() + "-> " + revision.getTipo());
		}
    	System.out.println("\t\t\t\t-------------------------------------------------------");

    }
    private static void mostrarCochesRevisiones() {
    	cochesRevisiones = cochesRevisionDAO.listaCochesRevision(); 
    	
    	System.out.println("\t\t\t\t----------------- Mostrar Coches Revisiones ------------------");
    	System.out.println("\t\t\t\tID MATRICULA KILOMETROS     FECHA      \t     REVISIONES");
    	for (CochesRevisiones cR : cochesRevisiones) {
    		
    		
			System.out.println("\t\t\t\t"+ cR.getIdCochesRevisiones()+")  "+cR.getCoche().getMatricula() + "   " +  cR.getKilometros() + "      "+  cR.getFecha() + "\t"+ cR.getRevision().getNombre());
		}
    	System.out.println("\t\t\t\t-------------------------------------------------------");

    }
}
