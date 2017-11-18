/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzariadiferente;

import Bean.Cliente;
import Bean.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dell-soncini
 */

public class ModeloTabelaPedido extends AbstractTableModel{
    private String[] colunas=new String[]{"id", "Nome", "Telefone", "Valor", "Status"};

    private List<Pedido> lista=new ArrayList<Pedido>();

    
    public ModeloTabelaPedido(List<Pedido> lista){
        this.lista=lista;
    }

    public ModeloTabelaPedido(){
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
        Pedido pedido = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return pedido.getId();
            case 1: return pedido.getCliente().getNome();
            case 2: return pedido.getCliente().getTelefone();
            case 3: return pedido.getValor();
            case 4: return pedido.getStatus().getDescricao();
            default : return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        try {
            Pedido customer = lista.get(row);
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

    public void adicionaPedido(Pedido pedido) {
        this.lista.add(pedido);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaPedido(List<Pedido> pedidos) {
        this.lista = pedidos;
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

    public Pedido getPedido(int linha){
        return lista.get(linha);
    }
    
}