package br.com.exemplo.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.exemplo.dao.LeitorDAO;
import br.com.exemplo.model.Leitor;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNomeDoLeitor;
	private JLabel lblTipoDoLeitor;
	private JTextField txtCodigoLeitor;
	private JTextField txtNomeLeitor;
	private JComboBox cmbTipoLeitor;
	private TextArea txtListar;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnSair;
	private Leitor leitor;
	private LeitorDAO dao;
	private JButton btnExcluir;
	private JButton btnConsultar;
	private JButton btnListar;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setTitle("Sistema de Leitor");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 599);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("C\u00D3DIGO:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(182, 170, 45, 14);
		contentPane.add(lblNewLabel);
		
		lblNomeDoLeitor = new JLabel("NOME:");
		lblNomeDoLeitor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNomeDoLeitor.setBounds(192, 196, 33, 14);
		contentPane.add(lblNomeDoLeitor);
		
		lblTipoDoLeitor = new JLabel("TIPO:");
		lblTipoDoLeitor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipoDoLeitor.setBounds(197, 225, 28, 14);
		contentPane.add(lblTipoDoLeitor);
		
		txtCodigoLeitor = new JTextField();
		txtCodigoLeitor.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(64, 64, 64)));
		txtCodigoLeitor.setBounds(229, 164, 154, 20);
		contentPane.add(txtCodigoLeitor);
		txtCodigoLeitor.setColumns(10);
		
		txtNomeLeitor = new JTextField();
		txtNomeLeitor.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(64, 64, 64)));
		txtNomeLeitor.setColumns(10);
		txtNomeLeitor.setBounds(228, 190, 420, 20);
		contentPane.add(txtNomeLeitor);
		
		cmbTipoLeitor = new JComboBox();
		cmbTipoLeitor.setBackground(Color.WHITE);
		cmbTipoLeitor.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cmbTipoLeitor.setModel(new DefaultComboBoxModel(new String[] {"Selecione o tipo do leitor", "Aluno", "Professor", "Administrativo"}));
		cmbTipoLeitor.setBounds(229, 217, 419, 22);
		contentPane.add(cmbTipoLeitor);
		
		txtListar = new TextArea();
		txtListar.setBackground(SystemColor.text);
		txtListar.setBounds(182, 277, 468, 272);
		contentPane.add(txtListar);
		
		btnNovo = new JButton("");
		Image imgNovo = new ImageIcon(this.getClass().getResource("novo.png")).getImage();
		btnNovo.setIcon(new ImageIcon(imgNovo));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=====
				txtCodigoLeitor.setText(null);
				txtNomeLeitor.setText(null);
				txtListar.setText(" ");
				cmbTipoLeitor.setSelectedIndex(0);
				//=====
			}
		});
		btnNovo.setBounds(10, 142, 155, 49);
		contentPane.add(btnNovo);
		
		btnSalvar = new JButton("");
		Image imgSalvar = new ImageIcon(this.getClass().getResource("salvar.png")).getImage();
		btnSalvar.setIcon(new ImageIcon(imgSalvar));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==============
				leitor = new Leitor();
				leitor.setNomeLeitor(txtNomeLeitor.getText());
				leitor.setCodigoLeitor(Integer.parseInt(txtCodigoLeitor.getText()));
				leitor.setTipoLeitor((String)cmbTipoLeitor.getSelectedItem());
				try {
					dao = new LeitorDAO();
					dao.salvar(leitor);
					JOptionPane.showMessageDialog(null, "Leitor salvo com sucesso! :D");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao gravar");
				}
				//==============
			}
		});
		btnSalvar.setBounds(10, 207, 155, 49);
		contentPane.add(btnSalvar);
		
		btnSair = new JButton("");
		Image imgSair = new ImageIcon(this.getClass().getResource("sair.png")).getImage();
		btnSair.setIcon(new ImageIcon(imgSair));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//============
				JOptionPane.showMessageDialog(null, "Encerrando o programa, obrigado :)");
				System.exit(0);
				//============
			}
		});
		btnSair.setBounds(10, 500, 155, 49);
		contentPane.add(btnSair);
		
		JButton btnAlterar = new JButton("");
		Image imgAlterar = new ImageIcon(this.getClass().getResource("alterar.png")).getImage();
		btnAlterar.setIcon(new ImageIcon(imgAlterar));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==============
				leitor = new Leitor();
				leitor.setNomeLeitor(txtNomeLeitor.getText());
				leitor.setCodigoLeitor(Integer.parseInt(txtCodigoLeitor.getText()));
				leitor.setTipoLeitor((String)cmbTipoLeitor.getSelectedItem());
				try {
					dao = new LeitorDAO();
					dao.alterar(leitor);
					JOptionPane.showMessageDialog(null, "Você alterou os dados com sucesso!");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao gravar");
				}
				//==============
			}
		});
		btnAlterar.setBounds(10, 319, 155, 49);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setBackground(Color.WHITE);
		Image imgExcluir = new ImageIcon(this.getClass().getResource("excluir.png")).getImage();
		btnExcluir.setIcon(new ImageIcon(imgExcluir));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//================
				try {
					dao = new LeitorDAO(); // abre o banco de dados
					int codLeitor = Integer.parseInt(txtCodigoLeitor.getText());
					dao.excluir(codLeitor);   // alterar
					JOptionPane.showMessageDialog(null, "Leitor excluido :)");
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				//=====================
			}
		});
		btnExcluir.setBounds(10, 376, 155, 49);
		contentPane.add(btnExcluir);
		
		btnConsultar = new JButton("");
		Image imgConsultar = new ImageIcon(this.getClass().getResource("Consultar.png")).getImage();
		btnConsultar.setIcon(new ImageIcon(imgConsultar));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//================
				try {
					dao = new LeitorDAO(); // abre o banco de dados
					int codLeitor = Integer.parseInt(txtCodigoLeitor.getText());
					leitor = dao.consultar(codLeitor);   // consultar
					txtNomeLeitor.setText(leitor.getNomeLeitor());
					if(leitor.getTipoLeitor().equalsIgnoreCase("aluno")) {
						//ele compara o equals e ignore case ignora se é maiusculo ou minusculo
						cmbTipoLeitor.setSelectedIndex(1);
					} else if(leitor.getTipoLeitor().equalsIgnoreCase("professor")) {
						cmbTipoLeitor.setSelectedIndex(2);
					} else if(leitor.getTipoLeitor().equalsIgnoreCase("administrativo")) {
						cmbTipoLeitor.setSelectedIndex(3);
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
				//=====================
			}
		});
		btnConsultar.setBounds(10, 262, 155, 49);
		contentPane.add(btnConsultar);
		
		btnListar = new JButton("");
		Image imgListar = new ImageIcon(this.getClass().getResource("listar.png")).getImage();
		btnListar.setIcon(new ImageIcon(imgListar));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==================================
				List<Leitor> lista = new ArrayList<Leitor>();
				try {
					dao = new LeitorDAO(); // abre o banco
					txtListar.setText(" \n");
					lista = dao.listarTodos();
					for(Leitor leitor:lista) {
						txtListar.append("Código : "+ leitor.getCodigoLeitor()+"\n");
						txtListar.append("Nome   : "+ leitor.getNomeLeitor()+"\n");
						txtListar.append("Tipo      : "+ leitor.getTipoLeitor()+"\n");
						txtListar.append("\n");
					}
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				//==================================
			}
		});
		btnListar.setBounds(10, 442, 155, 49);
		contentPane.add(btnListar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 662, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image imgTitulo = new ImageIcon(this.getClass().getResource("titulo.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(imgTitulo));
		lblNewLabel_2.setBounds(207, 11, 270, 113);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("[INSERIR DADOS]");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(182, 142, 147, 20);
		contentPane.add(lblNewLabel_1);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(10, 197, 155, 4);
		contentPane.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(10, 432, 155, 4);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("[LISTAGEM DOS DADOS]");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(182, 250, 201, 20);
		contentPane.add(lblNewLabel_1_1);
	}
}
