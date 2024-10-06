package edu.java.lab2;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 * Program for cinema
 * 
 * @author Ivan_Arno
 * @version 1.0
 * @since 2024
 */

public class App {
	private JFrame frame;
	private JToolBar ButtonsPanel;
	private JButton save;
	private JButton open;
	private JButton add;
	private JButton edit;
	private JButton delete;
	private JButton info;
	private JButton filter;
	private DefaultTableModel model;
	private JTable films;
	private JComboBox Name;
	private JTextField filmName;
	private JPanel filterPanel;
	
	public void show() {
		frame = new JFrame ("Список фильмов");
		//**Добавляем панель*/
		ButtonsPanel = new JToolBar();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setLocationRelativeTo(null);
		//**кнопки на панели*/
		save = new JButton(new ImageIcon("./Icons/save2.png"));
		open = new JButton(new ImageIcon("./Icons/Open.png"));
		add = new JButton(new ImageIcon("./Icons/add.png"));
		edit = new JButton(new ImageIcon("./Icons/edit.png"));
		delete = new JButton(new ImageIcon("./Icons/trash.png"));
		info = new JButton(new ImageIcon("./Icons/info.png"));
		//**Размешяем кнопки на панель*/
		ButtonsPanel.add(save);
		ButtonsPanel.add(open);
		ButtonsPanel.add(add);
		ButtonsPanel.add(edit);
		ButtonsPanel.add(delete);
		ButtonsPanel.add(info);
		//**Размешяем панель*/
		frame.getContentPane().add(BorderLayout.NORTH, ButtonsPanel);
		//**Таблица данных*/
		 String[] columns = {"Фильм", "Жанр", "Сеанс", "Проданные билеты"};
		 Object[][] data = {
		            {"Дюна", "Научная фантастика", "18:00", "120"},
		            {"Темные времена", "Драма", "20:30", "90"}
		        };
		 model = new DefaultTableModel(data, columns);
		 films = new JTable(model);
		 
		 frame.add(BorderLayout.CENTER, new JScrollPane(films));
		 //**Панель поиска*/
		 Name = new JComboBox(new String[]{"Фильм", "Жанр",
		 "Сеанс"});
		 filmName = new JTextField("Название фильма");
		 filter = new JButton("Поиск");
		 filterPanel = new JPanel();
		 filterPanel.add(Name);
		 filterPanel.add(filmName);
		 filterPanel.add(filter);
		 frame.add(BorderLayout.SOUTH, filterPanel);
		 //**Отображение окна*/
		 frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new App().show();
	}
}