package spring5Hiberante5.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int id;

	@Column(name = "category_name")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "CATEGORYOS", joinColumns = {
			@JoinColumn(referencedColumnName = "category_id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "os_id") })
	private Set<OperatingSystem> os;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "category")
	private Set<Brand> brand;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<OperatingSystem> getOs() {
		return os;
	}

	public void setOs(Set<OperatingSystem> os) {
		this.os = os;
	}

	public Set<Brand> getBrand() {
		return brand;
	}

	public void setBrand(Set<Brand> brand) {
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
