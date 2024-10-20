package edu.java.lab2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.*;

/**
 * Program for cinema
 * 
 * Author: Ivan_Arno
 * Version: 1.0
 * Since: 2024
 */

public class App {
    private JFrame frame;
    private JToolBar buttonsPanel;
    private JButton save;
    private JButton open;
    private JButton add;
    private JButton edit;
    private JButton delete;
    private JButton info;
    private JButton filter;
    private DefaultTableModel model;
    private JTable films;
    private JComboBox<String> name;
    private JTextField filmName;
    private JPanel filterPanel;
    
    public void show() {
        frame = new JFrame("Список фильмов");
        // Создание панели инструментов
        buttonsPanel = new JToolBar();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        
        // Создание кнопок на панели
        save = new JButton(new ImageIcon("./Icons/save2.png"));
        open = new JButton(new ImageIcon("./Icons/Open.png"));
        add = new JButton(new ImageIcon("./Icons/add.png"));
        edit = new JButton(new ImageIcon("./Icons/edit.png"));
        delete = new JButton(new ImageIcon("./Icons/trash.png"));
        info = new JButton(new ImageIcon("./Icons/info.png"));

        // Размещение кнопок на панели
        buttonsPanel.add(save);
        buttonsPanel.add(open);
        buttonsPanel.add(add);
        buttonsPanel.add(edit);
        buttonsPanel.add(delete);
        buttonsPanel.add(info);
        
        // Размещение панели в окне
        frame.getContentPane().add(BorderLayout.NORTH, buttonsPanel);
        
        // Создание таблицы данных
        String[] columns = { "Фильм", "Жанр", "Сеанс", "Проданные билеты" };
        Object[][] data = {
            {"Дюна", "Научная фантастика", "18:00", "120"},
            {"Темные времена", "Драма", "20:30", "90"}
        };
        model = new DefaultTableModel(data, columns);
        films = new JTable(model);
        
        // Добавление таблицы в окно
        frame.add(BorderLayout.CENTER, new JScrollPane(films));

        // Создание панели поиска
        name = new JComboBox<>(new String[] { "Фильм", "Жанр", "Сеанс" });
        filmName = new JTextField("Название фильма");
        filter = new JButton("Поиск");
        filterPanel = new JPanel();
        filterPanel.add(name);
        filterPanel.add(filmName);
        filterPanel.add(filter);
        frame.add(BorderLayout.SOUTH, filterPanel);
        
        // Отображение окна
        frame.setVisible(true);

        // Обработка событий
        ButtonListener buttonListener = new ButtonListener();
        info.setActionCommand("Информация");
        add.setActionCommand("Добавить");
        delete.setActionCommand("Удалить");
        
        info.addActionListener(buttonListener);
        add.addActionListener(buttonListener);
        delete.addActionListener(buttonListener);
    }
    
    // Класс для обработки событий кнопок
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "Информация":
                    JOptionPane.showMessageDialog(frame, "Тест кнопки");
                    break;
                case "Добавить": {
                    int selectedRow = films.getSelectedRow();
                    if (selectedRow != -1) { // Проверяем, выбрана ли строка
                        model.insertRow(selectedRow + 1, new Object[]{});
                    } else {
                        model.addRow(new Object[]{});
                    }
                    break;
                }
                case "Удалить": {
                    int selectedRow = films.getSelectedRow();
                    if (selectedRow != -1) { // Проверяем, выбрана ли строка
                        model.removeRow(selectedRow);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Выберите строку для удаления.");
                    }
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new App().show();
    }
}
