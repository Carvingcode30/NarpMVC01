package kr.bit.model;
/*
 * create table member(
	num int primary key auto_increment,
	id varchar(20) not null,
	pass varchar(20) not null,
	name varchar(30) not null,
	age int not null,
	email varchar(30) not null,
	phone varchar(30) not null
)
 */
//회원(Object) -> MemberVO
public class MemberVO {
	private int num;
	private String id;
	private String pass;
	private String name;
	private int age;
	private String email;
	private String phone;
	
	// 기본 생성자
	// 다른 생성자가 있으면 별도로 정의 해줘야함
	public MemberVO() { }
	
	// 회원 객체 생성 및 초기화 담당(아마도?)
	public MemberVO(String id, String pass, String name, int age, String email, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}
	
	// Overloading 회원 번호를 포함, 특정 회원 정보 식별 및 초기화(아마도?) 
	public MemberVO(int num, String id, String pass, String name, int age, String email, String phone) {
		super();
		this.num = num;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}


	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// toString() 메서드는 객체의 내용을 문자열로 반환하는 메서드
	// Java의 모든 클래스는 Object 클래스에서 상속받는 toString() 메서드를 가지고 있다
	// 객체의 상태를 쉽게 확인하고 디버깅하기 용이함
	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pass=" + pass + ", name=" + name + ", age=" + age + ", email="
				+ email + ", phone=" + phone + "]";
	}
	
}
