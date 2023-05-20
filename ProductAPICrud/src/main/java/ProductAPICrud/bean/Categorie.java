package ProductAPICrud.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Categorie {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "categoriId")
	    private int categoriId;
	    private String cName;
	    private int cdiscount;
	    private int cgst;
	    private int ccharges;
	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "CategoriID",referencedColumnName = "categoriId")
	    private List<Product> products;
		public int getCategoriId() {
			return categoriId;
		}
		public int getCdiscount() {
			return cdiscount;
		}
		public void setCdiscount(int cdiscount) {
			this.cdiscount = cdiscount;
		}
		public int getCgst() {
			return cgst;
		}
		public void setCgst(int cgst) {
			this.cgst = cgst;
		}
		public int getCcharges() {
			return ccharges;
		}
		public void setCcharges(int ccharges) {
			this.ccharges = ccharges;
		}
		public void setCategoriId(int categoriId) {
			this.categoriId = categoriId;
		}
		public String getcName() {
			return cName;
		}
		public void setcName(String cName) {
			this.cName = cName;
		}
		public List<Product> getProducts() {
			return products;
		}
		public void setProducts(List<Product> products) {
			this.products = products;
		}
		public Categorie(int categoriId, String cName, int cgst,int ccharges,int cdiscount ,List<Product> products) {
			super();
			this.categoriId = categoriId;
			this.cName = cName;
			this.cdiscount=cdiscount;
			this.cgst=cgst;
			this.ccharges=ccharges;
			this.products = products;
		}
		public Categorie() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
		
	    
	    
	    
	    
}