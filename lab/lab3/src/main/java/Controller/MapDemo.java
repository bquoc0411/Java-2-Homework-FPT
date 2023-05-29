/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Student;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, Student> map = new HashMap<>();
        Student sv = new Student("Mymy", 8.3, "Xu li du lieu");
        map.put(sv.getName(), sv);
        Student sv2 = new Student("Sam", 7, "Xu li du lieu");
        map.put(sv2.getName(), sv2);
        Student sv3 = new Student("Kim", 5, "Xu li du lieu");
        map.put(sv3.getName(), sv3);
        
        
        Set<String> keys = map.keySet();
        for(String name : keys) {
            Student sv1 = map.get(name);
            System.out.printf("\n\nHo ten: %s", sv1.getName());
            System.out.printf("\nHoc luc: %s", sv1.getRank());
            
        }
    }
}
