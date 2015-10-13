package com.msds.baseinfo.entity;


/**
 * 临时的权限表
 *
 */
public class Permission  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
     private String name;
     private String codename;
     private Integer parentNode;
     private Integer isMenu;
     private Integer sequence;
     private String permission;
     private String parentIds;

     
	/** default constructor */
    public Permission() {
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


    public String getCodename() {
        return this.codename;
    }
    
    public void setCodename(String codename) {
        this.codename = codename;
    }

    public Integer getParentNode() {
        return this.parentNode;
    }
    
    public void setParentNode(Integer parentNode) {
        this.parentNode = parentNode;
    }


    public Integer getIsMenu() {
        return this.isMenu;
    }
    
    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }


	public Integer getSequence() {
		return sequence;
	}


	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}


	public String getPermission() {
		return permission;
	}


	public void setPermission(String permission) {
		this.permission = permission;
	}


	public String getParentIds() {
		return parentIds;
	}


	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
}