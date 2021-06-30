package pia.football.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "football_team")
public class FootballTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "name")
	@NotBlank
	@NotNull
	private String name;
	
	@Column(name = "founded_year")
	@NotBlank
	@NotNull
	private int foundedYear;
	
	@Column(name = "image_url")
	@NotBlank
	@NotNull
	private int imageUrl;
	
	@ManyToOne()
	@JoinColumn(name="color_first")
	private Color colorFirst;
	
	@ManyToOne()
	@JoinColumn(name="color_second")
	private Color colorSecond;
	
	@ManyToOne()
	@JoinColumn(name = "football_league")
	private FootballLeague footballLeague;
	
	@ManyToOne()
	@JoinColumn(name = "city")
	private City city;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "footballTeam")
	@JsonIgnore
	private List<Footballer> footballers;

} 
