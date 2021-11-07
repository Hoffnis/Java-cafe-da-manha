package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Da {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/caffe?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "1234";

	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			return con;
		} catch (Exception e) {
			System.out.println(e);

			return null;

		}
	}

	public void testeConexao() {

		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void inserirdados(Native nat) {
		String creat = "insert into cafe (cpf, nome, comida) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(creat);
			pst.setString(1, nat.getCpf());
			pst.setString(2, nat.getNome());
			pst.setString(3, nat.getComida());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Native> listarcontatos(){
		ArrayList<Native> cafe = new ArrayList<>();
		String read = "select * from cafe order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String cpf = rs.getString(1);
				String nome = rs.getString(2);
				String comida = rs.getString(3);
				String idade = rs.getString(3);

				
				cafe.add(new Native(cpf,nome,comida,idade));
			}
			con.close();
			return cafe;
		} catch (Exception e) {
		
		System.out.println(e);
		return null;
		}
	}
	
	public void selecionarContato(Native nat) {
		String read2 = "Select * from cafe where cpf = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, nat.getCpf());
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				nat.setCpf(rs.getString(1));
				nat.setNome(rs.getString(2));
				nat.setComida(rs.getString(3));
				nat.setIdade(rs.getString(4));
			}
			con.close();
			
		} catch (Exception e) {
		System.out.println(e);
		}
	}
	public void alterarContato(Native nat) {
		String create = "update contatos set cpf=?, nome=?, comida=?, idade=?";
		
		try {
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(create);
		pst.setString(1, nat.getCpf());
		pst.setString(2, nat.getNome());
		pst.setString(3, nat.getComida());
		pst.setString(4, nat.getIdade());
		pst.executeUpdate();
		con.close();
		
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void deletarContato(Native nat) {
		String delete = "delete from contatos where cpf=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, nat.getCpf());
			pst.executeUpdate();
			con.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
