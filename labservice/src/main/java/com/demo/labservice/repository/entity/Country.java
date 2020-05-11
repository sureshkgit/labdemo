package com.demo.labservice.repository.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "countries")
@Getter @Setter @NoArgsConstructor
public class Country implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String countryName;
    private String iso;
    
    @JsonIgnore
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<State> states;

	public Country(Long id, String countryName, String iso) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.iso = iso;
	}
}