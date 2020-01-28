package spring5Hiberante5.bean;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;

	@Column(name = "product_name")
	private String name;

	@Column(name = "Description")
	private String description;

	@Column(name = "reveived_date")
	private Date receivedDate;

	@Column(name = "quantity")
	private long quantity;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private Category category;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
	private Brand brand;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "os_id", referencedColumnName = "os_id")
	private OperatingSystem os;

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public OperatingSystem getOs() {
		return os;
	}

	public void setOs(OperatingSystem os) {
		this.os = os;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
