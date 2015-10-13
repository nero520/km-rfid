package com.msds.baseinfo.entity;

// default package



/**
 * AuthGroup entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class AuthGroup  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;


    // Constructors

    /** default constructor */
    public AuthGroup() {
    }

    
    /** full constructor */
    public AuthGroup(String name) {
        this.name = name;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}