/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

/**
 *
 * @author Alan
 */
public class Funcionario {


    private int id;
    private double salario;
    private String cargo;
    private int departamentoId;

    public Funcionario(int id, double salario, String cargo, int departamentoId) {
        this.id = id;
        this.salario = salario;
        this.cargo = cargo;
        this.departamentoId = departamentoId;
    }

    public int getId() {
        return id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public boolean isGerente() {
        return "gerente".equalsIgnoreCase(cargo);
    }

    
    
    
    
    
    
}

    

