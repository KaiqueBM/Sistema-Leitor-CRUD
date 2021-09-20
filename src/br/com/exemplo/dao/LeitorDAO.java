package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import br.com.exemplo.model.Leitor;
import br.com.exemplo.util.ConnectionFactory;
import java.sql.ResultSet; //tabela
import java.util.ArrayList;
import java.util.List;

public class LeitorDAO {  // CRUD
	
	private Leitor leitor;
	private Connection conn;       // conecta com o banco de dados
	private PreparedStatement ps;  // permite executar querys
	private ResultSet rs; //sou uma tabela - guarda resultado do select
	
	public LeitorDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
		}catch(Exception e) {
			throw new Exception("Erro "+ e.getMessage());
		}
	}

	public void salvar(Leitor leitor) throws Exception {
		try {
			String sql="INSERT INTO tbLeitor(codLeitor, nomeLeitor,tipoLeitor) "
					+ " values (?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, leitor.getCodigoLeitor());
			ps.setString(2, leitor.getNomeLeitor());
			ps.setString(3, leitor.getTipoLeitor());
			ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception("Erro ao salvar "+ e.getMessage());
		}	
	}
	
	//alterar
	public void alterar(Leitor leitor) throws Exception {
		try {
			String sql="UPDATE  tbLeitor SET nomeLeitor=?, tipoLeitor=? "
					+ " WHERE codLeitor=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, leitor.getNomeLeitor());
			ps.setString(2, leitor.getTipoLeitor());
			ps.setInt(3, leitor.getCodigoLeitor());
			ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception("Erro ao alterar "+ e.getMessage());
		}	
	}
	
	//excluir
		public void excluir(int codLeitor) throws Exception {
			try {
				String sql="DELETE FROM tbLeitor WHERE codLeitor=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, codLeitor);
				ps.executeUpdate();
			}catch(Exception e) {
				throw new Exception("Erro ao excluir "+ e.getMessage());
			}	
		}
		
		//consultar
				public Leitor consultar(int codLeitor) throws Exception {
					try {
						String sql="SELECT * FROM tbLeitor WHERE codLeitor=?";
						ps = conn.prepareStatement(sql);
						ps.setInt(1, codLeitor);
						rs = ps.executeQuery();
						if(rs.next()) { //ele pula para a próxima linha da tabela até dar F que é quando acabar.
							int codigoLeitor = rs.getInt("codLeitor"); //peguei o cod do banco
							String nomeLeitor = rs.getString("nomeLeitor");
							String tipoLeitor = rs.getString("tipoLeitor");
							leitor = new Leitor(codigoLeitor, nomeLeitor, tipoLeitor);
						}
					}catch(Exception e) {
						throw new Exception("Erro ao consultar "+ e.getMessage());
					}
					return leitor;
				}
				
				//listar
				public List listarTodos() throws Exception {
					List<Leitor> lista = new ArrayList<Leitor>();
					try {
						String sql="SELECT * FROM tbLeitor";
						ps = conn.prepareStatement(sql);
						rs = ps.executeQuery();
						while(rs.next()) {
							int codigoLeitor = rs.getInt("codLeitor");
							String nomeLeitor = rs.getString("nomeLeitor");
							String tipoLeitor = rs.getString("tipoLeitor");
							leitor = new Leitor(codigoLeitor,nomeLeitor, tipoLeitor);
							lista.add(leitor);
						}
					}catch(Exception e) {
						throw new Exception("Erro ao consultar "+ e.getMessage());
					}	
					return lista;
				}
}