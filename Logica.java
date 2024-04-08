package biblioteca;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
public class Logica {
	private static final int DURACION_PENALIZACION = 7;
	
	protected static void Menuser(ArrayList<Persona> personas, ArrayList<Articulo> articulos,  ArrayList<Prestamo> prestamos) {
		int opcion;
		Scanner sc = new Scanner (System.in);
		 do { 
			 System.out.println("¡Hola! Bienvenido a la Bilioteca");
			 System.out.println("Opcion 1: Soy Administrador");
			 System.out.println("Opcion 2: Soy usuario");
			 System.out.println("Opcion 3: Salir");
			 System.out.println("Seleccina una opcion:");
			 opcion=sc.nextInt();
			 
			 switch (opcion) {
			 case 1:  verificarAdmin(personas, articulos, prestamos);
				 break;
			 case 2: verificarUser(personas, articulos, prestamos);
				 break;
			 case 3: System.out.println("Hasta luego.");
				 break;
				 default:  System.out.println("Por favor selecciona una opcion valida.");
			 
			 	}	 
			 }while(opcion!=3);	
		}
	protected static void verificarAdmin(ArrayList<Persona> personas, ArrayList<Articulo> articulos, ArrayList<Prestamo> prestamos) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Verificar Administrador, por favor introduce tu usuario y contraseña");
		System.out.println("Usuario:");
		String username = sc.nextLine().trim();
		System.out.print("Contraseña: ");
	    String password = sc.nextLine().trim();
	    for (Persona persona : personas) {
	        if (persona instanceof Admin) { 
	            Admin admin = (Admin) persona;            
	            if (admin.getUser().equals(username) && admin.password.equals(password)) {
	                System.out.println("Inicio de sesión exitoso como administrador.");
	                optionAdmin (personas, articulos, prestamos);              
	                return; 
	            }
	        }
	    }

	    System.out.println("Nombre de usuario o contraseña incorrectos.");
	}	
	protected static void optionAdmin (ArrayList<Persona> personas, ArrayList<Articulo> articulos,  ArrayList<Prestamo> prestamos) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		 do { 
			 System.out.println("Bienvenido Administrador, que deseas hacer?");
			 System.out.println("Opcion 1: Crear nuevo usuario");
			 System.out.println("Opcion 2: Ver usuarios creados ");
			 System.out.println("Opcion 3: Ver prestamos de un cliente");
			 System.out.println("Opcion 4: Menu articulos");
			 System.out.println("Opcion 0: Regresar al menu anterior ");
			 System.out.println("Seleccina una opcion:");
			 opcion=sc.nextInt();
			 
			 switch (opcion) {
			 case 1:  newuser (personas);
				 break;
			 case 2: verUsers (personas);
				 break;
			 case 3: verPrestamosCliente(prestamos);
			 	break;
			 case 4: Menuarticulos (articulos);
				 break;
			 case 0: return;
				 default:  System.out.println("Por favor selecciona una opcion valida.");
			 
			 	}	 
			 }while(opcion!=3);	
		}
	protected static void newuser(ArrayList<Persona> personas) {
	    String newUser;
	    String newPassword;
	    String newName;
	    boolean datosValidos = false;
	    Scanner sc = new Scanner(System.in);
	    do {
	        System.out.println("Ingresa el ID del usuario que deseas crear:");
	        newUser = sc.nextLine().trim();
	        System.out.println("Ingresa la contraseña:");
	        newPassword = sc.nextLine().trim();
	        System.out.println("Ingresa el nombre del usuario:");
		    newName = sc.nextLine().trim();
	        if (!newUser.isEmpty() && !newPassword.isEmpty() && !newName.isEmpty()) {
	            boolean nombreUsuarioValido = true;
	            for (Persona persona : personas) {
	                if (persona instanceof User && ((User) persona).getUser().equals(newUser)) {
	                    System.out.println("El nombre de usuario ya está en uso. Por favor, elige otro nombre de usuario.");
	                    nombreUsuarioValido = false;
	                    break;
	                }
	            }
	            if (nombreUsuarioValido) {
	                datosValidos = true;
	            }
	        } else {
	            System.out.println("El ID de usuario y la contraseña no pueden estar vacíos. Por favor, inténtalo nuevamente.");
	        }
	    } while (!datosValidos);   
	    User nuevoUsuario = new User(newUser, newPassword, newName);
	    personas.add(nuevoUsuario);
	    System.out.println("Usuario creado exitosamente.");
	}
	protected static void verUsers (ArrayList<Persona> personas) {
		Scanner sc = new Scanner (System.in);
		 System.out.println("Ingresa el ID del usuario a consultar");
		 String userConsulta= sc.nextLine().trim();
		 for (Persona persona : personas) {
			 if (persona instanceof User && ((User) persona).getUser().equals(userConsulta)) {
		            System.out.println("Usuario encontrado:");
		            System.out.println(persona);
		            break;
			 		}
			 else { System.out.println("Usuario no encontrado, volviendo al menu de opciones");
			 }
		 }
	}
	protected static void Menuarticulos (ArrayList<Articulo> articulos) {
		Scanner sc = new Scanner (System.in);
		 int opcion;
		 do { 
			 System.out.println("Bienvenido al menu de articulos, que deseas hacer");
			 System.out.println("Opcion 1: Dar de alta un nuevo articulo(Libros, revistas o peliculas)");
			 System.out.println("Opcion 2: Modificar un articulo (Libro, revistas o peliiculas)");
			 System.out.println("Opcion 3: Dar de baja un articulo(Libro, revistas o peliculas)");
			 System.out.println("Opcion 4: Consultar Stock y detalles de los articulos disponibles ");
			 System.out.println("Opcion 0: Regresar al menu anterior ");
			 System.out.println("Seleccina una opcion:");
			 opcion=sc.nextInt();
				switch(opcion) {
				case 1: altaArticulo (articulos);
					break;
				case 2: modificarArticulo (articulos);
					break;
				case 3:  bajaArticulo (articulos);
					break;
				case 4: consultarArticulos (articulos);
					break;
				default:  System.out.println("Por favor selecciona una opcion valida.");
				}
			 }while(opcion!=0);
		}
	protected static void altaArticulo (ArrayList<Articulo> articulos) {
		 Scanner sc = new Scanner(System.in);
		    int opcion;
		    do {
			    System.out.println("¿Qué tipo de artículo deseas dar de alta?");
		        System.out.println("1. Libro");
		        System.out.println("2. Revista");
		        System.out.println("3. Película");
		        System.out.println("0. Regresar al menú anterior");
		        System.out.print("Selecciona una opción: ");
		        opcion = sc.nextInt();
		        sc.nextLine(); 
		        
		        switch (opcion) {
		            case 1:
	            	System.out.println("Dar de alta un libro");
	                boolean libroExistente;
	                	do {
		                    libroExistente = false;
		                    System.out.print("ID del libro: ");
		                    int idLibro = sc.nextInt();
		                    sc.nextLine();
	                    for (Articulo articulo : articulos) {
	                        if (articulo.getIdarticulo() == idLibro) {
	                            libroExistente = true;
	                            System.out.println("El ID del libro ya está en uso. Por favor, elige otro ID.");
	                            break;
	                        }
	                    }	                    
	                    if (!libroExistente) {
	                        System.out.print("Nombre del libro: ");
	                        String nombreLibro = sc.nextLine();
	                        System.out.print("Género del libro: ");
	                        String generoLibro = sc.nextLine();
	                        System.out.print("Autor del libro: ");
	                        String autorLibro = sc.nextLine();
	                        libro nuevoLibro = new libro(idLibro, nombreLibro, generoLibro, autorLibro);
	                        articulos.add(nuevoLibro);
	                        System.out.println("Libro añadido con éxito.");
	                    	}
	                	 } while (libroExistente);
	                break;
	            case 2:
	                System.out.println("Dar de alta una revista");
	                boolean RevistaExistente;
	                do {
	                	RevistaExistente=false;
	                	System.out.print("ID de la Revista: ");
	                	int idRevista = sc.nextInt();
	                	sc.nextLine();
	                	for (Articulo articulo: articulos) {
	                		if( articulo.getIdarticulo()== idRevista) {
	                			RevistaExistente=true;
	                			System.out.println("El ID de la revista ya está en uso. Por favor, elige otro ID.");
	                			break;
	                		}
	                	}
	                	if (!RevistaExistente) {
	                        System.out.print("Nombre de la revista: ");
	                        String nombreRevista = sc.nextLine();
	                        System.out.print("Género de la revista: ");
	                        String generoRevista = sc.nextLine();
	                        System.out.print("Autor de la revista: ");
	                        String autorRevista = sc.nextLine();
	                        Revista nuevaRevista = new Revista(idRevista, nombreRevista, generoRevista, autorRevista);
	                        articulos.add(nuevaRevista);
	                        System.out.println("Revista añadida con éxito.");
	                    	}
	                }while(RevistaExistente);
	                break;
	            case 3:
	                System.out.println("Dar de alta una película"); 
	                boolean PeliculaExistente;
	                do {
	                 PeliculaExistente=false;
	                 System.out.print("ID de la Pelicula: ");
	                 int idPelicula = sc.nextInt();
	                	sc.nextLine();
	                	for (Articulo articulo: articulos) {
	                		if( articulo.getIdarticulo()== idPelicula) {
	                			PeliculaExistente=true;
	                			System.out.println("El ID de la Pelicula ya está en uso. Por favor, elige otro ID.");
	                			break;
	                		}
	                	}
	                	if (!PeliculaExistente) {
	                        System.out.print("Nombre de la Pelicula: ");
	                        String nombrePelicula = sc.nextLine();
	                        System.out.print("Género de la Pelicula: ");
	                        String generoPelicula = sc.nextLine();                    
	                        System.out.print("Director de la pelicula: ");
	                        String directorPelicula = sc.nextLine();
	                        Pelicula nuevaPelicula = new Pelicula (idPelicula, nombrePelicula, generoPelicula, directorPelicula);
	                        articulos.add(nuevaPelicula);
	                        System.out.println("Pelicula añadida con éxito.");
	                    	}
	                	}while (PeliculaExistente);
	                break;
	            case 0:
	                System.out.println("Volviendo al menú anterior...");
	                break;
	            default:
	                System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
	                break;
	        }	
		 }while(opcion!=0);
	 }
	protected static void modificarArticulo(ArrayList<Articulo> articulos) {
		 Scanner sc = new Scanner(System.in);
		 int opcion;
		 do {
			 System.out.println("¿Qué tipo de artículo deseas modificar?");
		     System.out.println("1. Libro");
		     System.out.println("2. Revista");
		     System.out.println("3. Película");
		     System.out.println("0. Regresar al menú anterior");
		     System.out.print("Selecciona una opción: ");
		     opcion = sc.nextInt();
		     sc.nextLine(); 
				switch (opcion) {
				case 1:
					System.out.println("Modificar un libro");
					System.out.print("ID del libro a modificar: ");
					int idLibro = sc.nextInt();
					sc.nextLine();
					 for (Articulo articulo : articulos) {
		                    if (articulo instanceof libro && articulo.getIdarticulo() == idLibro) {
		                        System.out.print("Nuevo nombre del libro: ");
		                        String nuevoNombreLibro = sc.nextLine();
		                        ((libro) articulo).setNombre(nuevoNombreLibro);
		                        System.out.print("Nuevo género del libro: ");
		                        String nuevoGeneroLibro = sc.nextLine();
		                        ((libro) articulo).setGenero(nuevoGeneroLibro);
		                        System.out.print("Nuevo autor del libro: ");
		                        String nuevoAutorLibro = sc.nextLine();
		                        ((libro) articulo).setAutor(nuevoAutorLibro);
		                        System.out.println("Libro modificado correctamente.");
		                        return;
		                    }
		                }
		                System.out.println("No se encontró ningún libro con ese ID.");
		           break;
				case 2: 
					System.out.println("Modificar una revista");
					System.out.print("ID de la revista a modificar: ");
					int idRevista = sc.nextInt();
					sc.nextLine();
					for (Articulo articulo : articulos) {
	                    if (articulo instanceof Revista && articulo.getIdarticulo() == idRevista) {
	                        System.out.print("Nuevo nombre de la Revista: ");
	                        String nuevoNombreRevista = sc.nextLine();
	                        ((Revista) articulo).setNombre(nuevoNombreRevista);
	                        System.out.print("Nuevo genero de la revista: ");
	                        String nuevoGeneroRevista = sc.nextLine();
	                        ((Revista) articulo).setGenero(nuevoGeneroRevista);
	                        System.out.print("Nueva editorial de la revista: ");
	                        String nuevaEditorialRevista = sc.nextLine();
	                        ((Revista) articulo).setEditorial(nuevaEditorialRevista);
	                        System.out.println("Revista modificada correctamente.");
	                        return;
	                    }
	                }
	                System.out.println("No se encontró ninguna revista con ese ID.");
				case 3:
					System.out.println("Modificar una Pelicula");
					System.out.print("ID de la Pelicula a modificar: ");
					int idPelicula = sc.nextInt();
					sc.nextLine();
					for (Articulo articulo : articulos) {
						if (articulo instanceof Pelicula && articulo.getIdarticulo()== idPelicula) {
							System.out.print("Nuevo nombre de la Pelicula: ");
							String nuevoNombrePelicula = sc.nextLine();
							((Pelicula)articulo).setNombre(nuevoNombrePelicula);
							System.out.print("Nuevo Genero de la Pelicula: ");
							String nuevoGeneroPelicula = sc.nextLine();
							((Pelicula)articulo).setGenero(nuevoGeneroPelicula);
							System.out.print("Nuevo Director de la Pelicula: ");
							String nuevoDirectorPelicula = sc.nextLine();
							((Pelicula)articulo).setDirector(nuevoDirectorPelicula);
	                        System.out.println("Pelicula Modificada correctamente.");
	                        return;
						}
					}
				default:  System.out.println("Por favor selecciona una opcion valida.");
			}	
		 }while(opcion!=0);   
	}
	protected static void bajaArticulo (ArrayList<Articulo> articulos) {
		 Scanner sc = new Scanner(System.in);
		 int opcion;
		 do {
			 System.out.println("¿Qué tipo de artículo deseas dar de baja?");
		     System.out.println("1. Libro");
		     System.out.println("2. Revista");
		     System.out.println("3. Película");
		     System.out.println("0. Regresar al menú anterior");
		     System.out.print("Selecciona una opción: ");
		     opcion = sc.nextInt();
		     sc.nextLine(); 
			 switch(opcion) {
			 	case 1:  
			 		System.out.println("Eliminar un libro");
		            System.out.print("ID del libro a eliminar: ");
		            int idLibro = sc.nextInt();
		            sc.nextLine(); 
		            for (Articulo articulo : articulos) {
		                if (articulo instanceof libro && articulo.getIdarticulo() == idLibro) {
		                    articulos.remove(articulo);
		                    System.out.println("Libro eliminado correctamente.");
		                    return;
		                 }
		             }
		             System.out.println("No se encontró ningún libro con ese ID.");
						 break;
			 	case 2: 
			 		System.out.println("Eliminar una Revista");
			 		System.out.print("ID de la revista a eliminar: ");
			 		int idRevista= sc.nextInt();
			 		sc.nextLine();
			 		for (Articulo articulo : articulos) {
		 			if(articulo instanceof Revista && articulo.getIdarticulo()== idRevista) {
		 				articulos.remove(articulo);
		 				System.out.println("Revista eliminada correctamente.");
		                    return;
		 			}
		 		}
		 		System.out.println("No se encontró ninguna Revista con ese ID.");
			 		break;
			 	case 3:
			 		System.out.println("Eliminar una pelicula");
			 		System.out.print("ID de la pelicula a eliminar: ");
			 		int idPelicula= sc.nextInt();
			 		sc.nextLine();
			 		for (Articulo articulo : articulos) {
			 			if(articulo instanceof Pelicula && articulo.getIdarticulo()== idPelicula) {
			 				articulos.remove(articulo);
			 				System.out.println("Pelicula eliminada correctamente.");
			                    return;
			 			}
			 		}
			 		System.out.println("No se encontró ninguna Pelicula con ese ID.");
			 		break;
			 	case 0: 
			 		System.out.println("Regresar al menu anterior");
			 	default:  System.out.println("Por favor selecciona una opcion valida.");
			 		return;
					 }
		 }while(opcion!=0);
	}
	protected static void consultarArticulos(ArrayList<Articulo> articulos) {
	    System.out.println("Lista de artículos disponibles:");
	    for (Articulo articulo : articulos) {
	        System.out.println(articulo.toString());
	    }
	}
	
	protected static void verificarUser (ArrayList<Persona> personas, ArrayList<Articulo> articulos,  ArrayList<Prestamo> prestamos) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Verificar Usuario, por favor introduce tu usuario y contraseña");
		System.out.println("Usuario:");
		String username = sc.nextLine().trim();
		System.out.print("Contraseña: ");
	    String password = sc.nextLine().trim();
	    for (Persona persona : personas) {
	        if (persona instanceof User) { 
	            User user = (User) persona;            
	            if (user.getUser().equals(username) && user.password.equals(password)) {
	                System.out.println("Inicio de sesión exitoso como usuario.");
	                optionUser (user, personas, articulos, prestamos);              
	                return; 
	            }
	        }
	    }
	    System.out.println("Nombre de usuario o contraseña incorrectos.");
	}
	protected static void optionUser (User currentUser, ArrayList<Persona> personas, ArrayList<Articulo> articulos,  ArrayList<Prestamo> prestamos) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		do {
			 System.out.println("Bienvenido Usuario, que deseas hacer?");
			 System.out.println("Opcion 1: Hacer un prestamo");
			 System.out.println("Opcion 2: Devolver un prestamo");
			 System.out.println("Opcion 3: Ver prestamos activos");
			 System.out.println("Opcion 0: Regresar al menu anterior ");
			 System.out.println("Seleccina una opcion:");
			 opcion=sc.nextInt();
			 switch(opcion) {
			 case 1: prestarArticulo(currentUser, personas, articulos, prestamos);
				 break;
			 case 2: devolverPrestamo(currentUser, prestamos);
				 break;
			 case 3:  verPrestamos (currentUser, prestamos);
				 break;
			 case 0: 
				 return;
			 default:  System.out.println("Seleccina una opcion valida por favor:");
			 }
		}while(opcion!=0);
	}
	protected static void prestarArticulo(User currentUser, ArrayList<Persona> personas, ArrayList<Articulo> articulos, ArrayList<Prestamo> prestamos) {
	    Scanner sc = new Scanner(System.in);   
	    if (tienePrestamosActivos(currentUser, prestamos)) {
	        System.out.println("Tienes préstamos activos. No puedes realizar nuevos préstamos hasta devolver los anteriores.");
	        return;
	    }   
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());
	    calendar.add(Calendar.DAY_OF_MONTH, 7);
	    Date fechaDevolucion = calendar.getTime(); 
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    String fechaDevolucionStr = sdf.format(fechaDevolucion);
	    System.out.println("Artículos disponibles para préstamo:");
	    for (Articulo articulo : articulos) {
	        if (!articulo.isPrestado()) {
	            System.out.println(articulo.toString());
	        }
	    }
	    System.out.println("Ingresa el ID del artículo que deseas tomar prestado:");
	    int articleId = sc.nextInt();
	    sc.nextLine();
	    Articulo selectedArticle = null;
	    for (Articulo articulo : articulos) {
	        if (articulo.getIdarticulo() == articleId) {
	            selectedArticle = articulo;
	            break;
	        }
	    }
	    if (selectedArticle != null && !selectedArticle.isPrestado()) {
	        selectedArticle.setPrestado(true);   
	        Prestamo prestamo = new Prestamo(currentUser, selectedArticle, fechaDevolucionStr);
	        prestamos.add(prestamo);

	        System.out.println("El artículo ha sido prestado con éxito. Debes devolverlo antes del " + fechaDevolucionStr);
	    } else {
	        System.out.println("No se pudo encontrar el artículo seleccionado o ya está prestado.");
	    }
	}
	protected static User obtenerUsuarioActual(ArrayList<Persona> personas) {
	    for (Persona persona : personas) {
	        if (persona instanceof User) {
	            return (User) persona;
	        }
	    }
	    return null;
	}
	protected static boolean tienePrestamosActivos(User usuario, ArrayList<Prestamo> prestamos) {
		    for (Prestamo prestamo : prestamos) {
		        if (prestamo.getUsuario().equals(usuario) && prestamo.getFechaDevolucion() != null) {
		            if (!prestamo.isDevuelto()) {     
		                Date fechaActual = new Date();    
		                if (fechaActual.after(prestamo.getFechaDevolucion())) {		                 
		                    return true;
		                }
		            }
		        }
		    }
		return false;
	}
	protected static ArrayList<Prestamo> obtenerPrestamosActivos(User usuario, ArrayList<Prestamo> prestamos) {
		    ArrayList<Prestamo> prestamosActivos = new ArrayList<>();
		    for (Prestamo prestamo : prestamos) {
		        if (prestamo.getUsuario().equals(usuario) && !prestamo.isDevuelto()) {
		            prestamosActivos.add(prestamo);
		        }
		    }
		    return prestamosActivos;
		}
	protected static void verPrestamos(User currentUser, ArrayList<Prestamo> prestamos) {
			 ArrayList<Prestamo> prestamosActivos = obtenerPrestamosActivos(currentUser, prestamos);
			    if (!prestamosActivos.isEmpty()) {
			        System.out.println("Prestamos activos:");
			        for (Prestamo prestamo : prestamosActivos) {
			            System.out.println(prestamo.toString());
			        }
			    } else {
			        System.out.println("No tienes préstamos activos.");
			    } 
		}
	protected static void devolverPrestamo(User currentUser, ArrayList<Prestamo> prestamos) {
        ArrayList<Prestamo> prestamosActivos = obtenerPrestamosActivos(currentUser, prestamos);
        Scanner sc = new Scanner(System.in);
        if (!prestamosActivos.isEmpty()) {
            System.out.println("Prestamos activos:");
            for (int i = 0; i < prestamosActivos.size(); i++) {
                System.out.println((i + 1) + ". " + prestamosActivos.get(i).toString());
            }
            System.out.println("Seleccione el préstamo que desea devolver:");
            int indexPrestamo = sc.nextInt();
            sc.nextLine();
            if (indexPrestamo >= 1 && indexPrestamo <= prestamosActivos.size()) {
                Prestamo prestamoSeleccionado = prestamosActivos.get(indexPrestamo - 1);
                LocalDate fechaActual = LocalDate.now();
                long diffDias = ChronoUnit.DAYS.between(prestamoSeleccionado.getFechaPrestamo(), fechaActual);
                if (diffDias <= 7) {
                    prestamoSeleccionado.devolver();
                    prestamos.remove(prestamoSeleccionado);
                    System.out.println("El préstamo ha sido devuelto con éxito.");
                } else {
                    penalizarUsuario(currentUser);
                }
            } else {
                System.out.println("Selección inválida. Intente nuevamente.");
            }
        } else {
            System.out.println("No tienes préstamos activos para devolver.");
        }
    }
	   protected static void verPrestamosCliente(ArrayList<Prestamo> prestamos) {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Ingrese el ID del cliente para ver sus préstamos:");
	    String idCliente = sc.nextLine().trim();

	    boolean found = false;
	    for (Prestamo prestamo : prestamos) {
	        if (prestamo.getUsuario().getUser().equals(idCliente)) {
	            found = true;
	            System.out.println("ID del cliente: " + idCliente);
	            if (prestamo.isDevuelto()) {
	                System.out.println("Préstamo devuelto: " + prestamo);
	            } else {
	                System.out.println("Préstamo activo: " + prestamo);
	            }
	        }
	    }

	    if (!found) {
	        System.out.println("No se encontraron préstamos para el cliente con ID: " + idCliente);
	    }
	}
	   private static Date penalizarUsuario(User currentUser) {
		   Calendar calendar = Calendar.getInstance();
		    calendar.setTime(new Date());
		    calendar.add(Calendar.DAY_OF_MONTH, 7);
		    return calendar.getTime();
	    }
	   private static Date calcularFechaFinPenalizacion() {
		   Date fechaActual = new Date();
		    long tiempoPenalizacion = DURACION_PENALIZACION * 24 * 60 * 60 * 1000; 
		    long tiempoFinalPenalizacion = fechaActual.getTime() + tiempoPenalizacion;
		    return new Date(tiempoFinalPenalizacion);
	    }

}