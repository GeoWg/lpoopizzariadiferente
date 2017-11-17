/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzariadiferente;

import Bean.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dell-soncini
 */

public class ModeloTabelaCliente extends AbstractTableModel{
    private String[] colunas=new String[]{"id","Nome", "Sobrenome", "Telefone","Endereco"};

    private List<Cliente> lista=new ArrayList<Cliente>();

    
    public ModeloTabelaCliente(List<Cliente> lista){
        this.lista=lista;
    }

    public ModeloTabelaCliente(){
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
        Cliente customer = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return customer.getId();
            case 1: return customer.getNome();
            case 2: return customer.getSobreNome();
            case 3: return customer.getTelefone();
            case 4: return customer.getEndereco() ;
            default : return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        try {
            Cliente customer = lista.get(row);
            switch (col) {
                case 0:
                    customer.setId((int) value); //if column 0 (code)
                    break;
                case 1:
                    customer.setNome((String) value);
                    break;
                case 2:
                    customer.setSobreNome((String) value);
                    break;
                case 3:
                    customer.setTelefone((String)value);
                    break;
                case 4:
                    customer.setEndereco((String) value);
                    break;
                default:
            }
            this.fireTableCellUpdated(row, col);
        } catch (Exception  ex) {
            ex.printStackTrace();
        }
    }

    public boolean removeCliente(Cliente customer) {
        int linha = this.lista.indexOf(customer);
        boolean result = this.lista.remove(customer);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaContato(Cliente customer) {
        this.lista.add(customer);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaClientes(List<Cliente> clientes) {
        this.lista = clientes;
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

    public Cliente getCliente(int linha){
        return lista.get(linha);
    }
    
}