package com.ap.main;
import java.time.LocalDate;
import java.util.List;
import com.ap.implementacion.Empleado;
import com.ap.interfaces.Interface;
import com.ap.implementacion1.EmpleadoServiceImpl;


public class Main {
    public static void main(String[] args) {
    	Interface  empleadoService = new EmpleadoServiceImpl();

        // Registrar empleados
        Empleado emp1 = new Empleado(1, "Alicia Contreras", "Gerente", 5000, LocalDate.of(2020, 1, 15), "IT");
        Empleado emp2 = new Empleado(2, "Lucia Martinez", "Gerente Comercial", 10000, LocalDate.of(2018, 3, 22), "Administración");
        
        empleadoService.registrarEmpleado(emp1);
        empleadoService.registrarEmpleado(emp2);

        // Listar empleados
        List<Empleado> empleados = empleadoService.listarEmpleados();
        for (Empleado emp : empleados) {
            System.out.println(emp.getNombre() + " - " + emp.getPuestoTrabajo());
        }

        // Calcular IGSS y IRTRA
        double igssEmp1 = empleadoService.calcularIgss(emp1);
        double irtraEmp1 = empleadoService.calcularIrtra(emp1);

        System.out.println("IGSS de " + emp1.getNombre() + ": " + igssEmp1);
        System.out.println("IRTRA de " + emp1.getNombre() + ": " + irtraEmp1);

        // Agregar bonificaciones y descuentos
        empleadoService.agregarBono(emp1, 500);
        empleadoService.agregarDescuento(emp1, 200);

        // Dar de baja a un empleado
        empleadoService.bajarEmpleado(1);

        // Listar empleados después de dar de baja
        empleados = empleadoService.listarEmpleados();
        for (Empleado emp : empleados) {
            System.out.println(emp.getNombre() + " - " + emp.getPuestoTrabajo());
        }
    }
}
