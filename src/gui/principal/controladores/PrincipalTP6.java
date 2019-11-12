/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.principal.controladores;

import gui.areas.modelos.Area;
import gui.areas.modelos.GestorAreas;
import gui.personas.modelos.Cargo;
import gui.personas.modelos.GestorAlumnoEnTrabajo;
import gui.personas.modelos.GestorPersonas;
import gui.seminarios.modelos.GestorSeminarios;
import gui.seminarios.modelos.NotaAprobacion;
import gui.seminarios.modelos.Seminario;
import gui.trabajos.modelos.AlumnoEnTrabajo;
import gui.trabajos.modelos.GestorRolEnTrabajo;
import gui.trabajos.modelos.GestorTrabajos;
import gui.trabajos.modelos.Rol;
import gui.trabajos.modelos.RolEnTrabajo;
import gui.trabajos.modelos.Trabajo;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rosalba Caldez
 */
public class PrincipalTP6 {
    public static void main(String[] args) {
        GestorAreas gAreas = GestorAreas.crear();
        GestorPersonas gPersonas = GestorPersonas.crear();
        GestorTrabajos gTrabajos = GestorTrabajos.crear();
        GestorSeminarios gSeminarios = GestorSeminarios.crear();
        GestorAlumnoEnTrabajo gAet = GestorAlumnoEnTrabajo.crear();
        GestorRolEnTrabajo gRot = GestorRolEnTrabajo.crear();
        
        /* ------------------ AREAS ----------------------- */
        
//        System.out.println(gAreas.nuevaArea("Software"));
//        System.out.println(gAreas.nuevaArea("Hardware"));
//        System.out.println(gAreas.nuevaArea("Sistemas Embebidos"));
//        System.out.println(gAreas.nuevaArea("Redes"));
//        System.out.println(gAreas.nuevaArea("Redes"));
//        System.out.println(gAreas.nuevaArea(""));
//        System.out.println(gAreas.nuevaArea(null));
////        
//        gAreas.mostrarAreas();
//        
//        Area a1 = gAreas.dameArea("Soft");
//        Area a2 = gAreas.dameArea("Redes");
//        
//        try{
//            a1.mostrar();
//        }
//        catch(NullPointerException e){
//            System.out.println("-");
//        }
//        
//        try{
//            a2.mostrar();
//        }
//        catch(NullPointerException e){
//            System.out.println("-");
//        }
//        
//        List<Area> areas1 = gAreas.buscarArea("Soft");
//        List<Area> areas2 = gAreas.buscarArea("S");
//        List<Area> areas3 = gAreas.buscarArea("");
//        List<Area> areas4 = gAreas.buscarArea(null);
//        List<Area> areas5 = gAreas.buscarArea("Fisica");
//        
//        System.out.println("");
//        System.out.println("FILTRO Soft");
//       for(Area a: areas1){
//           try{
//               a.mostrar();
//           }
//           catch(NullPointerException e){
//               System.out.println("-");
//           }
//       }
//        
//        System.out.println("");
//        System.out.println("Filtro S");
//       for(Area a: areas2){
//           try{
//               a.mostrar();
//           }
//           catch(NullPointerException e){
//               System.out.println("-");
//           }
//       }
//       
//       System.out.println("");
//        System.out.println("Filtro ");
//       for(Area a: areas3){
//           try{
//               a.mostrar();
//           }
//           catch(NullPointerException e){
//               System.out.println("-");
//           }
//       }
//       
//       System.out.println("");
//        System.out.println("Filtro null");
//       for(Area a: areas4){
//           try{
//               a.mostrar();
//           }
//           catch(NullPointerException e){
//               System.out.println("-");
//           }
//       }
//       
//       System.out.println("");
//        System.out.println("Filtro Fisica");
//       for(Area a: areas5){
//           try{
//               a.mostrar();
//           }
//           catch(NullPointerException e){
//               System.out.println("-");
//           }
//       }
       
       
       /* ---------------- PERSONAS ---------------*/
       
        System.out.println(gPersonas.nuevoProfesor("Juarez", "Juan Jose", 1234567, Cargo.ASOCIADO));
        System.out.println(gPersonas.nuevoProfesor(null, "Pedro",42499931 , Cargo.ADG)); //No se agrega
        System.out.println(gPersonas.nuevoProfesor("Lopez", "Maximo", 1234567, Cargo.EXTERNO)); //No se agrea, mismo DNI
        System.out.println(gPersonas.nuevoProfesor("Juarez", "", 223456, Cargo.ASOCIADO)); //NO, nombre empty
        System.out.println(gPersonas.nuevoProfesor("Juarez", "Juan Jose", 0, Cargo.ASOCIADO)); //No, dni 0
        System.out.println(gPersonas.nuevoProfesor("Perelmut", "Valentina", 41649842, Cargo.TITULAR));
        System.out.println(gPersonas.nuevoProfesor("Diaz", "Juan", 13345678, Cargo.JTP)); // Se agrega
        System.out.println(gPersonas.nuevoProfesor("Juarez", "Ana María", 14345678, Cargo.ADJUNTO));
        System.out.println(gPersonas.nuevoProfesor("San Martin","Jose Manuel", 15345678, Cargo.ADG));
        System.out.println(gPersonas.nuevoProfesor("Ortega", "Laura", 16345678, Cargo.ASOCIADO));
        System.out.println(gPersonas.nuevoProfesor("Rodriguez","Juliana", 15345678, Cargo.TITULAR));
        
        System.out.println("");
        
        System.out.println(gPersonas.nuevoAlumno("Musa", "Ezequiel", 34567890, "16345") + "1");
        System.out.println(gPersonas.nuevoAlumno("Martinez", "Ricardo Juan", 34567891, "16343")+"2");
        System.out.println(gPersonas.nuevoAlumno("Gimenez", "María José", 34567892, "16344")+"3");
        System.out.println(gPersonas.nuevoAlumno("Flores", "Mauricio José", 34567890, "16543")+"4"); //CX repetido
        System.out.println(gPersonas.nuevoAlumno("Campos", "Juan Pablo", 34567895, "17345")+"5");
        System.out.println(gPersonas.nuevoAlumno("Campos", "Augusto", 15345678, "17348")+"6"); //Mismo DNI que un profesor
        System.out.println(gPersonas.nuevoAlumno("Rodriguez", "Miguel Angel", 34567852, "17346")+"7");
        System.out.println(gPersonas.nuevoAlumno("Alvarez", "Ezequiel", 44567890, "16345")+"8");//CX Repetido
        System.out.println(gPersonas.nuevoAlumno("Aguero", "Luciana", 45567890, "17349")+"9");
        System.out.println(gPersonas.nuevoAlumno("Campos Figueroa", "Juana", 46567890, "16345")+"10"); //CX Repetido
        System.out.println(gPersonas.nuevoAlumno("Apud", "Josefina", 45367890, "18345")+"11");
        System.out.println(gPersonas.nuevoAlumno("", "Josefina", 41649842, "18345")+"12"); //Apellido empty
        System.out.println(gPersonas.nuevoAlumno("Apud", null, 43339516, "18345")+"13"); //Nombre null
        System.out.println(gPersonas.nuevoAlumno("Apud", "Josefina", 0, "18345")+"14"); //Dni cero
        System.out.println(gPersonas.nuevoAlumno("Apud", "Josefina", 45367890, null)+"15"); //CX null
        
//        List<Profesor> profesores1 = gPersonas.buscarProfesores("Musa"); //NO sale nada
//        List<Profesor> profesores2 = gPersonas.buscarProfesores("");
//        List<Profesor> profesores3 = gPersonas.buscarProfesores("S");
//        List<Profesor> profesores4 = gPersonas.buscarProfesores(null);
//        
//        
//        System.out.println("");
//        System.out.println("FILTRO Musa");
//        for(Profesor p : profesores1){
//            p.mostrar();
//        }
//        
//        System.out.println("");
//        System.out.println("FILTRO ");
//        for(Profesor p : profesores2){
//            p.mostrar();
//        }
//        
//        System.out.println("");
//        System.out.println("FILTRO S");
//        for(Profesor p : profesores3){
//            p.mostrar();
//        }
//        
//        System.out.println("");
//        System.out.println("FILTRO null");
//        for(Profesor p : profesores4){
//            p.mostrar();
//        }
//        
//        List<Alumno> alumnos1 = gPersonas.buscarAlumnos("Musa"); 
//        List<Alumno> alumnos2 = gPersonas.buscarAlumnos("");
//        List<Alumno> alumnos3 = gPersonas.buscarAlumnos("Caca");
//        List<Alumno> alumnos4 = gPersonas.buscarAlumnos(null);
//        
//        
//        System.out.println("");
//        System.out.println("FILTRO Musa");
//        for(Alumno p : alumnos1){
//            p.mostrar();
//        }
//        
//        System.out.println("");
//        System.out.println("FILTRO ");
//        for(Alumno p : alumnos2){
//            p.mostrar();
//        }
//        
//        System.out.println("");
//        System.out.println("FILTRO Caca");
//        for(Alumno p : alumnos3){
//            p.mostrar();
//        }
//        
//        System.out.println("");
//        System.out.println("FILTRO null");
//        for(Alumno p : alumnos4){
//            p.mostrar();
//        }
//        
//        System.out.println("ProfesorBuscar");
//        
//        Profesor p1 = gPersonas.dameProfesor(1234567);
//        Profesor p2 = gPersonas.dameProfesor(987654321);
//        Profesor p3 = gPersonas.dameProfesor(0);
//        Profesor p4 = gPersonas.dameProfesor(34567890);
//        
//        try{
//          p1.mostrar();
//        }
//        catch(NullPointerException e){
//            System.out.println("-");
//        }
//        
//        try{
//          p2.mostrar();
//        }
//        catch(NullPointerException e){
//            System.out.println("-");
//        }
//        
//        try{
//          p3.mostrar();
//        }
//        catch(NullPointerException e){
//            System.out.println("-");
//        }
//        
//        try{
//          p4.mostrar();
//        }
//        catch(NullPointerException e){
//            System.out.println("-");
//        }
//        
//        System.out.println("AlumnosBuscar");
//        
//        Alumno a1 = gPersonas.dameAlumno(null);
//        Alumno a2 = gPersonas.dameAlumno("");
//        Alumno a3 = gPersonas.dameAlumno("16345");
//        Alumno a4 = gPersonas.dameAlumno("papa");
//        
//        try{
//          a1.mostrar();
//        }
//        catch(NullPointerException e){
//            System.out.println("-");
//        }
//        
//        try{
//          a2.mostrar();
//        }
//        catch(NullPointerException e){
//            System.out.println("-");
//        }
//        
//        try{
//          a3.mostrar();
//        }
//        catch(NullPointerException e){
//            System.out.println("-");
//        }
//        
//        try{
//          a4.mostrar();
//        }
//        catch(NullPointerException e){
//            System.out.println("-");
//        }

//        System.out.println("");
//        System.out.println("PERSONAS");
//        gPersonas.mostrarPersonas();
//        
//        System.out.println("");
//        System.out.println("PROFESORES");
//        gPersonas.mostrarProfesores();
//        
//        System.out.println("");
//        System.out.println("ALUMNOS");
//        gPersonas.mostrarAlumnos();


        /* --------------GESTOR ROL EN TRABAJO ------------*/
        System.out.println("ROL");
        System.out.println("");
        RolEnTrabajo rot1 = gRot.nuevoRolEnTrabajo(gPersonas.dameProfesor(1234567), Rol.TUTOR, LocalDate.now());
        RolEnTrabajo rot2 = gRot.nuevoRolEnTrabajo(gPersonas.dameProfesor(13345678), Rol.COTUTOR, LocalDate.now());
        RolEnTrabajo rot3 = gRot.nuevoRolEnTrabajo(gPersonas.dameProfesor(14345678), Rol.JURADO, LocalDate.now());
        RolEnTrabajo rot4 = gRot.nuevoRolEnTrabajo(gPersonas.dameProfesor(15345678), Rol.JURADO, LocalDate.now());
        RolEnTrabajo rot5 = gRot.nuevoRolEnTrabajo(gPersonas.dameProfesor(16345678), Rol.JURADO, LocalDate.now());
        
        RolEnTrabajo rot6 = gRot.nuevoRolEnTrabajo(null, Rol.TUTOR, LocalDate.now()); //No se agrega por ser null
        RolEnTrabajo rot7 = gRot.nuevoRolEnTrabajo(gPersonas.dameProfesor(1234567),null, LocalDate.now());
        RolEnTrabajo rot8 = gRot.nuevoRolEnTrabajo(gPersonas.dameProfesor(1234567), Rol.TUTOR, null);
        
        /**** PARA CREAR LOS TRABAJOS ****/
        RolEnTrabajo rot9 = gRot.nuevoRolEnTrabajo(gPersonas.dameProfesor(1234567), Rol.COTUTOR, LocalDate.now());
        RolEnTrabajo rot10 = gRot.nuevoRolEnTrabajo(gPersonas.dameProfesor(1234567), Rol.JURADO, LocalDate.now());
        RolEnTrabajo rot11 = gRot.nuevoRolEnTrabajo(gPersonas.dameProfesor(13345678), Rol.COTUTOR, LocalDate.now());       
        
       List<RolEnTrabajo> listaValida = new ArrayList<RolEnTrabajo>();
       
       List<RolEnTrabajo> lista1 = new ArrayList<RolEnTrabajo>();
       
       List<RolEnTrabajo> lista2 = new ArrayList<RolEnTrabajo>();
       
       List<RolEnTrabajo> lista3 = new ArrayList<RolEnTrabajo>();
       
       List<RolEnTrabajo> lista6 = new ArrayList<RolEnTrabajo>();
       
       List<RolEnTrabajo> lista10 = new ArrayList<RolEnTrabajo>();
       
       List<RolEnTrabajo> lista11 = new ArrayList<RolEnTrabajo>();
       
       List<RolEnTrabajo> lista12 = new ArrayList<RolEnTrabajo>();
       
       List<RolEnTrabajo> lista13 = new ArrayList<RolEnTrabajo>();
       
       listaValida.add(rot1);
       listaValida.add(rot2);
       listaValida.add(rot3);
       listaValida.add(rot4);
       listaValida.add(rot5);
       
       /* Cotutor es tutor */
       lista1.add(rot1);
       lista1.add(rot9);
       lista1.add(rot3);
       lista1.add(rot4);
       lista1.add(rot5);
       
       /*Tutor es jurado */
       lista2.add(rot1);
       lista2.add(rot2);
       lista2.add(rot3);
       lista2.add(rot4);
       lista2.add(rot10);
       
       /*Cotutor es jurado*/
       lista3.add(rot1);
       lista3.add(rot2);
       lista3.add(rot3);
       lista3.add(rot4);
       lista3.add(rot11);
       
       /*Profesor nulo*/
       lista6.add(rot1);
       lista6.add(rot2);
       lista6.add(rot3);
       lista6.add(null);
       lista6.add(rot5);
       
       /*Falta tutor */
       lista10.add(rot2);
       lista10.add(rot3);
       lista10.add(rot4);
       lista10.add(rot5);
       
       /*Falta jurado*/
       lista11.add(rot2);
       lista11.add(rot3);
       lista11.add(rot4);
       lista11.add(rot1);
       
       /*Jurado repetido*/
       lista12.add(rot1);
       lista12.add(rot2);
       lista12.add(rot4);
       lista12.add(rot4);
       lista12.add(rot5);
       
       /*Sin jurados*/
       lista13.add(rot1);
       lista13.add(rot2);
       
       
       
       
       /* --------------------- ALUMNOS ----------------*/
        System.out.println("");
        System.out.println("ALUMNO EN TRABAJO");
        System.out.println("");
        AlumnoEnTrabajo aet1 = gAet.nuevoAlumnoEnTrabajo(LocalDate.now(), gPersonas.dameAlumno("16345"));
        AlumnoEnTrabajo aet2 = gAet.nuevoAlumnoEnTrabajo(LocalDate.now(), gPersonas.dameAlumno("16343"));
        AlumnoEnTrabajo aet3 = gAet.nuevoAlumnoEnTrabajo(LocalDate.now(), gPersonas.dameAlumno("17345"));
        AlumnoEnTrabajo aet4 = gAet.nuevoAlumnoEnTrabajo(LocalDate.now(), gPersonas.dameAlumno("18345"));
        
        List<AlumnoEnTrabajo> listaV = new ArrayList<AlumnoEnTrabajo>();
        List<AlumnoEnTrabajo> lista4 = new ArrayList<AlumnoEnTrabajo>();
        List<AlumnoEnTrabajo> lista5 = new ArrayList<AlumnoEnTrabajo>();
        List<AlumnoEnTrabajo> lista7 = new ArrayList<AlumnoEnTrabajo>();
        
        listaV.add(aet1);
        listaV.add(aet2);
        listaV.add(aet3);
        
        lista4.add(aet1);
        lista4.add(aet1);
        lista4.add(aet4);
        
        lista5.add(null);
        lista5.add(aet1);
        lista5.add(aet4);
        
        /* ---- LISTA DE AREAS ------------*/
        List<Area> listaAreas1 = new ArrayList<Area>();
        listaAreas1.add(gAreas.dameArea("Redes"));
        listaAreas1.add(gAreas.dameArea("Hardware")); 
        
        List<Area> listaAreas2 = new ArrayList<Area>();
       
        /* --------------------- TRABAJOS ----------------*/
        LocalDate fecha1 = LocalDate.of(2017, 10, 2);
        LocalDate fecha2 = null; 
        LocalDate fecha3 = LocalDate.of(2017, 11, 2);
        LocalDate fecha4= LocalDate.of(2017, 8, 12);
        LocalDate fecha5= LocalDate.of(2017, 9, 12);
        LocalDate fecha6= LocalDate.of(2017, 10, 2);
        
            
        System.out.println("");
        System.out.println("TRABAJOS");
        
        System.out.println(gTrabajos.nuevoTrabajo("Protocolos de comunicación", 6, fecha1, fecha3,listaAreas1,listaValida,listaV) + "1");
        System.out.println(gTrabajos.nuevoTrabajo(null,6, fecha1, fecha3,listaAreas1,listaValida,listaV)+"2");
        System.out.println(gTrabajos.nuevoTrabajo("Proteos",0, fecha1, fecha3,listaAreas1,listaValida,listaV)+"3");
        System.out.println(gTrabajos.nuevoTrabajo("Vale Vale", 6, null, fecha3,listaAreas1,listaValida,listaV)+"4");
        System.out.println(gTrabajos.nuevoTrabajo("Rochu", 6, fecha3, fecha1,listaAreas1,listaValida,listaV)+"5");
        System.out.println(gTrabajos.nuevoTrabajo("Jamon con dulce de leche", 6, fecha1, fecha3,listaAreas1,lista10,listaV)+"6");
        System.out.println(gTrabajos.nuevoTrabajo("Helado de bosta", 6, fecha1, fecha3,listaAreas2,listaValida,listaV)+"7");
        System.out.println(gTrabajos.nuevoTrabajo("Aborto espontáneo", 6, fecha1, fecha3,listaAreas1,lista12,listaV)+"8"); // JURADO REPETIDO
        System.out.println(gTrabajos.nuevoTrabajo("ProtoCOLON", 6, fecha1, fecha3,listaAreas1,lista13,listaV)+"9"); //SIN JURADOS NO AGREGA
        System.out.println(gTrabajos.nuevoTrabajo("Perelmut", 6, fecha1, fecha3,listaAreas1,lista2,listaV)+"10");
        System.out.println(gTrabajos.nuevoTrabajo("Calduz", 6, fecha1, fecha3,listaAreas1,lista3,listaV)+"11");
        System.out.println(gTrabajos.nuevoTrabajo("Middagh", 6, fecha1, fecha3,listaAreas1,listaValida,lista4)+"12");
        System.out.println(gTrabajos.nuevoTrabajo("FUCK", 6, fecha1, fecha3,listaAreas1,listaValida,lista5)+"13");
        System.out.println(gTrabajos.nuevoTrabajo("ELIAS", 6, fecha1, fecha3,listaAreas1,listaValida,lista7)+"14");
        System.out.println(gTrabajos.nuevoTrabajo("ROCHAKU", 6, fecha1, fecha3,listaAreas1,lista13,listaV) + "15");
        System.out.println(gTrabajos.nuevoTrabajo("BORRAR", 6, fecha1, fecha3,listaAreas1,listaValida,listaV) + "1");
        
        /* ---------- SEMINARIOS --------*/
        
        System.out.println(gSeminarios.validarSeminario(fecha1, NotaAprobacion.DESAPROBADO, "Es un pete y desaprobo jaja"));
        System.out.println(gSeminarios.validarSeminario(fecha1, NotaAprobacion.APROBADO_SINOBS, null));
        System.out.println(gSeminarios.validarSeminario(fecha1, NotaAprobacion.APROBADO_CONOBS, "Es un pete y desaprobo jaja"));
        System.out.println(gSeminarios.validarSeminario(fecha1, NotaAprobacion.APROBADO_CONOBS, null));
        System.out.println(gSeminarios.validarSeminario(fecha2, NotaAprobacion.DESAPROBADO, "Es un pete y desaprobo jaja"));
        System.out.println(gSeminarios.validarSeminario(fecha1, null, "Es un pete y desaprobo jaja"));
        
        Trabajo trabajo = gTrabajos.dameTrabajo("Protocolos de comunicación");
        
        
        System.out.println(trabajo.nuevoSeminario(LocalDate.of(2018,10,10), NotaAprobacion.DESAPROBADO, "Es un pete y desaprobo jaja"));
//        System.out.println(trabajo.nuevoSeminario(LocalDate.of(2018,10,10), NotaAprobacion.APROBADO_SINOBS, null));
//        System.out.println(trabajo.nuevoSeminario(LocalDate.of(2018,10,10), NotaAprobacion.APROBADO_CONOBS, "Es un pete y desaprobo jaja"));
//        System.out.println(trabajo.nuevoSeminario(LocalDate.of(2018,10,10), NotaAprobacion.APROBADO_CONOBS, null));
        System.out.println(trabajo.nuevoSeminario(fecha2, NotaAprobacion.DESAPROBADO, "Es un pete y desaprobo jaja"));
        System.out.println(trabajo.nuevoSeminario(LocalDate.of(2018,10,10), null, "Es un pete y desaprobo jaja"));
        System.out.println(trabajo.nuevoSeminario(fecha1,NotaAprobacion.DESAPROBADO , "Es un pete y desaprobo jaja"));
    
        /* --------- BORRAR AREA ----------- */
        
//        System.out.println(gAreas.borrarArea(gAreas.dameArea("Redes")));
//        System.out.println(gAreas.borrarArea(gAreas.dameArea("Sistemas Embebidos")));
        
        /* -------- MODIFICAR PROFESOR ----------*/
//        System.out.println("MODIFICAR PROFESOR");
//        gPersonas.dameProfesor(1234567).mostrar();
//        System.out.println(gPersonas.modificarProfesor(gPersonas.dameProfesor(1234567), "Juarez", "Alvaro", Cargo.ASOCIADO));
//        gPersonas.dameProfesor(1234567).mostrar();
//        System.out.println(gPersonas.modificarProfesor(gPersonas.dameProfesor(1234567), "Estevez", "Alvaro", Cargo.ASOCIADO));
//        gPersonas.dameProfesor(1234567).mostrar();
//        System.out.println(gPersonas.modificarProfesor(gPersonas.dameProfesor(1234567), "Juarez", "Alvaro", Cargo.ADG));
//        gPersonas.dameProfesor(1234567).mostrar();
//        
//        System.out.println("Ahora con lo que no se puede");
//        System.out.println(gPersonas.modificarProfesor(gPersonas.dameProfesor(5), "Juarez", "Alvaro", Cargo.ASOCIADO));
//        System.out.println(gPersonas.modificarProfesor(gPersonas.dameProfesor(1234567), null, "Alvaro", Cargo.ASOCIADO));
//        System.out.println(gPersonas.modificarProfesor(gPersonas.dameProfesor(1234567), "Juarez", null, Cargo.ASOCIADO));
//        System.out.println(gPersonas.modificarProfesor(gPersonas.dameProfesor(1234567), "Juarez", "Alvaro", null));
        
        
        /* -------- MODIFICAR ALUMNO ---------*/
        
//        System.out.println("MODIFICAR ALUMNO");
//        gPersonas.dameAlumno("16345").mostrar();
//        System.out.println(gPersonas.modificarAlumno(gPersonas.dameAlumno("16345"), "Perelmut", "Ezequiel", "16345"));
//        gPersonas.dameAlumno("16345").mostrar();
//        System.out.println(gPersonas.modificarAlumno(gPersonas.dameAlumno("16345"), "Perelmut", "Rosalba", "16345"));
//        gPersonas.dameAlumno("16345").mostrar();
//        System.out.println(gPersonas.modificarAlumno(gPersonas.dameAlumno("16345"), "Perelmut", "Ezequiel", "18345"));
//        gPersonas.dameAlumno("18345").mostrar();
//        
//        System.out.println(gPersonas.modificarAlumno(gPersonas.dameAlumno("16345"), null, "Ezequiel", "18345"));
//        System.out.println(gPersonas.modificarAlumno(gPersonas.dameAlumno("16345"), "", "Ezequiel", "18345"));
//        System.out.println(gPersonas.modificarAlumno(gPersonas.dameAlumno("16345"), "Perelmut", "", "18345"));
//        System.out.println(gPersonas.modificarAlumno(gPersonas.dameAlumno("16345"), "Perelmut", "Ezequiel", null));
//        
//        System.out.println(gPersonas.borrarAlumno(gPersonas.dameAlumno("16343")));
//        System.out.println(gPersonas.borrarAlumno(gPersonas.dameAlumno("17349")));
//        System.out.println(gPersonas.borrarAlumno(gPersonas.dameAlumno(null)));
//        System.out.println(gPersonas.borrarAlumno(gPersonas.dameAlumno("")));
//        
//        System.out.println(gPersonas.borrarProfesor(gPersonas.dameProfesor(1234567)));
//        System.out.println(gPersonas.borrarProfesor(gPersonas.dameProfesor(41649842)));
//        System.out.println(gPersonas.borrarProfesor(gPersonas.dameProfesor(0)));
        
//        System.out.println(gTrabajos.finalizarTrabajo(gTrabajos.dameTrabajo("Protocolos de comunicación"), LocalDate.of(2018,10,10)));
//        System.out.println(gTrabajos.finalizarTrabajo(null, LocalDate.of(2019,02,03)));
//        System.out.println(gTrabajos.finalizarTrabajo(gTrabajos.dameTrabajo("Protocolos de comunicación"), null));
//        System.out.println(gTrabajos.finalizarTrabajo(gTrabajos.dameTrabajo("Protocolos de comunicación"), fecha1));
//        
//        
//        System.out.println(gTrabajos.borrarTrabajo(gTrabajos.dameTrabajo("Protocolos de comunicación")));
//        System.out.println(gTrabajos.borrarTrabajo(gTrabajos.dameTrabajo(null)));
//        System.out.println(gTrabajos.borrarTrabajo(gTrabajos.dameTrabajo("")));
//        System.out.println(gTrabajos.borrarTrabajo(gTrabajos.dameTrabajo("BORRAR")));
        
//        System.out.println(gTrabajos.reemplazarProfesor(gTrabajos.dameTrabajo("Protocolos de comunicación"), gPersonas.dameProfesor(41649842), LocalDate.of(2019,10,10), "paja", null));
        
        System.out.println(gTrabajos.finalizarAlumno(gTrabajos.dameTrabajo("Protocolos de comunicación"), gPersonas.dameAlumno("16345"), LocalDate.of(2019,10,10), null));
        
    
    
    }}