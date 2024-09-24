/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alan
 */
public class BonusControle {
    private List<Funcionario> listaFuncionarios;
    private List<Departamento> listaDepartamentos;
    private static final double BONUS_PADRAO = 2000.0;
    private static final double BONUS_REDUZIDO = 1000.0;

    public BonusControle(List<Funcionario> listaFuncionarios, List<Departamento> listaDepartamentos) {
        this.listaFuncionarios = listaFuncionarios;
        this.listaDepartamentos = listaDepartamentos;
    }

    public int calcularBonus() throws BonusAlerta {
        if (listaFuncionarios.isEmpty() || listaDepartamentos.isEmpty()) {
            throw new BonusAlerta(1, "Tabela de Funcionários ou Departamentos está vazia");
        }

        // Identificar o(s) departamento(s) com maior valor de vendas
        double maiorVenda = listaDepartamentos.stream()
                .mapToDouble(Departamento::getTotalVendas)
                .max()
                .orElse(0);

        List<Departamento> departamentosComMaiorVenda = listaDepartamentos.stream()
                .filter(dept -> dept.getTotalVendas() == maiorVenda)
                .toList();

        // Filtrar os funcionários elegíveis
        List<Funcionario> funcionariosElegiveis = listaFuncionarios.stream()
                .filter(func -> departamentosComMaiorVenda.stream()
                        .anyMatch(dept -> dept.getId() == func.getDepartamentoId()))
                .toList();

        if (funcionariosElegiveis.isEmpty()) {
            throw new BonusAlerta(2, "Nenhum funcionário elegível para bônus");
        }

        // Aplicar os bônus conforme as regras
        for (Funcionario func : funcionariosElegiveis) {
            if (func.getSalario() >= 150000 || func.isGerente()) {
                func.setSalario(func.getSalario() + BONUS_REDUZIDO);
            } else {
                func.setSalario(func.getSalario() + BONUS_PADRAO);
            }
        }

        return 0; // Execução bem-sucedida
    }

}