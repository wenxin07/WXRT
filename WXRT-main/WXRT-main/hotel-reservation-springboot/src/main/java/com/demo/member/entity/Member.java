package com.demo.member.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.demo.domain.Reservation;
import com.demo.util.Utils;

@Entity
@Table(name = "Member")
public class Member {
	// Allows UI to delete guest by its temp id rather than send full name details
	// which equals/hashCode use.
	@Transient
	private UUID tempId = UUID.randomUUID();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Size(min = 1, max = 20)
	@NotNull(message = "required")
	@Column(name = "firstname")
	private String firstname;

	@Size(min = 1, max = 20)
	@NotNull(message = "required")
	@Column(name = "lastname")
	private String lastname;

// private boolean child;

	@Column(name = "birth")
	private Date birth;

	@Size(min = 10, max = 10)
	@Column(name = "phone")
	private String phone;

	@Column(name = "email", nullable = false)
	private String email;

	@Size(min = 6, max = 20)
	@Column(name = "password", nullable = false)
	private String password;

	@Transient
	private String checkpassword;
	
	@OneToMany(mappedBy="member", cascade= {CascadeType.PERSIST}, orphanRemoval = false)
	private Set<Reservation> reservations = new HashSet<>();

	public Member(Long id, String firstName, String lastName, String password, String sex, Date birth, String email,
			String phone, Set<Reservation> reservations) {
		super();
		this.id = id;
		this.firstname = firstName;
		this.lastname = lastName;
		this.password = password;
		this.birth = birth;
		this.email = email;
		this.phone = phone;
		this.reservations = reservations;
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param child
	 * @param birth
	 * @param phone
	 * @param email
	 * @param password
	 * @param registerTime
	 */

	// }

	public Member() {
	}

	public UUID getTempId() {
		return tempId;
	}

	public void setTempId(UUID tempId) {
		this.tempId = tempId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFormattedFullName() {
		return Utils.capitalizeWords(firstname) + " " + Utils.capitalizeWords(lastname);
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCheckpassword() {
		return checkpassword;
	}

	public void setCheckpassword(String checkpassword) {
		this.checkpassword = checkpassword;
	}

	@Override
	public String toString() {
		return "Member{" + "id=" + id + ", firstName='" + firstname + '\'' + ", lastName='" + lastname + '\''
				+ ", birth=" + birth + '\'' + ", phone=" + phone + '\'' + ", email=" + email + '\'' + ", password="
				+ password + '}';

	}

	/**
	 * @return A {@code Comparator} that orders adults first then by firstName then
	 *         lastName.
	 */
//    public static Comparator<Member> comparator() {
//        return Comparator.comparing(Member::isChild, Boolean::compareTo)
//                .thenComparing(Member::getFirstName)
//                .thenComparing(Member::getLastName);
//    }

	/**
	 * Cant use a UUID because that does not prevent a guest with the same name
	 * being added.
	 */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Member member = (Member) o;
//        return child == member.child &&
//        		Objects.equals(id, member.id)&&
//                Objects.equals(firstName, member.firstName) &&
//                Objects.equals(lastName, member.lastName);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(firstName, lastName, child);
//    }

}
