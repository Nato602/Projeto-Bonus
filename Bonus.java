/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Principal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alan
 */
public class Bonus {

    
    public static void main(String[] args) {
        
    List<Funcionario> funcionarios = List.of(
            new Funcionario(1, 150000, "desenvolvedor", 101),
            new Funcionario(2, 123000, "gerente", 102),
            new Funcionario(3, 140000, "analista", 101),
            new Funcionario(4, 90000, "desenvolvedor", 102)
        );

        List<Departamento> departamentos = List.of(
            new Departamento(101, 500000),
            new Departamento(102, 500000)
        );

        BonusControle bonusControle = new BonusControle(funcionarios, departamentos);
        try {
            int resultado = bonusControle.calcularBonus();
            System.out.println("Cálculo de bônus concluído. Código de retorno: " + resultado);
        } catch (BonusAlerta e) {
            System.err.println("Erro no cálculo de bônus: " + e.getMessage() + " (Código: " + e.getCodigoErro() + ")");
        }

        // Exibindo os novos salários
        funcionarios.forEach(func -> System.out.println("Funcionário ID: " + func.getId() + ", Novo Salário: " + func.getSalario()));
    }
        
    
}