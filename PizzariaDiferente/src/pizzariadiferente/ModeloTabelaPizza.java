/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzariadiferente;

import Bean.Cliente;
import Bean.Pedido;
import Bean.Pizza;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dell-soncini
 */

public class ModeloTabelaPizza extends AbstractTableModel{
    private String[] colunas=new String[]{"Forma", "Area", "Sabores", "Preco"};

    private List<Pizza> lista=new ArrayList<Pizza>();

    
    public ModeloTabelaPizza(List<Pizza> lista){
        this.lista=lista;
    }

    public ModeloTabelaPizza(){
    }


    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
            return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pizza pizza = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return pizza.getForma().getNome();
            case 1: return pizza.getForma().getArea();
            case 2: return pizza.getStringSabor();
            case 3: return pizza.getPreco();
            default : return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        try {
            Pizza pizza = lista.get(row);
            this.fireTableCellUpdated(row, col);
        } catch (Exception  ex) {
            ex.printStackTrace();
        }
    }

    public boolean removePizza(Pizza pizza) {
        int linha = this.lista.indexOf(pizza);
        boolean result = this.lista.remove(pizza);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaPizza(Pizza pizza) {
        this.lista.add(pizza);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaPizza(List<Pizza> pizzas) {
        this.lista = pizzas;
        this.fireTableDataChanged();
        //this.fireTableRowsInserted(0,contatos.size()-1);//update JTable
    }

    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public Pizza getPedido(int linha){
        return lista.get(linha);
    }
    
}