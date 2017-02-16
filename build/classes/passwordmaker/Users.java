/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmaker;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Keertikeya
 */
@Entity
@Table(name = "users", catalog = "pwdgen", schema = "")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUID", query = "SELECT u FROM Users u WHERE u.uID = :uID"),
    @NamedQuery(name = "Users.findByUName", query = "SELECT u FROM Users u WHERE u.uName = :uName"),
    @NamedQuery(name = "Users.findByPwd", query = "SELECT u FROM Users u WHERE u.pwd = :pwd")})
public class Users implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uID")
    private Integer uID;
    @Basic(optional = false)
    @Column(name = "uName")
    private String uName;
    @Basic(optional = false)
    @Column(name = "pwd")
    private String pwd;

    public Users() {
    }

    public Users(Integer uID) {
        this.uID = uID;
    }

    public Users(Integer uID, String uName, String pwd) {
        this.uID = uID;
        this.uName = uName;
        this.pwd = pwd;
    }

    public Integer getUID() {
        return uID;
    }

    public void setUID(Integer uID) {
        Integer oldUID = this.uID;
        this.uID = uID;
        changeSupport.firePropertyChange("UID", oldUID, uID);
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        String oldUName = this.uName;
        this.uName = uName;
        changeSupport.firePropertyChange("UName", oldUName, uName);
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        String oldPwd = this.pwd;
        this.pwd = pwd;
        changeSupport.firePropertyChange("pwd", oldPwd, pwd);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uID != null ? uID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.uID == null && other.uID != null) || (this.uID != null && !this.uID.equals(other.uID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "passwordmaker.Users[ uID=" + uID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
