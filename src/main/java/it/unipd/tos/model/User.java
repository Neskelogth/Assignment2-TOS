////////////////////////////////////////////////////////////////////
// [Samuel] [Kostadinov] [1187605]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;
    public class User {
    String name;
    String surname;
    int age;
    int id;
    public User (String n, String s, int a, int i) {
        this.name = n;
        this.surname = s;
        this.age = a;
        this.id = i;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public boolean isMinorenne() {
        return age < 18;
    }
    public int getId() {
        return id;
    }
}
