package CNPM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.JButton;

import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class EditInfo extends JFrame {
	JPanel pnlHeader;
	JButton btnExit, btnMinimize, btnMaximize;
	static boolean maximized = true;
	int xMouse, yMouse;
	private JPanel panel;
	

	public static void main(String args[]) {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(EditInfo.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(EditInfo.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(EditInfo.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(EditInfo.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new EditInfo().setVisible(true);
			}
		});
	}

	
		public EditInfo() {
			
		initComponent();
		}
	
		private void initComponent() {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setTitle("Edit Pesonal Information");
			getContentPane().setBackground(SystemColor.activeCaption);
//			setLocationRelativeTo(null);
//			setLocation(300, 150);
		
		 pnlHeader = new JPanel();
		pnlHeader.setBackground(SystemColor.inactiveCaptionBorder);
		pnlHeader.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent m) {
				pnlHeaderMouseDragged(m);
			}
		});
		pnlHeader.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent m) {
				pnlHeaderMousePressed(m);
			}
		});
		
		 btnMinimize = new JButton();
		btnMinimize.setBorder(null);
		btnMinimize.setIcon(new ImageIcon(EditInfo.class.getResource("/gambar/Minimize (2).png")));
		btnMinimize.setOpaque(true);
		btnMinimize.setFocusable(false);
		btnMinimize.setContentAreaFilled(false);
		btnMinimize.setBackground(SystemColor.inactiveCaptionBorder);
		btnMinimize.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				btnMinimizeMouseEntered(evt);
			}
			public void mouseExited(MouseEvent evt) {
				btnMinimizeMouseExited(evt);
			}
		});
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed( ActionEvent evt ) {
				btnMinimizeActionPerformed(evt);
			}
		});
		 btnMaximize = new JButton();
		btnMaximize.setBorder(null);
		btnMaximize.setIcon(new ImageIcon(EditInfo.class.getResource("/gambar/Maximize (2).png")));
		btnMaximize.setOpaque(true);
		btnMaximize.setFocusable(false);
		btnMaximize.setContentAreaFilled(false);
		btnMaximize.setBackground(SystemColor.inactiveCaptionBorder);
		btnMaximize.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent m) {
				btnMaximizeMouseEntered(m);
			}
			public void mouseExited(MouseEvent m) {
				btnMaximizeMouseExited(m);
			}
			
		});
		btnMaximize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnMaximizeActionPerformed(evt);
			}
		});
		
		 btnExit = new JButton();
		btnExit.setBorder(null);
		btnExit.setIcon(new ImageIcon(EditInfo.class.getResource("/gambar/Exit.png")));
		btnExit.setOpaque(true);
		btnExit.setFocusable(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBackground(SystemColor.inactiveCaptionBorder);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});
		btnExit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent m) {
				btnExitMouseEntered(m);
			}
			public void mouseExited(MouseEvent m) {
				btnExitMouseExited(m);
			}
		});
		GroupLayout gl_pnlHeader = new GroupLayout(pnlHeader);
		gl_pnlHeader.setHorizontalGroup(
			gl_pnlHeader.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlHeader.createSequentialGroup()
					.addContainerGap(572, Short.MAX_VALUE)
					.addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMaximize, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
		);
		gl_pnlHeader.setVerticalGroup(
			gl_pnlHeader.createParallelGroup(Alignment.TRAILING)
				.addComponent(btnMinimize, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
				.addComponent(btnMaximize, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
				.addComponent(btnExit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
		);
		pnlHeader.setLayout(gl_pnlHeader);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
				.addComponent(pnlHeader, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
				.addComponent(pnlHeader, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 700, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 449, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		initComponents();
		
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 478);
		setUndecorated(true);
	}
	private void btnExitMouseEntered(MouseEvent evt) {
		btnExit.setBackground(new Color(232, 17, 35));
	}

	private void btnExitMouseExited(MouseEvent evt) {
		btnExit.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
	}
	

	private void btnExitActionPerformed(ActionEvent evt) {
		setVisible(false);
	}

	private void btnMaximizeMouseEntered(MouseEvent m) {
		btnMaximize.setBackground(new Color(229, 229, 229));
	}

	private void btnMaximizeMouseExited(MouseEvent evt) {
		btnMaximize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
	}

	private void btnMaximizeActionPerformed(ActionEvent evt) {
		if (maximized) {

			EditInfo.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			EditInfo.this.setMaximizedBounds(env.getMaximumWindowBounds());
			maximized = false;
		} else {
			setExtendedState(JFrame.NORMAL);
			maximized = true;
		}
	}

	private void btnMinimizeMouseEntered(MouseEvent evt) {
		btnMinimize.setBackground(new Color(229, 229, 229));
	}

	private void btnMinimizeMouseExited(MouseEvent evt) {
		btnMinimize.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
	}

	private void btnMinimizeActionPerformed(ActionEvent evt) {
		this.setState(Frame.ICONIFIED);
	}

	private void pnlHeaderMousePressed(MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void pnlHeaderMouseDragged(MouseEvent evt) {
		if (maximized) {
			int x = evt.getXOnScreen();
			int y = evt.getYOnScreen();
			this.setLocation(x - xMouse, y - yMouse);
		}
	}
}
