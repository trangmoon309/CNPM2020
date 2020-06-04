package CNPM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;

public class RegisterTiem extends JFrame {

	private JPanel contentPane;
	private JTextField tbHoten;
	private JTextField tbSL1;
	private JTextField tbSL2;
	private JTextField tbSL3;
	private JTextField tbDate;
	String userName;
	Connection conn = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//RegisterTiem frame = new RegisterTiem();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public RegisterTiem(String u) {
		userName = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0103ng k\u00FD l\u1ECBch ti\u00EAm");
		lblNewLabel.setForeground(SystemColor.textInactiveText);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
		//Datetime pick selected date
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setForeground(SystemColor.windowBorder);
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				String d1  = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				tbDate.setText(d1.toString());
			}
		});

		dateChooser.setDateFormatString("yyyy-MM-dd");

		if((Date) dateChooser.getDate() != null) {
			Date date = (Date) dateChooser.getDate();
			tbDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate()));
		}
		


		tbDate = new JTextField();
		tbDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tbDate.setColumns(10);
		
		JLabel lblNgyngK = new JLabel("Ng\u00E0y \u0111\u0103ng k\u00ED");
		lblNgyngK.setForeground(SystemColor.windowBorder);
		lblNgyngK.setFont(new Font("Arial", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(102)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
						.addComponent(dateChooser, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(91, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNgyngK, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(tbDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(153))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(98)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tbDate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNgyngK, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(270, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbHoten = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lbHoten.setForeground(SystemColor.windowBorder);
		lbHoten.setFont(new Font("Arial", Font.PLAIN, 18));
		lbHoten.setBounds(35, 103, 89, 34);
		panel_1.add(lbHoten);
		
		JLabel lbSoLuongVN = new JLabel("S\u1ED1 lo\u1EA1i v\u1EADt nu\u00F4i");
		lbSoLuongVN.setForeground(SystemColor.windowBorder);
		lbSoLuongVN.setFont(new Font("Arial", Font.PLAIN, 18));
		lbSoLuongVN.setBounds(35, 150, 133, 34);
		panel_1.add(lbSoLuongVN);
		
		JLabel lbVN1 = new JLabel("V\u1EADt nu\u00F4i 1");
		lbVN1.setForeground(SystemColor.windowBorder);
		lbVN1.setFont(new Font("Arial", Font.PLAIN, 18));
		lbVN1.setBounds(35, 197, 133, 34);
		panel_1.add(lbVN1);
		
		JLabel lbSL1 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lbSL1.setForeground(SystemColor.windowBorder);
		lbSL1.setFont(new Font("Arial", Font.PLAIN, 18));
		lbSL1.setBounds(35, 244, 133, 34);
		panel_1.add(lbSL1);
		
		JLabel lbVN2 = new JLabel("V\u1EADt nu\u00F4i 2");
		lbVN2.setForeground(SystemColor.windowBorder);
		lbVN2.setFont(new Font("Arial", Font.PLAIN, 18));
		lbVN2.setBounds(35, 290, 133, 34);
		lbVN2.setVisible(false);
		panel_1.add(lbVN2);
		
		JLabel lbSL2 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lbSL2.setForeground(SystemColor.windowBorder);
		lbSL2.setFont(new Font("Arial", Font.PLAIN, 18));
		lbSL2.setBounds(35, 337, 133, 34);
		lbSL2.setVisible(false);
		panel_1.add(lbSL2);
		
		JLabel lbVN3 = new JLabel("V\u1EADt nu\u00F4i 3");
		lbVN3.setForeground(SystemColor.windowBorder);
		lbVN3.setFont(new Font("Arial", Font.PLAIN, 18));
		lbVN3.setBounds(35, 384, 133, 34);
		lbVN3.setVisible(false);
		panel_1.add(lbVN3);
		
		JLabel lbSL3 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng");
		lbSL3.setForeground(SystemColor.windowBorder);
		lbSL3.setFont(new Font("Arial", Font.PLAIN, 18));
		lbSL3.setBounds(35, 430, 133, 34);
		lbSL3.setVisible(false);
		panel_1.add(lbSL3);
		
		tbHoten = new JTextField();
		tbHoten.setFont(new Font("Arial", Font.PLAIN, 17));
		tbHoten.setBounds(180, 103, 259, 29);
		panel_1.add(tbHoten);
		tbHoten.setColumns(10);
		
		JComboBox cbVN1 = new JComboBox();
		cbVN1.setModel(new DefaultComboBoxModel(new String[] {"Ngan", "V\u1ECBt", "Ng\u1ED7ng", "G\u00E0", "B\u00F2", "Tr\u00E2u", "D\u00EA", "C\u1EEBu ", "Heo"}));
		cbVN1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbVN1.setBounds(180, 197, 117, 29);
		panel_1.add(cbVN1);
		
		JComboBox cbVN2 = new JComboBox();
		cbVN2.setModel(new DefaultComboBoxModel(new String[] {"Ngan", "V\u1ECBt", "Ng\u1ED7ng", "G\u00E0", "B\u00F2", "Tr\u00E2u", "D\u00EA", "C\u1EEBu ", "Heo"}));
		cbVN2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbVN2.setBounds(180, 290, 117, 29);
		cbVN2.setVisible(false);
		panel_1.add(cbVN2);
		
		JComboBox cbVN3 = new JComboBox();
		cbVN3.setModel(new DefaultComboBoxModel(new String[] {"Ngan", "V\u1ECBt", "Ng\u1ED7ng", "G\u00E0", "B\u00F2", "Tr\u00E2u", "D\u00EA", "C\u1EEBu ", "Heo"}));
		cbVN3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbVN3.setBounds(180, 384, 117, 29);
		cbVN3.setVisible(false);
		panel_1.add(cbVN3);
		
		tbSL1 = new JTextField();
		tbSL1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbSL1.setBounds(180, 244, 116, 29);
		panel_1.add(tbSL1);
		tbSL1.setColumns(10);
		
		tbSL2 = new JTextField();
		tbSL2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbSL2.setColumns(10);
		tbSL2.setBounds(180, 337, 116, 29);
		tbSL2.setVisible(false);
		panel_1.add(tbSL2);
		
		tbSL3 = new JTextField();
		tbSL3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tbSL3.setColumns(10);
		tbSL3.setBounds(180, 430, 116, 29);
		tbSL3.setVisible(false);
		panel_1.add(tbSL3);
		tbHoten.setText(userName);
		tbHoten.setEditable(false);
		
		//Button DangKy Event Handler
		JButton btnDangKy = new JButton("\u0110\u0103ng k\u00FD");
		btnDangKy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterTiemModel model = new RegisterTiemModel();
				Vacxin vx = new Vacxin();
				Animal ani = new Animal();

				try {
					conn = Connect_DB.getSQLServer();
					String query = "insert into DangkiTiem(idHodan,idVaccine,idVatNuoi,Number,Date_register) values (?,?,?,?,?)";
					PreparedStatement pre = conn.prepareStatement(query);
					
					int idHD = model.getIDfromUserName(userName);
					pre.setInt(1, idHD);
					pre.setString(2,vx.getIDByAnimalName(cbVN1.getSelectedItem().toString()));
					pre.setString(3,ani.getIDByAnimalName(cbVN1.getSelectedItem().toString()));
					pre.setInt(4, Integer.parseInt(tbSL1.getText()));
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
					String dateInString = tbDate.getText();
					java.sql.Date sqlDate = java.sql.Date.valueOf( dateInString );
					pre.setDate(5, sqlDate);
					int row= pre.executeUpdate();
					if(row != 0) JOptionPane.showMessageDialog(null,"Thanh cong!");
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDangKy.setForeground(SystemColor.windowBorder);
		btnDangKy.setFont(new Font("Arial", Font.BOLD, 18));
		btnDangKy.setBounds(180, 315, 158, 42);
		panel_1.add(btnDangKy);
		
		//Combobox so luong loai vat nuoi Event Handler
		JComboBox cbSL = new JComboBox();
		cbSL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String)cbSL.getSelectedItem();
				if(Integer.parseInt(selectedItem) == 2) {
					cbVN2.setVisible(true);
					tbSL2.setVisible(true);
					lbVN2.setVisible(true);
					lbSL2.setVisible(true);
					btnDangKy.setBounds(180, 400, 158, 42);
				}
				else if(Integer.parseInt(selectedItem) == 3) {
					cbVN2.setVisible(true);
					tbSL2.setVisible(true);
					lbVN2.setVisible(true);
					lbSL2.setVisible(true);
					cbVN3.setVisible(true);
					tbSL3.setVisible(true);
					lbVN3.setVisible(true);
					lbSL3.setVisible(true);
					btnDangKy.setBounds(180, 490, 158, 42);
				}
				else {
					cbVN2.setVisible(false);
					tbSL2.setVisible(false);
					lbVN2.setVisible(false);
					lbSL2.setVisible(false);
					cbVN3.setVisible(false);
					tbSL3.setVisible(false);
					lbVN3.setVisible(false);
					lbSL3.setVisible(false);
					btnDangKy.setBounds(180, 315, 158, 42);
				}
			}
		});

		cbSL.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		cbSL.setFont(new Font("Tahoma", Font.PLAIN, 17));
		cbSL.setBounds(180, 150, 60, 34);
		panel_1.add(cbSL);

		

		
	}
}
