/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.educastur.javierlr.Biblioteca;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

//iker estuvo aquí
public class Biblioteca {
 
    private ArrayList <Libro> libros;
    private ArrayList <Usuario> usuarios;
    private ArrayList <Prestamo> prestamos;
    private ArrayList <Prestamo> prestamosHist;
    private int pos;

    public Biblioteca() {
        this.libros = new ArrayList();
        this.usuarios = new ArrayList();
        this.prestamos = new ArrayList();
        this.prestamosHist = new ArrayList();
    }
    
    public static void main(String[] args) {
       Biblioteca b= new Biblioteca();
       b.cargaDatos(); 
       b.menu();
    }
    
    //<editor-fold defaultstate="collapsed" desc="MENUS">
    public void menu(){
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tBIBLIOTECA\n");
            System.out.println("\t\t\t\t1 - LIBROS");
            System.out.println("\t\t\t\t2 - USUARIOS");
            System.out.println("\t\t\t\t3 - PRESTAMOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    menuLibros();
                    break;
                }    
                case 2:{
                    menuUsuarios();
                    break;
                } 
                case 3:{
                    menuPrestamos();
                    break;
                } 
            }
        }while (opcion != 9);
    }

    private void menuLibros() {
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tLIBROS\n");
            System.out.println("\t\t\t\t1 - NUEVO LIBRO");
            System.out.println("\t\t\t\t2 - ELIMINAR LIBRO");
            System.out.println("\t\t\t\t3 - MODIFICAR LIBRO");
            System.out.println("\t\t\t\t4 - LISTADOS");
             System.out.println("\t\t\t\t5 - LIBROS MAS LEIDOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    nuevoLibro();
                    break;
                }    
                case 2:{
                    eliminarLibro();
                    break;
                } 
                case 3:{
                    modificarLibros();
                    break;
                } 
                case 4:{
                    listaLibros();
                    break;
                } 
               case 5:{
                   libroMasLeido();
                   break;
                
                } 
            }
        }while (opcion != 9);
    }

    private void menuUsuarios() {
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tUSUARIOS");
            System.out.println("\t\t\t\t1 - NUEVO USUARIO");
            System.out.println("\t\t\t\t2 - ELIMINAR USUARIO");
            System.out.println("\t\t\t\t3 - MODIFICAR USUARIO");
            System.out.println("\t\t\t\t4 - LISTADO GENERAL USUARIOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    nuevoUsuario();
                    break;
                }    
                case 2:{
                    eliminarUsuario();
                    break;
                } 
                case 3:{
                    modificarUsuario();
                    break;
                } 
                case 4:{
                    listaUsuarios();
                    break;
                } 
               
            }
        }while (opcion != 9);
    }

    private void menuPrestamos() {
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tPRESTAMOS\n");
            System.out.println("\t\t\t\t1 - NUEVO PRESTAMO");
            System.out.println("\t\t\t\t2 - DEVOLUCION PRESTAMO");
            System.out.println("\t\t\t\t3 - PRORROGA PRESTAMO");
            System.out.println("\t\t\t\t4 - LISTADO GENERAL PRESTAMOS");
            System.out.println("\t\t\t\t5 - LISTADO PRESTAMOS USUARIO");
            System.out.println("\t\t\t\t6 - LISTADO PRESTAMOS LIBRO");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    nuevoPrestamo();
                    break;
                }    
                case 2:{
                    devolucion();
                    break;
                } 
                case 3:{
                    prorroga();
                    break;
                } 
                case 4:{
                    listaPrestamos();
                    break;
                } 
                case 5:{
                    listaPrestamosUsu();
                    break;
                } 
                case 6 :{
                    ListaPrestamosLibro();
                    break;
                }
            }
        }while (opcion != 9);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GESTION LIBROS">
     private void nuevoLibro() {
         Scanner sc=new Scanner(System.in);           
        System.out.println("Nuevo libro:");
        System.out.println("ISBN: ");
        String isbn= sc.nextLine();
        System.out.println("Título: ");
        String titulo=sc.nextLine();
        System.out.println("Autor: ");
        String autor=sc.nextLine();
        System.out.println("Género:");
        String genero=sc.nextLine();
        System.out.println("Ejemplares");
        int ejemplares=sc.nextInt();
        
           System.out.println(new Libro(isbn,titulo,autor,genero,ejemplares));
       libros.add(new Libro(isbn,titulo,autor,genero,ejemplares));
    }

    private void eliminarLibro() {
           Scanner sc=new Scanner(System.in);  
        System.out.println("ISBN del libro a eliminar");
        String isbn= sc.nextLine();
        
        int pos= buscaIsbn(isbn);
        if(pos==-1){
            System.out.println("El libro que buscas no esta registrado");
        }else{
            System.out.println("Esta seguro de que desea borrar el libro?");
            System.out.println("Si o no");
            String confirmacion = sc.nextLine();
            if (confirmacion.equalsIgnoreCase("si")){
                System.out.println("El libro ha sido eliminado");
                libros.remove(pos);
            }else{
                System.out.println("Operacion cancelada con exito");
            }
            
        }
    }

    private void modificarLibros() {
            Scanner sc=new Scanner(System.in); 
        System.out.println("Dime el ISBN del libro que quieres modificar: ");
        String isbn= sc.nextLine();
        
        int pos= buscaIsbn(isbn);
        if (pos==-1) {
            System.out.println("El libro que buscas no esta registrado");
        } else {
            System.out.println("Pulsa + si quieres aumentar el número de ejemplares o - si quieres disminuir la cantidad de estos");
            String confirm= sc.nextLine();
            if (confirm.equals("+")) {
                 if (confirm.equals("+")) {
                System.out.println("¿Cuantos ejemplares quieres añadir?");
                int mas= sc.nextInt();
                int ejemplar= libros.get(pos).getEjemplares();
                int calculo2= ejemplar + mas;  
                libros.get(pos).setEjemplares(calculo2);
                System.out.println("Operacion realizada con exito");
            } 
                else if (confirm.equals("-")) {
                System.out.println("¿Cuantos ejemplares quieres quitar?");
                int menos=sc.nextInt();
                int ejemplar= libros.get(pos).getEjemplares();
                int calculo2= ejemplar - menos; 
                libros.get(pos).setEjemplares(calculo2);
                System.out.println("Operacion realizada con exito");
          
            }
            } else {
                     System.out.println("No se ha detectado ningun simbolo +/-");
            }
           
          
        }
    }
      private void listaLibros() {
        for (Libro l : libros) {
            System.out.println(l);
        }
    }
      private void libroMasLeido (){
          ArrayList <Integer> contadoresLibros=new ArrayList();
          int contador;
          for (Libro l : libros) {
          contador=0;
          for (Prestamo p:prestamos){
              if (l==p.getLibroPrest()) {
                  contador++;
              }
          }
           for (Prestamo p:prestamosHist){
              if (l==p.getLibroPrest()) {
                  contador++;
              }
           }
           contadoresLibros.add(contador);
      }
          int posMasLeido=0;
          int max=0;
          for (int i = 0;i < libros.size();i++){
              if (contadoresLibros.get(i)>max) {
                  max=contadoresLibros.get(i);
                  posMasLeido=i;
              }

           }
          System.out.println("El libro/s mas leido/s con " + max +" prestamos es/son: ");
          System.out.println(libros.get(posMasLeido));
          for (int i = 0;i < libros.size();i++){
              if (contadoresLibros.get(i)==max) {
                  System.out.println(libros.get(i));
              }
      }
      }
      //private void libroMasLeido{
    

    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTION USUARIOS">
    private void nuevoUsuario() {
         Scanner sc=new Scanner(System.in);           
        System.out.println("Nuevo usuario:");
        System.out.println("DNI: ");
        String dni= sc.nextLine();
        System.out.println("Nombre: ");
        String nombre=sc.nextLine();
        System.out.println("Email: ");
        String email=sc.nextLine();
        System.out.println("Telefono:");
        String telefono=sc.nextLine();
      
        
           System.out.println(new Usuario(dni,nombre,email,telefono));
       usuarios.add(new Usuario(dni,nombre,email,telefono));
    }

    private void eliminarUsuario() {
           Scanner sc=new Scanner(System.in);  
        System.out.println("Dni del usuario a eliminar");
        String dni= sc.nextLine();
        
        int pos= buscaDni(dni);
        if(pos==-1){
            System.out.println("El usuario que buscas no esta registrado");
        }else{
            System.out.println("Esta seguro de que desea borrar el usuario?");
            System.out.println("Si o no");
            String confirmacion = sc.nextLine();
            if (confirmacion.equalsIgnoreCase("si")){
                System.out.println("El usuario ha sido eliminado");
                libros.remove(pos);
            }else{
                System.out.println("Operacion cancelada con exito");
            }
            
        }
    }


    private void modificarUsuario() {
    }

    private void listaUsuarios() {
         for (Usuario l : usuarios) {
            System.out.println(l);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTION PRESTAMOS">
    private void nuevoPrestamo() {
        System.out.println("Identificación del usuario:");
        int posUsuario = buscaDni(solicitaDni());
        if (posUsuario==-1){
            System.out.println("No es aún usuario de la biblioteca");
        }else{
            System.out.println("Identificación del libro:"); 
            int posLibro=buscaIsbn(solicitaIsbn());
            if (posLibro==-1){
                System.out.println("El ISBN pertenece a un libro inexistente");
            } else if (libros.get(posLibro).getEjemplares()>0){
                LocalDate hoy=LocalDate.now();
                prestamos.add(new Prestamo(libros.get(posLibro),usuarios.get(posUsuario),hoy,hoy.plusDays(15)));
                libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares()-1);
                }else{
                    System.out.println("No quedan unidades disponibles del libro");
                }
        }
    }

    private void devolucion() {
        System.out.println("Datos para la porroga del devolucion");
        String isbnLibro=solicitaIsbn();
        int pos=buscaPrestamo(solicitaDni(),isbnLibro);
        if (pos==-1){
            System.out.println("No hay prestamo con esos datos");
        }else{
            prestamos.get(pos).setFechaDev(LocalDate.now());
            libros.get(buscaIsbn(isbnLibro))
            .setEjemplares(libros.get(buscaIsbn(isbnLibro)).getEjemplares()+1);
            prestamosHist.add(prestamos.get(pos));
            prestamos.remove(pos);
    }
    }
    private void prorroga() {
        System.out.println("Datos para la porroga del prestamo");
        int pos=buscaPrestamo(solicitaDni(),solicitaIsbn());
        if (pos==-1){
            System.out.println("No hay prestamo con esos datos");
        }else{
            prestamos.get(pos).setFechaDev(prestamos.get(pos).getFechaDev().plusDays(15));
            prestamos.get(pos).setFechaPrest(LocalDate.now());
            System.out.println("Se ha porrogrado el prestamo en 15 dias");
        }
    }

    private void listaPrestamos() {
        System.out.println("Listado prestamos activos");
        for (Prestamo p : prestamos) {
            System.out.println(p);  
        }
        System.out.println("\nListado prestamos historicos"); 
        for (Prestamo p : prestamosHist) {
            System.out.println(p);  
        }
    }
    private void  listaPrestamosUsu(){
        String dni=solicitaDni();
        System.out.println("Prestamos activos de: "
            + usuarios.get(buscaDni(dni)).getNombre());
        for (Prestamo p : prestamos){
            if (p.getUsuarioPrest().getDni().equals(dni)){
                System.out.println(p);
            }
}
            System.out.println("\nPrestamos ya devueltos por: "
            + usuarios.get(pos).getNombre());
            for (Prestamo p : prestamosHist) {
            if (p.getUsuarioPrest().getDni().equals(dni)){
                System.out.println(p);
            }
        }
    }
    private void ListaPrestamosLibro(){
        String isbn=solicitaIsbn();
        int pos=buscaIsbn(isbn);
        if (pos==-1)
            System.out.println("No tengo ningun libro con ese ISBN");
    else{
    for (Prestamo p : prestamos){
        if (p.getLibroPrest().getIsbn().equals(isbn)){
            System.out.println(p.getUsuarioPrest());
        }
    }
}
    }      
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="METODOS AUXILIARES">
    /**
     * Método para solicitar por teclado el DNI de un usuario. pdte de validación
     * @return (String) dni del usuario tecleado
     */
    
    
    public String solicitaDni(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Teclea el dni del usuario:");
        String dni=sc.next();
        return dni;
    }
    /**
     * Método para solicitar por teclado el ISBN de un libro. pdte de validación
     * @return (String) isbn del libro tecleado
     */
    public String solicitaIsbn(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Teclea el isbn del libro:");
        String isbn=sc.next();
        return isbn;
    }
    public int buscaPrestamo (String dni, String isbn){
        int pos=-1;
        for (int i = 0; i < prestamos.size();i++){
            if (prestamos.get(i).getUsuarioPrest().getDni().equals(dni)
            && prestamos.get(i).getLibroPrest().getIsbn().equals(isbn)){
                    pos=i;
                    break;
                }
        }
        return pos;
}
    
    /**
     * Método para buscar un dni en la colección usuarios
     * @param dni (String) del usuario a buscar en la colección
     * @return posición (int) del usuario en el Arraylist, valor -1 si no se encuentra
     */
    public int buscaDni(String dni){
        int pos=-1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDni().equals(dni)){
                pos=i;
                break;
            }
        }
        return pos;       
    }
    
     /**
     * Método para buscar un libro en la colección libros
     * @param isbn (String) del libro a buscar en la colección
     * @return posición (int) del libro el Arraylist, valor -1 si no se encuentra
     */
    public int buscaIsbn(String isbn){
        int pos=-1;
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)){
                pos=i;
                break;
            }
        }
        return pos;       
    }
    
    public void cargaDatos(){
        libros.add(new Libro("1-11","El Hobbit","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-22","El Silmarillon","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-33","El Médico","N. Gordon","Aventuras",4)); 
        libros.add(new Libro("1-44","Chamán","N. Gordon","Aventuras",3)); 
        libros.add(new Libro("1-55","Momo","M. Ende","Aventuras",2)); 
        libros.add(new Libro("1-66","Paraíso inhabitado","A.M.Matute","Aventuras",2)); 
        libros.add(new Libro("1-77","Olvidado Rey Gudú","A.M.Matute","Aventuras",2)); 
        libros.add(new Libro("1-88","El último barco","D.Villar","Novela Negra",3)); 
        libros.add(new Libro("1-99","Ojos de agua","D.Villar","Novela Negra",0)); 

        usuarios.add(new Usuario("11","Ana","ana@email.com","621111111")); 
        usuarios.add(new Usuario("22","David","david@email.com","622222222")); 
        usuarios.add(new Usuario("33","Bea","bea@email.com","623333333")); 
        usuarios.add(new Usuario("44","Lucas","lucas@email.com","624444444")); 
        usuarios.add(new Usuario("55","Carlota","carlota@email.com","625555555")); 
        usuarios.add(new Usuario("66","Juan","juan@email.com","626666666"));
        
        LocalDate hoy= LocalDate.now();
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(0), hoy.minusDays(12),hoy.plusDays(4)));
        prestamos.add(new Prestamo(libros.get(8),usuarios.get(2), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(4), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(2), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(1), hoy,hoy.plusDays(15)));
    
        for (Libro l:libros) {
            System.out.println(l);
        }
        System.out.println("");
        for (Usuario u:usuarios) {
            System.out.println(u);
        }
        System.out.println("");
        for (Prestamo p:prestamos) {
            System.out.println(p);
        }
    }
//</editor-fold>
   
}
