package com.brencorp.presentation;

import com.brencorp.model.Catador;
import com.brencorp.business.CatadorService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CatadorView extends JFrame {
    private CatadorService catadorService = new CatadorService();
    
    private JTextField txtId = new JTextField(5);
    private JTextField txtName = new JTextField(20);
    private JTextField txtEmail = new JTextField(20);
    private JTable catadorTable;
    private DefaultTableModel tableModel;
    
    public CatadorView() {
        setTitle("Gerenciamento de Catadores");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("ID:"));
        add(txtId);
        add(new JLabel("Nome:"));
        add(txtName);
        add(new JLabel("Email:"));
        add(txtEmail);

        JButton btnCreate = new JButton("Criar");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCatador();
            }
        });
        add(btnCreate);

        JButton btnReadAll = new JButton("Mostrar Todos");
        btnReadAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readAllCatadores();
            }
        });
        add(btnReadAll);

        JButton btnUpdate = new JButton("Atualizar");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCatador();
            }
        });
        add(btnUpdate);

        JButton btnDelete = new JButton("Excluir");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCatador();
            }
        });
        add(btnDelete);

        // Configurar a tabela de catadores
        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Email"}, 0);
        catadorTable = new JTable(tableModel);
        add(new JScrollPane(catadorTable));

        setVisible(true);
    }

    private void createCatador() {
        if (validateFields()) {
            Catador catador = new Catador();
            catador.setId(Integer.parseInt(txtId.getText()));
            catador.setName(txtName.getText());
            catador.setEmail(txtEmail.getText());
            catadorService.createCatador(catador);
            JOptionPane.showMessageDialog(this, "Catador criado com sucesso!");
            clearFields();
        }
    }

    private void readAllCatadores() {
        List<Catador> catadores = catadorService.getAllCatadores();
        tableModel.setRowCount(0); // Limpar a tabela
        for (Catador catador : catadores) {
            tableModel.addRow(new Object[]{catador.getId(), catador.getName(), catador.getEmail()});
        }
    }

    private void updateCatador() {
        if (validateFields()) {
            Catador catador = new Catador();
            catador.setId(Integer.parseInt(txtId.getText()));
            catador.setName(txtName.getText());
            catador.setEmail(txtEmail.getText());
            catadorService.updateCatador(catador);
            JOptionPane.showMessageDialog(this, "Catador atualizado com sucesso!");
            clearFields();
        }
    }

    private void deleteCatador() {
        int id = Integer.parseInt(txtId.getText());
        catadorService.deleteCatador(id);
        JOptionPane.showMessageDialog(this, "Catador excluído com sucesso!");
    }

    private boolean validateFields() {
        if (txtId.getText().isEmpty() || txtName.getText().isEmpty() || txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtEmail.setText("");
    }

    public static void main(String[] args) {
        new CatadorView();
    }
}
