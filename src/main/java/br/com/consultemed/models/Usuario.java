/**
 * 
 */
package br.com.consultemed.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author carlosbarbosagomesfilho
 *
 */

@NamedQueries({ @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
		@NamedQuery(name = "Usuario.loginUsuario", query = "SELECT u FROM Usuario u WHERE u.login =:login AND u.senha =:senha") })

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "TB_USUARIOS")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Getter
	@Setter
	@NonNull
	@Column(name = "LOGIN")
	private String login;

	@Getter
	@Setter
	@NonNull
	@Column(name = "SENHA")
	private String senha;

	@Getter
	@Setter
	@NonNull
	@Column(name = "EMAIL")
	private String email;

}
