package edu.si.ing1.pds.vsc.connectionPool;

import java.util.List;

public class Person {
	private int id;
    private String name;
    private int age;
    private List<Person> list_person;
    public List<Person> getList_person() {
		return list_person;
	}
	public void setList_person(List<Person> list_person) {
		this.list_person = list_person;
	}
	public int getId() {return this.id;}
    public String getName() {return this.name;}
    public int getAge() {return this.age;}
    public void setName(String n) {this.name=n;}
    public void setAge(int a) {this.age=a;}

    public Person()
    {}
    public Person(int id, String name,int age)
    {
        this.id=id;
        this.name=name;
        this.age=age;
    }
}
