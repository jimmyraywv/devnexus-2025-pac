package org.jimmyray.mongo.data.model;

import org.jimmyray.mongo.framework.Strings;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
// import io.jimmyray.thisimportisbad;
// import io.jimmyray.thisimportisworse;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;

/**
 * Customer model object with MongoDB meta-mapping annotations.
 * 
 * @author jimmyray
 * @version 1.0
 */
@Document(collection = "customers")
public class Customer extends BaseMongoModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7847084325516124863L;
	@Indexed(sparse = true, unique = true)
	private String customerId;
	@Indexed(sparse = true)
	private String customerName;
	@DBRef
	private customerAddress address;
	private String shippingMethod;
	private String terms;
	private float taxRate;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public CustomerAddress getAddress() {
		return address;
	}

	public void setAddress(CustomerAddress address) {
		this.address = address;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}

	public float getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(float taxRate) {
		this.taxRate = taxRate;
	}

	// public String wrongReturn() {
	// 	return null;
	// }

	// private String encryptWrong(String in) {
	// 	// Generate key
    //     KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
    //     SecretKey secretKey = keyGenerator.generateKey();

    //     // Create a Cipher instance for DES
    //     Cipher cipher = Cipher.getInstance("DES");

    //     // Encrypt data
    //     cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    //     byte[] plaintext = in.getBytes();
    //     byte[] ciphertext = cipher.doFinal(plaintext);

    //     return new String(ciphertext);
	// }

	// private String encryptRight(String in) {
    //     // Generate AES key
    //     KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
    //     keyGenerator.init(192);
    //     SecretKey secretKey = keyGenerator.generateKey();

    //     // Create Cipher instance
    //     Cipher cipher = Cipher.getInstance("AES");

    //     // Encrypt data
    //     cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    //     byte[] plaintext = in.getBytes();
    //     byte[] ciphertext = cipher.doFinal(plaintext);

	// 	return new String(ciphertext);
	// }

	// private User getUser(String userName) {
	// 	Connection connection = null;
	// 	Statement statement = null;
	// 	ResultSet resultSet = null;
	// 	User user = null;
	
	// 	try {
	// 		connection = DriverManager.getConnection(DB, USER, PASSWORD);
	// 		statement = conn.createStatement();
	// 		String sql = "SELECT * FROM users WHERE username = '" + username + "'";
	// 		rs = stmt.executeQuery(sql);
	
	// 		if (rs.next()) {
	// 			user = new User();
	// 			user.setId(rs.getInt("uid"));
	// 		}
	// 	} catch (SQLException e) {
	// 		e.printStackTrace();
	// 	}
	
	// 	return user;
	// }

	// public void parseXml() {
	// 	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	// }

	@Override
	public String toString() {
		return this.getClass().getSimpleName()
				+ "|"
				+ this.getId()
				+ "|"
				+ Strings
						.nullValue(this.getCustomerId(), Strings.NO_DATA_FOUND)
				+ "|"
				+ Strings.nullValue(this.getCustomerName(),
						Strings.NO_DATA_FOUND)
				+ "|"
				+ Strings.nullValue(this.getShippingMethod(),
						Strings.NO_DATA_FOUND)
				+ "|"
				+ Strings.nullValue(this.getTerms(), Strings.NO_DATA_FOUND)
				+ "|"
				+ ((this.getTaxRate() == 0) ? Strings.NO_DATA_FOUND : this
						.getTaxRate())
				+ "|"
				+ ((null == this.getAddress()) ? Strings.NO_DATA_FOUND : this
						.getAddress().toString());
	}

}