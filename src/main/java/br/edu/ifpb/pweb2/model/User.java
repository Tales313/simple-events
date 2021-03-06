package br.edu.ifpb.pweb2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.context.WebApplicationContext;

@Entity
@Table(name = "tb_usuario")
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Nome e obrigatorio")
	private String nome;

//	@Pattern(
//	regexp = "^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$", 
//	message = "Informe um telefone [(83) 98892-1223]")
	
	private String telefone;

	@NotEmpty(message = "Email e obrigatorio")
	private String email;

	@Size(min = 8, message = "A senha deve conter no minino 8 caracteres")
	private String senha;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "A data deve estar no passado")
	private Date datanascimento;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Evento> eventos = new ArrayList<>();

	@OneToOne
	private Candidato_Vaga candidato_vaga;

	@OneToOne
	private Avaliacao_Evento avaliacao_evento;

	private boolean isAdmin = false;

	public User() {};

	public Avaliacao_Evento getAvaliacao_evento() {
		return avaliacao_evento;
	}

	public void setAvaliacao_evento(Avaliacao_Evento avaliacao_evento) {
		this.avaliacao_evento = avaliacao_evento;
	}

	public Candidato_Vaga getCandidato_vaga() {
		return candidato_vaga;
	}

	public void setCandidato_vaga(Candidato_Vaga candidato_vaga) {
		this.candidato_vaga = candidato_vaga;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addEvento(Evento ev) {
		this.eventos.add(ev);
	}

	public void remove(Evento ev) {
		this.eventos.remove(ev);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", senha=" + senha
				+ ", datanascimento=" + datanascimento + "]";
	}

}
